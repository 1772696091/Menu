package tixing;

import java.util.ArrayList;
import com.example.menu.R;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class adapter extends BaseAdapter{
	private ArrayList<naoling> list;
	private LayoutInflater inflater;
	private ViewHolde holder;
	private AlarmManager manger;
	private PendingIntent pi;
	public adapter(Context context,ArrayList<naoling> list,AlarmManager m){
		inflater=LayoutInflater.from(context);
		this.list=list;
		manger=m;
	}
	public void setPi(PendingIntent pi) {
		this.pi = pi;
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
			arg1=inflater.inflate(com.example.menu.R.layout.item_naoling, arg2, false);
			holder=new ViewHolde();
			holder.title=(TextView)arg1.findViewById(R.id.naoling_title);
			holder.bt=(Button) arg1.findViewById(R.id.button_naoling);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		holder.title.setText(list.get(arg0).getTitle());
		holder.bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				 manger.cancel(pi);
				 list.remove(arg0);
				 Log.i("loh", "=======================================");
				 notifyDataSetChanged();
			}
		});
		return arg1;
	}
	static class ViewHolde{
		TextView title;
		Button bt;
	}


}
