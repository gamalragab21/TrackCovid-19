package gamal.myappnew.coroniveris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import gamal.myappnew.coroniveris.Moduel.Common;
import gamal.myappnew.coroniveris.Retrofit.InfoCoron;

public class DeatlistActivity extends AppCompatActivity {
    TextView countryname, cassess,recoverd,deaths,todaycassess,todayrecoverd,todaydeaths;
    InfoCoron infoCoron;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatlist);
        infoCoron= Common.infoCoron;
        cassess=findViewById(R.id.cassess);
        recoverd=findViewById(R.id.recoverd);
        deaths=findViewById(R.id.deaths);
        todaycassess=findViewById(R.id.todaycassess);
        todayrecoverd=findViewById(R.id.todayrecoverd);
        todaydeaths=findViewById(R.id.toidaydeaths);
        countryname=findViewById(R.id.countyname);
        //
         countryname.setText(infoCoron.getCountry());
        cassess.setText(infoCoron.getCases()+"");
        recoverd.setText(infoCoron.getRecovered()+"");
        deaths.setText(infoCoron.getDeaths()+"");
        todaycassess.setText(infoCoron.getTodayCases()+"");
        todayrecoverd.setText(infoCoron.getTodayRecovered()+"");
        todaydeaths.setText(infoCoron.getTodayDeaths()+"");




    }
}
