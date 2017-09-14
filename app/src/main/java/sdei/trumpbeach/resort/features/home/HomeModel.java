package sdei.trumpbeach.resort.features.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;

/**
 * Created by smartData on 14/09/17.
 */

public class HomeModel extends BaseObservable{

    private String Title;
    private int Image;

    public HomeModel(String title, int image) {
        Title = title;
        Image = image;
    }

    @Bindable
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
        notifyAll();
    }

    @Bindable
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
        notifyAll();
    }
}
