package com.payoneerexercise1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.payoneerexercise1.databinding.FragmentHomeBinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.payoneerexercise1.R;
import com.payoneerexercise1.model.Applicable;
import com.payoneerexercise1.ui.adapters.PaymentAdapter;
import com.payoneerexercise1.viewmodel.PaymentViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {
    private static final String TAG = "Home";
    private FragmentHomeBinding binding;
    private PaymentViewModel viewModel;
    private PaymentAdapter adapter;
    private ArrayList<Applicable> paymentList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PaymentViewModel.class);

        initRecyclerView();
        observeData();
        viewModel.getPaymentsMethod();
    }


    private void observeData() {
        viewModel.getPaymentList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Applicable>>() {
            @Override
            public void onChanged(ArrayList<Applicable> pokemons) {
                Log.e(TAG, "onChanged: " + pokemons.size());
                adapter.updateList(pokemons);
            }
        });
    }

    private void initRecyclerView() {
        binding.paymentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PaymentAdapter(getContext(), paymentList);
        binding.paymentRecyclerView.setAdapter(adapter);
    }
}