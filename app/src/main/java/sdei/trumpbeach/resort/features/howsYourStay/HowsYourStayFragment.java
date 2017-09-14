package sdei.trumpbeach.resort.features.howsYourStay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sdei.trumpbeach.resort.R;

/**
 * Created by gagandeep.singh on 14/09/17.
 */

public class HowsYourStayFragment extends Fragment
{
    public static HowsYourStayFragment newInstance() {
        return new HowsYourStayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_how_your_stay,container, false);
    }

}
