package com.example.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

class CustomCardAdapter extends RecyclerView.Adapter<CustomCardAdapter.MyViewHolder> {

    String[] data;

    public CustomCardAdapter(String[] list0Data) {
        this.data = list0Data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView productRV;
        TextView header;

        public MyViewHolder(View itemView) {
            super(itemView);

            header = itemView.findViewById(R.id.card_view_header);
            productRV = itemView.findViewById(R.id.product_RV);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView header = holder.header;
        header.setText(data[listPosition]);
//        RecyclerView productRV = holder.productRV;

        RecyclerView.LayoutManager layoutManagerCardView = new GridLayoutManager(holder.productRV.getContext(), 3);
        holder.productRV.setLayoutManager(layoutManagerCardView);
        CustomRVAdapter secondAdapter = new CustomRVAdapter(MyData.productsList0, MyData.productsList1, MyData.productsList2);
        holder.productRV.setAdapter(secondAdapter);

    }

    @Override
    public int getItemCount() {
        return MyData.headersList.length;
    }
}
