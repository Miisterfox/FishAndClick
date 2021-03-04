package com.example.fishnclick;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UpgradesFragment extends Fragment implements View.OnClickListener{
    private ArrayList<Fish> fish;
    private Button Button1;
    private Button Button2;
    private TextView CarpeLevel;
    private TextView BarLevel;

    public UpgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        Fish bar = MainActivity.getFish("Bar");
        Fish carpe = MainActivity.getFish("Carpe");
        Button1 = (Button) view.findViewById(R.id.barB);
        Button2 = (Button) view.findViewById(R.id.carpeB);
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        BarLevel = (TextView) view.findViewById(R.id.barlevel);
        CarpeLevel = (TextView) view.findViewById(R.id.carpelevel);
        BarLevel.setText("lvl " + bar.getLevel());
        CarpeLevel.setText("lvl " + carpe.getLevel());
        Button1.setText(((1+bar.getLevel())*bar.getValue()) + "€");
        Button2.setText(((1+carpe.getLevel())*bar.getValue()) + "€");
        return view;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.barB:
                Fish bar = MainActivity.getFish("Bar");
                OnLevelUp(bar,Button1,BarLevel);
                break;
            case R.id.carpeB:
                Fish carpe = MainActivity.getFish("Carpe");
                OnLevelUp(carpe,Button2,CarpeLevel);
                break;
        }
    }

    public void OnLevelUp(Fish fish,Button button,TextView text){
        if(FishFragment.getMoney()-(fish.getValue()*fish.getLevel())>0) {
            FishFragment.setMoney(-(fish.getValue() * fish.getLevel()));
            fish.levelUp();
            button.setText(((1 + fish.getLevel()) * fish.getValue()) + "€");
            text.setText("lvl " + fish.getLevel());
        }
    }
}