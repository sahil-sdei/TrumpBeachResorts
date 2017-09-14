package sdei.trumpbeach.resort.features.home;

import java.util.List;

import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;

/**
 * Created by smartData on 14/09/17.
 */

public interface HomeView extends Viewable<HomePresenter>{
    void showData(List<HomeModel> dataList);
}
