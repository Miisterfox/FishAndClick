package com.example.fishnclick;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FishFragment extends Fragment implements View.OnClickListener{
    private TextView FishView;
    private TextView FishName;
    private ImageButton fishButton;
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
        fishButton = (ImageButton) view.findViewById(R.id.FishClick);
        fishButton.setOnClickListener(this);
        ImageButton arrowLeft = (ImageButton) view.findViewById(R.id.arrowLeft);
        arrowLeft.setOnClickListener(this);
        ImageButton arrowRight = (ImageButton) view.findViewById(R.id.arrowRight);
        arrowRight.setOnClickListener(this);

        fish = new ArrayList<>();
        fish.add(new Fish("Bar", 1, R.drawable.fish1));
        fish.add(new Fish("Carpe", 2, R.drawable.fish2));
        fishIndex = 0;
        FishView = (TextView) view.findViewById(R.id.FishView);;
        FishName = (TextView) view.findViewById(R.id.FishName);
        moneyText = (TextView) view.findViewById(R.id.Money);
        money = 0;
        moneyText.setText(money + "$");
        updateFish();
        return view;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.FishClick:
                FishClick();
                break;
            case R.id.arrowRight:
                ArrowRight();
                break;
            case R.id.arrowLeft:
                ArrowLeft();
                break;
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    private void updateFish() {
        Fish SelectedFish = fish.get(fishIndex);

        FishName.setText(SelectedFish.toString());
        FishView.setText(SelectedFish.getClicks() + " " + SelectedFish.toString() + "s");
        fishButton.setImageResource(SelectedFish.getLogo());
    }
    public void FishClick() {
        Fish SelectedFish = fish.get(fishIndex);
        SelectedFish.addClick();
        FishView.setText(SelectedFish.getClicks() + " " + SelectedFish.toString() + "s");
        //moneyupdate
        money += SelectedFish.getValue();
        moneyText.setText(money + "$");
    }

    public void ArrowLeft() {
        if (fishIndex == 0) {
            fishIndex = fish.size() - 1;
        } else {
            fishIndex--;
        }
        updateFish();
    }


    public void ArrowRight() {
        if (fishIndex == fish.size() - 1) {
            fishIndex = 0;
        } else {
            fishIndex++;
        }
        updateFish();
    }

}