package com.payoneerexercise1.di;

import com.payoneerexercise1.network.PaymentApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static PaymentApiService providePokemonApiService(){

        return  new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PaymentApiService.class);
    }
}
