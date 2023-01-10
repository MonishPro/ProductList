package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CartList extends AppCompatActivity {
private RecyclerView recyclerView;
private ImageButton Back,Home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        Back=findViewById(R.id.imageButton9);
        Home=findViewById(R.id.imageButton10);
        recyclerView=findViewById(R.id.recyclerView);

        int productimage=getIntent().getIntExtra("key3",0);
        String productname=getIntent().getStringExtra("key1");
        String productprice=getIntent().getStringExtra("key2");

        SharedPreferences sharedPreferences=getSharedPreferences("atabase",MODE_PRIVATE);
        int length=sharedPreferences.getInt("data2",0);
        Toast.makeText(this, length+"", Toast.LENGTH_SHORT).show();

        String [] pname=new String[length];
        String [] pprice=new String[length];
        int [] pimage=new int[length];

        for (int i = length-1; i <= length; i++) {
            pname[i]=productname;
            pprice[i]=productprice;
            pimage[i]=productimage;

            break;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Monishadapter monishadapter=new Monishadapter(pname,pprice,pimage, getApplicationContext());
        recyclerView.setAdapter(monishadapter);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Screen2.class);
                startActivity(i);
                finish();
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}