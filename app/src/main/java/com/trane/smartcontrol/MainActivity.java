package com.trane.smartcontrol;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView weatherImage;
    private Gauge gauge;
    int i = 50;

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
                Snackbar.make(view, "Sample Action Trigger", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        gauge = (Gauge) findViewById(R.id.gauge1);
        gauge.setValue(50);
        final TextView tempDisplay = (TextView) findViewById(R.id.textView15);
        tempDisplay.setText(Integer.toString(gauge.getValue()));
        final TextView statusDisplay = (TextView)findViewById(R.id.textView14);

        // temperature buttons setup
        ImageButton upButton = (ImageButton) findViewById(R.id.button6);
        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (i < 91) {
                    gauge.setValue(i++);
                    tempDisplay.setText(Integer.toString(gauge.getValue()));
                }
            }
        });

        ImageButton downButton = (ImageButton) findViewById(R.id.button7);
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (i > 49) {
                    gauge.setValue(i--);
                    tempDisplay.setText(Integer.toString(gauge.getValue()));
                }
            }
        });

        ImageButton heatButton = (ImageButton) findViewById(R.id.button5);
        heatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                statusDisplay.setTextColor(getResources().getColor(R.color.md_red_500));
                statusDisplay.setText("HEAT DEMAND");
            }
        });

        ImageButton coolButton = (ImageButton) findViewById(R.id.button4);
        coolButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                statusDisplay.setTextColor(getResources().getColor(R.color.md_sky_500));
                statusDisplay.setText("COOL DEMAND");
            }
        });
    }

    public ImageView getWeatherImage() {
        return weatherImage;
    }
}
