package sdei.trumpbeach.resort.features.loginSignup.signup.buildMyProfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import sdei.trumpbeach.resort.R;
import sdei.trumpbeach.resort.utils.UtillsG;

public class SignUpCompleteActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, SignUpCompleteActivity.class);
        context.startActivity(starter);
        UtillsG.finishAll(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_complete);

        setupToolbar();
    }



    public void setupToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
