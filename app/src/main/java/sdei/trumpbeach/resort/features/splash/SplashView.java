package sdei.trumpbeach.resort.features.splash;

import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;

/**
 * Created by G-Expo on 13 Sept 2017.
 */

public interface SplashView extends Viewable<SplashPresenter>
{
    long splashTimer();

    void openLogin();

    void showOptions();
}
