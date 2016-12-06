package com.example.triva;

import java.util.Arrays;

import com.example.triva.R.raw;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VidGameActivity extends ActionBarActivity {
	MediaPlayer mp1;
	MediaPlayer mp2;
	private int currentQuestion1;
	private String[] questions1;
	private String[] answers1;
	private Button answerButton1;
	private Button questionButton1;
	private TextView questionView1;
	private TextView answerView1;
	private EditText answerText1;
	int count = 0;
	TextView ScoreCount1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vid_game);

		init();

	}

	public void init() {
		questions1 = new String[] {
				"35 percent of Americans play video games true or false?",
				"How many people on planet earth are gamers millions or billions?",
				"What is the average age of video game users, is it 21 or 31?",
				"Which industry makes more money, video game sells or movie sells in 2013?",
				"Pikachu is one of the species of creatures in which series of games, Pokemon or Final Fantasy?",
				"Which game allows up to 64 players online in a given match, Call of Duty or Battlefield?",
				"Some games can be expanded with DLC. What dose DLC stand for? ",
				"Who plays more games on Facebook women or men?" };
		// Toast toast=Toast.makeText(this,questions1[2],Toast.LENGTH_SHORT);
		// toast.show();

		// Toast.makeText(VidGameActivity.this,
		// "You have finished the game"+Arrays.toString(questions1),
		// Toast.LENGTH_SHORT).show();
		// Toast Button
		// Toast.makeText(getApplicationContext(),"To start game hit show next button",
		// Toast.LENGTH_LONG).show();

		answers1 = new String[] { "False", "Billions", "31", "Video Games",
				"Pokemon", "Battlefield", "Downloadable content", "Women" };

		currentQuestion1 = -1;

		mp1 = MediaPlayer.create(VidGameActivity.this, raw.applause);
		mp2 = MediaPlayer.create(VidGameActivity.this, raw.boo);
		ScoreCount1 = (TextView) findViewById(R.id.ScoreCount1);
		ScoreCount1.setText(count + "");
		answerButton1 = (Button) findViewById(R.id.AnswerButton1);
		questionButton1 = (Button) findViewById(R.id.QuestionButton1);
		questionView1 = (TextView) findViewById(R.id.QuestionTextView1);
		answerView1 = (TextView) findViewById(R.id.AnswerTextView1);
		answerText1 = (EditText) findViewById(R.id.AnswerText1);

		answerButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer();
			}
		});

		questionButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showQuestion();

			}
		});

	}

	public void showQuestion() {

		if (currentQuestion1 == questions1.length - 1) {
			Toast.makeText(getApplicationContext(),
					"You have finished the game good job!", Toast.LENGTH_LONG)
					.show();
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					Intent intentHome = new Intent(VidGameActivity.this,
							HomeActivity.class);
					startActivity(intentHome);
					finish();
				}
			}, Toast.LENGTH_LONG * 2200);

			// currentQuestion =0;

		} else {
			currentQuestion1++;
			questionView1.setText(questions1[currentQuestion1]);
			answerView1.setText("");
			answerText1.setText("");
		}
	}

	// This method return true if the answer equals to correct
	// answer

	public boolean isCorrect(String answer) {
		return (answer.equalsIgnoreCase(answers1[currentQuestion1]));
	}

	/*
	 * this method : Read the answer from the answerTextEdit display the
	 * appropriate message.
	 */

	public void checkAnswer() {
		String answer = answerText1.getText().toString();

		count++;
		ScoreCount1.setText(count + "");

		if (isCorrect(answer)) {
			mp1.start();

			answerView1.setText("You're right!");
		}

		// keeps count of right answers
		// textViewCounter.setText("You have" +count);

		else {

			count--;
			ScoreCount1.setText(count + "");

			mp2.start();
			answerView1.setText("Sorry, the correct answer is "
					+ answers1[currentQuestion1]);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vid_game, menu);
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
