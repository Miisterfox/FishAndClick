package com.example.fishnclick;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private static ArrayList<Fish> fish;
    private static int money;
    private static Chronometer CurrentBoost;
    private static int boost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boost=1;
        money=0;
        setContentView(R.layout.activity_main);
        fish = new ArrayList<>();
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Salmon", 2, R.drawable.fish2));
        CurrentBoost = (Chronometer) findViewById(R.id.CurrentBoost);
        CurrentBoost.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(chronometer.getText().toString().equalsIgnoreCase("00:00")) {
                    chronometer.stop();
                    chronometer.setText("");
                    setBoost(1);
                    ShopFragment.disableBoosts();
                }
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fish);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.fish:
                        fragmentTransaction.replace(R.id.mainFragment,new FishFragment()).commit();
                        return true;
                    case R.id.shop:
                        fragmentTransaction.replace(R.id.mainFragment,new ShopFragment()).commit();
                        return true;
                    case R.id.upgrades:
                        fragmentTransaction.replace(R.id.mainFragment,new UpgradesFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }

    public static ArrayList<Fish> getFish() {
        return fish;
    }

    public static Fish getFish(String name) {
        for(Fish f : fish){
            if(f.toString()==name){
                return f;
            }
        }
        return null;
    }

    public static void setBoost(long durée, int boost) {
        CurrentBoost.setText("lol ca boost");
        CurrentBoost.setBase(durée);
        setBoost(boost);
        Log.d("Boost",""+MainActivity.getBoost());
        CurrentBoost.start();
    }
    public static int getMoney() {
        return money;
    }
    public  static void setBoost(int b) {
        boost=b;
    }
    public static int getBoost() {
        return boost;
    }
    public static void setMoney(int m) {
        money=m;
    }

}