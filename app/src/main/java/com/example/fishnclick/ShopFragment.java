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
    View view;
    TextView moneyTextView;
    public ShopFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        BoostButton1 = (Button) view.findViewById(R.id.Boost1);
        BoostButton1.setOnClickListener(this);
        moneyTextView = (TextView) view.findViewById(R.id.moneyShop);
        updateMoney();
        disableBoosts();
        return view;


    }
    public static void disableBoosts() {
        if(MainActivity.getBoost()!=1) {
            BoostButton1.setEnabled(false);
        }
        else {
            BoostButton1.setEnabled(true);
        }
    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Boost1:
                buyBoost1();
                break;
        }
    }

    public void updateMoney() {
        int money=MainActivity.getMoney();
        moneyTextView.setText(money+"$");
    }

    private void buyBoost1() {
        int boostPrice=1;
        if(MainActivity.getMoney()>=boostPrice) {
            MainActivity.setMoney(MainActivity.getMoney()-boostPrice);
            updateMoney();
            MainActivity.setBoost(SystemClock.elapsedRealtime() + 10000,2);
            disableBoosts();
        }
    }
}