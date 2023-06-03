package com.example.newlyindependent;

import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.*;

public class ListItemActivity extends Activity{ 
    String id, item, meal, date, name; 
    TextView tvdate, tvmeal, tvitem; 
    Button btnrec, btndel; 
    String searchname; 
    MealDataHelper mydb;
    
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_listitem);
        Intent i = getIntent();
        
        id = i.getExtras().getString("id"); 
        item = i.getExtras().getString("item"); 
        meal = i.getExtras().getString("meal"); 
        date = i.getExtras().getString("date"); 
        name = i.getExtras().getString("name");
        
        tvdate = (TextView)findViewById(R.id.datetv); 
        tvdate.setText(date); 
        tvmeal = (TextView)findViewById(R.id.mealtv); 
        tvmeal.setText(meal); 
        tvitem = (TextView)findViewById(R.id.itemtv); 
        tvitem.setText(item);
        
        btnrec = (Button)findViewById(R.id.btnrec); 
        btndel = (Button)findViewById(R.id.btndel); 
        searchname = tvitem.getText().toString(); 
        mydb = new MealDataHelper(this);
        
        btndel.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Integer delrows = mydb.deletePlan(id);
                
                if(delrows > 0){ 
                    Toast.makeText(ListItemActivity.this, "Deleted sucessfully!", Toast.LENGTH_SHORT).show(); 
                    Intent deli = new Intent(getApplicationContext(), MealPlanActivity.class); 
                    deli.putExtra("name", name); 
                    startActivity(deli); 
                }else{
                    Toast.makeText(ListItemActivity.this, "Error!", Toast.LENGTH_SHORT).show(); 
                } 
            } 
        });
        
btnrec.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View arg0) { 
// TODO Auto-generated method stub 
if(searchname.equals("Rava Dosa")){ 
Intent ri = new Intent(getApplicationContext(), 
RavadosaActivity.class); 
ri.putExtra("name", name); 
startActivity(ri); 
}else if(searchname.equals("Aloo Sandwich")){ 
Intent ri = new Intent(getApplicationContext(), 
SandwichActivity.class); 
ri.putExtra("name", name); 
startActivity(ri); 
}else if(searchname.equals("Lemon Rice")){ 
Intent ri = new Intent(getApplicationContext(), 
LemonActivity.class); 
ri.putExtra("name", name); 
startActivity(ri); 
}else if(searchname.equals("Rasam Rice")){ 
Intent ri = new Intent(getApplicationContext(), 
RasamActivity.class); 
ri.putExtra("name", name); 
startActivity(ri);
}else if(searchname.equals("Chapati")){ 
Intent ri = new Intent(getApplicationContext(), 
ChapatiActivity.class); 
ri.putExtra("name", name); 
startActivity(ri); 
}else if(searchname.equals("Upma")){ 
Intent ri = new Intent(getApplicationContext(), 
UpmaActivity.class); 
ri.putExtra("name", name); 
startActivity(ri); 
}else{ 
} 
} 
}); 
} 
}
