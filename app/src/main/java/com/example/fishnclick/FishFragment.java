package com.example.fishnclick;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FishFragment extends Fragment implements View.OnClickListener{
    private TextView FishView;
    private TextView FishName;
    private ImageButton fishButton;
    private int fishIndex;
    private static TextView moneyText;
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
        money=MainActivity.getMoney();
        fishIndex = 0;
        FishView = (TextView) view.findViewById(R.id.FishView);
        FishName = (TextView) view.findViewById(R.id.FishName);
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
        Fish SelectedFish = MainActivity.getFishList().get(fishIndex);
        fishButton.setEnabled(SelectedFish.getEnabled());
        if(!SelectedFish.getEnabled()) {
            fishButton.setColorFilter(Color.rgb(128,128,128));
        }
        else {
            fishButton.setColorFilter(null);
        }
        FishName.setText(SelectedFish.toString());
        FishView.setText(SelectedFish.getClicks() + " " + SelectedFish.toString());
        fishButton.setImageResource(SelectedFish.getLogo());
    }


    public void FishClick() {
        Fish SelectedFish = MainActivity.getFishList().get(fishIndex);
        SelectedFish.addClick();
        FishView.setText(SelectedFish.getClicks() + " " + SelectedFish.toString());
        //moneyupdate
        money += SelectedFish.getValue() *MainActivity.getBoost() * (1 + SelectedFish.getLevel());
        MainActivity.setMoney(money);
        MainActivity.updateFish(SelectedFish);
    }



    public void ArrowLeft() {
        if (fishIndex == 0) {
            fishIndex = MainActivity.getFishList().size() - 1;
        } else {
            fishIndex--;
        }
        updateFish();
    }


    public void ArrowRight() {
        if (fishIndex == MainActivity.getFishList().size() - 1) {
            fishIndex = 0;
        } else {
            fishIndex++;
        }
        updateFish();
    }

}