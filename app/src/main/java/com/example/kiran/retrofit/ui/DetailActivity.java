package com.example.kiran.retrofit.ui;

import android.content.Intent;
import android.renderscript.Float2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiran.retrofit.R;
import com.example.kiran.retrofit.model.Flower;
import com.example.kiran.retrofit.model.Helper.Constants;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView mName,mId,mCategory,mInstruction;
    private ImageView mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        configViews();

        mId.setText(""+flower.getProductId());
        mName.setText(flower.getName());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstructions());

        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/"+flower.getPhoto()).into(mPhoto);
    }

    private void configViews() {
        mPhoto = (ImageView)findViewById(R.id.detailphoto);
        mName =(TextView)findViewById(R.id.Name);
        mId =(TextView)findViewById(R.id.id);
        mCategory =(TextView)findViewById(R.id.Category);
        mInstruction =(TextView)findViewById(R.id.Instruction);
    }
}





































































