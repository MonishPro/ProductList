package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {

    private ImageView imageView;
    private TextView Name,Price,Description;
    private ImageButton Back;
    private Button Carty;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlay);

        imageView=findViewById(R.id.imageView3);
        Name=findViewById(R.id.textView10);
        Price=findViewById(R.id.textView11);
        Description=findViewById(R.id.textView14);
        Back=findViewById(R.id.imageButton2);
        Carty=findViewById(R.id.button2);

        int productimage=getIntent().getIntExtra("key3",0);
        String productname=getIntent().getStringExtra("key1");
        String productprice=getIntent().getStringExtra("key2");

        resource(productname,productprice,productimage);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Screen2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

//        Carty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    void resource(String name,String price,int Image)
    {
        Name.setText(name);
        Price.setText(price);
        imageView.setImageResource(Image);
    }

}