package com.example.newlyindependent; 
import android.app.Activity; 
import android.content.Intent; 
import android.net.Uri; 
import android.os.Bundle; 
import android.view.View; 
import android.view.Window; 
import android.widget.*; 
public class ChapatiActivity extends Activity{ 
TextView itemname; 
Button mealplan; 
ProgressBar time; 
RatingBar ease; 
String name; 
protected void onCreate(Bundle savedInstanceState){ 
super.onCreate(savedInstanceState); 
requestWindowFeature(Window.FEATURE_NO_TITLE); 
setContentView(R.layout.activity_chapati); 
Intent i = getIntent(); 
name = i.getExtras().getString("name"); 
VideoView videoView = (VideoView) findViewById(R.id.videoView1); 
Uri uri = Uri.parse("android.resource://com.example.newlyindependent/"+R.raw.chapavid); videoView.setVideoURI(uri); 
MediaController mediaController = new MediaController(this); 
videoView.setMediaController(mediaController); 
mediaController.setAnchorView(videoView); 
time = (ProgressBar)findViewById(R.id.progressBar1); 
time.setMax(60); 
time.setProgress(30);
ease = (RatingBar)findViewById(R.id.ratingBar1); 
ease.setRating(Float.parseFloat("3.5")); 
mealplan = (Button)findViewById(R.id.btnrec); 
itemname = (TextView)findViewById(R.id.tvitem); 
mealplan.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View arg0) { 
// TODO Auto-generated method stub 
String item = itemname.getText().toString(); 
Intent mi = new 
Intent(getApplicationContext(),PlanMealActivity.class); mi.putExtra("name", name); 
mi.putExtra("item", item); 
startActivity(mi); 
} 
}); 
} 
}

