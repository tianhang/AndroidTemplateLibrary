package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 19/7/15.
 */
public class PersonOpenHelper extends SQLiteOpenHelper {
    public PersonOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        db.execSQL("create table person(id integer primary key autoincrement" +
                ",name varchar(20),phone varchar(20),money integer(20)," +
                "age integer(10));");
                */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
