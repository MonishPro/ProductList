package com.example.productlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.productlist.aman.BuyProductActivity;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private String[] productname;
    private String[] productprices;
    private int[] productimages;
    private Context context;
    private final CartListInterface cartListInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productname;
        private final TextView productprices;
        private final ImageView productimagess;
        private final ImageView removeimage,payment;

        public ViewHolder(View view,CartListInterface cartListInterface) {
            super(view);

            productname =  view.findViewById(R.id.textView12);
            productprices= view.findViewById(R.id.textView16);
            productimagess= view.findViewById(R.id.imageView12);
            removeimage= view.findViewById(R.id.imageButton14);
            payment= view.findViewById(R.id.imageButton16);

            removeimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cartListInterface != null)
                    {
                        int pos=getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION)
                        {
                            cartListInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    public CartAdapter(String[] dataSet, String[] prices, int[] images, Context context, CartListInterface cartListInterface) {
        productname=dataSet;
        productprices=prices;
        productimages=images;
        this.context=context;
        this.cartListInterface=cartListInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_layout, viewGroup, false);

        return new ViewHolder(view,cartListInterface);
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
                i.putExtra("key4",0);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        viewHolder.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Bought", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BuyProductActivity.class);
                intent.putExtra("key1",productname[a]);
                intent.putExtra("key2",productprices[a]);
                intent.putExtra("key3",productimages[a]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productname.length;
    }
}
