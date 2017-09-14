package sdei.trumpbeach.resort.features.loginSignup.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import sdei.trumpbeach.resort.features.loginSignup.signup.RegistrationActivity;
import sdei.trumpbeach.resort.features.internal.base.BaseActivity;
import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginPresenter> implements LoginView, View.OnClickListener
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new LoginPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        setupToolbar("");
        getDataBinder().setData(getPresenter());
        getDataBinder().tvSignIn.setOnClickListener(this);
    }

    @Override
    public Context getActivityG()
    {
        return LoginActivity.this;
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.tvSignIn:
                RegistrationActivity.start(getActivityG());
                break;

        }
    }

}
