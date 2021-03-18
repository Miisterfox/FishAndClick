package com.example.fishnclick;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ShopFragment extends Fragment implements View.OnClickListener {
    private static Button BoostButton1;
    private static Button BoostButton3;
    private static Button BoostButton2;
    View view;
    TextView moneyTextView;
    public ShopFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        BoostButton1 = (Button) view.findViewById(R.id.Boost1);
        BoostButton2 = (Button) view.findViewById(R.id.boost2);
        BoostButton3 = (Button) view.findViewById(R.id.boost3);
        BoostButton1.setOnClickListener(this);
        BoostButton3.setOnClickListener(this);
        BoostButton2.setOnClickListener(this);
        disableBoosts();
        return view;


    }
    public static void disableBoosts() {
        if(MainActivity.getBoost()!=1) {
            BoostButton1.setEnabled(false);
            BoostButton2.setEnabled(false);
            BoostButton3.setEnabled(false);
        }
        else {
            BoostButton1.setEnabled(true);
            BoostButton3.setEnabled(true);
            BoostButton2.setEnabled(true);
        }
    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Boost1:
                buyBoost1();
                break;
            case R.id.boost2:
                buyBoost2();
                break;
                case R.id.boost3:
                buyBoost3();
                break;
        }
    }


    private void buyBoost1() {
        int boostPrice=10000;
        int durée = 10000;
        if(MainActivity.getMoney()>=boostPrice) {
            MainActivity.setMoney(MainActivity.getMoney()-boostPrice);
            MainActivity.setBoost(SystemClock.elapsedRealtime() + durée,2);
            disableBoosts();
        }
    }

    private void buyBoost2() {
        int boostPrice=10000;
        int durée = 60000*5;
        if(MainActivity.getMoney()>=boostPrice) {
            MainActivity.setMoney(MainActivity.getMoney()-boostPrice);
            MainActivity.setBoost(SystemClock.elapsedRealtime() + durée,2);
            disableBoosts();
        }
    }
    private void buyBoost3() {
        int boostPrice=50000;
        int durée = 60000*60;
        if(MainActivity.getMoney()>=boostPrice) {
            MainActivity.setMoney(MainActivity.getMoney()-boostPrice);
            MainActivity.setBoost(SystemClock.elapsedRealtime() + durée,2);
            disableBoosts();
        }
    }

}