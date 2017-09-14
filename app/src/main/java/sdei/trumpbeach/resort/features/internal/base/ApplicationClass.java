package sdei.trumpbeach.resort.features.internal.base;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by singh.gagandeep on 12/09/17.
 */

public class ApplicationClass  extends Application
{

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            initRetrofitModule();
        }
        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        MultiDex.install(getApplicationContext());

        //for camera
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        initRetrofitModule();
    }

    private static void initRetrofitModule() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okClient())
                .build();

    }

    private static OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
    }


}
