package com.example.yinhao.bottomnavigationdemo;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = findViewById(R.id.view_pager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        List<Fragment> list = new ArrayList<>();
//        list.add(TestFragment.newInstance("onDraw"));
//        list.add(TestFragment.newInstance("Anim"));
//        list.add(TestFragment.newInstance("优秀控件"));
//        list.add(TestFragment.newInstance("xx"));
//        list.add(TestFragment.newInstance("xx"));
        list.add(TestFragment.newInstance("消息"));
        list.add(TestFragment.newInstance("联系人"));
        list.add(TestFragment.newInstance("办公"));
        list.add(TestFragment.newInstance("应用"));
        list.add(TestFragment.newInstance("我的"));
        viewPagerAdapter.setList(list);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.item_tab1:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.item_tab2:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.item_tab3:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.item_tab4:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.item_tab5:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };
}
