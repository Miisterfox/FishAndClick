package com.example.fishnclick;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class UpgradesFragment extends Fragment implements View.OnClickListener{
    private ArrayList<Fish> fish;
    private int[] buttonList = {R.id.buyfish1,R.id.buyfish2,R.id.buyfish3,R.id.buyfish4,R.id.buyfish5,R.id.buyfish6};
    private int[] lvlList = {R.id.lvlfish1,R.id.lvlfish2,R.id.lvlfish3,R.id.lvlfish4,R.id.lvlfish5,R.id.lvlfish6};
    private int[] fishImage = {R.id.imgf1,R.id.imgf2,R.id.imgf3,R.id.imgf4,R.id.imgf5,R.id.imgf6};
    private ArrayList<Fish> fishList;
    private int[] levels = {10,50,200,500,1000,2500,10000};
    private View view;
    public UpgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        fishList =MainActivity.getFishList();
        for(int i=0;i<buttonList.length;i++) {
            Button button = (Button) view.findViewById(buttonList[i]);
            button.setOnClickListener(this);

        }
        setLEVELS();
        return view;
    }

    public void setLEVELS() {
        for(int i=0;i<lvlList.length;i++) {
            TextView BarLevel = view.findViewById(lvlList[i]);
            Button buybutton = view.findViewById(buttonList[i]);
            ImageView fishimg = (ImageView) view.findViewById(fishImage[i]);
            Fish fish = fishList.get(i);
            if(!fish.getEnabled()) {
                fishimg.setColorFilter(Color.rgb(128,128,128));
                BarLevel.setText("Not unlocked");
                buybutton.setText(fish.getValue()*100+"€");
            }
            else {
                if (fish.getLevel() != levels.length) {
                    BarLevel.setText("lvl " + fish.getLevel());
                    buybutton.setText(levels[fish.getLevel()]*fish.getValue() + "€");
                } else {
                    BarLevel.setText("MAX");
                    buybutton.setText("lvl MAX");
                    buybutton.setEnabled(false);
                }
            }
        }
    }
    @Override
    public void onClick(View v) {
        Log.e("test","lol on arrive ici1");
        for(int i=0;i<buttonList.length;i++) {
            if(v.getId()==buttonList[i]) {
                Button button = (Button) v.findViewById(buttonList[i]);
                TextView BarLevel = (TextView) view.findViewById(lvlList[i]);
                ImageView imgFish = (ImageView) view.findViewById(fishImage[i]);
                OnLevelUp(fishList.get(i),button,BarLevel,imgFish);
            }
        }
    }

    public void OnLevelUp(Fish fish,Button button,TextView text,ImageView img) {
        if(!fish.getEnabled()) {
            if (MainActivity.getMoney() - (fish.getValue() * 100) >= 0) {
                MainActivity.setMoney(MainActivity.getMoney() - (fish.getValue() * 100));
                fish.setEnabled();
                button.setText(levels[fish.getLevel()] * fish.getValue() + "€");
                text.setText("lvl " + fish.getLevel());
                img.setColorFilter(null);
            }
        }
        else {
            if (fish.getLevel() != levels.length) {
                if (MainActivity.getMoney() - (levels[fish.getLevel()]) >= 0) {
                    MainActivity.setMoney(MainActivity.getMoney() - levels[fish.getLevel()]);
                    fish.levelUp();
                    if (fish.getLevel() == levels.length) {
                        button.setText("MAX");
                        text.setText("lvl MAX");
                        button.setEnabled(false);
                    } else {
                        button.setText(levels[fish.getLevel()] + "€");
                        text.setText("lvl " + fish.getLevel());
                    }
                }
            }
        }
        MainActivity.updateFish(fish);
    }
}