# AndroidNotee
loginnote

A simple offline notes app with pin protection for mobiles with low space issues and older android versions.

##SCREENSHOTS:
![alt text](https://user-images.githubusercontent.com/40829097/56265323-d9021080-6106-11e9-819a-f3ef23503126.jpg)



Features:
1. Provide security with a simple 4-pin protection.
2. Occupies very little space.
3. User friendly.

Here's the source code to it.

Designing:
1.Colors.xml
<resources>
    
    
    <color name="colorPrimary">#f4511e</color>
    <color name="colorPrimaryDark">#b91400</color>
    <color name="colorAccent">#a30000</color>
    <color name="msg_no_notes">#999</color>
    <color name="hint_enter_note">#89c3c3c3</color>
    <color name="timestamp">#858585</color>
    <color name="note_list_text">#232323</color>
    <color name="grey">#D3D3D3</color>
    <color name="gold">#FFDF00</color>
    <color name="lock_orange">#FF8C00</color>
    <color name="white">#FFFFFF</color>
    <color name="black_overlay">#66000000</color>
</resources>

2.Dimens.xml

<resources>
    <dimen name="fab_margin">35dp</dimen>
    <dimen name="activity_margin">20dp</dimen>
    <dimen name="dot_margin_right">10dp</dimen>
    <dimen name="msg_no_notes">26sp</dimen>
    <dimen name="margin_top_no_notes">120dp</dimen>
    <dimen name="lbl_new_note_title">20sp</dimen>
    <dimen name="dimen_10">10dp</dimen>
    <dimen name="input_new_note">20sp</dimen>
    <dimen name="input_new_title">25dp</dimen>
    <dimen name="dot_height">30dp</dimen>
    <dimen name="dot_text_size">40sp</dimen>
    <dimen name="timestamp">14sp</dimen>
    <dimen name="note_list_text">18sp</dimen>
    <dimen name="my_lock_right">40dp</dimen>
    <dimen name="my_lock_top">20dp</dimen>
    <dimen name="my_lock_left">40dp</dimen>
    <dimen name="change_pin">17sp</dimen>

</resources>
3.strings.xml

<resources>
    <string name="app_name">SecondNote</string>
    <string name="change_pin">Change Pin</string>
    <string name="activity_title_home">Notes</string>
    <string name="msg_no_notes">No notes found!</string>
    <string name="lbl_new_note_title">New Note</string>
    <string name="lbl_edit_note_title">Edit Note</string>
    <string name="hint_enter_note">Enter your note!</string>
    <string name="enter_Title">No Title!</string>
    <string name="title">Enter Title!</string>
    <string name="pin_title">Enter PIN</string>

    <string name="enter_here_hint">Enter here</string>
    <string name="gold_suggest">"Please create Pin!"</string>
    <string name="contentDescription1">"circle image 1"</string>
    <string name="contentDescription2">"circle image 2"</string>
    <string name="contentDescription3">"circle image 3"</string>
    <string name="contentDescription4">"circle image 4"</string>

    <string name="title_activity_splash_screen">SplashScreen</string>
    <string name="dummy_button">Dummy Button</string>
    <string name="dummy_content">DUMMY\nCONTENT</string>

</resources>
4.circle.xml

It creates a circle view with not selected

<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <stroke
        android:width="2dp"
        android:color="@color/colorAccent" />
    <size
        android:width="25dp"
        android:height="25dp" />

</shape>

5.circle

It selects a solid circle.

<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid
        android:color="@color/colorAccent"/>
    <size
        android:width="25dp"
        android:height="25dp" />
</shape>

6.Activity_main

<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:background="@color/hint_enter_note"
    android:layout_width="match_parent"
    android:id="@+id/coordinator_layout"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />

    </android.support.design.widget.AppBarLayout>

    <include layout="@layout/content_main" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        android:src="@drawable/ic_plus_name"
        />
</android.support.design.widget.CoordinatorLayout>

7.Activity_my_lock

<LinearLayout android:id="@+id/no_linear_main"
    android:layout_width="340dp"
    android:layout_height="320dp"
    android:layout_margin="20dp"
    android:background="@android:color/transparent"
    android:orientation="vertical"
    android:layout_marginStart="@dimen/my_lock_left"
    android:layout_marginEnd="@dimen/my_lock_right"
    android:layout_marginTop="@dimen/my_lock_top"

    android:paddingBottom="@dimen/dimen_10"
    android:paddingLeft="@dimen/activity_margin"
    android:paddingRight="@dimen/activity_margin"
    android:paddingTop="@dimen/dimen_10"
    xmlns:android="http://schemas.android.com/apk/res/android">

        <LinearLayout
            android:id="@+id/no_linear_1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:id="@+id/no_textview_1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_margin="10dp"
                android:text="@string/pin_title"
                android:textSize="25sp"
                android:textStyle="bold" />

            <LinearLayout
                android:id="@+id/no_linear_2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_marginTop="50dp"
                android:orientation="horizontal">

                <ImageView
                    android:id="@+id/imageview_circle1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:contentDescription="@string/contentDescription1"
                    android:src="@drawable/circle" />

                <ImageView
                    android:id="@+id/imageview_circle2"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:contentDescription="@string/contentDescription2"
                    android:src="@drawable/circle" />

                <ImageView
                    android:id="@+id/imageview_circle3"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:contentDescription="@string/contentDescription3"
                    android:src="@drawable/circle" />

                <ImageView
                    android:id="@+id/imageview_circle4"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:contentDescription="@string/contentDescription4"
                    android:src="@drawable/circle" />

            </LinearLayout>
        </LinearLayout>

        <LinearLayout
            android:layout_width="120dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="105dp"
            android:orientation="vertical">

            <EditText
                android:id="@+id/enter_pin"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:inputType="numberPassword"
                android:maxLength="4"
                android:hint="@string/enter_here_hint"
                android:textAlignment="center"
                android:textColor="@color/note_list_text"
                android:textSize="22sp"
                android:visibility="visible" />


        </LinearLayout>
    </LinearLayout>

8.activity_splash

<LinearLayout android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/no_top_linear"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <LinearLayout
        android:id="@+id/no_linear_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingTop="80dp"
        android:background="@color/note_list_text"
        android:orientation="vertical">


        <LinearLayout
            android:id="@+id/no_linear_1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"

            android:orientation="vertical"
            >
            <TextView
                android:id="@+id/no_textview_1"

                android:textColor="@color/lock_orange"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"

                android:textStyle="bold"
                android:textSize="25sp"
                android:layout_margin="10dp"
                android:layout_gravity="center_horizontal"/>
            <LinearLayout
                android:id="@+id/no_linear_2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:layout_marginTop="50dp"
                android:layout_gravity="center_horizontal">
                <ImageView
                    android:id="@+id/imageview_circle1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:src="@drawable/circle"/>
                <ImageView
                    android:id="@+id/imageview_circle2"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:src="@drawable/circle"/>
                <ImageView
                    android:id="@+id/imageview_circle3"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:src="@drawable/circle"/>
                <ImageView
                    android:id="@+id/imageview_circle4"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="6dp"
                    android:src="@drawable/circle"/>

            </LinearLayout>
        </LinearLayout>

        <LinearLayout
            android:layout_width="120dp"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="105dp">

            <EditText
                android:id="@+id/enter_pin"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:inputType="numberPassword"
                android:textAlignment="center"
                android:maxLength="4"
                android:hint="Enter here"
                android:textColor="@color/grey"
                android:textColorHint="@color/lock_orange"
                android:textSize="22sp"
                android:layout_gravity="center_horizontal"
                android:visibility="visible"/>
        </LinearLayout>

        <TextView
            android:id="@+id/pinChange"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAlignment="center"
            android:layout_gravity="center"
            android:minWidth="0dp"
            android:minHeight="0dp"
            android:clickable="true"
            android:focusable="true"
            android:textSize="@dimen/change_pin"
            android:text="@string/change_pin"
            android:layout_marginTop="20dp"
            android:textColor="@color/white"/>
    </LinearLayout>

</LinearLayout>

9.content_main

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main"
    >


    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <TextView
        android:id="@+id/empty_notes_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="@dimen/margin_top_no_notes"
        android:fontFamily="sans-serif-light"
        android:text="@string/msg_no_notes"
        android:textColor="@color/msg_no_notes"
        android:textSize="@dimen/msg_no_notes" />

</RelativeLayout>

10.note_dialog

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingLeft="@dimen/activity_margin"
    android:paddingRight="@dimen/activity_margin"
    android:paddingTop="@dimen/activity_margin">

    <TextView android:id="@+id/dialog_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/dimen_10"
        android:fontFamily="sans-serif-medium"
        android:lineSpacingExtra="8sp"
        android:text="@string/lbl_new_note_title"
        android:textColor="@color/colorAccent"
        android:textSize="@dimen/lbl_new_note_title"
        android:textStyle="normal" />


    <EditText
        android:id="@+id/note"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/transparent"
        android:gravity="top"
        android:layout_marginTop="5dp"
        android:hint="@string/hint_enter_note"
        android:inputType="textCapSentences|textMultiLine"
        android:lines="4"
        android:textColor="@color/colorPrimary"
        android:textColorHint="@color/colorPrimary"
        android:textSize="@dimen/input_new_note" />


</LinearLayout>

11.noteListRow

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="150dp"
    android:clickable="true"
    android:focusable="true"
    android:background="@drawable/view_shape"
    android:foreground="?attr/selectableItemBackground"
    android:paddingBottom="@dimen/dimen_10"
    android:paddingLeft="@dimen/activity_margin"
    android:paddingRight="@dimen/activity_margin"
    android:paddingTop="@dimen/dimen_10"
    >

    <TextView
        android:id="@+id/dot"
        android:layout_width="wrap_content"
        android:layout_height="@dimen/dot_height"
        android:layout_marginEnd="@dimen/dot_margin_right"
        android:layout_marginTop="@dimen/dimen_10"
        android:includeFontPadding="false"
        android:textColor="@color/colorAccent"
        android:lineSpacingExtra="0dp"
        android:textSize="@dimen/dot_text_size" />

    <TextView
        android:id="@+id/timestamp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/note"
        android:layout_toEndOf="@id/dot"
        android:layout_centerHorizontal="true"
        android:textColor="@color/timestamp"
        android:textSize="@dimen/timestamp" />

    <TextView
        android:id="@+id/note"
        android:layout_width="match_parent"
        android:layout_height="105dp"
        android:layout_marginTop="2dp"
        android:ellipsize="end"
        android:maxLines="3"
        android:layout_toEndOf="@id/dot"
        android:textColor="@color/note_list_text"
        android:textSize="@dimen/note_list_text"
        />



</RelativeLayout>
*********************************************************************************
*********************************************************************************
1.Manifest file

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.mkv.secondnote">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar"></activity>
        <activity android:name=".SplashActivity"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>
    </application>

</manifest>

{Make change to intent filter.}


2.DatabaseHelper

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Note.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertNote(String note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Note.COLUMN_NOTE, note);

        //can be error

        // insert row
        long id = db.insert(Note.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public Note getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Note.TABLE_NAME,
                new String[]{Note.COLUMN_ID, Note.COLUMN_NOTE,
                        Note.COLUMN_TIMESTAMP},
                Note.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Note note = new Note(
                cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));


        // close the db connection
        cursor.close();

        return note;
    }

    public Collection<? extends Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Note.TABLE_NAME + " ORDER BY " +
                Note.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));


                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }


    public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

}

3.Note Model class
public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";


    private int id;
    private String note;
    private String timestamp;



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }

    public Note(int id, String note, String timestamp) {
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;

    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
4.Divider Item Decoration


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int mOrientation;
    private Context context;
    private int margin;

    public MyDividerItemDecoration(Context context, int orientation, int margin) {
        this.context = context;
        this.margin = margin;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left + dpToPx(margin), top, right - dpToPx(margin), bottom);
            mDivider.draw(c);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top + dpToPx(margin), right, bottom - dpToPx(margin));
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }

    private int dpToPx(int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
5.NotesAdapter

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView note;
        public TextView dot;
        public TextView timestamp;


        public MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.note);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);

        }
    }


    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.note.setText(note.getNote());

        //display html code dot


        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }



    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }

}

6.RecyclerTouchListener


public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener clicklistener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {

        this.clicklistener = clicklistener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clicklistener != null) {
                    clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
            clicklistener.onClick(child, rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
7.Splash Activity contains pin access

public class SplashActivity extends AppCompatActivity implements View.OnKeyListener {

    private static final String TAG="pin";
    ImageView i1,i2,i3,i4;
    EditText enterPin;
    LinearLayout backgroundLayout;
    static SharedPreferences sharedPreferences;
    private static String answer;
    TextView create_edit;
    TextView changePin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        //definition of sharedPreference
        sharedPreferences=this.getSharedPreferences
                ("com.mkv.pin", Context.MODE_PRIVATE);

        create_edit=(TextView) findViewById(R.id.no_textview_1);
        if(example() == null) {
            create_edit.setText("Create Pin");
        }else{create_edit.setText("Enter Pin");}

        changePin=(TextView) findViewById(R.id.pinChange);

        changePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        i1=(ImageView) findViewById(R.id.imageview_circle1);
        i2=(ImageView) findViewById(R.id.imageview_circle2);
        i3=(ImageView) findViewById(R.id.imageview_circle3);
        i4=(ImageView) findViewById(R.id.imageview_circle4);

        enterPin=(EditText) findViewById(R.id.enter_pin);
        enterPin.requestFocus();
        enterPin.setInputType(InputType.TYPE_CLASS_NUMBER);
        enterPin.setFocusableInTouchMode(true);

        enterPin.setOnKeyListener(this);
        backgroundLayout=(LinearLayout) findViewById(R.id.no_linear_1);
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


        enterPin.addTextChangedListener(new TextWatcher() {
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

    }


    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

            String text = enterPin.getText().toString();

            if (text.length() != 4) {

                Toast.makeText(this, "Please" +
                        " enter 4 digit pin.", Toast.LENGTH_SHORT).show();
            }
            if (text.length() == 4) {
                if(example() == null) {
                    savePin(text);
                }else{
                    if(example().equals(text)){
                        Intent intent=new Intent(this,MainActivity.class);
                        startActivity(intent);
                        this.finish();
                    }else{
                        Toast.makeText(this, "WRONG PIN"
                                , Toast.LENGTH_SHORT).show();

                    }
                }//end of else


            }
        }
        //write code about what happens on clicking done button

        return false;
    }


    public void savePin( String myPin){
        sharedPreferences.edit().putString("password",myPin).apply();



        Toast.makeText(this,"Pin created successfully",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
        Log.i("ad","da");



    }
    public static String example(){
        answer=sharedPreferences.getString("password","");
        return answer;
    }

}
8.MainActivity

public class MainActivity extends AppCompatActivity{
    private NotesAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private TextView noNotesView;

    private DatabaseHelper db;

    static SharedPreferences sharedPreferences;

    ArrayList<String> savePosition=new ArrayList<>();





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
        noNotesView = findViewById(R.id.empty_notes_view
