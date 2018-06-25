package viewpager;
import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class zixunAdapter extends BaseAdapter{
	private ArrayList<doctor> list;
	private LayoutInflater inflater;
	private ViewHolde holder;
	private doctor doc;
	private Context context;
	public zixunAdapter(Context context,ArrayList<doctor> list){
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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(arg1==null){
			arg1=inflater.inflate(com.example.menu.R.layout.item_zixun, arg2, false);
			holder=new ViewHolde();
			holder.name=(TextView)arg1.findViewById(com.example.menu.R.id.name);
			holder.hospital=(TextView)arg1.findViewById(com.example.menu.R.id.hospital);
			holder.jianjie=(TextView)arg1.findViewById(com.example.menu.R.id.jieshao);
			holder.bt=(Button) arg1.findViewById(com.example.menu.R.id.Bt_ZIXUN);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		doc=list.get(arg0);
		holder.name.setText(doc.getName());
		holder.hospital.setText(doc.getHospital());
		holder.jianjie.setText(doc.getJianjie());
		holder.bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,ZixunActivity.class);
				intent.putExtra("name", doc.getName());
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		
		return arg1;
	}
	static class ViewHolde{
		TextView name;
		TextView hospital;
		TextView jianjie;
		Button bt;
	}

}
