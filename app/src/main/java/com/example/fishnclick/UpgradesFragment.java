package com.example.fishnclick;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UpgradesFragment extends Fragment implements View.OnClickListener{
    private ArrayList<Fish> fish;
    private Button B1;
    private Button B2;

    public UpgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        Fish bar = MainActivity.getFish("Bar");
        Fish carpe = MainActivity.getFish("Carpe");
        B1 = (Button) view.findViewById(R.id.B1);
        B2 = (Button) view.findViewById(R.id.B2);
        System.out.println("OUI");
        B1.setText(((1+bar.getLevel())*bar.getValue()) + "€");
        B2.setText(((1+carpe.getLevel())*bar.getValue()) + "€");
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.B1:
                System.out.println("OUI");
                Fish fish = MainActivity.getFish("Bar");
                FishFragment.setMoney(-(FishFragment.getMoney()*fish.getLevel()));
                fish.levelUp();
                B1.setText(((1+fish.getLevel())*fish.getValue()) + "€");
                break;
        }
    }

}