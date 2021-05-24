package com.payoneerexercise1.repository;

import com.payoneerexercise1.model.PaymentListResult;
import com.payoneerexercise1.network.PaymentApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Abhinav Singh on 17,June,2020
 */

public class Repository {

    private PaymentApiService apiService;

    @Inject
    public Repository( PaymentApiService apiService) {
        this.apiService = apiService;
    }


    public Observable<PaymentListResult> getPaymentMethods(){
        return apiService.getListResult();
    }

}
