package com.payoneerexercise1.network;

import com.payoneerexercise1.model.PaymentListResult;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface PaymentApiService {

    @GET("listresult.json")
    Observable<PaymentListResult> getListResult();
}
