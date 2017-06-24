package com.example.material.joanbarroso.multithreadingexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by marcos on 24/06/2017.
 */

public class Utils {
    public static Bitmap loadImageFromNetwork(String url) {
        try {
            Bitmap bitmap = BitmapFactory
                    .decodeStream((InputStream) new URL(url)
                            .getContent());
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


