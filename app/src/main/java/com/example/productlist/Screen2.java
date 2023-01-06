package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {

    private ImageView imageView;
    private TextView Name,Price,Description;
    private ImageButton Back;

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

        int position=getIntent().getIntExtra("key",0);

        resource(position);
        imageretrieve(position);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Screen2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    void resource(int position)
    {
        Resources resources=getResources();
        String [] name=resources.getStringArray(R.array.product_name);
        String [] prices=resources.getStringArray(R.array.product_prices);

        Name.setText(name[position]);
        Price.setText(prices[position]);
    }

    void imageretrieve(int position)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
        String img=sharedPreferences.getString("data1",null);

        String[] image = img.split(",");
        int[] images=new int[image.length];

        for (int i = 0; i < image.length; i++) {
            images[i]= Integer.parseInt(image[i]);
        }

        try {
            imageView.setImageResource(images[position]);
        }
        catch (Exception e){};
    }
}