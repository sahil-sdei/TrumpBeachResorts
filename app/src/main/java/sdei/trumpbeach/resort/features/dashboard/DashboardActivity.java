package sdei.trumpbeach.resort.features.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.ActivityDashboardBinding;
import sdei.trumpbeach.resort.features.adapter.ViewPagerAdapter;
import sdei.trumpbeach.resort.features.fragment.ProgressFragment;
import sdei.trumpbeach.resort.features.home.HomeFragment;
import sdei.trumpbeach.resort.features.howsYourStay.HowsYourStayFragment;
import sdei.trumpbeach.resort.features.internal.base.BaseActivity;

public class DashboardActivity extends BaseActivity<ActivityDashboardBinding, DashboardPresenter> implements DashboardView {

    private Toolbar toolbar;
    private ViewPagerAdapter adapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, DashboardActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void onCreateActivityG() {
        injectPresenter(new DashboardPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public Context getActivityG() {
        return DashboardActivity.this;
    }

    @Override
    public void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupViewPager(getDataBinder().viewpager);
        getDataBinder().tabs.setupWithViewPager(getDataBinder().viewpager);
        getDataBinder().viewpager.setOffscreenPageLimit(3);
        setupTabIcons();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), getString(R.string.home));
        adapter.addFrag(new ProgressFragment(), getString(R.string.loyalty_program));
        adapter.addFrag(new HowsYourStayFragment(), getString(R.string.hows_your_stay));
        viewPager.setAdapter(adapter);
    }

    public void setCurrentTab(int position) {
        getDataBinder().viewpager.setCurrentItem(position, true);
    }

    /**
     * Setup tab icons
     */
    private void setupTabIcons() {
        LinearLayout tabOne = (LinearLayout) LayoutInflater.from(getActivityG()).inflate(R.layout.custom_tab, null);
        TextView tetViewTab1 = (TextView) tabOne.findViewById(R.id.tv_tab);
        tetViewTab1.setText(R.string.home);
        ImageView imageViewTab1 = (ImageView) tabOne.findViewById(R.id.iv_icon);
        imageViewTab1.setBackgroundResource(R.drawable.tab_home_selector);
        getDataBinder().tabs.getTabAt(0).setCustomView(tabOne);

        LinearLayout tabTwo = (LinearLayout) LayoutInflater.from(getActivityG()).inflate(R.layout.custom_tab, null);
        TextView tetViewTab2 = (TextView) tabTwo.findViewById(R.id.tv_tab);
        tetViewTab2.setText(R.string.loyalty_program);
        ImageView imageViewTab2 = (ImageView) tabTwo.findViewById(R.id.iv_icon);
        imageViewTab2.setBackgroundResource(R.drawable.tab_loyalty_selector);
        getDataBinder().tabs.getTabAt(1).setCustomView(tabTwo);

        LinearLayout tabThree = (LinearLayout) LayoutInflater.from(getActivityG()).inflate(R.layout.custom_tab, null);
        TextView tetViewTab3 = (TextView) tabThree.findViewById(R.id.tv_tab);
        tetViewTab3.setText(R.string.hows_your_stay);
        ImageView imageViewTab3 = (ImageView) tabThree.findViewById(R.id.iv_icon);
        imageViewTab3.setBackgroundResource(R.drawable.tab_stay_selector);
        getDataBinder().tabs.getTabAt(2).setCustomView(tabThree);
    }
}
