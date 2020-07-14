package gamal.myappnew.coroniveris;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import gamal.myappnew.coroniveris.Retrofit.CornaClient;
import gamal.myappnew.coroniveris.Retrofit.InfoCoron;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronViewModuel extends ViewModel {
     public MutableLiveData<List<InfoCoron>> mutableLiveData=new MutableLiveData<>();
    public void getAllInformation()
    {
        Call<List<InfoCoron>> call= CornaClient.getINSTANCE().getAllInfo();
        call.enqueue(new Callback<List<InfoCoron>>() {
            @Override
            public void onResponse(Call<List<InfoCoron>> call, Response<List<InfoCoron>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<InfoCoron>> call, Throwable t) {

            }
        });
    }
}
