package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productlist.aman.BuyProductActivity;

public class DisplayProductActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView Name,Price,Description;
    private ImageButton Back;
    private Button btnBuyNow,Cart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        imageView=findViewById(R.id.imageView3);
        Name=findViewById(R.id.tv_product_name);
        Price=findViewById(R.id.textView11);
        Description=findViewById(R.id.textView14);
        Back=findViewById(R.id.imageButton2);
        btnBuyNow =findViewById(R.id.btn_buy_now);
        Cart=findViewById(R.id.button3);

        int productimage=getIntent().getIntExtra("key3",0);
        String productname=getIntent().getStringExtra("key1");
        String productprice=getIntent().getStringExtra("key2");
        int visibility=getIntent().getIntExtra("key4",1);

        if(visibility==0)
        {
          Cart.setVisibility(View.INVISIBLE);
        }

        resource(productname,productprice,productimage);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DisplayProductActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayProductActivity.this, "Bought", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DisplayProductActivity.this, BuyProductActivity.class);
                intent.putExtra("key1",productname);
                intent.putExtra("key2",productprice);
                intent.putExtra("key3",productimage);
                startActivity(intent);
            }
        });

        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
                int length=sharedPreferences.getInt("data2",0);
                SharedPreferences.Editor editor= sharedPreferences.edit();

                length++;
                Intent i=new Intent(getApplicationContext(),CartList.class);
                i.putExtra("key1",productname);
                i.putExtra("key2",productprice);
                i.putExtra("key3",productimage);

                editor.putInt("data2",length);
                editor.apply();

                startActivity(i);
                finish();
            }
        });
    }

    void resource(String name,String price,int Image)
    {
        Name.setText(name);
        Price.setText(price);
        imageView.setImageResource(Image);
    }

}