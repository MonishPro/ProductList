package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private Monishadapter monishadapter;
private ImageButton button0,button1,button2,button3,button4,button5,button6;
private final Context context=MainActivity.this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        button0=findViewById(R.id.imageButton11);
        button1=findViewById(R.id.imageButton3);
        button2=findViewById(R.id.imageButton4);
        button3=findViewById(R.id.imageButton5);
        button4=findViewById(R.id.imageButton6);
        button5=findViewById(R.id.imageButton7);
        button6=findViewById(R.id.imageButton8);

        String [] products=resources.getStringArray(R.array.product_name);
        String [] prices=resources.getStringArray(R.array.product_prices);
        int [] images= {R.drawable.earphones,R.drawable.speakers,R.drawable.smartphone,R.drawable.lamp,R.drawable.vase};

        imageshare(images);

        recyclerView=findViewById(R.id.recycler);

        monishadapter=new Monishadapter(products,prices,images,this);

        recyclerView.setAdapter(monishadapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonarea(products,prices,images);

    }

    void imageshare(int [] images)
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

    void buttonarea(String [] products,String [] prices, int [] images)
    {

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello 0", Toast.LENGTH_SHORT).show();

                monishadapter=new Monishadapter(products,prices,images, (MainActivity) context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.phones);
                String [] prices=resources.getStringArray(R.array.phone_prices);
                int [] images= {R.drawable.phone1,R.drawable.phone20,R.drawable.phone2,R.drawable.phone3,R.drawable.phone4,R.drawable.phone5,R.drawable.phone6,R.drawable.phone7,R.drawable.phone8,R.drawable.phone9,R.drawable.phone10,R.drawable.phone11,R.drawable.phone12,R.drawable.phone13,R.drawable.phone14,R.drawable.phone15,R.drawable.phone16,R.drawable.phone17,R.drawable.phone18,R.drawable.phone19};

                monishadapter=new Monishadapter(products,prices,images, (MainActivity) context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.books);
                String [] prices=resources.getStringArray(R.array.booksprice);
                int[] images={R.raw.book1,R.raw.book2,R.raw.book3,R.raw.book4,R.raw.book5,R.raw.book6,R.raw.book7,R.raw.book8,R.raw.book9,R.raw.book10,R.raw.book11,R.raw.book12,R.raw.book13,R.raw.book14,R.raw.book15,R.raw.book16,R.raw.book17,R.raw.book18,R.raw.book19,R.raw.book20};

                monishadapter=new Monishadapter(products,prices,images, (MainActivity) context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello 3", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello 4", Toast.LENGTH_SHORT).show();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello 5", Toast.LENGTH_SHORT).show();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello 6", Toast.LENGTH_SHORT).show();
            }
        });
    }
}