package doctorzhuce;
import java.util.ArrayList;
import com.example.menu.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class Yaodian extends Activity {
	private ListView listview;
	private ArrayList<myyaodian> arraylist;
	private mylistadapter adapter;
	private String[] yaodian=new String[]{"华佗套房(伊梅园店)","华佗套房(新一中店)","润佳药房","南山堂新兴药房(钻石路店)","金康大药房(老鸦庄镇司法所西)","华佗药房(名仕乐居店)","华佗药房(中兴西苑店)","一附好大药房(清河湾店)","华佗药房(果树场店)","德仁堂大药房通泰店"};
	private String[] dizhi=new String[]{"河北省张家口市桥东区钻石南路11号","河北省张家口市高新区清水河南路95号清河湾小区41号楼","110国道(清水河南路)","南站街道钻石南路2号6号底商","钻石南路15号(老鸦庄镇司法所西)","西河沿南街111号民仕乐居旁","高新区中兴西苑1号楼底商","河北省张家口市桥西区清水河南路95","河北省张家口市桥东区纬一花园28号楼B区2号底商1-102","河北省张家口市桥东区盛华西大街26-7"};
	private int[] imageid=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_docter_zhu_ce);
		arraylist=new ArrayList<myyaodian>();
		listview=(ListView) findViewById(R.id.list_yaodian);
		for(int i=0;i<10;i++){
			myyaodian yao=new myyaodian(imageid[i], yaodian[i], dizhi[i]);
			arraylist.add(yao);
		}
		adapter=new mylistadapter(getApplicationContext(), arraylist);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.docter_zhu_ce, menu);
		return true;
	}

}
