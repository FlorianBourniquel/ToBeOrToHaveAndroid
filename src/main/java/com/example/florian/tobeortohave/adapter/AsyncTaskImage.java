package com.example.florian.tobeortohave.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AsyncTaskImage extends AsyncTask{

    private ImageView imageView;

    public AsyncTaskImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            InputStream inputStream = (InputStream) new URL(String.valueOf(params[0])).getContent();
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        imageView.setImageBitmap((Bitmap) o);
    }
}
