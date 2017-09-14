package sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile;

import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;

/**
 * Created by singh.gagandeep on 13/09/17.
 */

public interface BuildMyProfileView extends Viewable<BuildMyProfilePresenter>{
    void updateBindedData();

    void endOfPrefSelection();

    void close();
}
