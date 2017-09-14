package sdei.trumpbeach.resort.features.loginSignup.signup;

import android.content.Context;
import android.content.Intent;

import sdei.trumpbeach.resort.features.internal.base.BaseActivity;
import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.ActivityRegisterationBinding;

public class RegistrationActivity extends BaseActivity<ActivityRegisterationBinding, RegistrationPresenter> implements RegistrationView
{

    public static void start(Context context) {
        Intent starter = new Intent(context, RegistrationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_registeration;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new RegistrationPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        setupToolbar("");
        getDataBinder().setData(getPresenter());
    }


    @Override
    public Context getActivityG()
    {
        return RegistrationActivity.this;
    }

}
