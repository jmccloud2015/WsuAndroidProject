package com.example.triva;


import com.example.triva.R.raw;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;


public class TriviaActivity extends ActionBarActivity {
	
  
    //TextView textViewCounter; 
  
	
    MediaPlayer mp1; 
    MediaPlayer mp2;
	private int currentQuestion; 
    private String[] questions;
    private String[] answers; 
    private Button answerButton; 
    private Button questionButton;
    private TextView questionView;
    private TextView answerView;
    private EditText answerText; 
    int count = 0; 
    TextView ScoreCount; 
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
       
        
        init();
        
    }
    
    public void init() 
    {
    questions = new String[]{"What company is the largest producer of computer software for the personal computer?", 
   " What year was the first iPhone released 2007 or 2008? ", " Which day of the week gets the most post on instagram?", " Which company is the leading platform for smartphone use in the U.S., Android or Apple.",
   "About how many Facebook users are there 100,000,000 or 800,000,000.?",
   "Which phone company owns the patent for the slide unlock feature Samsung or apple?.", "65 % of smartphone users download 0 apps per month. true or false?",
   "Android was updated for the first time in Feb 2009 and what was its name, Cupcake or Donut?"};
    
    //Toast Message 
    Toast.makeText(getApplicationContext(),"To start game hit show next button", Toast.LENGTH_LONG).show();
    
    
    answers = new String[]{"Microsoft", "2007", "Thursday", "Android", "800,000,000","Apple","True","Cupcake"  };
    
   
    currentQuestion = -1;
  
    mp1 = MediaPlayer.create(TriviaActivity.this, raw.applause);
    mp2 = MediaPlayer.create(TriviaActivity.this, raw.boo);
    ScoreCount = (TextView)findViewById(R.id.ScoreCount1); 
    ScoreCount.setText(count+"");
    answerButton = (Button)findViewById(R.id.AnswerButton1); 
    questionButton = (Button)findViewById(R.id.QuestionButton1); 
    questionView = (TextView) findViewById(R.id.QuestionTextView1); 		
    answerView = (TextView) findViewById(R.id.AnswerTextView1); 
    answerText = (EditText) findViewById(R.id.AnswerText1); 

  
    

    
    answerButton.setOnClickListener(new OnClickListener(){ 
    @Override 
    public void onClick(View v) { 
    checkAnswer(); 
    }
    }
    );

	
    
    questionButton.setOnClickListener(new OnClickListener(){ 
    @Override 
    public void onClick(View v) { 
    showQuestion();
   
    }
    }
    );
    
    }
    
    public void showQuestion() 
    { 
    
   
    if(currentQuestion == questions.length-1) {
    Toast.makeText(getApplicationContext(),"You have finished the game good job!", Toast.LENGTH_LONG).show();
    
    new Handler().postDelayed(new Runnable() {

		@Override
		public void run() {
			Intent intentHome = new Intent(TriviaActivity.this,
					HomeActivity.class);
			startActivity(intentHome);
			finish();
		}
	}, Toast.LENGTH_LONG * 2200);

        
    //currentQuestion =0; 
    
    }
    else{
    currentQuestion++; 
    questionView.setText(questions[currentQuestion]); 
    answerView.setText(""); 
    answerText.setText(""); 
    }
    }
    
 
//This method return true if the answer equals to correct 
//answer 
 
public boolean isCorrect(String answer) 
{ 
return (answer.equalsIgnoreCase(answers[currentQuestion])); 
} 

/* this method : 
 * Read the answer from the answerTextEdit 
 * display the appropriate message. 
*/

public void checkAnswer() 
{ 
String answer = answerText.getText().toString();

count++;
ScoreCount.setText(count+"");

if(isCorrect(answer)) {
mp1.start(); 




answerView.setText("You're right!"); 
}

//keeps count of right answers 
//textViewCounter.setText("You have" +count);

else {
	
count--;
ScoreCount.setText(count+"");
 
mp2.start();
answerView.setText("Sorry, the correct answer is "
+ answers[currentQuestion]);
}


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trivia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
