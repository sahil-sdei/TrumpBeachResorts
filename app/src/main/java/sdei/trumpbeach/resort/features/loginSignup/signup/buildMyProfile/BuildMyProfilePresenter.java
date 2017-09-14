package sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.features.internal.base.BasePresenter;

/**
 * Created by singh.gagandeep on 13/09/17.
 */

public class BuildMyProfilePresenter extends BasePresenter<BuildMyProfileView> {

    public ProfilePrefModel selectedModel;

    private List<ProfilePrefModel> dataList;
    private int selectedIndex=0;


    public BuildMyProfilePresenter(Context context) {
        selectedIndex=0;
        dataList=new ArrayList<>();

        Resources res = context.getResources();

        TypedArray firstName = res.obtainTypedArray(R.array.firstName);
        TypedArray secondName= res.obtainTypedArray(R.array.secondName);

        TypedArray firstImage = res.obtainTypedArray(R.array.firstImage);
        TypedArray secondImage= res.obtainTypedArray(R.array.secondImage);

        for (int i = 0; i < firstName.length(); i++) {
            ProfilePrefModel profilePrefModel=new ProfilePrefModel();
            profilePrefModel.setFirstName(firstName.getString(i));
            profilePrefModel.setSecondName(secondName.getString(i));

            profilePrefModel.setFirstImage(firstImage.getDrawable(i));
            profilePrefModel.setSecondImage(secondImage.getDrawable(i));
            dataList.add(profilePrefModel);
        }

        firstImage.recycle();
        secondImage.recycle();
        firstName.recycle();
        secondName.recycle();

        this.selectedModel=dataList.get(selectedIndex);
    }


    public ProfilePrefModel getCurrentData() {
        return selectedModel;
    }

    public void leftClicked() {
        showNext();

    }

    public void rightClicked() {
        showNext();
    }

    private void showNext() {
        selectedIndex++;

        if (selectedIndex >= dataList.size()) {
            selectedIndex = dataList.size()-1;
            getView().endOfPrefSelection();
            return;
        }
        this.selectedModel=dataList.get(selectedIndex);
        getView().updateBindedData();
    }



    public void handleBackPress() {
        if (selectedIndex==0) {
            getView().close();
        }
        else
        {
            selectedIndex--;
            this.selectedModel=dataList.get(selectedIndex);
            getView().updateBindedData();
        }
    }

}
