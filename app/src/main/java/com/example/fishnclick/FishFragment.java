package com.example.fishnclick;

import android.content.Context;
import android.os.Bundle;
<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
=======
>>>>>>> Test
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
>>>>>>> Test

public class FishFragment extends Fragment implements View.OnClickListener{
    private GestionInterface gestionInterface;
    private TextView FishView;
    private TextView FishName;
    private ImageButton fishButton;
    private int fishIndex;
    private TextView moneyText;
<<<<<<< HEAD
    private int money;
    private ArrayList<Fish> fish;
=======

>>>>>>> Test
    public FishFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            gestionInterface=(GestionInterface)context;
            fish=gestionInterface.getFish();
        } catch(ClassCastException castException) {

        }
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
        fishIndex = 0;
        FishView = (TextView) view.findViewById(R.id.FishView);;
        FishName = (TextView) view.findViewById(R.id.FishName);
        moneyText = (TextView) view.findViewById(R.id.Money);
<<<<<<< HEAD
        money = 0;
=======
        int money=MainActivity.getMoney();
>>>>>>> Test
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
        int money=MainActivity.getMoney();
        money += SelectedFish.getValue();
        MainActivity.setMoney(money);
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