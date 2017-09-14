package sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile;

import android.graphics.drawable.Drawable;

/**
 * Created by singh.gagandeep on 13/09/17.
 */

public class ProfilePrefModel {


    private String firstName, secondName;
    private Drawable firstImage, secondImage;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Drawable getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(Drawable firstImage) {
        this.firstImage = firstImage;
    }

    public Drawable getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(Drawable secondImage) {
        this.secondImage = secondImage;
    }
}
