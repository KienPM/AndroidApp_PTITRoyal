package example.ken.ptitroyaldemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.readystatesoftware.viewbadger.BadgeView;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    private StudyFragment studyFragment;
    private ActivitiesFragment activitiesFragment;
    private GastronomyFragment gastronomyFragment;

    private BadgeView bvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyFragment = new StudyFragment();
        activitiesFragment = new ActivitiesFragment();
        gastronomyFragment = new GastronomyFragment();

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

        initComoponent();
    }

    private void initComoponent() {
        View target = findViewById(R.id.imgNotification);
        bvNotification = new BadgeView(this, target);
        bvNotification.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        bvNotification.setText("1");
        bvNotification.show();
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"Học tập", "Vui chơi", "Ăn uống"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    return activitiesFragment;
                case 2:
                    return gastronomyFragment;
                default:
                    return studyFragment;
            }
        }
    }
}
