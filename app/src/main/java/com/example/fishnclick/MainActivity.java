package com.example.fishnclick;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestionInterface{
    private static ArrayList<Fish> fish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fish=new ArrayList<Fish>();

        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main);
        fish = new ArrayList<>();
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fish);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.fish:
                        FishFragment.updateMoney();
                        fragmentTransaction.show(fragmentManager.findFragmentById(R.id.mainFragment));
                        fragmentTransaction.replace(R.id.content,new Fragment()).commit();
                        return true;
                    case R.id.shop:
                        fragmentTransaction.hide(fragmentManager.findFragmentById(R.id.mainFragment));
                        fragmentTransaction.replace(R.id.content,new ShopFragment()).commit();
                        return true;
                    case R.id.upgrades:
                        fragmentTransaction.hide(fragmentManager.findFragmentById(R.id.mainFragment));
                        fragmentTransaction.replace(R.id.content,new UpgradesFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
    @Override
        public ArrayList<Fish> getFish() {
        return fish;
        }
}