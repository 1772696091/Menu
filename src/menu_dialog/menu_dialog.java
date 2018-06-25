package menu_dialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class menu_dialog extends Dialog{
	
	public menu_dialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("deprecation")
	public menu_dialog(Context context,int layout,int style) {
	super(context, style);
	//set content
	setContentView(layout);
	//set window params
	Window window = getWindow();
	WindowManager m=window.getWindowManager();
	WindowManager.LayoutParams params = window.getAttributes();
	//set width,height by density and gravity
	params.gravity = Gravity.LEFT|Gravity.TOP;
	Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
	params.height = (int) (d.getHeight()); // 高度设置为屏幕的高
	params.width = (int) (d.getWidth()*0.5); // 宽度设置为屏幕的0.4 
    params.alpha = 1f;
	window.setAttributes(params);
	
	}
	}

