package com.example.productlist.aman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.productlist.MainActivity;
import com.example.productlist.R;
import com.example.productlist.databinding.ActivityBuyProductBinding;

public class BuyProductActivity extends AppCompatActivity {

    ActivityBuyProductBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences=getSharedPreferences(MainActivity.SHARED_PREF_DB,MODE_PRIVATE);

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

    private void validateAndMakePayment() {
        String addressCountry = binding.tilAddressCountry.getEditText().getText().toString();
        String addressState = binding.tilAddressState.getEditText().getText().toString();
        String addressDistrict = binding.tilAddressDistrict.getEditText().getText().toString();
        String addressPinCode = binding.tilAddressPincode.getEditText().getText().toString();
        String upi = binding.tilUpi.getEditText().getText().toString();
        if (addressCountry.equals("") | addressState.equals("") | addressDistrict.equals("") | addressPinCode.equals("")
         | upi.equals("")){
            binding.tvError.setVisibility(View.VISIBLE);
        }else {
            String fullAddress = addressCountry+","+addressState+","+addressDistrict+","+addressPinCode;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("address",fullAddress);
            editor.putString("upi", upi);
            editor.apply();
            Intent intent = new Intent(BuyProductActivity.this, ThankYouActivity.class);
            startActivity(intent);
            finish();
        }
    }
}