package sdei.trumpbeach.resort.features.internal.base;

import android.support.annotation.NonNull;

import sdei.trumpbeach.resort.features.internal.base.contract.Presentable;
import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;
import sdei.trumpbeach.resort.utils.CallBackG;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Gagandeep Singh on 11 Sept 2017.
 */


public class BasePresenter<T extends Viewable> implements Presentable<T>
{
    private T viewable;
    //for multiple request we can use compositeDisposable,
    // but currently we use Disposable,as there can be only one request.
    protected Disposable compositeDisposable;

    public Disposable getDisposable() {
        return compositeDisposable;
    }

    public void clearSubscriptions() {
        if (getDisposable() != null) {
            getDisposable().dispose();
        }
    }
    @Override
    public void onStart()
    {
        // No-op by default
    }

    @Override
    public void onViewCreated()
    {
//        views are created ,now its time to initialize them..
        if (getView() != null) {
            getView().initViews();
        }
    }

    @Override
    public void onResume()
    {
        // No-op by default
    }

    @Override
    public void onPause()
    {
        // No-op by default
    }

    @Override
    public void onStop()
    {
        // No-op by default
    }

    @Override
    public void attachView(@NonNull T viewable)
    {
        this.viewable = viewable;
    }

    @Override
    public void detachView()
    {
        this.viewable = null;
        clearSubscriptions();
    }

    @Override
    public T getView()
    {
        return viewable;
    }

    /**
     * get API interface created by retrofit instance using the interface class.
     * @param retroInterface - API interface class.
     * @param <G>
     * @return API interface created by <b>Retrofit</b> Instance.
     */
    protected final <G> G getRetrofitInstance(Class<G> retroInterface)
    {
        return ApplicationClass.getRetrofit().create(retroInterface);
    }


    /**
     * Create a network class and return back the response using {@link CallBackG}
     * @param observables - observable returned by API interface
     * @param callBack - genric call back.
     * @param <V>   - type of data which should be returned by the call back.
     */
    protected <V> void createApiRequest(Observable<V> observables, final CallBackG<V> callBack) {
        compositeDisposable = (observables
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<V>()
                {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull V s) {
                        callBack.callBack(s);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        getView().displayError(e.getMessage());
                        getView().hideLoading();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
