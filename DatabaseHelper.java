package com.example.newlyindependent; 
import android.content.ContentValues; 
import android.content.Context;
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{ 
    public static final String DB_NAME = "users.db";
    
    public DatabaseHelper(Context context) { 
        super(context, DB_NAME, null, 1); 
        // TODO Auto-generated constructor stub 
    } 

    @Override 
    public void onCreate(SQLiteDatabase mydb) { 
        // TODO Auto-generated method stub 
        mydb.execSQL("CREATE TABLE users(email TEXT PRIMARY KEY, name TEXT, password TEXT)"); 
    } 
    
    @Override 
    public void onUpgrade(SQLiteDatabase mydb, int arg1, int arg2) { 
        // TODO Auto-generated method stub 
        mydb.execSQL("DROP TABLE IF EXISTS users"); 
    } 
    
    public Boolean insertUser(String name, String email, String password){ 
        SQLiteDatabase mydb = this.getWritableDatabase(); 
        ContentValues cv = new ContentValues(); 
        cv.put("email", email); 
        cv.put("name", name); 
        cv.put("password", password); 
        long result = mydb.insert("users", null, cv); 
        if(result==-1) return false; 
        else return true; 
    } 
    
    public Boolean checkUser(String email){ 
        SQLiteDatabase mydb = this.getWritableDatabase(); 
        Cursor c = mydb.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});
        if(c.getCount()>0){ 
            return true; 
        }else{ 
            return false; 
        } 
    } 
    
    public Boolean loginCheck(String email, String password){ 
        SQLiteDatabase mydb = this.getWritableDatabase(); 
        Cursor c = mydb.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[]{email, password}); 
        if(c.getCount()>0){ 
            return true; 
        }else{ 
            return false; 
        } 
    } 
    
    public Cursor getName(String email, String password){ 
        SQLiteDatabase db = this.getReadableDatabase(); 
        Cursor result = db.rawQuery("SELECT * FROM users WHERE email =? AND password = ?", new String[]{email, password}); 
        return result; 
    } 
} 

