package gamal.myappnew.coroniveris.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CornaClient {
    public static final String BASE_URL="https://corona.lmao.ninja/v2/";
    ApiInterface apiInterface;
    private static CornaClient INSTANCE;

    public CornaClient() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         apiInterface=retrofit.create(ApiInterface.class);
//        Call<List<InfoCoron>> call=apiInterface.getallinfo();
    }

    public static CornaClient getINSTANCE() {
        if (INSTANCE==null)
        INSTANCE=new CornaClient();
        return INSTANCE;
    }
    public Call<List<InfoCoron>> getAllInfo()
    {
        return apiInterface.getallinfo();
    }
}
