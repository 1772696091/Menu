package tixing;

import java.util.ArrayList;
import java.util.Calendar;

import util.time;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.menu.R;

public class TiXing extends Activity {
private ListView listview;
private PendingIntent pi;
private ArrayList<naoling> list;
private adapter adapter;
private Button bt;
private Intent intent;
private AlarmManager alarmManager;
private boolean isset=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ti_xing);
		listview=(ListView) findViewById(R.id.naoling);
		bt=(Button) findViewById(R.id.Bt_naoling);
		list=new ArrayList<naoling>();
		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		intent = new Intent(this,ClockActivity.class);
		adapter=new adapter(getApplicationContext(), list, alarmManager);
 		listview.setAdapter(adapter);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  Calendar currentTime = Calendar.getInstance();
	                new time(TiXing.this,
	                        new TimePickerDialog.OnTimeSetListener() {
	                            @Override
	                            public void onTimeSet(TimePicker view,
	                                                  int hourOfDay, int minute) {
	                            	pi = PendingIntent.getActivity(TiXing.this, 0, intent, 0);
	                            	adapter.setPi(pi);
	                                //设置当前时间
	                                Calendar c = Calendar.getInstance();
	                                c.setTimeInMillis(System.currentTimeMillis());
	                                // 根据用户选择的时间来设置Calendar对象
	                                c.set(Calendar.HOUR, hourOfDay);
	                                c.set(Calendar.MINUTE, minute);
	                                // ②设置AlarmManager在Calendar对应的时间启动Activity
	                                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
	                                Log.e("HEHE",c.getTimeInMillis()+"");   //这里的时间是一个unix时间戳
	                                // 提示闹钟设置完毕:
	                                if(minute<10){
	                                	list.add(new naoling(hourOfDay+":0"+minute));
	                                }else{
	                                list.add(new naoling(hourOfDay+":"+minute));}
	                                adapter.notifyDataSetChanged();
	                                Toast.makeText(TiXing.this, "闹钟设置完毕~",
	                                        Toast.LENGTH_SHORT).show();}
	                        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
	                        .get(Calendar.MINUTE), false).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ti_xing, menu);
		return true;
	}

}
