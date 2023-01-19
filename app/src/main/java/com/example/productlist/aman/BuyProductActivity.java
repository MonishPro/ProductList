package com.example.productlist.aman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.productlist.MainActivity;
import com.example.productlist.databinding.ActivityBuyProductBinding;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuyProductActivity extends AppCompatActivity {

    ActivityBuyProductBinding binding;
    private SharedPreferences sharedPreferences;
    private String productName, productPrice;
    private int productImage;
    private int priceInt, gst, shippingCharge, total;
    ArrayList<OrderListModelClass> orderListDataHolder;
    public static final String ORDER_LIST = "order_list";
    private String orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREF_DB, MODE_PRIVATE);
        //
        String comingFromActivity = getIntent().getStringExtra(OrderListAdapter.REQUEST_CODE);
        if (comingFromActivity.equals(null)) {
            comingFromActivity = "this";
        }
        System.out.println("comingFromActivity + " + comingFromActivity);
        if (comingFromActivity.equals("OrderListAdapter")) {
            OrderListModelClass orderListDataHolder = getIntent().getParcelableExtra("orderListDataHolder");
            binding.imgOrderProduct.setImageResource(orderListDataHolder.getProductImage());
            binding.tvProductName.setText("Product Name: " + orderListDataHolder.getProductName());
            binding.tvProductPriceValue.setText(orderListDataHolder.getProductPrice());
            binding.tvProductPriceGstValue.setText(Integer.toString(orderListDataHolder.getGst()));
            binding.tvProductPriceShippingChargeValue.setText(Integer.toString(orderListDataHolder.getShippingCharge()));
            int productTotalPrice = orderListDataHolder.getPriceInt() + orderListDataHolder.getGst() + orderListDataHolder.getShippingCharge();
            binding.tvProductTotalPriceValue.setText(Integer.toString(productTotalPrice));
        } else if (comingFromActivity.equals("DisplayProductActivity")) {
            productName = getIntent().getStringExtra("key1");
            productPrice = getIntent().getStringExtra("key2");
            productImage = getIntent().getIntExtra("key3", 0);

            binding.imgOrderProduct.setImageResource(productImage);
            binding.tvProductName.setText(productName);
            binding.tvProductPriceValue.setText(productPrice);
            String[] price = productPrice.split(" ");
            priceInt = Integer.parseInt(price[1]);
            gst = (priceInt * 18) / 100;
            binding.tvProductPriceGstValue.setText(Integer.toString(gst));
            shippingCharge = 50;
            binding.tvProductPriceShippingChargeValue.setText(Integer.toString(shippingCharge));
            total = Integer.parseInt(price[1]) + gst + shippingCharge;
            binding.tvProductTotalPriceValue.setText(Integer.toString(total));


            binding.btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validateAndMakePayment();
                }
            });

            binding.btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
    }

    private void validateAndMakePayment() {
        String addressCountry = binding.tilAddressCountry.getEditText().getText().toString();
        String addressState = binding.tilAddressState.getEditText().getText().toString();
        String addressDistrict = binding.tilAddressDistrict.getEditText().getText().toString();
        String addressPinCode = binding.tilAddressPincode.getEditText().getText().toString();
        String upi = binding.tilUpi.getEditText().getText().toString();
        if (addressCountry.equals("") || addressState.equals("") || addressDistrict.equals("") || addressPinCode.equals("")
                || upi.equals("")) {
            binding.tvError.setVisibility(View.VISIBLE);
        } else {
            String fullAddress = addressCountry + "," + addressState + "," + addressDistrict + "," + addressPinCode;
            Gson gson = new Gson();
            String orderListPreviousData = sharedPreferences.getString(BuyProductActivity.ORDER_LIST, "");
            Type type = new TypeToken<List<OrderListModelClass>>() {
            }.getType();
            List<OrderListModelClass> orderListDataHolder;
            if (orderListPreviousData.equals("")) {
                orderListDataHolder = new ArrayList<>();
            } else {
                orderListDataHolder = gson.fromJson(orderListPreviousData, type);
            }
            OrderListModelClass orderListModel = new OrderListModelClass(productName, productPrice, productImage, fullAddress, upi, priceInt, gst, shippingCharge);
            orderListDataHolder.add(orderListModel);
            String orderList = gson.toJson(orderListDataHolder);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("address", fullAddress);
            editor.putString("upi", upi);
            editor.putString(ORDER_LIST, orderList);
            editor.apply();
            Toast.makeText(BuyProductActivity.this, "Saved!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(BuyProductActivity.this, ThankYouActivity.class);
            startActivity(intent);
            finish();
        }
    }

}