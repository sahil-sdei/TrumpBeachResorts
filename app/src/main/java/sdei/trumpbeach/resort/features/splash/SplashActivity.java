package sdei.trumpbeach.resort.features.splash;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.features.loginSignup.login.LoginActivity;
import sdei.trumpbeach.resort.features.loginSignup.signup.RegistrationActivity;
import sdei.trumpbeach.resort.features.internal.base.BaseActivityNoBinding;
import sdei.trumpbeach.resort.utils.UtillsG;

public class SplashActivity extends BaseActivityNoBinding<SplashPresenter> implements SplashView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, SplashActivity.class);
        context.startActivity(starter);
        UtillsG.finishAll(context);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new SplashPresenter());
        getPresenter().attachView(this);

        getPresenter().splashCheck();
    }

    @Override
    public Context getActivityG()
    {
        return SplashActivity.this;
    }

    @Override
    public void initViews()
    {
        //no initialization required for this activity ,as no view used..!
    }

    @Override
    public long splashTimer()
    {
        return 2000;
    }

    @Override
    public void openLogin()
    {
        LoginActivity.start(getActivityG());
    }

    @Override
    public void showOptions() {
        ( (LinearLayout) findViewById(R.id.layoutButtons)).setVisibility(View.VISIBLE);
    }

    public void signIn(View view) {
        LoginActivity.start(getActivityG());
    }

    public void jOin(View view) {
        RegistrationActivity.start(getActivityG());
    }
}
