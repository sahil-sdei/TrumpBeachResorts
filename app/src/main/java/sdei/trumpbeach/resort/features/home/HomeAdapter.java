package sdei.trumpbeach.resort.features.home;

import java.util.List;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.InflatorHomeBinding;
import sdei.trumpbeach.resort.features.internal.base.InfiniteAdapterG;

/**
 * Created by smartData on 14/09/17.
 */

public class HomeAdapter extends InfiniteAdapterG<InflatorHomeBinding>
{

    private HomePresenter presenter;
    private List<HomeModel> dataList;

    public HomeAdapter(List<HomeModel> dataList,HomePresenter presenter) {
        this.dataList = dataList;
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public int getInflateLayout() {
        return R.layout.inflator_home;
    }

    @Override
    protected void bindData(int position, MyViewHolderG myViewHolderG)
    {
        myViewHolderG.binding.setData(dataList.get(position));
        myViewHolderG.binding.setPresenter(presenter);
        myViewHolderG.binding.executePendingBindings();
    }
}
