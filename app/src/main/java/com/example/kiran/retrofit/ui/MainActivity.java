package com.example.kiran.retrofit.ui;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.kiran.retrofit.R;
import com.example.kiran.retrofit.controller.RestManager;
import com.example.kiran.retrofit.model.Flower;
import com.example.kiran.retrofit.model.Helper.Constants;
import com.example.kiran.retrofit.model.adapter.FlowerAdapter;


import java.util.List;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListener {
    private RecyclerView recyclerView;
    private RestManager mManager;
    private FlowerAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mManager = new RestManager();
        Call<List<Flower>> listCall = mManager.getmFlowerService().getALLFlowers();
       listCall.enqueue(new retrofit2.Callback<List<Flower>>() {
           @Override
           public void onResponse(Call<List<Flower>> call, retrofit2.Response<List<Flower>> response) {
               if(response.isSuccessful()) {
                   List<Flower> flowerlist = response.body();

                   for (int i = 0; i < flowerlist.size(); i++) {
                       Flower flower = flowerlist.get(i);
                       madapter.addFlower(flower);

                   }
               }else{
                   int sc = response.code();

               }
           }

           @Override
           public void onFailure(Call<List<Flower>> call, Throwable t) {

           }
       });
    }

    private void configViews() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        madapter = new FlowerAdapter(this);
        recyclerView.setAdapter(madapter);
    }

    @Override
    public void onClick(int position) {
        Flower selectedFlower = madapter.getSelectedFlower(position);
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER,selectedFlower);
        startActivity(intent);
    }
}

























































