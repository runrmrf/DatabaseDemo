package com.mancng.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void btnJavaScript (View view) {

        Intent i = new Intent(getApplicationContext(),WebViewActivity.class);
        startActivity(i);

    }

    public void btnHttp (View view) {

        Intent a = new Intent(getApplicationContext(), HttpActivity.class);
        startActivity(a);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //Add new database if not exist
//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS myUsers (name TEXT, age INTEGER, id INTEGER PRIMARY KEY)");

//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name TEXT, age INTEGER, id INTEGER PRIMARY KEY)");

//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS myNewUsers (name TEXT, age INTEGER, id INTEGER PRIMARY KEY)");

//            myDatabase.execSQL("INSERT INTO myNewUsers (name, age) VALUES ('Susan', 48)");
//            myDatabase.execSQL("INSERT INTO myNewUsers (name, age) VALUES ('Lily', 46)");
//            myDatabase.execSQL("INSERT INTO myNewUsers (name, age) VALUES ('Coty', 41)");
//            myDatabase.execSQL("INSERT INTO myNewUsers (name, age) VALUES ('Jason', 39)");

            //Example from Rob
            myDatabase.execSQL("DELETE FROM myNewUsers WHERE id = 1");

            //Example to update a record. This will update all Jason records
//            myDatabase.execSQL("UPDATE myUsers SET age = 100 WHERE name = 'Jason'");

            //Pull data
            Cursor c = myDatabase.rawQuery("SELECT * FROM myNewUsers", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            if (c != null && c.moveToNext()) {

                do {

                    Log.i("name", c.getString(nameIndex));
                    Log.i("age", c.getString(ageIndex));
                    Log.i("id", c.getString(idIndex));

                } while (c.moveToNext());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
