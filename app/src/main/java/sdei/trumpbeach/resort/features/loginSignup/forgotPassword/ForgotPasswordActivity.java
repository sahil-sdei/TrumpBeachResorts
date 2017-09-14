package sdei.trumpbeach.resort.features.loginSignup.forgotPassword;

import android.content.Context;
import android.content.Intent;

import sdei.trumpbeach.resort.features.internal.base.BaseActivity;
import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordPresenter> implements ForgotPasswordView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, ForgotPasswordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_forgot_password;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new ForgotPasswordPresenter());
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
        return ForgotPasswordActivity.this;
    }
}
