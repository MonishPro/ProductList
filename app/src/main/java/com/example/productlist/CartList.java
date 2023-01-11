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

        int show=getIntent().getIntExtra("key5",1);

        if(show==1)
        {
            try{
                //SharedPreferences Array
                SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
                int length=sharedPreferences.getInt("data2",0);
                String pnam= sharedPreferences.getString("data3",null);
                String ppric= sharedPreferences.getString("data4",null);
                String pimg= sharedPreferences.getString("data5",null);

//        actual formed SharedPreferences array
                String [] pnames=pnam.split(",");
                String [] pprices=ppric.split(",");
                String [] pimag=pimg.split(",");

                int [] pimages=new int[pimag.length];
                for (int i = 0; i < pimag.length; i++) {
                    pimages[i]=Integer.parseInt(pimag[i]);
                }

                //Newly Initialised array
                String [] pname=new String[length];
                String [] pprice=new String[length];
                int [] pimage=new int[length];

                for (int i = 0; i < length-1; i++) {
                    pname[i]=pnames[i];
                    pprice[i]=pprices[i];
                    pimage[i]=pimages[i];
                }

                pname[length-1]=productname;
                pprice[length-1]=productprice;
                pimage[length-1]=productimage;

                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                Monishadapter monishadapter=new Monishadapter(pname,pprice,pimage, getApplicationContext());
                recyclerView.setAdapter(monishadapter);

                stringstorage(pname,pprice,pimage);
            }
            catch (Exception e)
            {
                SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
                int length=sharedPreferences.getInt("data2",0);

                String [] pname=new String[length];
                String [] pprice=new String[length];
                int [] pimage=new int[length];

                pname[length-1]=productname;
                pprice[length-1]=productprice;
                pimage[length-1]=productimage;

                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                Monishadapter monishadapter=new Monishadapter(pname,pprice,pimage, getApplicationContext());
                recyclerView.setAdapter(monishadapter);

                stringstorage(pname,pprice,pimage);
            }
        }
        else {
            SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
            int length=sharedPreferences.getInt("data2",0);
            String pnam= sharedPreferences.getString("data3",null);
            String ppric= sharedPreferences.getString("data4",null);
            String pimg= sharedPreferences.getString("data5",null);

            String [] pnames=pnam.split(",");
            String [] pprices=ppric.split(",");
            String [] pimag=pimg.split(",");

            String [] pname=new String[length];
            String [] pprice=new String[length];
            int [] pimage=new int[length];

            int [] pimages=new int[pimag.length];
            for (int i = 0; i < pimag.length; i++) {
                pimages[i]=Integer.parseInt(pimag[i]);
            }

            for (int i = 0; i < length; i++) {
                pname[i]=pnames[i];
                pprice[i]=pprices[i];
                pimage[i]=pimages[i];
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Monishadapter monishadapter=new Monishadapter(pname,pprice,pimage, getApplicationContext());
            recyclerView.setAdapter(monishadapter);
        }



        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),Screen2.class);
                i.putExtra("key1",productname);
                i.putExtra("key2",productprice);
                i.putExtra("key3",productimage);
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

    void stringstorage(String[] pname,String[] pprice,int [] pimage)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
        SharedPreferences.Editor ed=sharedPreferences.edit();

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();

        for (int i = 0; i < pname.length; i++) {
            str1.append(pname[i]).append(",");
            str2.append(pprice[i]).append(",");
            str3.append(pimage[i]).append(",");
        }

        ed.putString("data3",str1.toString());
        ed.putString("data4",str2.toString());
        ed.putString("data5",str3.toString());
        ed.apply();
    }

}