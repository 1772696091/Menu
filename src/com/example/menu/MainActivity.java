package com.example.menu;
import doctorzhuce.Yaodian;
import fankui.YiJianFanKui;
import gunayu.myAbout;
import bingli.BingLi;
import tixing.TiXing;
import viewpager.MyFragment1;
import viewpager.fragementviewpageradapter;
import menu_dialog.menu_dialog;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener {
	
    private menu_dialog dialog;
    private ImageButton menubutton;
    private RadioGroup rg;
    private RadioButton rb_webview;
    private RadioButton rb_luntan;
    private RadioButton rb_zixun;
    private ViewPager vpager;
    private Intent intent;
    private long exitTime = 0;
    private fragementviewpageradapter mAdapter;
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_main);
        mAdapter = new fragementviewpageradapter(getSupportFragmentManager());
		dialog=new menu_dialog(MainActivity.this,R.layout.activity_dialog, R.style.Theme_dialog);
        menubutton=(ImageButton)findViewById(R.id.menu);
        menubutton.setOnClickListener(MainActivity.this); 
		initView(); 
	    rb_webview.setChecked(true);
    }
    private void initView() {
        TextView bingli = (TextView)dialog.findViewById(com.example.menu.R.id.bingli); 
        TextView tixing = (TextView)dialog.findViewById(com.example.menu.R.id.tixing);  
        TextView doctor = (TextView)dialog.findViewById(com.example.menu.R.id.doctor); 
        TextView returnme = (TextView)dialog.findViewById(com.example.menu.R.id.returnme); 
        TextView about = (TextView)dialog.findViewById(com.example.menu.R.id.about); 
        rg=(RadioGroup)findViewById(R.id.rg);
        rb_webview=(RadioButton)findViewById(R.id.rb1);
        rb_luntan=(RadioButton)findViewById(R.id.rb2);
        rb_zixun=(RadioButton)findViewById(R.id.rb3);
        rg.setOnCheckedChangeListener(this);
        about.setOnClickListener(MainActivity.this);  
        bingli.setOnClickListener(MainActivity.this);  
        tixing.setOnClickListener(MainActivity.this);  
        doctor.setOnClickListener(MainActivity.this); 
        returnme.setOnClickListener(MainActivity.this); 
        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setOnPageChangeListener(this);
    }
	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkId) {
		// TODO Auto-generated method stub
		 switch (checkId) {
         case R.id.rb1:
             vpager.setCurrentItem(PAGE_ONE);
             break;
         case R.id.rb2:
             vpager.setCurrentItem(PAGE_TWO);
             break;
         case R.id.rb3:
             vpager.setCurrentItem(PAGE_THREE);
             break;
         default:
             break;

     }
	}  
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.menu:
			dialog.show();
			break;
		case R.id.bingli:
			intent=new Intent(this, BingLi.class);
			startActivity(intent);
			break;
		case R.id.tixing:
			intent=new Intent(this, TiXing.class);
			startActivity(intent);
			break;
		case R.id.doctor:
			intent=new Intent(this, Yaodian.class);
			startActivity(intent);
			break;
		case R.id.returnme:
			intent=new Intent(this, YiJianFanKui.class);
			startActivity(intent);
			break;
		case R.id.about:
			intent=new Intent(this, myAbout.class);
			startActivity(intent);
			break;
		default:
			break;
		}
    
	}
	@Override
	public void onPageScrollStateChanged(int state) {
		// TODO Auto-generated method stub
		  if (state == 2) {
	            switch (vpager.getCurrentItem()) {
	                case PAGE_ONE:
	                    rb_webview.setChecked(true);
	                    break;
	                case PAGE_TWO:
	                    rb_luntan.setChecked(true);
	                    break;
	                case PAGE_THREE:
	                    rb_zixun.setChecked(true);
		            	break;
		            default:
		            	break;
	            }
		  }
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onBackPressed() {
        MyFragment1 fragement=new MyFragment1();
    	WebView view=fragement.getWeb();
    	if(view.canGoBack()){
    		view.goBack();
    	}else{
    	       if ((System.currentTimeMillis() - exitTime) > 2000) {
    	            Toast.makeText(getApplicationContext(), "再按一次退出程序",
    	                    Toast.LENGTH_SHORT).show();
    	            exitTime = System.currentTimeMillis();
    	        } else {
    	            super.onBackPressed();
    	        }
    	}
    
}
	
}
