package com.example.kiran.retrofit.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiran.retrofit.R;
import com.example.kiran.retrofit.model.Flower;
import com.example.kiran.retrofit.model.Helper.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiran on 5/28/2017.
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {
    private final FlowerClickListener mListener;
    private List<Flower> mFlower;

    public FlowerAdapter(FlowerClickListener listener) {
        mFlower  = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower currFlower = mFlower.get(position);
        holder.mName.setText(currFlower.getName());
        holder.mPrice.setText("$"+Double.toString(currFlower.getPrice()));
        Picasso.with(holder.itemView.getContext()).load(Constants.HTTP.photo+currFlower.getPhoto()).into(holder.mphoto);



    }

    @Override
    public int getItemCount() {
        return mFlower.size();
    }

    public void addFlower(Flower flower) {
        mFlower.add(flower);
        notifyDataSetChanged();
    }

    public Flower getSelectedFlower(int position) {
        return mFlower.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView mphoto;
        private TextView mName,mPrice;

        public Holder(View itemView) {
            super(itemView);

            mphoto = (ImageView)itemView.findViewById(R.id.flowerphoto);
            mName = (TextView)itemView.findViewById(R.id.flowerName);
            mPrice = (TextView)itemView.findViewById(R.id.flowerPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(getLayoutPosition());
        }
    }
    public interface FlowerClickListener{
        void onClick(int position);
    }
}





















































































