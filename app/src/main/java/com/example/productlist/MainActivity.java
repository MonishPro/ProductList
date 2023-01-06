package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private Monishadapter monishadapter;
private int [] images= {R.drawable.earphones,R.drawable.speakers,R.drawable.smartphone,R.drawable.lamp,R.drawable.vase};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        String [] products=resources.getStringArray(R.array.product_name);
        String [] prices=resources.getStringArray(R.array.product_prices);

        imageshare();

        recyclerView=findViewById(R.id.recycler);

        monishadapter=new Monishadapter(products,prices,images,this);

        recyclerView.setAdapter(monishadapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void imageshare()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
        SharedPreferences.Editor ed=sharedPreferences.edit();

        StringBuilder str = new StringBuilder();
        String [] imgo=new String[images.length];
        for (int i = 0; i < images.length; i++) {
            imgo[i]= String.valueOf(images[i]);
            str.append(imgo[i]).append(",");
        }

        ed.putString("data1",str.toString());
        ed.apply();
    }
}