package fankui;

import com.example.menu.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YiJianFanKui extends Activity {
private EditText ed_fankui;
private Button bt_tijiao;
private Button bt_quxiao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_yi_jian_fan_kui);
		ed_fankui=(EditText)findViewById(R.id.ED_fankui);
		bt_tijiao=(Button)findViewById(R.id.BT_tijiao);
		bt_quxiao=(Button)findViewById(R.id.BT_quxiao);
		bt_tijiao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ed_fankui.setText("");
				Toast.makeText(getApplicationContext(), "·´À¡³É¹¦", 1000).show();
			}
		});
		bt_quxiao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yi_jian_fan_kui, menu);
		return true;
	}

}
