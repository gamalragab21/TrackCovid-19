package gamal.myappnew.coroniveris.Retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("countries")
    public Call<List<InfoCoron>> getallinfo();
}
