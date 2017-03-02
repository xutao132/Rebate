package com.hhxy.redate.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhxy.redate.MainActivity;
import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;
import com.hhxy.redate.presenter.StartActivityPresenter;

public class StartActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageView mImageView;
    private int i = 4;
    private IStartActivity mIStartActivity;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                i--;
                mTextView.setText(i+"");
                if(i == 0){
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
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
        mIStartActivity = new StartActivityPresenter();
        mIStartActivity.getWellCome(Constants.WELCOME_IMAGE);
    }
    private void init() {
        findview();
        setData();
    }

    private void setData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        Message message = new Message();
                        message.what=1;
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
}
