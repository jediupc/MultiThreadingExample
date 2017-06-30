package com.example.material.joanbarroso.multithreadingexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThreadSample extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_sampl);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.threadButton)
    public void getImagecontent() {
        downloadImage(imageView);
    }

    @OnClick(R.id.nextButton)
    public void goNextSample() {
        startActivity(new Intent(getApplicationContext(), AsyncTaskExample.class));
    }

    private final Handler mhHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100 && msg.obj != null) {
                imageView.setImageBitmap((Bitmap) msg.obj);
            }
        }
    };


    public void downloadImage(View v) {
        new Thread(new Runnable() {
            public void run() {
                final Bitmap bitmap = Utils.loadImageFromNetwork("http://jakewharton.github.io/butterknife/static/logo.png");
                Message msg = new Message();
                msg.what = 100;
                msg.obj = bitmap;
                mhHandler.sendMessage(msg);
            }
        }).start();
    }
}
