package com.example.productlist.aman;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productlist.CartAdapter;
import com.example.productlist.DisplayProductActivity;
import com.example.productlist.R;
import com.example.productlist.aman.BuyProductActivity;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    private String[] productname;
    private String[] productprices;
    private int[] productimages;
    private Context context;
    private OrderListInterface orderListInterface;

    public OrderListAdapter() {
    }

    public OrderListAdapter(String[] productname, String[] productprices, int[] productimages, Context context, OrderListInterface orderListInterface) {
        this.productname = productname;
        this.productprices = productprices;
        this.productimages = productimages;
        this.context = context;
        this.orderListInterface = orderListInterface;
    }

    @NonNull
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.cart_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {
        holder.productname.setText(productname[position]);
        holder.productprices.setText(productprices[position]);
        holder.productimagess.setImageResource(productimages[position]);

        int a=position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() {
        return productname.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productname;
        private final TextView productprices;
        private final ImageView productimagess;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productname =  itemView.findViewById(R.id.textView12);
            productprices= itemView.findViewById(R.id.textView16);
            productimagess= itemView.findViewById(R.id.imageView12);
        }
    }
}
