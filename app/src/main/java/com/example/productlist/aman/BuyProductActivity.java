package com.example.productlist.aman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.productlist.R;
import com.example.productlist.databinding.ActivityBuyProductBinding;

public class BuyProductActivity extends AppCompatActivity {

    ActivityBuyProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String productName = getIntent().getStringExtra("key1");
        String productPrice = getIntent().getStringExtra("key2");
        int productImage = getIntent().getIntExtra("key3",0);

        binding.imgOrderProduct.setImageResource(productImage);
        binding.tvProductName.setText("Product Name: " + productName);
        binding.tvProductPriceValue.setText(productPrice);
        String[] price  = productPrice.split(" ");
        int gst = (Integer.parseInt(price[1])*18)/100;
        binding.tvProductPriceGstValue.setText(Integer.toString(gst));
        binding.tvProductPriceShippingChargeValue.setText("50");
        int total = Integer.parseInt(price[1]) + gst + 50;
        binding.tvProductTotalPriceValue.setText(Integer.toString(total));
    }
}