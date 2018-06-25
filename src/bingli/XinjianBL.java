package bingli;

import com.example.menu.R;
import com.example.menu.R.id;
import com.example.menu.R.layout;
import com.example.menu.R.menu;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class XinjianBL extends Activity {
private EditText ed_name;
private EditText ed_leixing;
private EditText ed_yiyuan;
private EditText ed_keshi;
private EditText ed_yisheng;
private EditText ed_juti;
private EditText ed_jianyi;
private Button bt;
private String name;
private String leixing;
private String yiyuan;
private String keshi;
private String yisheng;
private String juti;
private String jianyi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xinjian_bl);
		init();
		bt.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				name=ed_name.getText().toString().trim();
				leixing=ed_leixing.getText().toString().trim();
				yiyuan=ed_yiyuan.getText().toString().trim();
			    keshi=ed_keshi.getText().toString().trim();
				yisheng=ed_yisheng.getText().toString().trim();
				juti=ed_juti.getText().toString().trim();
				jianyi=ed_jianyi.getText().toString().trim();
				// TODO Auto-generated method stub
				if(name.isEmpty()&&leixing.isEmpty()&&yiyuan.isEmpty()&&keshi.isEmpty()&&yisheng.isEmpty()&&juti.isEmpty()&&jianyi.isEmpty()){
					Toast.makeText(getApplicationContext(), "内容不能为空",Toast.LENGTH_SHORT).show();
				}else{
					Sqlitehelper openhelper=new Sqlitehelper(getApplicationContext(), "suiyi", null, 1);
					SQLiteDatabase db=openhelper.getWritableDatabase();
					ContentValues values=new ContentValues();
					values.put("name", name);
					values.put("leixing", leixing);
					values.put("hospital", yiyuan);
					values.put("keshi", keshi);
					values.put("doctor", yisheng);
					values.put("juti", juti);
					values.put("jianyi", jianyi);
					db.insert("bingli", null, values);
					Toast.makeText(getApplicationContext(), "保存成功！！！",Toast.LENGTH_SHORT).show();
					onBackPressed();
				}
			}
		});
	}
	public void init(){
		ed_jianyi=(EditText)findViewById(R.id.ZCyishnegjianyi);
		ed_name=(EditText)findViewById(R.id.ZCname);
		ed_leixing=(EditText)findViewById(R.id.ZCleixing);
		ed_yiyuan=(EditText)findViewById(R.id.ZCyiyuan);
		ed_keshi=(EditText)findViewById(R.id.ZCkeshi);
		ed_yisheng=(EditText)findViewById(R.id.ZCyisheng);
		ed_juti=(EditText)findViewById(R.id.ZCjutibingqing);
		bt=(Button)findViewById(R.id.button1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xinjian_bl, menu);
		return true;
	}


}
