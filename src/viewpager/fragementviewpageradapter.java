package viewpager;

import com.example.menu.MainActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class fragementviewpageradapter extends FragmentPagerAdapter{

		private final int PAGER_COUNT = 3;
	    private android.support.v4.app.Fragment myFragment1 = null;
	    private android.support.v4.app.Fragment myFragment2 = null;
	    private android.support.v4.app.Fragment myFragment3 = null;

	    public fragementviewpageradapter(FragmentManager fm) {
		super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
		// TODO Auto-generated constructor stub
	}
	    @Override
	    public int getCount() {
	        return PAGER_COUNT;
	    }


	    @Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			return super.instantiateItem(container, position);
		}
		@Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        super.destroyItem(container, position, object);
	    }

	    @Override
	    public android.support.v4.app.Fragment getItem(int position) {
	        android.support.v4.app.Fragment fragment = null;
	        switch (position) {
	            case MainActivity.PAGE_ONE:
	                fragment = myFragment1;
	                break;
	            case MainActivity.PAGE_TWO:
	                fragment = myFragment2;
	                break;
	            case MainActivity.PAGE_THREE:
	                fragment = myFragment3;
	            	break;
	            default:
		            	break;
	        }
	        return fragment;
	    }
}
