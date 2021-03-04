package com.example.fishnclick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class UpgradesFragment extends Fragment implements View.OnClickListener{
    private ArrayList<Fish> fish;
    private Button Button1;
    private Button Button2;
    private TextView CarpeLevel;
    private TextView BarLevel;
    private TextView moneyTextView;
    Fish carpe;
    Fish bar;
    private int[] levels = {10,50,200};
    public UpgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        bar = MainActivity.getFish("Bar");
        carpe = MainActivity.getFish("Carpe");
        Button1 = (Button) view.findViewById(R.id.barB);
        Button2 = (Button) view.findViewById(R.id.carpeB);
        moneyTextView = (TextView) view.findViewById(R.id.money);
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        BarLevel = (TextView) view.findViewById(R.id.barlevel);
        CarpeLevel = (TextView) view.findViewById(R.id.carpelevel);
        setLEVELS();
        updateMoney();
        return view;
    }
    public void updateMoney() {
        int money=MainActivity.getMoney();
        moneyTextView.setText(money+"$");
    }
    public void setLEVELS() {
        if(bar.getLevel()!=levels.length) {
            BarLevel.setText("lvl " + bar.getLevel());
            Button1.setText(levels[bar.getLevel()] + "€");
        }
        else {
            BarLevel.setText("MAX");
            Button1.setText("lvl MAX");
            Button1.setEnabled(false);
        }
        if(carpe.getLevel()!=levels.length) {
            CarpeLevel.setText("lvl " + carpe.getLevel());
            Button2.setText(levels[carpe.getLevel()] + "€");
        }
        else {
            CarpeLevel.setText("MAX");
            Button2.setText("lvl MAX");
            Button2.setEnabled(false);
        }
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

    public void OnLevelUp(Fish fish,Button button,TextView text) {
        if (fish.getLevel() != levels.length) {
            if (MainActivity.getMoney() - (levels[fish.getLevel()]) >= 0) {
                MainActivity.setMoney(MainActivity.getMoney() - levels[fish.getLevel()]);
                fish.levelUp();
                if(fish.getLevel()==levels.length) {
                    button.setText("MAX");
                    text.setText("lvl MAX");
                    button.setEnabled(false);
                }
                else {
                    button.setText(levels[fish.getLevel()] + "€");
                    text.setText("lvl " + fish.getLevel());
                }
                updateMoney();
            }
        }
    }
}