package com.example.telephonymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class NavigationActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        pagerAdapter = new PagerAdapter(this);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT " + (position + 1))
        ).attach();
    }

    public class PagerAdapter extends FragmentStateAdapter {
        public PagerAdapter(FragmentActivity fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Return a NEW fragment instance in createFragment(int)

            switch (position) {
                case 0: return new ScreenSlidePageFragment();
                case 1: return new BlankFragment();
                default: return new ScreenSlidePageFragment();
            }

        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(0);
        }
    }
}