package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView FishView;
    private TextView FishName;
    private ImageButton FishClick;
    private static ArrayList<Fish> fish;
    private int fishIndex;
    private TextView moneyText;
    private int money;

    //peche chaque poisson toutes les 5s
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for(Fish f : fish) {
                f.addClick();
                money+=f.getValue();
                moneyText.setText(money+"$");
            }
            updateFish();
            handler.postDelayed(this, 5000);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fish = new ArrayList<>();
        fish.add(new Fish("Bar",1,R.drawable.fish1));
        fish.add(new Fish("Carpe",2,R.drawable.fish2));
        fishIndex=0;
        FishView = (TextView) findViewById(R.id.FishView);
        FishName = (TextView) findViewById(R.id.FishName);
        moneyText = (TextView) findViewById(R.id.Money);
        money=0;
        moneyText.setText(money+"$");
        FishClick = (ImageButton) findViewById(R.id.FishClick);
        updateFish();
        handler.postDelayed(runnable, 1000);
    }


    private void updateFish() {
        Fish SelectedFish = fish.get(fishIndex);
        FishName.setText(SelectedFish.toString());
        FishView.setText(SelectedFish.getClicks() +" " +SelectedFish.toString()+"s");
        FishClick.setImageResource(SelectedFish.getLogo());
    }
    public void FishClick(View view) {
        Fish SelectedFish = fish.get(fishIndex);
        SelectedFish.addClick();
        FishView.setText(SelectedFish.getClicks() +" " +SelectedFish.toString()+"s");
        //moneyupdate
        money+=SelectedFish.getValue();
        moneyText.setText(money+"$");
    }

    public void ArrowLeft(View view) {
        if(fishIndex==0) {
            fishIndex=fish.size()-1;
        }
        else {
            fishIndex--;
        }
        updateFish();
    }
    public void ArrowRight(View view) {
        if(fishIndex==fish.size()-1) {
            fishIndex=0;
        }
        else {
            fishIndex++;
        }
        updateFish();
    }
}