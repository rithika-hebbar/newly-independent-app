package com.example.newlyindependent;

import android.app.Activity; 
import android.content.Intent; 
import android.database.Cursor; 
import android.os.Bundle; 
import android.view.View; 
import android.view.Window; 
import android.widget.AdapterView; 
import android.widget.ListView; 
import android.widget.SimpleCursorAdapter;

public class MealPlanActivity extends Activity{ 
    String name; 
    MealDataHelper mydb;
    
    protected void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_mealplan); 
        mydb = new MealDataHelper(this); 
        Intent i = getIntent(); 
        name = i.getExtras().getString("name"); 
        populateListView(); 
        listViewClick(); 
    }
    
    public void populateListView(){ 
        Cursor result = mydb.getAllRows(name); 
        startManagingCursor(result); 
        String[] fields = new String[]{"_id", "item","meal","date"};
        int[] viewid = new int[]{R.id.tvnone,R.id.tvitem, R.id.tvmeal, R.id.tvdate}; 
        SimpleCursorAdapter ca = new SimpleCursorAdapter(this, R.layout.layout_listview, result, fields, viewid); 
        ListView lv = (ListView)findViewById(R.id.listView1); 
        lv.setAdapter(ca); 
    }
    
    public void listViewClick(){ 
        ListView lv = (ListView)findViewById(R.id.listView1);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            
            public void onItemClick(AdapterView<?> parent, View viewclick, int pos, long id) { 
                // TODO Auto-generated method stub 
                Cursor c = mydb.getRow(id); 

                if(c.moveToFirst()){ 
                    long iddb = c.getLong(0); 
                    String item = c.getString(2); 
                    String meal = c.getString(3); 
                    String date = c.getString(4); 
                    Intent lvi = new Intent(getApplicationContext(), ListItemActivity.class); 
                    lvi.putExtra("id", String.valueOf(iddb)); 
                    lvi.putExtra("item", item); 
                    lvi.putExtra("meal", meal); 
lvi.putExtra("date", date); 
lvi.putExtra("name", name); 
startActivity(lvi); 
} 
} 
}); 
} 
}

