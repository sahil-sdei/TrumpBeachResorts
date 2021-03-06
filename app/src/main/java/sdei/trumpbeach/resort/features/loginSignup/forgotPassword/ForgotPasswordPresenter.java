package sdei.trumpbeach.resort.features.loginSignup.forgotPassword;

import android.databinding.ObservableField;
import android.view.View;

import sdei.trumpbeach.resort.features.internal.base.BasePresenter;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordView>
{
    public ObservableField<String> email =
            new ObservableField<>();

    public ForgotPasswordPresenter()
    {
        email.set("");
    }

    public void submitEmail(View view)
    {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
            getView().displayError("Please enter a valid email");
        }
        else {
            //api call to get password.
            getView().displayError("Yiipeeeeeeeeeeeeeee..!");

        }
    }
}
