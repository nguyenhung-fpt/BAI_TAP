package com.example.myapplication.ativity;

ckage com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;


import com.example.myapplication.R;
import com.example.myapplication.model.Wheather;
import com.example.myapplication.network.ApiManager;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHour;
    private TextView tvTem, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView) findViewById(R.id.tvTem);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        //B1
        getHours();
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .
                        baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        service.gethour().enqueue(new Callback<List<Wheather>>() {
            @Override
            public void onResponse(Call<List<Wheather>> call, Response<List<Wheather>> response) {
                if (response.body() == null) return;

                List<Wheather> wheatherList = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this, wheatherList);
                rvHour.setAdapter(adapter);

                Wheather wheather = wheatherList.get(0);
                tvTem.setText(wheather.getTemperature().getValue().intValue()+"");
                tvStatus.setText(wheather.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<Wheather>> call, Throwable t) {

            }
        });
    }
}