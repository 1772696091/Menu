package bingli;
import java.util.ArrayList;

import com.example.menu.R;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class arraylistadapter extends BaseAdapter{
private ArrayList<myBingli> list;
private LayoutInflater inflater;
private ViewHolde holder;
private myBingli bl;
private Context context;
public arraylistadapter(Context context,ArrayList<myBingli> list){
	inflater=LayoutInflater.from(context);
	this.list=list;
	this.context=context;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(arg1==null){
			arg1=inflater.inflate(com.example.menu.R.layout.item_bingli, arg2, false);
			holder=new ViewHolde();
			holder.name=(TextView)arg1.findViewById(R.id.textView2);
			holder.leixing=(TextView)arg1.findViewById(R.id.textView3);
			holder.hospital=(TextView)arg1.findViewById(R.id.textView4);
			holder.keshi=(TextView)arg1.findViewById(R.id.textView5);
			holder.doctor=(TextView)arg1.findViewById(R.id.textView6);
			holder.bt2=(Button)arg1.findViewById(R.id.delete);
			holder.bt1=(Button)arg1.findViewById(R.id.look);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		bl=list.get(arg0);
		holder.name.setText("������"+bl.getYonghu());
		holder.leixing.setText("���ͣ�"+bl.getLeixing());
		holder.hospital.setText(bl.getYiyuan());
		holder.keshi.setText(bl.getKeshi());
		holder.doctor.setText(bl.getDoctor());
		holder.bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,BingLixianshi.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				Log.i("log", "arg0============================"+arg0);
				intent.putExtra("data", list.get(arg0).getYonghu());
				context.startActivity(intent);
			}
		});
		holder.bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Sqlitehelper openhelper=new Sqlitehelper(context, "suiyi", null, 1);
				SQLiteDatabase db=openhelper.getWritableDatabase();
				Log.i("log", "bt2arg0============================"+arg0+1);
				db.delete("bingli","name=?",new String[]{list.get(arg0).getYonghu()});
				list.remove(arg0);
				notifyDataSetChanged();
			}
		});
		
		return arg1;
	}
	static class ViewHolde{
		TextView name;
		TextView leixing;
		TextView hospital;
		TextView keshi;
		TextView doctor;
		Button bt1;
		Button bt2;
	}

}
