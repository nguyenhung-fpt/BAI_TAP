package com.example.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Wheather;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    private List<Wheather> wheatherList;

    public HourAdapter(Activity activity, List<Wheather> wheatherList) {
        this.activity = activity;
        this.wheatherList = wheatherList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_hour,parent, false);
        HourHolder holder = new HourHolder(itemView );
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Wheather wheather = wheatherList.get(position);
        vh.tvTime.setText(convertTime(wheather.getDateTime()));
        vh.tvTem.setText(wheather.getTemperature().getValue()+"");
        String url ="";
        if (wheather.getWeatherIcon() <10){
            url = "https://developer.accuweather.com/sites/default/files/0" + wheather.getWeatherIcon() + "-s.png";
        }else {
            url = "https://developer.accuweather.com/sites/default/files/" + wheather.getWeatherIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into((vh.icon));

    }

    @Override
    public int getItemCount() {
        return wheatherList.size();
    }

    private static class HourHolder extends RecyclerView.ViewHolder {

        private TextView tvTime;
        private TextView icon;
        private TextView tvTem;

        public HourHolder(View itemView) {
         super(itemView);
         tvTem = (TextView) itemView.findViewById(R.id.tvTem);
            icon = (TextView) itemView.findViewById(R.id.icon);
         tvTem = (TextView) itemView.findViewById(R.id.tvTem);
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        }catch (java.text.ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }


}