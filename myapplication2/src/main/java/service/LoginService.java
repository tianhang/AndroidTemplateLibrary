package service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by student on 17/7/15.
 */
public class LoginService {
    /**
     * save user info
     * @param username
     * @param password
     * @return
     */
    public static boolean saveUserInfo(Context context,String username,String password){
        SharedPreferences sp =  context.getSharedPreferences("config", Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putString("username",username);
        edit.putString("password",password);
        edit.commit();

        return true;
    }
}
