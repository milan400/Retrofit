package com.example.kiran.retrofit.model.callback;

import com.example.kiran.retrofit.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kiran on 5/29/2017.
 */
public interface FlowerService {

    //@GET("/feeds/flowers.json")
    @GET("/feeds/flowers.json")
    Call<List<Flower>> getALLFlowers();
}




















