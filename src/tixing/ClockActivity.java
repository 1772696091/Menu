package tixing;

import com.example.menu.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;

public class ClockActivity extends Activity {
    private MediaPlayer mediaPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
		Log.i("asd", "=====================================");
		mediaPlayer = MediaPlayer.create(this,R.raw.nao);
        mediaPlayer.start();
        //����һ���������ѵĶԻ���,���ȷ���ر�������ҳ��
        new AlertDialog.Builder(ClockActivity.this).setTitle("����").setMessage("С��С�����~")
                .setPositiveButton("�ر�����", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        ClockActivity.this.finish();
                    }
                }).show();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		 mediaPlayer.stop();
         ClockActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clock, menu);
		return true;
	}

}
