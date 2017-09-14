package sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.databinding.ActivityBuildMyProfileBinding;
import sdei.trumpbeach.resort.features.internal.base.BaseActivity;

public class BuildMyProfileActivity extends BaseActivity<ActivityBuildMyProfileBinding, BuildMyProfilePresenter> implements BuildMyProfileView {


    public static void start(Context context) {
        Intent starter = new Intent(context, BuildMyProfileActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected int setLayoutId() {
        return R.layout.activity_build_my_profile;
    }

    @Override
    protected void onCreateActivityG() {
        injectPresenter(new BuildMyProfilePresenter(getActivityG()));
        getPresenter().attachView(this);
    }

    @Override
    public void initViews() {
        setupToolbar("Build My Profile");
        getDataBinder().setData(getPresenter().getCurrentData());
    }

    @Override
    public Context getActivityG() {
        return BuildMyProfileActivity.this;
    }

    public void onRightClick(View view) {
        getPresenter().leftClicked();
    }

    public void onLeftClick(View view) {
        getPresenter().rightClicked();
    }


    @Override
    public void updateBindedData() {
        getDataBinder().setData(getPresenter().getCurrentData());
    }


    @Override
    public void endOfPrefSelection() {
       SignUpCompleteActivity.start(getActivityG());
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        getPresenter().handleBackPress();
    }


    @Override
    public void close() {
        finish();
    }
}
