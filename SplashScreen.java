package com.example.newlyindependent; 
import java.util.Timer; 
import java.util.TimerTask; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.Window;

public class SplashScreen extends Activity{ 
    long delay=7000;
  
    @Override 
    protected void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_splash); 
        Timer RunSplash = new Timer(); 
        TimerTask show = new TimerTask(){ 
            @Override 
            public void run(){ 
                finish(); 
                Intent i = new Intent(SplashScreen.this, LoginActivity.class); 
                startActivity(i); 
            }
        }; 
        RunSplash.schedule(show, delay); 
    }
    
    @Override 
    public boolean onCreateOptionsMenu(Menu menu){ 
        getMenuInflater().inflate(R.menu.main, menu); 
        return true; 
    } 
} 
