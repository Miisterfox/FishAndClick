package com.example.fishnclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fish);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.fish:
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
}