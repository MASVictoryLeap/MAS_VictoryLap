package info.tabsswipe.adapter;


import info.tabsswipe.adapter.AppsPageFragment;
import info.tabsswipe.adapter.TopPlayersFragment;
import info.tabsswipe.adapter.UtilitiesFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	Context context;
    public TabsPagerAdapter(FragmentManager fm, Context e) {
        super(fm);
        this.context=e;
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new AppsPageFragment(context);
        case 1:
            // Utilities fragment activity
            return new UtilitiesFragment();
        case 2:
            // Top Rated fragment activity
            return new TopPlayersFragment();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}