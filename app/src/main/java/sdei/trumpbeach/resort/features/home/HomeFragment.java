package sdei.trumpbeach.resort.features.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.FragmentHomeBinding;
import sdei.trumpbeach.resort.features.internal.base.BaseFragment;

/**
 * Created by gagandeep.singh on 14/09/17.
 */

public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomePresenter> implements HomeView
{
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onCreateFragmentG() {
        injectPresenter(new HomePresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews() {
        getPresenter().loadHomeData();
    }

    @Override
    public void showData(List<HomeModel> dataList) {
        HomeAdapter homeAdapter = new HomeAdapter(dataList,getPresenter());
        homeAdapter.setShouldLoadMore(false);
        getDataBinder().recyclerView.setLayoutManager(new GridLayoutManager(getActivityG(),2));
        getDataBinder().recyclerView.setAdapter(homeAdapter);
    }
}
