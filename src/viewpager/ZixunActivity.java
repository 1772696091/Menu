package viewpager;

import java.io.IOException;
import java.util.ArrayList;

import util.httpconnection;

import com.example.menu.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ZixunActivity extends Activity {
private ListView listview;
private TextView tx;
private EditText ed;
private Button bt;
private jiaoliuAdapter adapter;
private ArrayList<jiaoliu> list;
private Handler handler=new Handler(){

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		switch (msg.what) {
		case 100:
			String js=(String) msg.obj;
			list.add(new jiaoliu(js, true));
			adapter.notifyDataSetChanged();
			break;
		case 101:
			Toast.makeText(getApplicationContext(), "服务器连接失败，请稍后再试！", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
	
};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zixun);
		listview=(ListView) findViewById(R.id.list_jiaoliu);
		bt=(Button) findViewById(R.id.bt_jiaoliu);
		ed=(EditText)findViewById(R.id.ed_jiaoliu);
		tx=(TextView) findViewById(R.id.Tx_doctorname);
		Intent intent=getIntent();
		tx.setText(intent.getStringExtra("name"));
		list=new ArrayList<jiaoliu>();
		list.add(new jiaoliu("请问有什么可以帮到您的呢？", true));
		adapter=new jiaoliuAdapter(getApplicationContext(), list);
		listview.setAdapter(adapter);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final String msg=ed.getText().toString().trim();
				if(!msg.isEmpty()&&msg!=null){
					list.add(new jiaoliu(msg, false));
					Thread thread=new Thread(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew12");
								String result=coon.getzixun(msg);
								if(result!=null){
									Message mysg=new Message();
									mysg.obj=result;
									mysg.what=100;
									handler.sendMessage(mysg);}
								else{
									handler.sendEmptyMessage(101);
									}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					};
					thread.start();
				}else{
					Toast.makeText(getApplicationContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zixun, menu);
		return true;
	}

}
