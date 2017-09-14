package sdei.trumpbeach.resort.features.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by abhinavr on 23/9/16.
 */

public abstract class BaseFragment extends Fragment {

    private int mLayoutXml;
    private View mView;

    public void onCreate(@Nullable Bundle savedInstanceState, int layoutXml) {
        super.onCreate(savedInstanceState);
        this.mLayoutXml = layoutXml;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = inflater.inflate(mLayoutXml, container, false);
        this.mView.setClickable(true);
        //initImageLoader();
        initView();
        bindControls();
        return this.mView;
    }


    /**
     * Get current view
     *
     * @return
     */
    public View getView() {
        return mView;
    }

    /**
     * Init view ids
     */
    protected abstract void initView();

    /**
     * Bind view data into view
     */
    protected abstract void bindControls();


    /**
     * Set TextView value from activity
     * @param id
     * @param text
     * @return
     */
    /**
     * Get view type and set text
     *
     * @param id
     * @param text
     * @return
     */
    public <T extends View> T getView(int id, String... text) {
        T t = (T) mView.findViewById(id);
        if (text != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : text) {
                stringBuilder.append(s).append(" ");
                if (t instanceof TextView)
                    ((TextView) t).setText(stringBuilder.toString().trim());
                else if (t instanceof Button)
                    ((Button) t).setText(stringBuilder.toString().trim());
                else if (t instanceof EditText) {
                    EditText editText = ((EditText) t);
                    editText.setText(stringBuilder.toString().trim());
                    editText.setSelection(editText.getText().length());
                }
            }
        }
        return t;
    }

    /**
     * Get value from Edittext
     *
     * @param id
     * @return
     */
    public String getTextFromTextView(int id) {
        return ((TextView) this.mView.findViewById(id)).getText().toString().trim();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
