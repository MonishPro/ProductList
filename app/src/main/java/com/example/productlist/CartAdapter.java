package com.example.productlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private String[] productname;
    private String[] productprices;
    private int[] productimages;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productname;
        private final TextView productprices;
        private final ImageView productimagess;
        private final ImageButton removeimage,payment;

        public ViewHolder(View view) {
            super(view);

            productname = (TextView) view.findViewById(R.id.textView12);
            productprices=(TextView) view.findViewById(R.id.textView16);
            productimagess=(ImageView) view.findViewById(R.id.imageView12);
            removeimage=(ImageButton) view.findViewById(R.id.imageButton14);
            payment=(ImageButton) view.findViewById(R.id.imageButton16);

        }
    }

    public CartAdapter(String[] dataSet, String[] prices, int[] images, Context context) {
        productname=dataSet;
        productprices=prices;
        productimages=images;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_layout, viewGroup, false);

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

                Intent i=new Intent(context,Screen2.class);
                i.putExtra("key",a);
                i.putExtra("key1",productname[a]);
                i.putExtra("key2",productprices[a]);
                i.putExtra("key3",productimages[a]);
                i.putExtra("key4",0);
                context.startActivity(i);
            }
        });

        viewHolder.removeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                CartList cartList=new CartList();
//                RecyclerView recyclerview=cartList.findViewById(R.id.recyclerView);

                SharedPreferences sharedPreferences= context.getSharedPreferences("Database",Context.MODE_PRIVATE);
                int length=sharedPreferences.getInt("data2",0);
                String pnam= sharedPreferences.getString("data3",null);
                String ppric= sharedPreferences.getString("data4",null);
                String pimg= sharedPreferences.getString("data5",null);

                String [] pnames=pnam.split(",");
                String [] pprices=ppric.split(",");
                String [] pimag=pimg.split(",");

                Toast.makeText(context, pnames[a]+""+pprices[a], Toast.LENGTH_SHORT).show();

//                int [] pimages=new int[pimag.length];
//                for (int i = 0; i < pimag.length; i++) {
//                    pimages[i]=Integer.parseInt(pimag[i]);
//                }
//
//                for (int i = a; i < pnames.length; i++) {
//                    if(i<=pnames.length-2)
//                    {
//                        pnames[i]=pnames[i+1];
//                        pprices[i]=pprices[i+1];
//                        pimages[i]=pimages[i+1];
//                    }
//                    else {
//                        break;
//                    }
//                }
//                length=length-1;
//
//                String [] pname=new String[length];
//                String [] pprice=new String[length];
//                int [] pimage=new int[length];
//
//                for (int i = 0; i < length; i++) {
//                    pname[i]=pnames[i];
//                    pprice[i]=pprices[i];
//                    pimage[i]=pimages[i];
//                }
//
//                recyclerview.setLayoutManager(new LinearLayoutManager(context));
//                CartAdapter cartAdapter=new CartAdapter(pname,pprice,pimage,context);
//                recyclerview.setAdapter(cartAdapter);
//
//                SharedPreferences.Editor ed= sharedPreferences.edit();
//                StringBuilder str1 = new StringBuilder();
//                StringBuilder str2 = new StringBuilder();
//                StringBuilder str3 = new StringBuilder();
//
//                for (int i = 0; i < pname.length; i++) {
//                    str1.append(pname[i]).append(",");
//                    str2.append(pprice[i]).append(",");
//                    str3.append(pimage[i]).append(",");
//                }
//
//                ed.putString("data3",str1.toString());
//                ed.putString("data4",str2.toString());
//                ed.putString("data5",str3.toString());
//                ed.apply();
            }
        });

        viewHolder.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Bought", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productname.length;
    }
}
