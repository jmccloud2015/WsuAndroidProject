package com.example.triva;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity {
	Button Computers; 
	Button Game; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Toast.makeText(getApplicationContext(),"Select your catagory to start the game", Toast.LENGTH_LONG).show();
		
		 
		
		Game = (Button) this.findViewById(R.id.btnGame);
		Game.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeActivity.this, VidGameActivity.class);
				startActivity(intent); 
				
			}
		
		});
	
	
	
		Computers = (Button) this.findViewById(R.id.BtnComputers);
		Computers.setOnClickListener(new OnClickListener(){
		
	
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomeActivity.this, TriviaActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
