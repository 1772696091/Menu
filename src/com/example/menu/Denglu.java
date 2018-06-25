package com.example.menu;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.httpconnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint({ "NewApi", "HandlerLeak" })
public class Denglu extends Activity implements OnClickListener{
private EditText ed_zhanghao;
private EditText ed_mima;
private Button bt_dl;
private Button bt_zc;
private String result;
private Handler handler=new Handler(){

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		switch (msg.what) {
		case 100:
			Denglu.this.denglu();
			break;
		case 101:
			Denglu.this.toast();
			break;
		case 103:
			Denglu.this.toast1();
			break;
		default:
			Denglu.this.toast2();
			break;
		}
	}
	
};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_denglu);
		init();
		
	}
	public void init(){
		ed_zhanghao=(EditText)findViewById(R.id.zhanghao);
		ed_mima=(EditText)findViewById(R.id.mima);
		bt_dl=(Button)findViewById(R.id.denglu);
		bt_zc=(Button)findViewById(R.id.zhuce);
		bt_dl.setOnClickListener(this);
		bt_zc.setOnClickListener(this);
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void onClick(View arg0) {
		String zhanghao=ed_zhanghao.getText().toString().trim();
		String mima=ed_mima.getText().toString().trim();
		if(!zhanghao.isEmpty()&&!mima.isEmpty()){
			 Pattern p = Pattern.compile("[0-9]*"); 
			 Matcher m = p.matcher(zhanghao); 
			 if(!m.matches()){
				 Toast.makeText(this,"账号只能是数字", Toast.LENGTH_SHORT).show();
			 }else if(Pattern.compile("[\u4e00-\u9fa5]").matcher(mima).matches()){
				 Toast.makeText(this,"密码不能为文字", Toast.LENGTH_SHORT).show();
			}else{
				switch (arg0.getId()) {
				case R.id.denglu:
					final String Json="username:"+zhanghao+",password:"+mima;
					Thread thread=new Thread(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/user/login1");
								result=coon.post(Json);
								Log.i("asd", "result="+result);
								if(result==null){
									result="失败";
								}
								if(!result.isEmpty()&&result.equals("success")){
								handler.sendEmptyMessage(100);}else{
									handler.sendEmptyMessage(101);
									}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					};
					thread.start();
					break;

				default:
					final String mJson="username:"+zhanghao+",password:"+mima;
					Thread mythread=new Thread(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								httpconnection coon=new httpconnection("http://192.168.43.26:8080/H5music/news/addnew2");
								result=coon.post(mJson);
								if(!result.isEmpty()&&result.equals("success")){
								handler.sendEmptyMessage(103);}else{
									handler.sendEmptyMessage(104);
									}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					};
					mythread.start();
					break;
				}
			}
		}else{
			Toast.makeText(this,"账号与密码不能为空", Toast.LENGTH_SHORT).show();
		}
	}
	public void denglu(){
		Intent intent=new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	public void toast(){
		Toast.makeText(this,"登录失败，请稍后再试！" ,Toast.LENGTH_SHORT).show();
	}
	public void toast1(){
		Toast.makeText(this,"注册成功，请登录！" ,Toast.LENGTH_SHORT).show();
	}
	public void toast2(){
		Toast.makeText(this,"注册失败，请稍后再试！" ,Toast.LENGTH_SHORT).show();
	}
}