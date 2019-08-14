package com.example.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRVAdapter extends RecyclerView.Adapter<CustomRVAdapter.MyViewHolder> {

    private String[] data0;
    private String[] data1;
    private String[] data2;

    public CustomRVAdapter(String[] myDataset0, String[] myDataset1, String[] myDataset2) {
        data0 = myDataset0;
        data1 = myDataset1;
        data2 = myDataset2;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView productTV0;
        public TextView productTV1;
        public TextView productTV2;

        public MyViewHolder(View v) {
            super(v);

            this.productTV0 = v.findViewById(R.id.product_TV0);
            this.productTV1 = v.findViewById(R.id.product_TV1);
            this.productTV2 = v.findViewById(R.id.product_TV2);
        }
    }

    @Override
    public CustomRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rv_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRVAdapter.MyViewHolder holder, int position) {

        holder.productTV0.setText(data0[position]);
        holder.productTV1.setText(data1[position]);
        holder.productTV2.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data0.length;
    }
}
