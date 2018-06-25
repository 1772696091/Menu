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
	private String[] yaodian=new String[]{"��٢�׷�(��÷԰��)","��٢�׷�(��һ�е�)","���ҩ��","��ɽ������ҩ��(��ʯ·��)","�𿵴�ҩ��(��ѻׯ��˾������)","��٢ҩ��(�����־ӵ�)","��٢ҩ��(������Է��)","һ���ô�ҩ��(������)","��٢ҩ��(��������)","�����ô�ҩ��̩ͨ��"};
	private String[] dizhi=new String[]{"�ӱ�ʡ�żҿ����Ŷ�����ʯ��·11��","�ӱ�ʡ�żҿ��и�������ˮ����·95�������С��41��¥","110����(��ˮ����·)","��վ�ֵ���ʯ��·2��6�ŵ���","��ʯ��·15��(��ѻׯ��˾������)","�������Ͻ�111�������־���","������������Է1��¥����","�ӱ�ʡ�żҿ�����������ˮ����·95","�ӱ�ʡ�żҿ����Ŷ���γһ��԰28��¥B��2�ŵ���1-102","�ӱ�ʡ�żҿ����Ŷ���ʢ�������26-7"};
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
