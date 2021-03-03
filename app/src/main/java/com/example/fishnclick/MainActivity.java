package com.example.fishnclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< Updated upstream
=======
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
>>>>>>> Stashed changes

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class MainActivity extends AppCompatActivity {

=======
public class MainActivity extends AppCompatActivity{
    Fragment fishFragment;
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

    }
}