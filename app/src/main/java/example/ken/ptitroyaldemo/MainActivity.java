package example.ken.ptitroyaldemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.readystatesoftware.viewbadger.BadgeView;

import example.ken.ptitroyaldemo.model.User;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    private StudyFragment studyFragment;
    private ActivitiesFragment activitiesFragment;
    private GastronomyFragment gastronomyFragment;

    private BadgeView bvNotification;

    public static User user;

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

        user = new User("1", "KienPM", "http://file.vforum.vn/hinh/2016/01/1(96).jpg", "");

        initComoponent();
    }

    private void initComoponent() {
        View target = findViewById(R.id.imgNotification);
        bvNotification = new BadgeView(this, target);
        bvNotification.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        bvNotification.setText("1");
        bvNotification.show();
    }

    public class MyPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.CustomTabProvider {

        private final String[] TITLES = {"Học tập", "Vui chơi", "Ăn uống"};
        private final int[] ICONS = {R.mipmap.ic_study, R.mipmap.ic_activities, R.mipmap.ic_gastronomy};

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

        @Override
        public View getCustomTabView(ViewGroup parent, int position) {
            View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_tab, null);
            ImageView imgIcon = (ImageView) v.findViewById(R.id.imgIcon);
            imgIcon.setImageDrawable(getResources().getDrawable(ICONS[position]));
            return v;
        }

        @Override
        public void tabSelected(View tab) {
            tab.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        @Override
        public void tabUnselected(View tab) {
            tab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }
}
