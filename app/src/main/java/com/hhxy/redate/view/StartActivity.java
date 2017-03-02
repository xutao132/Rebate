package com.hhxy.redate.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hhxy.redate.MainActivity;
import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;
import com.hhxy.redate.presenter.IstartActivityPresenter;
import com.hhxy.redate.presenter.impl.StartActivityPresenter;

public class StartActivity extends AppCompatActivity implements IstartActivityPresenter {
    private TextView mTextView;
    private ImageView mImageView;
    private int i = 4;
    private IStartActivity mIStartActivity;
    private boolean flag = true;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                i--;
                mTextView.setText(i + "");
                if(flag){
                    if (i == 0) {
                        Intent intent = new Intent(StartActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else {
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
        mIStartActivity = new StartActivityPresenter(this);
        mIStartActivity.getWellCome(Constants.WELCOME_IMAGE);

    }

    public void ImageButton(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        flag = false;
        finish();
    }

    public void TextViewButton(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        flag = false;
        finish();
    }

    private void init() {
        findview();
        setData();
    }

    private void setData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Message message = new Message();
                        message.what = 1;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    private void findview() {
        mTextView = (TextView) findViewById(R.id.mTextView);
        mImageView = (ImageView) findViewById(R.id.mImageView);

    }

    @Override
    public void getStartActivityImagePath(String ImageURL) {
        Glide.with(this).load(ImageURL)
                .placeholder(R.mipmap.ic_launcher)
                .error(android.R.drawable.ic_menu_share)
                .into(mImageView);
    }
}
