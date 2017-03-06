package com.hhxy.redate.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hhxy.redate.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

public class myFirstActivityAdapter extends PagerAdapter {
    private List<ImageView> pager;
    private Context context;
    private Integer integer;
    //private List<Integer> listpager;

    public myFirstActivityAdapter(List<ImageView> pager,Context context){
        this.pager = pager;
        this.context = context;
    }
 /* public myFirstActivityAdapter(List<Integer> listpager,Context context){
      this.listpager = listpager;
      this.context = context;
  }*/

    @Override
    public int getCount() {
        return pager.size();
        //return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pager.get(position));
        return pager.get(position);
       /* ImageView img = new ImageView(context);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        if (listpager.size() != 0) {
            img.setImageResource(listpager.get(position % listpager.size()));
        }else {
            img.setImageResource(R.mipmap.ic_launcher);
        }
        container.addView(img);
        return img;*/
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}
