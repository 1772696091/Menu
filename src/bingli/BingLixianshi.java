package bingli;

import com.example.menu.R;
import com.example.menu.R.id;
import com.example.menu.R.layout;
import com.example.menu.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class BingLixianshi extends Activity {
	private String yonghu;
	private String leixing;
	private String yiyuan;
	private String keshi;
	private String doctor;
	private String juti;
	private String jianyi;
	private TextView ed_name;
	private TextView ed_leixing;
	private TextView ed_yiyuan;
	private TextView ed_keshi;
	private TextView ed_yisheng;
	private TextView ed_juti;
	private TextView ed_jianyi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bing_lixianshi);
		Sqlitehelper openhelper=new Sqlitehelper(getApplicationContext(), "suiyi", null, 1);
		SQLiteDatabase db=openhelper.getReadableDatabase();
		Intent intent=getIntent();
		String name=intent.getStringExtra("data");
		ed_name=(TextView)findViewById(R.id.XSname);
		ed_leixing=(TextView)findViewById(R.id.XSleixing);
		ed_yiyuan=(TextView)findViewById(R.id.XSyiyuan);
		ed_keshi=(TextView)findViewById(R.id.XSkeshi);
		ed_yisheng=(TextView)findViewById(R.id.XSyisheng);
		ed_juti=(TextView)findViewById(R.id.XSjutibingqing);
		ed_jianyi=(TextView)findViewById(R.id.XSyishnegjianyi);
		if(name!=null){
			Cursor cs=db.query("bingli", null, "name=?",new String[]{name}, null, null, null);
			if(cs.moveToFirst()){ 
				yonghu=cs.getString(1);				
				leixing=cs.getString(2);				
				yiyuan=cs.getString(3);
				doctor=cs.getString(4);
				keshi=cs.getString(5);
				juti=cs.getString(6);
				jianyi=cs.getString(7);
				ed_name.setText(yonghu);
				ed_leixing.setText(leixing);
				ed_jianyi.setText(jianyi);
				ed_juti.setText(juti);
				ed_keshi.setText(keshi);
				ed_yisheng.setText(doctor);
				ed_yiyuan.setText(yiyuan);
			}else{
				Toast.makeText(getApplicationContext(), "妈的智障了！", Toast.LENGTH_LONG).show();
			}
		}else{
			Toast.makeText(getApplicationContext(), "出现了未知错误", Toast.LENGTH_LONG).show();
		}
		
		
	}


}
