package viewpager;
import com.example.menu.R;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.support.v4.app.Fragment;

@SuppressLint("NewApi")
public class MyFragment1 extends Fragment{
	private static WebView webview;
    private WebSettings webSettings;
    private ProgressBar prograssbar;
	 public MyFragment1() {
	    }
	 public WebView getWeb(){
		return webview;}
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragementwebview, container, false);
	        webview =(WebView) view.findViewById(R.id.web);
	        prograssbar=(ProgressBar) view.findViewById(R.id.progressbar);
	        webview.loadUrl("https://www.jkyd.net/"); 
	        webSettings = webview.getSettings();
	        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小 
	        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
	        //缩放操作
	        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
	        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
	        webSettings.setDisplayZoomControls(false);
	        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
	        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
	        //设置不用系统浏览器打开,直接显示在当前Webview
	        webview.setWebViewClient(new WebViewClient() {
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);
	                return true;
	            }
	            @Override
	            public void onPageFinished(WebView view, String url) {//页面加载完成
	                prograssbar.setVisibility(View.INVISIBLE);
	            }

	            @Override
				public void onPageStarted(WebView view, String url,
						Bitmap favicon) {
					// TODO Auto-generated method stub
					super.onPageStarted(view, url, favicon);
					 prograssbar.setVisibility(View.VISIBLE);
				}
	        });
	        

	        
			return view;
	    }
}
	      