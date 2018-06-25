package viewpager;

import java.io.IOException;
import java.util.ArrayList;

import util.httpconnection;

import com.example.menu.R;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.Fragment;

@SuppressLint("NewApi")
public class MyFragment2 extends Fragment{
	 public MyFragment2() {
	    }
	private ListView listview;
	 private ArrayList<wenzhang> arraylist;
	 private oneadapter adapter;
	 private View view;
	 private Button bt;
	 private Button bt2;
	 private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case 100:
				ArrayList<wenzhang> list=(ArrayList<wenzhang>) msg.obj;
				arraylist.removeAll(arraylist);
				arraylist.addAll(list);
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
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        view = inflater.inflate(R.layout.fragementluntan, container, false);
	        listview=(ListView) view.findViewById(R.id.list_luntan);
	        bt=(Button) view.findViewById(R.id.Bt_fabiao);
	        bt2=(Button) view.findViewById(R.id.Bt_shuaxin);
	        arraylist=new ArrayList<wenzhang>();
	        adapter=new oneadapter(getActivity(), arraylist);
	        bt.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(getActivity(), FabiaoActivity.class);
					startActivity(intent);
				}
			});
	        listview.setAdapter(adapter);
	        listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					wenzhang mwz=arraylist.get(arg2);
					Intent intent=new Intent(view.getContext(), ItemActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					Bundle bd=new Bundle();
					bd.putString("title", mwz.getTitle());
					bd.putString("neirong", mwz.getNeirong());
					intent.putExtras(bd);
					startActivity(intent);
				}
			});
	        Thread thread=new Thread(){
	        	@Override
	        	public void run() {
	        		// TODO Auto-generated method stub
	        		try {
	        			httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew4");
	        			ArrayList<wenzhang> list=coon.getJson("请求更新论坛");
	        			if(list!=null){
	        				for(int k=0;k<list.size();k++){
	        				}
	        				Message msg=handler.obtainMessage();
	        				msg.obj=list;
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
bt2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Thread mythread=new Thread(){
			        	@Override
			        	public void run() {
			        		// TODO Auto-generated method stub
			        		try {
			        			httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew4");
			        			ArrayList<wenzhang> list=coon.getJson("请求更新论坛");
			        			if(list!=null){
			        				for(int k=0;k<list.size();k++){
			        				}
			        				Message msg=handler.obtainMessage();
			        				msg.obj=list;
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
			        mythread.start();
				}
			});
	        return view;
	    }
	}