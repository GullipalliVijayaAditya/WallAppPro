package com.example.android.wallapppro;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] ImageArray = {
            R.drawable.a1, R.drawable.a2,
            R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.b2,
            R.drawable.a6, R.drawable.b4,
            R.drawable.a7, R.drawable.b5,
            R.drawable.a8, R.drawable.b10,
            R.drawable.a9, R.drawable.b6,
            R.drawable.a10, R.drawable.b7,
            R.drawable.b1, R.drawable.b8,
            R.drawable.b3, R.drawable.b9,


    };

    GridView gridview;
    ImageView currentWallpaper;
    Drawable drawable;
    WallpaperManager wallpaperManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = findViewById(R.id.gridview);
        currentWallpaper = findViewById(R.id.imageview);
        gridview.setAdapter(new ImageAdapter(getApplicationContext()));
        UpdateMyWallpaper();
    }

    private void UpdateMyWallpaper() {
        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        drawable = wallpaperManager.getDrawable();
        currentWallpaper.setImageDrawable(drawable);
    }

    public class ImageAdapter extends BaseAdapter {

        Context context;

        public ImageAdapter(Context applicationContext) {
            context = applicationContext;
        }

        @Override
        public int getCount() {
            return ImageArray.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView GridImageView;

            if (view == null)
            {

                GridImageView = new ImageView(context);
                GridImageView.setLayoutParams(new GridView.LayoutParams(512, 512));
                GridImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                GridImageView = (ImageView) view;
            }

            GridImageView.setImageResource(ImageArray [i]);
            return GridImageView;
        }
    }


}
