package junit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import beans.Person;
import util.PersonOpenHelper;

/**
 * Created by student on 19/7/15. InstrumentationTestCase
 */
public class TestCase extends AndroidTestCase {
    private PersonOpenHelper helper;
    private SQLiteDatabase db;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        helper = new PersonOpenHelper(getContext(),"person.db",null,1);
        db = getDataBase();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        db.close();
    }
////
    public void test(){
        System.out.println("i am a test !");
        Log.i("tianhang", "tianhang test ");
        insert();
        ArrayList<Person> list = (ArrayList<Person>)query();
        Log.e("list",list.size()+"");
        assertEquals(102,list.size());


    }
    public SQLiteDatabase getDataBase(){
        SQLiteDatabase db =  helper.getWritableDatabase();
        return db;
    }

    public void insert(){
        for(int i =0;i<100;i++){
            db.execSQL("insert into person(name,phone,money,age)" +
                    "values(?,?,?,?)",new Object[]{"tianhang","12345",i,i});
        }
    }

    public List<Person> query(){
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
            personList.add(p);
            Log.i("person", p + "");
            System.out.println(p);
        }
        cursor.close();
        return personList;
    }
}