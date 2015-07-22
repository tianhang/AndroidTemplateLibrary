package DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import beans.Person;
import util.PersonOpenHelper;

/**
 * Created by student on 19/7/15.
 */
public class PersonDAO {

    public static List<Person> query(Context context){
        PersonOpenHelper helper = new PersonOpenHelper(context,"person.db",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = " select * from person;";
        List<Person> personList = new ArrayList<Person>();
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Person p = new Person();
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            Integer money = cursor.getInt(3);
            Integer age = cursor.getInt(4);
            p.setId(id);
            p.setAge(age);
            p.setMoney(money);
            p.setName(name);
            p.setPhone(phone);
            personList.add(p);
            //Log.i("database", p + "----->");
        }
        cursor.close();
        return personList;
    }
}
