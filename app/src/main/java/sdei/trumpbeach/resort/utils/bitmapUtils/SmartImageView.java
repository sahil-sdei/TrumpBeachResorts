package sdei.trumpbeach.resort.utils.bitmapUtils;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import sdei.trumpbeach.resort.R;


public class SmartImageView extends LinearLayout
{

    public SmartImageView(Context context)
    {
        super(context);

        init(context, null);
    }

    public SmartImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public SmartImageView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public SmartImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private ImageView imageView;

    private View progressBar;

    public void init(Context context, AttributeSet attrs)
    {
        this.context = context;

        setGravity(Gravity.CENTER);
        imageView = new ImageView(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);

        setLayoutTransition(new LayoutTransition());

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        progressBar = inflater.inflate(R.layout.progress_dialog, null);
        progressBar.setVisibility(GONE);

        addView(imageView);
        addView(progressBar);
    }

    private Context context;

    public ImageView getImageView()
    {
        return imageView;
    }


    public void loadingImage(boolean loading)
    {
        if (loading) {
            imageView.setVisibility(GONE);
            progressBar.setVisibility(VISIBLE);
        }
        else {
            progressBar.setVisibility(GONE);
            imageView.setVisibility(VISIBLE);
        }
    }

}