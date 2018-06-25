package util;

import android.app.TimePickerDialog;
import android.content.Context;

public class time extends TimePickerDialog{

	public time(Context context, int theme, OnTimeSetListener callBack,
			int hourOfDay, int minute, boolean is24HourView) {
		super(context, theme, callBack, hourOfDay, minute, is24HourView);
		// TODO Auto-generated constructor stub
	}

	public time(Context context, OnTimeSetListener callBack, int hourOfDay,
			int minute, boolean is24HourView) {
		super(context, callBack, hourOfDay, minute, is24HourView);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		//super.onStop();
	}
	

}
