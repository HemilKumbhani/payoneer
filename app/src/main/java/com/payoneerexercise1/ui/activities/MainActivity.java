package com.payoneerexercise1.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.payoneerexercise1.R;
import com.payoneerexercise1.databinding.ActivityMainBinding;
import com.payoneerexercise1.ui.fragments.HomeFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment())
                .commit();

    }


}