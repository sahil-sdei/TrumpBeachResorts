package sdei.trumpbeach.resort.features.loginSignup;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by singh.gagandeep on 12/09/17.
 */

public interface LoginAPI {
    @GET("users/{user}/repos")
    Observable<List<RepoDetails>> listRepos(@Path("user") String user);
}
