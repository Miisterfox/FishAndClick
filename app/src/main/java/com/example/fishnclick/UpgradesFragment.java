package com.example.fishnclick;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UpgradesFragment extends Fragment {

    public UpgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upgrades, container, false);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Buy:
                Fish fish = FishFragment.getFish("bar");
                FishFragment.setMoney(-(FishFragment.getMoney()*fish.getLevel()));
                fish.levelUp();
                break;
        }
    }

}