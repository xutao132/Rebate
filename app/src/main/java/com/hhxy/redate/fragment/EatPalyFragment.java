package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.view.CardActivity;
import com.hhxy.redate.view.GroupActivity;
import com.hhxy.redate.view.TakeActivity;
import com.hhxy.redate.view.TourActivity;
import com.hhxy.redate.view.VoitmeActivity;

/**
 * Created by Administrator on 2017/3/2.
 * 吃玩住行
 */
public class EatPalyFragment extends Fragment{
    private TextView text_eatpaly;
    private TextView card,take_out,tour,movie,group;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatplay_fragment,null);
        text_eatpaly = (TextView) view.findViewById(R.id.top_title);
        text_eatpaly.setText("吃玩住行");
       
        initdate(view);
        return view;
    }

    private void initdate(View v) {
        Mylistener mylisteer = new Mylistener();
        findview(v);
        card.setOnClickListener(mylisteer);
        take_out.setOnClickListener(mylisteer);
        tour.setOnClickListener(mylisteer);
        movie.setOnClickListener(mylisteer); 
        group.setOnClickListener(mylisteer);
    }

    private void findview(View view) {
        card = (TextView) view.findViewById(R.id.card);
        take_out = (TextView) view.findViewById(R.id.take_out);
        tour = (TextView) view.findViewById(R.id.tour);
        movie = (TextView) view.findViewById(R.id.movie);
        group = (TextView) view.findViewById(R.id.group);
    }
    class Mylistener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
          switch (v.getId()){
              case R.id.card:
                  startActivity(new Intent(getActivity(), CardActivity.class));
              break;
              case R.id.take_out:
                  startActivity(new Intent(getActivity(), TakeActivity.class));
                  break;
              case R.id.tour:
                  startActivity(new Intent(getActivity(), TourActivity.class));
                  break;
              case R.id.movie:
                  startActivity(new Intent(getActivity(), VoitmeActivity.class));
                  break;
              case R.id.group:
                  startActivity(new Intent(getActivity(), GroupActivity.class));
                  break;
          } 
            
        }
    }
    
}
