package com.example.newlyindependent; 
import android.app.ActionBar; 
import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle; 
import android.text.Html; 
import android.view.Menu; 
import android.view.MenuInflater; 
import android.view.MenuItem; 
import android.view.View; 
import android.widget.*;

public class HomeActivity extends Activity { 
    TextView wel; 
    String name;
    
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_home); 
        Button breakfast, lunch, dinner; 
        ActionBar actionBar = getActionBar(); 
        actionBar.setTitle(Html.fromHtml("<small>Newly Independent</small>"));
        wel = (TextView)findViewById(R.id.tvwel); 
        Intent i = getIntent(); 
        name = i.getExtras().getString("name"); 
        wel.setText("Welcome, "+name+"!\nWhat's cooking?"); 
        
        breakfast = (Button)findViewById(R.id.btnrec); 
        breakfast.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent bfi = new Intent(HomeActivity.this, 
                BreakfastActivity.class); 
                bfi.putExtra("name", name); 
                startActivity(bfi);
            } 
        }); 
        
        lunch = (Button)findViewById(R.id.btndel); 
        lunch.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent lfi = new Intent(HomeActivity.this, LunchActivity.class); 
                lfi.putExtra("name", name); 
                startActivity(lfi); 
            } 
        }); 
        
        dinner = (Button)findViewById(R.id.button3); 
        dinner.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent dfi = new Intent(HomeActivity.this, DinnerActivity.class); 
                dfi.putExtra("name", name); 
                startActivity(dfi); 
            } 
        }); 
    } 
    
    public boolean onCreateOptionsMenu(Menu menu){ 
        MenuInflater inflater = getMenuInflater(); 
        inflater.inflate(R.menu.options, menu); 
        return super.onCreateOptionsMenu(menu); 
    }
    
    public boolean onOptionsItemSelected(MenuItem item){ 
        switch(item.getItemId()){ 
            case R.id.action_mealplan:
                Intent i = new Intent(getApplicationContext(), MealPlanActivity.class); i.putExtra("name", name); 
                startActivity(i); 
                return true; 
            case R.id.action_about: 
                Intent ii = new Intent(getApplicationContext(), AboutActivity.class); 
                startActivity(ii); 
                return true; 
            default: 
                return super.onOptionsItemSelected(item); 
        } 
    } 
} 
