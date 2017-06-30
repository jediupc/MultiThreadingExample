package com.example.material.joanbarroso.multithreadingexample;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsyncTaskExample extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;

    @Bind(R.id.nextButton)
    Button nextButton;

    @OnClick(R.id.threadButton)
    public void getImageContent() {
        new DownloadImageTask().execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_sampl);
        ButterKnife.bind(this);
        nextButton.setVisibility(View.GONE);
    }

    private class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            return Utils.loadImageFromNetwork("http://jakewharton.github.io/butterknife/static/logo.png");
        }

        @Override
        protected void onPostExecute(Bitmap image) {
            super.onPostExecute(image);
            imageView.setImageBitmap(image);
        }
    }
}
