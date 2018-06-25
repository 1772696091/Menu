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
	        webSettings.setUseWideViewPort(true); //��ͼƬ�������ʺ�webview�Ĵ�С 
	        webSettings.setLoadWithOverviewMode(true); // ��������Ļ�Ĵ�С
	        //���Ų���
	        webSettings.setSupportZoom(true); //֧�����ţ�Ĭ��Ϊtrue���������Ǹ���ǰ�ᡣ
	        webSettings.setBuiltInZoomControls(true); //�������õ����ſؼ�����Ϊfalse�����WebView��������
	        webSettings.setDisplayZoomControls(false);
	        webSettings.setLoadsImagesAutomatically(true); //֧���Զ�����ͼƬ
	        webSettings.setDefaultTextEncodingName("utf-8");//���ñ����ʽ
	        //���ò���ϵͳ�������,ֱ����ʾ�ڵ�ǰWebview
	        webview.setWebViewClient(new WebViewClient() {
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);
	                return true;
	            }
	            @Override
	            public void onPageFinished(WebView view, String url) {//ҳ��������
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
	      