package gamal.myappnew.coroniveris.ui.country;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamal.myappnew.coroniveris.CoronViewModuel;
import gamal.myappnew.coroniveris.Moduel.AdapterCorona;
import gamal.myappnew.coroniveris.R;
import gamal.myappnew.coroniveris.Retrofit.ApiInterface;
import gamal.myappnew.coroniveris.Retrofit.InfoCoron;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryFragment extends Fragment {
    RecyclerView rvCovidCountry;
    ProgressBar progressBar;
    AdapterCorona adapterCorona;
    CoronViewModuel viewModuel;
    List<InfoCoron> list;
    EditText search;
    private static final String TAG = CountryFragment.class.getSimpleName();


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);
        rvCovidCountry = root.findViewById(R.id.rvCovidCountry);
        search=root.findViewById(R.id.search);
        progressBar = root.findViewById(R.id.progress_circular_country);
        viewModuel = ViewModelProviders.of(this).get(CoronViewModuel.class);
        viewModuel.getAllInformation();
        list=new ArrayList<>();
        rvCovidCountry.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModuel.mutableLiveData.observe(getActivity(), new Observer<List<InfoCoron>>() {
            @Override
            public void onChanged(List<InfoCoron> infoCorons) {
                list=infoCorons;
                if (infoCorons.isEmpty())
                    progressBar.setVisibility(View.VISIBLE);

                else {
                    progressBar.setVisibility(View.GONE);

                    adapterCorona = new AdapterCorona(getContext(), infoCorons);
                    rvCovidCountry.setAdapter(adapterCorona);
                }
            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });



        return root;
    }


    private void filter(String text) {
        ArrayList<InfoCoron> filteredList = new ArrayList<>();
        for (InfoCoron item : list) {
            if (item.getCountry().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapterCorona.filterList(filteredList);
    }
}