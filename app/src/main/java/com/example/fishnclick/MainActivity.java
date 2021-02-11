package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int clicks = 0;
    //loldqsd
    TextView FishView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FishView = (TextView) findViewById(R.id.FishView);
    }

    


    public void FishClick(View view) {
        clicks++;
        FishView.setText(clicks+ " clicks!");
    }

}