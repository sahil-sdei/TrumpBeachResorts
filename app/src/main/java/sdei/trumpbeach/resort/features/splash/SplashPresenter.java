package sdei.trumpbeach.resort.features.splash;

import android.os.Handler;

import sdei.trumpbeach.resort.features.internal.base.BasePresenter;

/**
 * Created by G-Expo on 13 Sept 2017.
 */

public class SplashPresenter extends BasePresenter<SplashView> implements Runnable {
    public void splashCheck() {
        new Handler().postDelayed(this, getView().splashTimer());
    }

    @Override
    public void run() {
        getView().showOptions();
    }
}
