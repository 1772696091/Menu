package bingli;

import java.util.ArrayList;

import com.example.menu.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class BingLi extends Activity{
private ListView listview;
private ArrayList<myBingli> arraylist;
private Intent intent;
private arraylistadapter adapter;
private Button bt;
private Sqlitehelper openhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bing_li);
		listview=(ListView)findViewById(R.id.BingLilist);
		bt=(Button)findViewById(R.id.BingLixj);
		arraylist=new ArrayList<myBingli>();
		intent=new Intent(this,XinjianBL.class);
		openhelper=new Sqlitehelper(getApplicationContext(), "suiyi", null, 1);
		SQLiteDatabase db=openhelper.getReadableDatabase();
		Cursor cs=db.query("bingli", null, null, null,null, null,null);
		while(cs.moveToNext()){
			String yonghu=cs.getString(1);
			String leixing=cs.getString(2);
			String yiyuan=cs.getString(3);
			String doctor=cs.getString(4);
			String keshi=cs.getString(5);
			arraylist.add(new myBingli(yonghu, leixing, yiyuan, doctor, keshi));
		}
		adapter=new arraylistadapter(getApplicationContext(), arraylist);
		listview.setAdapter(adapter);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bing_li, menu);
		return true;
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		arraylist.clear();
		openhelper=new Sqlitehelper(getApplicationContext(), "suiyi", null, 1);
		SQLiteDatabase db=openhelper.getReadableDatabase();
		Cursor cs=db.query("bingli", null, null, null,null, null,null);
		while(cs.moveToNext()){
			String yonghu=cs.getString(1);
			String leixing=cs.getString(2);
			String yiyuan=cs.getString(3);
			String doctor=cs.getString(4);
			String keshi=cs.getString(5);
			arraylist.add(new myBingli(yonghu, leixing, yiyuan, doctor, keshi));
		}
		adapter.notifyDataSetChanged();
		super.onRestart();
	}


}
