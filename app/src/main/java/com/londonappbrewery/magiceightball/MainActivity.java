package com.londonappbrewery.magiceightball;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        ShakeDetector sd= new ShakeDetector(this);
        sd.start(sm);
        final ImageView image=(ImageView)findViewById(R.id.image_eightball);
        final int[] Ballarray={
                            R.drawable.ball1,
                            R.drawable.ball2,
                            R.drawable.ball3,
                            R.drawable.ball4,
                            R.drawable.ball5};
        Button button =(Button)findViewById(R.id.askbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Random randomNumberGenerator = new Random();
                int number =randomNumberGenerator.nextInt(5);
                image.setImageResource(Ballarray[number]);
            }
        });


    }

    @Override
    public void hearShake() {
        final ImageView image=(ImageView)findViewById(R.id.image_eightball);
        final int[] Ballarray={
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5};
        Random randomNumberGenerator = new Random();
        int number =randomNumberGenerator.nextInt(5);
        image.setImageResource(Ballarray[number]);

    }
}
