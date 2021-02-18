package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
<<<<<<< Updated upstream
    private int clicks = 0;
    TextView FishView;
=======
    private static TextView FishView = (TextView) findViewById(R.id.FishView);
    private static Fish fish1 = new Fish("bar",1);
>>>>>>> Stashed changes
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