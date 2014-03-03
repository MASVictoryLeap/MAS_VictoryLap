package info.androidhive.tabsswipe.adapter;


import info.androidhive.tabsswipe.adapter.AppsPageFragment;
import info.androidhive.tabsswipe.adapter.UtilitiesFragment;
import info.androidhive.tabsswipe.adapter.TopRatedFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new AppsPageFragment();
        case 1:
            // Utilities fragment activity
            return new UtilitiesFragment();
        case 2:
            // Top Rated fragment activity
            return new TopRatedFragment();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}