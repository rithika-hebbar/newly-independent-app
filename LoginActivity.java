package com.example.newlyindependent; 
import android.app.Activity; 
import android.content.Intent; 
import android.database.Cursor; 
import android.os.Bundle; 
import android.view.View; 
import android.view.Window; 
import android.widget.*;

public class LoginActivity extends Activity { 
    Button login, register; 
    EditText email, password; 
    DatabaseHelper db;
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_login); 
        login = (Button)findViewById(R.id.btnlogin1); 
        register = (Button)findViewById(R.id.btnregister); 
        email = (EditText)findViewById(R.id.etlogemail); 
        password = (EditText)findViewById(R.id.etpassl); 
        db = new DatabaseHelper(this); 
        login.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                String emailstr = email.getText().toString(); 
                String passstr = password.getText().toString(); 
                if(emailstr.equals("")||passstr.equals("")) { 
                    Toast.makeText(LoginActivity.this, "Please enter all the details to continue!", Toast.LENGTH_SHORT).show(); 
                } else{ 
                    Boolean logincheck = db.loginCheck(emailstr, passstr); 
                    String intentname=""; 
                    if(logincheck) { 
                        Cursor result = db.getName(emailstr, passstr); 
                        if(result.moveToFirst()) { 
                            intentname = result.getString(result.getColumnIndex("name")); 
                        } 
                        Toast.makeText(LoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show(); 
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class); 
                        i.putExtra("name", intentname); 
                        startActivity(i); 
                        if (result != null && !result.isClosed()) { 
                            result.close();
                        } 
                    } else{ 
                        Toast.makeText(LoginActivity.this, "Invalid email or password!", Toast.LENGTH_SHORT).show(); 
                    } 
                } 
            } 
        }); 
        register.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View arg0) { 
                // TODO Auto-generated method stub 
                Intent i = new Intent(getApplicationContext(), MainActivity.class); 
                startActivity(i); 
            } 
        }); 
    } 
}
