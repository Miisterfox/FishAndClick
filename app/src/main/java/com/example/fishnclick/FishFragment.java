package com.example.fishnclick;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class FishFragment extends Fragment {
    private TextView FishView;
    private TextView FishName;
    private ImageButton FishClick;
    private static ArrayList<Fish> fish;
    private int fishIndex;
    private TextView moneyText;
    private int money;

    public FishFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fish = new ArrayList<>();
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));
        fishIndex = 0;
        FishView = (TextView) view.findViewById(R.id.FishView);
        FishName = (TextView) view.findViewById(R.id.FishName);
        moneyText = (TextView) view.findViewById(R.id.Money);
        money = 0;
        moneyText.setText(money + "$");
        FishClick = (ImageButton) view.findViewById(R.id.FishClick);
        FishClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fish SelectedFish = fish.get(fishIndex);
                SelectedFish.addClick();
                FishView.setText(SelectedFish.getClicks() + " " + SelectedFish.toString() + "s");
                //moneyupdate
                money += SelectedFish.getValue();
                moneyText.setText(money + "$");
            }
        });
    }
}