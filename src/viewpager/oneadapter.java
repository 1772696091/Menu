package viewpager;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class oneadapter extends BaseAdapter{
	private ArrayList<wenzhang> list;
	private LayoutInflater inflater;
	private ViewHolde holder;
	private wenzhang wz;
	private Context context;
	public oneadapter(Context context,ArrayList<wenzhang> list){
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
			arg1=inflater.inflate(com.example.menu.R.layout.item_luntan, arg2, false);
			holder=new ViewHolde();
			holder.title=(TextView)arg1.findViewById(com.example.menu.R.id.title);
			holder.neirong=(TextView)arg1.findViewById(com.example.menu.R.id.neirong);
			holder.huifu=(TextView)arg1.findViewById(com.example.menu.R.id.huifu);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		wz=list.get(arg0);
		holder.title.setText(wz.getTitle());
		holder.neirong.setText(wz.getNeirong());
		holder.huifu.setText(wz.getHuifu()+"");
		
		return arg1;
	}
	static class ViewHolde{
		TextView title;
		TextView neirong;
		TextView huifu;
	}


}
