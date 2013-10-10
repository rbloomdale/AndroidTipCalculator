package com.example.tipcalculator;

import java.text.NumberFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class TipPercentAdapter extends ArrayAdapter<TipPercent> {
	
	public TipPercentAdapter(Context context, List<TipPercent> tips){
		super(context, 0, 0, tips);
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		//Get data item
		final TipPercent tip = getItem(position);
		
		LayoutInflater inflater = LayoutInflater.from(getContext());
		Button button = (Button) inflater.inflate(R.layout.tip_button, null);
		button.setText(NumberFormat.getPercentInstance().format(tip.getPercent()));
		button.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CalculatorActivity activity = (CalculatorActivity) TipPercentAdapter.this.getContext();
				activity.calculate(tip.percent);
			}
			
		});
		return button;
	}
}
