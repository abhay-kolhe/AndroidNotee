package com.mkv.secondnote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends AppCompatActivity implements View.OnKeyListener {
    private NotesAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private TextView noNotesView;
    private static TextView noteText;
    private DatabaseHelper db;
    private static final String TAG="pin";
    private ImageView i1,i2,i3,i4;
    private Button saveButton;
    private EditText enterPin;
    private EditText mPin;

    static String answer;
    LinearLayout backgroundLayout;
    static SharedPreferences sharedPreferences;
    TextView pinTitle;
    ArrayList<String> savePosition=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences=this.getSharedPreferences
                ("com.mkv.pin", Context.MODE_PRIVATE);

            if(!savePosition.isEmpty()) {
                HashSet<String> set = new HashSet<>(savePosition);
                sharedPreferences.edit().putStringSet("hideChildChallenge", set).apply();
            }



        coordinatorLayout = findViewById(R.id.coordinator_layout);
        recyclerView = findViewById(R.id.recycler_view);
        noNotesView = findViewById(R.id.empty_notes_view);

        db = new DatabaseHelper(this);

        notesList.addAll(db.getAllNotes());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNoteDialog(false, null, -1);
            }
        });

        mAdapter = new NotesAdapter(this, notesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        toggleEmptyNotes();

        /**
         * On long press on RecyclerView item, open alert dialog
         * with options to choose
         * Edit and Delete
         * */
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                showActionsDialog(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                noteText = view.findViewById(R.id.note);
                Toast.makeText(MainActivity.this,String.valueOf(position),
                        Toast.LENGTH_SHORT).show();
                hidingDialog(noteText,position);


                }//end of longClick
        }));


    }


    /**
     * Inserting new note in db
     * and refreshing the list
     */
    private void createNote(String note) {
        // inserting note in db and getting
        // newly inserted note id
        long id = db.insertNote(note);


        // get the newly inserted note from db
        Note n = db.getNote(id);


        if (n != null) {
            // adding new note to array list at 0 position
            notesList.add(0, n);

            // refreshing the list
            mAdapter.notifyDataSetChanged();

            // refreshing the list
            toggleEmptyNotes();

            }
    }




    /**
     * Updating note in db and updating
     * item in the list by its position
     */
    private void updateNote(String note, int position) {
        Note n = notesList.get(position);
        // updating note text
        n.setNote(note);

        // updating note in db
        db.updateNote(n);

        // refreshing the list
        notesList.set(position, n);
        mAdapter.notifyItemChanged(position);

        toggleEmptyNotes();
    }

    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
    private void deleteNote(int position) {
        // deleting the note from db
        db.deleteNote(notesList.get(position));

        // removing the note from the list
        notesList.remove(position);
        mAdapter.notifyItemRemoved(position);

        toggleEmptyNotes();
    }

    /**
     * Opens dialog with Edit - Delete options
     * Edit - 0
     * Delete - 0
     */
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showNoteDialog(true, notesList.get(position), position);
                } else {
                    deleteNote(position);
                }
            }
        });
        builder.show();
    }

    /**
     * Shows alert dialog with EditText options to enter / edit
     * a note.
     * when shouldUpdate=true, it automatically displays old note and changes the
     * button text to UPDATE
     */
    private void showNoteDialog(final boolean shouldUpdate, final Note note, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.note_dialog, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilderUserInput.setView(view);

        final EditText inputNote = view.findViewById(R.id.note);
        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_note_title) : getString(R.string.lbl_edit_note_title));

        if (shouldUpdate && note != null) {
            inputNote.setText(note.getNote());
        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when no text is entered
                if (TextUtils.isEmpty(inputNote.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter note!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                // check if user updating note
                if (shouldUpdate && note != null) {
                    // update note by it's id
                    updateNote(inputNote.getText().toString(), position);
                } else {
                    // create new note
                    createNote(inputNote.getText().toString());
                }
            }
        });
    }

    private void hidingDialog(final TextView noteTexts,int position){
        myLock(noteTexts,position);
            }
    private void myLock(final TextView noteText, final int position){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        final View myLockView = layoutInflaterAndroid.inflate(R.layout.activity_my_lock, null);

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);


        mPin=(EditText) myLockView.findViewById(R.id.enter_pin);
        pinTitle=(TextView) myLockView.findViewById(R.id.no_textview_1);
        i1=(ImageView) myLockView.findViewById(R.id.imageview_circle1);
        i2=(ImageView) myLockView.findViewById(R.id.imageview_circle2);
        i3=(ImageView) myLockView.findViewById(R.id.imageview_circle3);
        i4=(ImageView) myLockView.findViewById(R.id.imageview_circle4);

        backgroundLayout=(LinearLayout) myLockView.findViewById(R.id.no_linear_1);



        mBuilder.setView(myLockView);
        mBuilder.setNegativeButton("No",null)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"entered further", Toast.LENGTH_SHORT).show();

                        String text=mPin.getText().toString();
                        if (text.length() != 4) {

                            Toast.makeText(MainActivity.this, "Please" +
                                    " enter 4 digit pin.", Toast.LENGTH_SHORT).show();
                        }if (text.length() == 4) {
                            if(example() == null) {

                                Toast.makeText(MainActivity.this, "PIN NOT CREATED INITIALLY"
                                        , Toast.LENGTH_SHORT).show();
                                savePin( text, sharedPreferences);

                            }else{
                                if(example().equals(text)){

                                    if(noteText.getVisibility()==View.VISIBLE){
                                        savePosition.add(String.valueOf(position));
                                        Toast.makeText(MainActivity.this,String.valueOf(position)
                                        , Toast.LENGTH_SHORT).show();
                                        noteText.setVisibility(View.INVISIBLE);


                                    }else {
                                        Toast.makeText(MainActivity.this,"visibilit RUN"
                                                , Toast.LENGTH_SHORT).show();
                                        noteText.setVisibility(View.VISIBLE);
                                    }

                                }else{
                                    Toast.makeText(MainActivity.this, "WRONG PIN"
                                            , Toast.LENGTH_SHORT).show();

                                }
                            }//end of else


                        }
                    }
                });

        AlertDialog dialog=mBuilder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f);





        mPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                switch (editable.length()) {
                    case 4:
                        i4.setImageResource(R.drawable.circle2);
                        break;
                    case 3:
                        i4.setImageResource(R.drawable.circle);
                        i3.setImageResource(R.drawable.circle2);
                        break;
                    case 2:
                        i3.setImageResource(R.drawable.circle);
                        i2.setImageResource(R.drawable.circle2);
                        break;
                    case 1:
                        i2.setImageResource(R.drawable.circle);
                        i1.setImageResource(R.drawable.circle2);
                        break;
                    default:
                        i1.setImageResource(R.drawable.circle);
                }
            }

        });
        backgroundLayout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(view.getId()==R.id.no_linear_1
                        || view.getId()==R.id.no_linear_2
                        || view.getId()==R.id.no_textview_1
                        ||view.getId()==R.id.no_linear_main){
                    InputMethodManager inputMethodManager=(InputMethodManager)
                            getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus()
                            .getWindowToken(),0);
                }
            }
        });

        enterPin=(EditText) myLockView.findViewById(R.id.enter_pin);
        enterPin.requestFocus();
        enterPin.setInputType(InputType.TYPE_CLASS_NUMBER);
        enterPin.setFocusableInTouchMode(true);
        enterPin.setOnKeyListener(MainActivity.this);




        }//abo

    public void savePin( String myPin,SharedPreferences sharedPreferences){
        sharedPreferences.edit().putString("password",myPin).apply();

        Toast.makeText(this, myPin,
                Toast.LENGTH_SHORT).show();
        answer=sharedPreferences.getString("password","");

        Log.i("ad","da");
        Toast.makeText(MainActivity.this,"MyloCK entered", Toast.LENGTH_SHORT).show();


    }

    public String example(){
        return answer;
    }
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

        Toast.makeText(MainActivity.this,"On Key Runs", Toast.LENGTH_SHORT).show();
        }
        //write code about what happens on clicking done button

        return false;
    }

    /**
     * Toggling list and empty notes view
     */
    private void toggleEmptyNotes() {
        // you can check notesList.size() > 0

        if (db.getNotesCount() > 0) {
            noNotesView.setVisibility(View.GONE);
        } else {
            noNotesView.setVisibility(View.VISIBLE);
        }
    }


}