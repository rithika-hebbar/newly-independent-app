package com.example.newlyindependent; 
import android.app.ActionBar; 
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.Menu; 
import android.view.MenuInflater; 
import android.view.View; 
import android.widget.*; 

public class LunchActivity extends Activity{ 
    String name; 
    Button lemon, rasam; 
    
    protected void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_lunch); 
        ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true); 
        Intent i = getIntent(); 
        name = i.getExtras().getString("name"); 
        lemon = (Button)findViewById(R.id.btnrec); 
        rasam = (Button)findViewById(R.id.btndel); 
        
        lemon.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent i = new Intent(getApplicationContext(), LemonActivity.class); 
                i.putExtra("name", name); 
                startActivity(i); 
            } 
        });
        
        rasam.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent i = new Intent(getApplicationContext(), RasamActivity.class); 
                i.putExtra("name", name); 
                startActivity(i); 
            } 
        }); 
    } 
    
    public boolean onCreateOptionsMenu(Menu menu){ 
        MenuInflater inflater = getMenuInflater(); 
        inflater.inflate(R.menu.options, menu); 
        return super.onCreateOptionsMenu(menu); 
    } 
}
