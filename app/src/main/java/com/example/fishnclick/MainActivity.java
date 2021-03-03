package com.example.fishnclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestionInterface{
    private static ArrayList<Fish> fish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fish=new ArrayList<Fish>();

        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));
        setContentView(R.layout.activity_main);
    }
    @Override
        public ArrayList<Fish> getFish() {
        return fish;
        }
}