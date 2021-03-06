package com.example.tipcalculator;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}
	
	public boolean calcTip(View v) {
		EditText edtTotal = (EditText) findViewById(R.id.edtTotal);
		TextView tvTip = (TextView) findViewById(R.id.tvTip);
		
		if (edtTotal.getText().toString().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Please enter total amount first!";
			int duration = Toast.LENGTH_SHORT;
			Toast.makeText(context, text, duration).show();
			
			return false;
		}
		
		String strTotal = edtTotal.getText().toString();
		double dblTotal = Double.parseDouble(strTotal);
		
		double tip;

		switch(v.getId()) {
		case R.id.btn10pct:
			tip = 0.1;
		break;
		case R.id.btn15pct:
			tip = 0.15;
		break;
		case R.id.btn20pct:
			tip = 0.2;
		break;
		default:
		throw new RuntimeException("Unknown button ID");
		}
		
		tip *= dblTotal; 
		String strTip = String.format("%.2f", tip);
		tvTip.setText("Tip is:    $" + strTip);
		
		return true;
	}
}
