package com.example.fishnclick;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Fish> fish;
    private static int money;
    private static Chronometer CurrentBoost;
    private static int boost;
    private static TextView MoneyView;
    private static MyDatabase db;
    private static SharedPreferences spMoney;
    private static SharedPreferences spAutoClick;
    private static Handler handler = new Handler();
    private static boolean autoClickBoolean;
    private static Runnable autoClick = new Runnable() {
        @Override
        public void run() {
            FishsClick();
            Log.d("runnable","it works");
            handler.postDelayed(this, 60000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        autoClickBoolean=false;
        Log.d("runnable","it works");
        fish = new ArrayList<>();
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Salmon", 2, R.drawable.fish2));
        fish.add(new Fish("Eel", 5, R.drawable.fish3, false));
        fish.add(new Fish("Octopus", 10, R.drawable.fish4, false));
        fish.add(new Fish("Shark", 25, R.drawable.fish5, false));
        fish.add(new Fish("Moonfish", 50, R.drawable.fish6, false));

        db = new MyDatabase(this, fish);
        db.updateFishList(fish);
        super.onCreate(savedInstanceState);
        boost = 1;
        setContentView(R.layout.activity_main);
        MoneyView = (TextView) findViewById(R.id.money);
        updateMoney();

        spMoney = getSharedPreferences("money", Context.MODE_PRIVATE);
        spAutoClick = getSharedPreferences("autoClick",Context.MODE_PRIVATE);
        autoClickBoolean = spAutoClick.getBoolean("autoclick",false);
        if(autoClickBoolean) {
            enableAutoClick();
        }
        money = spMoney.getInt("money", 0);
        MoneyView.setText(money + "$");
        CurrentBoost = (Chronometer) findViewById(R.id.CurrentBoost);


        CurrentBoost.setText("");
        CurrentBoost.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (chronometer.getText().toString().equalsIgnoreCase("00:00")) {
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
                switch (item.getItemId()) {
                    case R.id.fish:
                        fragmentTransaction.replace(R.id.mainFragment, new FishFragment()).commit();
                        return true;
                    case R.id.shop:
                        fragmentTransaction.replace(R.id.mainFragment, new ShopFragment()).commit();
                        return true;
                    case R.id.upgrades:
                        fragmentTransaction.replace(R.id.mainFragment, new UpgradesFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }

    public static ArrayList<Fish> getFishList() {
        return fish;
    }
    public static boolean isAutoClickOn() {
        return autoClickBoolean;
    }
    private static void FishsClick() {
        for (Fish f : fish) {
            if(f.getEnabled()) {
                for (int i = 0; i < f.getLevel() + 1; i++) {
                    f.addClick();
                    setMoney(money + f.getValue() * MainActivity.getBoost() * (1 + f.getLevel()));
                }
                MainActivity.updateFish(f);
            }
        }
        FishFragment.updateFish();
    updateMoney();
    }
    public static Fish getFishList(String name) {
        for (Fish f : fish) {
            if (f.toString() == name) {
                return f;
            }
        }
        return null;
    }

    public static void updateFish(Fish fishItem) {
        db.updateFish(fishItem);
    }

    public static void updateMoney() {
        MoneyView.setText(money + "$");
    }

    public static void setBoost(long durée, int boost) {
        CurrentBoost.setText("");
        CurrentBoost.setBase(durée);
        setBoost(boost);
        CurrentBoost.start();
    }

    public static int getMoney() {
        return money;
    }

    public static void enableAutoClick() {
        autoClickBoolean=true;
        Log.d("runnable","it starts");
        handler.postDelayed(autoClick, 60000);
        SharedPreferences.Editor editor = spAutoClick.edit();
        editor.putBoolean("autoclick", autoClickBoolean);
        editor.commit();
    }

    public static void setBoost(int b) {
        boost = b;
    }

    public static int getBoost() {
        return boost;
    }

    public static void setMoney(int m) {
        money = m;
        updateMoney();
        SharedPreferences.Editor editor = spMoney.edit();
        editor.putInt("money", money);
        editor.commit();
    }
}