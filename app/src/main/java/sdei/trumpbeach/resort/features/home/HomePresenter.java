package sdei.trumpbeach.resort.features.home;

import java.util.ArrayList;
import java.util.List;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.features.internal.base.BasePresenter;

/**
 * Created by smartData on 14/09/17.
 */

public class HomePresenter extends BasePresenter<HomeView>{

    public List<HomeModel> dataList;

    public HomePresenter() {
        dataList=new ArrayList<>();
    }

    public void loadHomeData() {

        dataList.add(new HomeModel("Direction to Airport", R.drawable.signup_active));
        dataList.add(new HomeModel("Mobile Check In", R.drawable.signup_active));

        dataList.add(new HomeModel("Beach and Pool", R.drawable.signup_active));
        dataList.add(new HomeModel("Spa and Hair salon", R.drawable.signup_active));
        dataList.add(new HomeModel("Dine Now", R.drawable.signup_active));
        dataList.add(new HomeModel("Dine Later", R.drawable.signup_active));
        dataList.add(new HomeModel("Recreation", R.drawable.signup_active));
        dataList.add(new HomeModel("Request Car", R.drawable.signup_active));
        dataList.add(new HomeModel("Housekeeping", R.drawable.signup_active));
        dataList.add(new HomeModel("Offer and Local Attraction", R.drawable.signup_active));

        getView().showData(dataList);
    }


    /**
     * adapter item is clicked having data {@link HomeModel}
     * @param homeModel
     */
    public void onItemClicked(HomeModel homeModel)
    {

    }
}
