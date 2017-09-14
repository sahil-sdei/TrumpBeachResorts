package sdei.trumpbeach.resort.features.loginSignup.login;

import android.databinding.ObservableField;
import android.view.View;

import sdei.trumpbeach.resort.features.dashboard.DashboardActivity;
import sdei.trumpbeach.resort.features.internal.base.BasePresenter;

/**
 * Created by G-Expo on 13 sept 2017.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    public ObservableField<String> userName =
            new ObservableField<>();
    public ObservableField<String> password =
            new ObservableField<>();

    public LoginPresenter() {
        userName.set("");
        password.set("");
    }

    public void LoginClicked(View view) {
//        if (userName.get().isEmpty()) {
//            getView().displayError("Please enter email.");
//        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userName.get()).matches()) {
//            getView().displayError("Please enter a valid email.");
//        } else if (password.get().isEmpty()) {
//            getView().displayError("Please enter password.");
//        } else {
            DashboardActivity.start(getView().getActivityG());
//        }
    }
}
