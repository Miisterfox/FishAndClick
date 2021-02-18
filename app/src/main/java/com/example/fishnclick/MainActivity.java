package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
    //commentaire lol
public class MainActivity extends AppCompatActivity {
    private static TextView FishView = (TextView) findViewById(R.id.FishView);;
    private static Fish fish1 = new Fish("bar",1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    


    public void FishClick(View view) {
        clicks++;
        FishView.setText(clicks+ " clicks!");
    }

}