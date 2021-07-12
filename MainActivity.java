package com.example.newlyindependent; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.View; 
import android.view.Window; 
import android.widget.*;

public class MainActivity extends Activity { 
    Button register,login; 
    EditText name,email,pass1,pass2; 
    DatabaseHelper db; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_main); 
        register = (Button)findViewById(R.id.btnreg); 
        login = (Button) findViewById(R.id.btnlogin); 
        name = (EditText)findViewById(R.id.etname); 
        email = (EditText)findViewById(R.id.etemaill); 
        pass1 = (EditText)findViewById(R.id.etpass1); 
        pass2 = (EditText)findViewById(R.id.etpass2); 
        db = new DatabaseHelper(this); 
        register.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                String namestr = name.getText().toString(); 
                String emailstr = email.getText().toString(); 
                String pass1str = pass1.getText().toString(); 
                String pass2str = pass2.getText().toString(); 
                if(namestr.equals("")||emailstr.equals("")||pass1str.equals("")||pass2str.equals("")){ 
                    Toast.makeText(MainActivity.this, "Please enter all the details to register!", Toast.LENGTH_SHORT).show(); 
                }else{ 
                    if(pass1str.equals(pass2str)){ 
                        Boolean checkUser = db.checkUser(emailstr); 
                        if(checkUser==false){ 
                            Boolean insert = db.insertUser(namestr, emailstr, pass1str); 
                            if(insert){ 
                                Toast.makeText(MainActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show(); 
                                Intent i = new Intent(getApplicationContext(), HomeActivity.class); 
                                i.putExtra("name",namestr); 
                                startActivity(i); 
                            }else{ 
                                Toast.makeText(MainActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show(); 
                            } 
                        }else{ 
                            Toast.makeText(MainActivity.this, "User already exists! Please login.", Toast.LENGTH_SHORT).show(); 
                        } 
                    }else{ 
                        Toast.makeText(MainActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show(); 
                    } 
                } 
            } 
        }); 
        
        login.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent i = new Intent(getApplicationContext(), LoginActivity.class); 
                startActivity(i); 
            } 
        }); 
    } 
    
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
        // Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.main, menu); 
        return true; 
    } 
} 
