package com.trane.smartcontrol;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView weatherImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add weather image
        weatherImage = (ImageView) findViewById(R.id.imageView);
        weatherImage.setImageResource(R.drawable.sunshine);

        // bottom mode selector
        View v = this.findViewById(android.R.id.content);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Heating   Cooling   Fan  Stop", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public ImageView getWeatherImage() {
        return weatherImage;
    }
}
