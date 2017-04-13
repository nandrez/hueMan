package com.nandrez.hueman.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.nandrez.hueman.R;

public class HueActivity extends FragmentActivity {
    
    private HuePagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hue);
        
        initTabLayout();
    }
    
    private void initTabLayout() {
        pagerAdapter = new HuePagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    
    public class HuePagerAdapter extends FragmentPagerAdapter {
        
        private LightSwitchFragment lightSwitchFragment;
        private LightGroupManager lightGroupManager;
    
        public HuePagerAdapter(FragmentManager fm) {
            super(fm);
            lightSwitchFragment = new LightSwitchFragment();
        }
    
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    return lightSwitchFragment;
                case 2:
                    return lightGroupManager;
                default:
                    return lightSwitchFragment;
            }
        }
    
        @Override
        public int getCount() {
            return 2;
        }
    }
    
    public class LightSwitchFragment extends Fragment {
        
    }
    
    public class LightGroupManager extends Fragment {
        
    }

}
