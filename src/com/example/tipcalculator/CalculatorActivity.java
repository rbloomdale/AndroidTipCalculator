package com.example.tipcalculator;

import java.text.NumberFormat;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	
	ArrayList<TipPercent> easyTips;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		easyTips = new ArrayList<TipPercent>();
		easyTips.add(new TipPercent(.1f));
		easyTips.add(new TipPercent(.15f));
		easyTips.add(new TipPercent(.2f));
		GridView tipButtonsView = (GridView) findViewById(R.id.easy_tip_buttons);
		TipPercentAdapter adapter = new TipPercentAdapter(this, easyTips);
		tipButtonsView.setAdapter(adapter);				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}
	
	/**
	 * @param percent should be between 0 and 1
	 */
	public void calculate(float percent)
	{
		if(percent < 0){
			
		}
		TextView result = (TextView) findViewById(R.id.resultTip);
		EditText checkTotalText = (EditText) findViewById(R.id.checkTotal);
		TextView newTotalText = (TextView) findViewById(R.id.newTotal);
		float checkTotalFloat = Float.parseFloat(checkTotalText.getText().toString());
		
		float newTip = checkTotalFloat*percent;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		result.setText(getResources().getText(R.string.tip_header)+currencyFormat.format(newTip));
		newTotalText.setText(getResources().getText(R.string.new_total_header)+currencyFormat.format(newTip + checkTotalFloat));
	}

}
