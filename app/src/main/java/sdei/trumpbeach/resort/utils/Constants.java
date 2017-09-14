package sdei.trumpbeach.resort.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by G-Expo on 07 Mar 2017.
 */



@Retention(RetentionPolicy.SOURCE)
public @interface Constants
{

    @interface Extras
    {
        String DATA              = "data";
        String TRANSITION_NAME_1 = "name";
        String TRANSITION_NAME_2 = "name2";
        String PAGE_NUMBER       = "page_number";
        String TITLE             = "title";
    }

    @interface RequestCode
    {
        int CAMERA       = 11;
        int GALLERY      = 22;
    }

}
