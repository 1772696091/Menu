package viewpager;

import java.io.IOException;

import util.httpconnection;
import com.example.menu.R;
import com.google.gson.Gson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class FabiaoActivity extends Activity implements OnClickListener{
private EditText ed_title;
private EditText ed_neirong;
private Button Bt_fanhui;
private Button Bt_tijiao;
private wenzhang wz;
private Handler handler=new Handler(){

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		switch (msg.what) {
		case 100:
			Toast.makeText(getApplicationContext(), "上传成功！", Toast.LENGTH_SHORT).show();
			onBackPressed();
			break;
		case 101:
			Toast.makeText(getApplicationContext(), "上传失败，请稍后再试！", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
	
};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabiao);
		ed_title=(EditText) findViewById(R.id.Ed_title);
		ed_neirong=(EditText) findViewById(R.id.Ed_neirong);
		Bt_fanhui=(Button) findViewById(R.id.Bt_qx);
		Bt_tijiao=(Button) findViewById(R.id.Bt_sc);
		Bt_fanhui.setOnClickListener(this);
		Bt_tijiao.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fabiao, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.Bt_qx:
			onBackPressed();
			break;
		case R.id.Bt_sc:
			String title=ed_title.getText().toString().trim();
			String neirong=ed_neirong.getText().toString().trim();
			Log.i("asd", "neirong"+neirong);
			if(!title.isEmpty() && !neirong.isEmpty()){
				wz=new wenzhang(0,title, neirong, 0);
				Gson gson=new Gson();
				final String jsonStr=gson.toJson(wz, wenzhang.class);
				Log.i("asd", jsonStr);
				Thread thread=new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew3");
							String result=coon.post(jsonStr);
							if(!result.isEmpty()&& result.equals("success")){
							handler.sendEmptyMessage(100);}else{
								handler.sendEmptyMessage(101);
								}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				};
				thread.start();
			}else{
				Toast.makeText(getApplicationContext(), "发帖内容不完整，请补充完整！", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		
	}

}
