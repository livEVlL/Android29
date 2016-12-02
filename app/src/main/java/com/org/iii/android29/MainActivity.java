package com.org.iii.android29;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager =(ViewPager) findViewById(R.id.pager);
        initViewPager();
    }

    private void initViewPager(){
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);

        View p0 = inflater.inflate(R.layout.p0,null);
        View p1 = inflater.inflate(R.layout.p1,null);
        View p2 = inflater.inflate(R.layout.p2,null);
        View p3 = inflater.inflate(R.layout.p3,null);
        View p4 = inflater.inflate(R.layout.p4,null);

        views.add(p0);
        views.add(p1);views.add(p2);views.add(p3);
        views.add(p4);

        flipper = (ViewFlipper) p2.findViewById(R.id.flipper);
        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);
        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });

        pager.setAdapter(new MyPagerAdapter());
        pager.setOnPageChangeListener(new MyPageChangeListener());
        pager.setCurrentItem(1);

    }
    private class MyPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            //super.onPageSelected(position);
            if (position == 0){
                pager.setCurrentItem(1);
            }else if (position == 4){
                pager.setCurrentItem(3);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            Log.v("brad", "pos:" + position);
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            pager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = views.get(position);
            pager.removeView(view);
            //super.destroyItem(container, position, object);
        }
    }

}
