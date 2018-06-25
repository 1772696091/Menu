package viewpager;

import java.io.IOException;
import java.util.ArrayList;

import util.httpconnection;

import com.example.menu.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity implements OnClickListener{
private TextView tv1;
private TextView tv2;
private ListView listview;
private EditText ed;
private Button bt;
private String title;
private ArrayList<huifu> list;
private huifuAdapter adapter;
private Handler handler=new Handler(){

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case 100:
			ArrayList<huifu> list1=(ArrayList<huifu>) msg.obj;
			list.addAll(list1);
	        adapter.notifyDataSetChanged();
			break;
		case 101:
			listview.setBackgroundResource(com.example.menu.R.drawable.godie);
			//view.findViewById(R.id.Bt_fabiao).setVisibility(View.INVISIBLE);
			break;
		case 102:
			this.huifu();
			String hui=(String) msg.obj;
			list.add(new huifu(0, hui));
			adapter.notifyDataSetChanged();
			ed.setText("");
			break;
		case 103:
			this.shibai();
			break;
		default:
			this.kong();
			break;
		}
	}

	private void kong() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "啥也没写！", Toast.LENGTH_SHORT).show();
	}

	private void shibai() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "服务器异常，回复失败！", Toast.LENGTH_SHORT).show();
	}

	private void huifu() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "回复成功", Toast.LENGTH_SHORT).show();
	}
	 
 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		init();
	}
public void init(){
	tv1=(TextView) findViewById(R.id.Text_title);
	tv2=(TextView) findViewById(R.id.Text_neirong);
	listview=(ListView) findViewById(R.id.list_huifu);
	ed=(EditText) findViewById(R.id.Ed_huifu);
	bt=(Button) findViewById(R.id.BT_huifu);
	Intent intent=getIntent();
	Bundle bd=intent.getExtras();
	title=bd.getString("title");
	tv1.setText(title);
	tv2.setText(bd.getString("neirong"));
	list=new ArrayList<huifu>();
	adapter=new huifuAdapter(getApplicationContext(), list);
	 listview.setAdapter(adapter);
	bt.setOnClickListener(this);
	  Thread thread=new Thread(){
      	@Override
      	public void run() {
      		// TODO Auto-generated method stub
      		try {
      			httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew5");
      			Log.i("asd", title);
      			ArrayList<huifu> t=coon.getHuifu(title);
      			for(int k=0;k<t.size();k++){
      				Log.i("asd",t.get(k).getHuifu());
      			}
      			if(t!=null){
      				Message msg=handler.obtainMessage();
      				msg.obj=t;
      				msg.what=100;
      				handler.sendMessage(msg);}else{
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
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.BT_huifu:
			final String myhuifu=ed.getText().toString().trim();
			if(myhuifu!=null){
				Thread thread=new Thread(){
			      	@Override
			      	public void run() {
			      		// TODO Auto-generated method stub
			      		try {
			      			httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew6");
			      			String result=coon.post(title+","+myhuifu);
			      			if(result!=null){
			      				Message msg=handler.obtainMessage();
			      				msg.obj=myhuifu;
			      				msg.what=102;
			      				handler.sendMessage(msg);
			      				}else{
			      					handler.sendEmptyMessage(103);
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
				Message msg=handler.obtainMessage();
  				msg.what=104;
  				handler.sendMessage(msg);
			}
			
			break;

		default:
			break;
		}
	}

}
