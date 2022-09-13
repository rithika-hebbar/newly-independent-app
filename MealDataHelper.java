package com.example.newlyindependent; 
import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; import android.database.sqlite.SQLiteOpenHelper; 
public class MealDataHelper extends SQLiteOpenHelper {
public static final String DB_NAME = "mealplans.db"; 
public MealDataHelper(Context context) { 
super(context, DB_NAME, null, 1); 
// TODO Auto-generated constructor stub 
} 
@Override 
public void onCreate(SQLiteDatabase mydb) { 
// TODO Auto-generated method stub 
mydb.execSQL("CREATE TABLE mealplan( _id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, item TEXT, meal TEXT, date TEXT)"); } 
@Override 
public void onUpgrade(SQLiteDatabase mydb, int arg1, int arg2) { 
// TODO Auto-generated method stub 
mydb.execSQL("DROP TABLE IF EXISTS mealplan"); 
onCreate(mydb); 
} 
public Boolean insertMeal(String name, String item, String meal, String date){ SQLiteDatabase mydb = this.getWritableDatabase(); 
ContentValues cv = new ContentValues(); 
cv.put("username", name); 
cv.put("item", item); 
cv.put("meal", meal); 
cv.put("date", date); 
long result = mydb.insert("mealplan", null, cv); 
if(result==-1) return false; 
else return true; 
} 
public Cursor getAllRows(String name){ 
SQLiteDatabase db = this.getReadableDatabase(); 
Cursor result = db.rawQuery("SELECT * FROM mealplan WHERE username = ?", new String[]{name}); 
return result; 
}
public Cursor getRow(long id){ 
SQLiteDatabase db = this.getReadableDatabase(); 
Cursor result = db.rawQuery("SELECT * FROM mealplan WHERE _id = ?", new String[]{String.valueOf(id)}); 
return result; 
} 
public Integer deletePlan(String id){ 
SQLiteDatabase db = this.getWritableDatabase(); 
return db.delete("mealplan", "_id = ?", new String[]{id}); 
} 
} 

