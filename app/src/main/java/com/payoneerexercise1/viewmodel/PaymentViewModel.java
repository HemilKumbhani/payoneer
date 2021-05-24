package com.payoneerexercise1.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.payoneerexercise1.model.Applicable;
import com.payoneerexercise1.repository.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class PaymentViewModel extends ViewModel {
    private static final String TAG = "PaymentViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Applicable>> paymentList = new MutableLiveData<ArrayList<Applicable>>();

    @ViewModelInject
    public PaymentViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Applicable>> getPaymentList() {
        return paymentList;
    }

    public void getPaymentsMethod() {
        repository.getPaymentMethods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(result -> {
                            paymentList.setValue((ArrayList<Applicable>) result.getNetworks().getApplicable());
                        },
                        error -> {
                            switch (((HttpException) error).code()) {
                                case 404:
                                    Log.e(TAG, "not found");

                                    break;
                                case 500:
                                    Log.e(TAG, "Server Broken");

                                    break;
                                default:
                                    Log.e(TAG, "unknown error");
                                    break;
                            }
                        });
    }


}
