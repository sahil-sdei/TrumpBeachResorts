package sdei.trumpbeach.resort.features.internal.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sdei.trumpbeach.resort.features.internal.base.contract.Presentable;
import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;
import sdei.trumpbeach.resort.utils.SharedPrefHelper;


/**
 * Created by Gagandeep Singh on 13 Sept 2017.
 */


public abstract class BaseFragment<B extends ViewDataBinding, T extends Presentable> extends Fragment implements Viewable<T>
{
    protected T                presenter;
    protected B                binding;
    protected View             view;
    protected SharedPrefHelper sharedPrefHelper;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart()
    {
        super.onStart();
        getPresenter().onStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        onCreateFragmentG();
        setRetainInstance(true);
    }

    @Override
    public SharedPrefHelper getLocalData()
    {
        if (sharedPrefHelper == null) {
            sharedPrefHelper = new SharedPrefHelper(getActivityG());
        }
        return sharedPrefHelper;
    }

    @Override
    public Context getActivityG()
    {
        return getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        view = binding.getRoot();
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onViewCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroyView()
    {
        getPresenter().detachView();
        super.onDestroyView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop()
    {
        getPresenter().onStop();
        super.onStop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy()
    {
        getPresenter().detachView();
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void onResume()
    {
        getPresenter().onResume();
        super.onResume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message)
    {
        if (getParentView() != null) {
            Snackbar.make(getParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * View returned by this method is used to display SnackBar.
     * @return parent view of the activity.
     */
    public View getParentView()
    {
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPresenter()
    {
        return presenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void injectPresenter(T presenter)
    {
        this.presenter = presenter;
    }

    public B getDataBinder()
    {
        return binding;
    }

    /**
     * Abstract method to get the xml layout for the activity,
     * this is used in {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)} method.
     * @return layout id -int.
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * injectPresenter( @link Presentable);
     * attachView(this);
     * both of the above methods should be inside this method.
     * After that,put all the stuff you need in your activity on create.
     */
    protected abstract void onCreateFragmentG();

}
