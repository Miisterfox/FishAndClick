package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< HEAD
=======
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
>>>>>>> main

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestionInterface{
    private static ArrayList<Fish> fish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        fish=new ArrayList<Fish>();

=======

        setContentView(R.layout.activity_main);
        fish = new ArrayList<>();
>>>>>>> main
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));
        setContentView(R.layout.activity_main);
    }
    @Override
        public ArrayList<Fish> getFish() {
        return fish;
        }
}