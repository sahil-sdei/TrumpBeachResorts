package sdei.trumpbeach.resort.features.loginSignup.signup;

import android.databinding.ObservableField;
import android.view.View;

import sdei.trumpbeach.resort.features.internal.base.BasePresenter;
import sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile.BuildMyProfileActivity;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class RegistrationPresenter extends BasePresenter<RegistrationView>
{
    public ObservableField<String> userName         =
            new ObservableField<>();
    public ObservableField<String> email            =
            new ObservableField<>();
    public ObservableField<String> phoneNumber            =
            new ObservableField<>();
    public ObservableField<String> password         =
            new ObservableField<>();

    public RegistrationPresenter()
    {
        userName.set("");
        email.set("");
        phoneNumber.set("");
        password.set("");
    }

    /**
     * register user on server with filled details.
     */
    public void registerClicked(View view)
    {
        //// TODO: 14/09/17 validations needs to be used after design phase.
//        if (userName.get().isEmpty()) {
//            getView().displayError("Please enter Name");
//        }
//        else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
//            getView().displayError("Please enter a valid email");
//        }
//        else if (password.get().isEmpty()) {
//
//            getView().displayError("Please enter password");
//        }
//        else {
            // send request to server.

            BuildMyProfileActivity.start(getView().getActivityG());
//        }
    }
}
