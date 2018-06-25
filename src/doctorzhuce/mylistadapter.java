package doctorzhuce;
import java.util.ArrayList;
import com.example.menu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class mylistadapter extends BaseAdapter{
	private ArrayList<myyaodian> list;
	private LayoutInflater inflater;
	private ViewHolde holder;
	public mylistadapter(Context context,ArrayList<myyaodian> list){
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
		if(arg1==null){
			arg1=inflater.inflate(com.example.menu.R.layout.item_yaodian, arg2, false);
			holder=new ViewHolde();
			holder.name=(TextView)arg1.findViewById(R.id.yaodian);
			holder.dizhi=(TextView)arg1.findViewById(R.id.dizhi);
			holder.im=(ImageView)arg1.findViewById(R.id.yaodiantupian);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolde) arg1.getTag();
		}
		holder.name.setText(list.get(arg0).getMingcheng());
		holder.dizhi.setText("��ַ��"+list.get(arg0).getDizhi());
		holder.im.setBackgroundResource(list.get(arg0).getImageid());
		return arg1;
	}
	static class ViewHolde{
		TextView name;
		TextView dizhi;
		ImageView im;
	}


}
