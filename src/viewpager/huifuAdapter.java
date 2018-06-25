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

	public class huifuAdapter extends BaseAdapter{
		private ArrayList<huifu> list;
		private LayoutInflater inflater;
		private ViewHolde holder;
		private huifu hf;
		private Context context;
		public huifuAdapter(Context context,ArrayList<huifu> list){
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
				arg1=inflater.inflate(com.example.menu.R.layout.item_huifu, arg2, false);
				holder=new ViewHolde();
				holder.huifu=(TextView)arg1.findViewById(com.example.menu.R.id.Text_huifu);
				arg1.setTag(holder);
			}else{
				holder = (ViewHolde) arg1.getTag();
			}
			hf=list.get(arg0);
			holder.huifu.setText(hf.getHuifu()+"");
			
			return arg1;
		}
		static class ViewHolde{
			TextView huifu;
		}

	}


