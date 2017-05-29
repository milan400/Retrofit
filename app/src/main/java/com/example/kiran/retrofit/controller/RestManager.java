package com.example.kiran.retrofit.controller;
import com.example.kiran.retrofit.model.Helper.Constants;
import com.example.kiran.retrofit.model.callback.FlowerService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kiran on 5/29/2017.
 */
public class RestManager {
    private FlowerService mFlowerService;

    public FlowerService getmFlowerService()
    {
        if(mFlowerService == null)
        {
            Retrofit retrofit = new  retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            mFlowerService = retrofit.create(FlowerService.class);
        }
        return mFlowerService;

    }
}






































