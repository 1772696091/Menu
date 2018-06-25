package viewpager;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class jiaoliuAdapter extends BaseAdapter{
	private ArrayList<jiaoliu> list;
	private LayoutInflater inflater;
	private ViewHolde holder;
	private jiaoliu jiaoliu;
	public jiaoliuAdapter(Context context,ArrayList<jiaoliu> list){
		inflater=LayoutInflater.from(context);
		this.list=list;
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
		jiaoliu=list.get(arg0);
		if(arg1==null){
			if(jiaoliu.isIsdoctor()==true){
				arg1=inflater.inflate(com.example.menu.R.layout.item_jiaoliu, arg2, false);
			}else{
				arg1=inflater.inflate(com.example.menu.R.layout.item_jiaoliu2, arg2, false);
			}
			holder=new ViewHolde();
			holder.jiaoliu=(TextView)arg1.findViewById(com.example.menu.R.id.tv_doctor);
			holder.jiaoliu2=(TextView)arg1.findViewById(com.example.menu.R.id.tv_huanzhe);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		jiaoliu=list.get(arg0);
		if(jiaoliu.isIsdoctor()==true){
			holder.jiaoliu.setText(jiaoliu.getJiaoliu());
		}else{
			holder.jiaoliu2.setText(jiaoliu.getJiaoliu());
		}	
		return arg1;
	}
	static class ViewHolde{
		TextView jiaoliu;
		TextView jiaoliu2;
	}
}
