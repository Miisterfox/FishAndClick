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
    private static Button autoclick;
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
        autoclick = (Button) view.findViewById(R.id.autoClick);
        BoostButton1.setOnClickListener(this);
        BoostButton3.setOnClickListener(this);
        BoostButton2.setOnClickListener(this);
        autoclick.setOnClickListener(this);
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
        autoclick.setEnabled(!MainActivity.isAutoClickOn());
    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Boost1:
                buyBoost(1000,10000);
                break;
            case R.id.boost2:
                buyBoost(10000,(60000*5));
                break;
                case R.id.boost3:
                buyBoost(50000,(60000*60));
                break;
            case R.id.autoClick:
                buyAutoClick();
                break;
        }
    }

    private void buyAutoClick() {
        int price = 1;
        if(MainActivity.getMoney()>=price) {
            MainActivity.setMoney(MainActivity.getMoney()-price);
            MainActivity.enableAutoClick();
            disableBoosts();
        }
    }

    private void buyBoost(int boostPrice, int durée) {
        if(MainActivity.getMoney()>=boostPrice) {
            MainActivity.setMoney(MainActivity.getMoney()-boostPrice);
            MainActivity.setBoost(SystemClock.elapsedRealtime() + durée,2);
            disableBoosts();
        }
    }
}