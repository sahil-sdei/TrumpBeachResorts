package sdei.trumpbeach.resort.features.internal.base;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import sdei.trumpbeach.resort.features.internal.base.contract.Presentable;
import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;
import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.utils.SharedPrefHelper;

/**
 * Created by Gagandeep Singh on 11 Sept 2017.
 */


public abstract class BaseActivity<B extends ViewDataBinding, T extends Presentable> extends AppCompatActivity implements Viewable<T>
{
    protected T presenter;
    protected B binding;

    private ProgressDialog progressDialog;
    private CharSequence progressTitle="Loading";
    private CharSequence progressMessage="Please wait";

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart()
    {
        super.onStart();
        getPresenter().onStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onResume()
    {
        super.onResume();
        getPresenter().onResume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPause()
    {
        getPresenter().onPause();
        super.onPause();
    }

    /**
     * @param title set title at the center of toolbar using a Text View.
     *              and also show back button.
     */
    public void setupToolbar(String title)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView viewById = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (viewById != null) {
            viewById.setText(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(setLayoutId());
        binding = DataBindingUtil.setContentView(this, setLayoutId());

        onCreateActivityG();
        getPresenter().onViewCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop()
    {
        getPresenter().onStop();
        super.onStop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy()
    {
        getPresenter().detachView();
        presenter = null;
        super.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message)
    {
        if (getParentView() != null) {
            Snackbar.make(getParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading()
    {
        // no-op by default
        progressDialog=ProgressDialog.show(getActivityG(),progressTitle,progressMessage);
    }

    /**
     * show loading with a custom message.
      * @param title
     * @param message
     */
    public void showLoading(String title,String message)
    {
        progressTitle = title;
        progressMessage=message;
        showLoading();
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading()
    {
        if (progressDialog != null && progressDialog.isShowing() ) {
            progressDialog.dismiss();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPresenter()
    {
        return presenter;
    }


    /**
     * @return data binding class according to the layout attached.
     */
    public B getDataBinder()
    {
        return binding;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void injectPresenter(T presenter)
    {
        this.presenter = presenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SharedPrefHelper getLocalData()
    {
        return new SharedPrefHelper(getApplicationContext());
    }

    /**
     * Abstract method to get the xml layout for the activity,
     * this is used in {@link android.app.Activity#setContentView(int)} method.
     * @return layout id -int.
     */
    protected abstract int setLayoutId();

    /**
     * View returned by this method is used to display SnackBar.
     * @return parent view of the activity.
     */
    protected View getParentView()
    {
        return findViewById(android.R.id.content);
    }

    /**
     * injectPresenter( @link Presentable);
     * attachView(this);
     * both of the above methods should be inside this method.
     * After that,put all the stuff you need in your activity on create.
     */
    protected abstract void onCreateActivityG();
}
