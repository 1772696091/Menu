package viewpager;

import java.io.IOException;
import java.util.ArrayList;

import util.httpconnection;

import com.example.menu.R;
import com.example.menu.R.id;
import com.example.menu.R.layout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

@SuppressLint("NewApi")
public class MyFragment3 extends Fragment{
	private ListView listview;
	private zixunAdapter adapter;
	private View view;
	ArrayList<doctor> list;
	 private Handler handler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case 100:
					ArrayList<doctor> t=(ArrayList<doctor>) msg.obj;
					list.addAll(t);
			        adapter.notifyDataSetChanged();
					break;
				case 101:
					view.setBackgroundResource(com.example.menu.R.drawable.godie);
					//view.findViewById(R.id.Bt_fabiao).setVisibility(View.INVISIBLE);
					break;
				default:
					
					break;
				}
			}
			 
		 };
	 public MyFragment3() {
	    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragementzixun, container, false);
        listview=(ListView) view.findViewById(R.id.list_zixun);
        list=new ArrayList<doctor>();
        adapter=new zixunAdapter(getActivity(), list);
        listview.setAdapter(adapter);
        Thread thread=new Thread(){
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        		try {
        			httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew11");
        			ArrayList<doctor> mylist=coon.getdoctor("请求更新咨询医生");
        			if(mylist!=null){
        				Message msg=handler.obtainMessage();
        				msg.obj=mylist;
        				msg.what=100;
        				handler.sendMessage(msg);
        				}else{
        					handler.sendEmptyMessage(101);
        				}
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        };
        thread.start();
        return view;
    }
}
