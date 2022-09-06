package com.example.newlyindependent;

import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.view.Window; 
import android.widget.*; 
import android.widget.AdapterView.OnItemSelectedListener;

public class PlanMealActivity extends Activity{ 
    String name, item; 
    TextView itemtv; 
    Button save; 
    Spinner meal; 
    DatePicker date; 
    String [] meals = { "Breakfast", "Lunch", "Dinner" }; 
    String dbname, dbitem, dbmeal, dbdate; 
    MealDataHelper mydb; 

    protected void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_planmeal); 
        Intent i = getIntent(); 
        name = i.getExtras().getString("name"); 
        item = i.getExtras().getString("item"); 
        dbname = name; 
        itemtv = (TextView)findViewById(R.id.tvdate); 
        itemtv.setText(item); 
        dbitem = item; 
        save = (Button)findViewById(R.id.btnrec); 
        meal = (Spinner)findViewById(R.id.spinner1); 
        date = (DatePicker)findViewById(R.id.datePicker1); 
        mydb = new MealDataHelper(this); 
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meals); 
        meal.setAdapter(a);
        
        meal.setOnItemSelectedListener(new OnItemSelectedListener(){ 
            @Override 
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
                // TODO Auto-generated method stub 
                int index = meal.getSelectedItemPosition(); 
                dbmeal = meals[index]; 
            }
            
            @Override 
            public void onNothingSelected(AdapterView<?> arg0) { 
                // TODO Auto-generated method stub 
            }
        });
        
        save.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                dbdate = getDate(); 
                Boolean ins = mydb.insertMeal(dbname, dbitem, dbmeal, dbdate); 
                
                if(ins){ 
                    Toast.makeText(PlanMealActivity.this, "Added to planner!", Toast.LENGTH_SHORT).show(); 
                    Intent mpi = new Intent(getApplicationContext(), HomeActivity.class); 
                    mpi.putExtra("name", dbname); 
                    startActivity(mpi); 
                }else{ 
                    Toast.makeText(PlanMealActivity.this, "Failed to add!", Toast.LENGTH_SHORT).show(); 
                } 
            } 
        }); 
} 
public String getDate(){ 
StringBuffer data = new StringBuffer(); 
data.append((date.getMonth()+1)+"/");
data.append(date.getDayOfMonth()+"/"); 
data.append(date.getYear()); 
return data.toString(); 
} 
} 
