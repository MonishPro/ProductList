package com.example.productlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Monishadapter extends RecyclerView.Adapter<Monishadapter.ViewHolder> {

    private String[] productname;
    private String[] productprices;
    private int[] productimages;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productname;
        private final TextView productprices;
        private final ImageView productimagess;

        public ViewHolder(View view) {
            super(view);

            productname = (TextView) view.findViewById(R.id.textView12);
            productprices=(TextView) view.findViewById(R.id.textView16);
            productimagess=(ImageView) view.findViewById(R.id.imageView12);
        }
    }

    public Monishadapter(String[] dataSet, String[] prices, int[] images, Context context) {
        productname=dataSet;
        productprices=prices;
        productimages=images;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.monish_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        viewHolder.productname.setText(productname[position]);
        viewHolder.productprices.setText(productprices[position]);
        viewHolder.productimagess.setImageResource(productimages[position]);

        int a=position;
        
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, DisplayProductActivity.class);
                i.putExtra("key",a);
                i.putExtra("key1",productname[a]);
                i.putExtra("key2",productprices[a]);
                i.putExtra("key3",productimages[a]);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productname.length;
    }
}
