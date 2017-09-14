package sdei.trumpbeach.resort.features.internal.base.contract;

import android.content.Context;

import sdei.trumpbeach.resort.utils.SharedPrefHelper;

/**
 * Android contract for every MVP/MVVM View
 */

public interface Viewable<T>
{

    /**
     * initialize all views here.
     */
    void initViews();

    /**
     * {@link SharedPrefHelper} is responsible for storing data in shared preferences.
     * @return {@link SharedPrefHelper} object.
     */
    SharedPrefHelper getLocalData();


    /**
     * @return {@link Context} of current activity.
     */
    Context getActivityG();

    /**
     * Every Viewable must be able to access to its attached Presenter
     *
     * @return Presentable
     */
    T getPresenter();

    /**
     * Every Viewable must be able to inject its Presenter
     *
     * @param presenter Presentable
     */
    void injectPresenter(T presenter);

    /**
     * Every Viewable must have a error message system
     */
    void displayError(String message);

    /**
     * Every Viewable must implement one show loading feature
     */
    void showLoading();

    /**
     * Every Viewable must implement one hide loading feature
     */
    void hideLoading();

}
