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
import com.example.productlist.CartList;
import com.example.productlist.DisplayProductActivity;
import com.example.productlist.R;
import com.example.productlist.aman.BuyProductActivity;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
 

    private Context context;
    private ArrayList<OrderListModelClass> orderListDataHolder;
    public static final String REQUEST_CODE = "request_code";
    public static final String REQUEST_CODE_NAME = "OrderListAdapter";


    public OrderListAdapter() {
    }

    public OrderListAdapter(Context context, ArrayList<OrderListModelClass> orderListDataHolder) {
        this.context = context;
        this.orderListDataHolder = orderListDataHolder;
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
        String productName = orderListDataHolder.get(position).getProductName();
        String productPrice = orderListDataHolder.get(position).getProductPrice();
        int productImage = orderListDataHolder.get(position).getProductImage();
        String fullAddress = orderListDataHolder.get(position).getFullAddress();
        String upi = orderListDataHolder.get(position).getUpi();
        int priceInt = orderListDataHolder.get(position).getPriceInt();
        int gst = orderListDataHolder.get(position).getGst();
        int shippingCharge = orderListDataHolder.get(position).getShippingCharge();

        holder.productname.setText(productName);
        holder.productprices.setText(productPrice);
        holder.productimagess.setImageResource(productImage);


        int a=position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, DisplayProductActivity.class);
                i.putExtra(REQUEST_CODE,REQUEST_CODE_NAME);
                i.putExtra("orderListDataHolder",orderListDataHolder.get(position));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return orderListDataHolder.size();
        }catch (Exception e){
            return 0;
        }

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
