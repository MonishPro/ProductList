package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Monishadapter monishadapter;
    private ImageView button6,button0,button1,button2,button3,button4,button5,cart;
    private final Context context=MainActivity.this;
    private int code=0,show=0;
    public static final String SHARED_PREF_DB = "Database";
    private SharedPreferences sharedPreferences;

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
        cart=findViewById(R.id.imageButton12);


        sharedPreferences=getSharedPreferences(SHARED_PREF_DB,MODE_PRIVATE);
        int code= sharedPreferences.getInt("code",0);
        if(code==0)
        {
            String [] products=resources.getStringArray(R.array.product_name);
            String [] prices=resources.getStringArray(R.array.product_prices);
            int [] images={R.raw.home1,R.raw.home2,R.raw.home3,R.raw.home4,R.raw.home5,R.raw.home6,R.raw.home7,R.raw.home8,R.raw.home9,R.raw.home10,R.raw.home11,R.raw.home12,R.raw.home13,R.raw.home14,R.raw.home15,R.raw.home16,R.raw.home17,R.raw.home18,R.raw.home19,R.raw.home20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==1)
        {
            String [] products=resources.getStringArray(R.array.phones);
            String [] prices=resources.getStringArray(R.array.phone_prices);
            int [] images= {R.drawable.phone1,R.drawable.phone20,R.drawable.phone2,R.drawable.phone3,R.drawable.phone4,R.drawable.phone5,R.drawable.phone6,R.drawable.phone7,R.drawable.phone8,R.drawable.phone9,R.drawable.phone10,R.drawable.phone11,R.drawable.phone12,R.drawable.phone13,R.drawable.phone14,R.drawable.phone15,R.drawable.phone16,R.drawable.phone17,R.drawable.phone18,R.drawable.phone19};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==2)
        {
            String [] products=resources.getStringArray(R.array.books);
            String [] prices=resources.getStringArray(R.array.booksprice);
            int[] images={R.raw.book1,R.raw.book2,R.raw.book3,R.raw.book4,R.raw.book5,R.raw.book6,R.raw.book7,R.raw.book8,R.raw.book9,R.raw.book10,R.raw.book11,R.raw.book12,R.raw.book13,R.raw.book14,R.raw.book15,R.raw.book16,R.raw.book17,R.raw.book18,R.raw.book19,R.raw.book20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==3)
        {
            String [] products=resources.getStringArray(R.array.laptops);
            String [] prices=resources.getStringArray(R.array.laptop_prices);
            int [] images={R.raw.laptop1,R.raw.laptop2,R.raw.laptop3,R.raw.laptop4,R.raw.laptop5,R.raw.laptop6,R.raw.laptop7,R.raw.laptop8,R.raw.laptop9,R.raw.laptop10,R.raw.laptop11,R.raw.laptop12,R.raw.laptop13,R.raw.laptop14,R.raw.laptop15,R.raw.laptop16,R.raw.laptop17,R.raw.laptop18,R.raw.laptop19,R.raw.laptop20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==4)
        {
            String [] products=resources.getStringArray(R.array.sports);
            String [] prices=resources.getStringArray(R.array.sports_prices);
            int [] images= {R.raw.sports1,R.raw.sports2,R.raw.sports3,R.raw.sports4,R.raw.sports5,R.raw.sports6,R.raw.sports7,R.raw.sports8,R.raw.sports9,R.raw.sports10,R.raw.sports11,R.raw.sports12,R.raw.sports13,R.raw.sports14,R.raw.sports15,R.raw.sports16,R.raw.sports17,R.raw.sports18,R.raw.sports19,R.raw.sports20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==6)
        {
            String [] products=resources.getStringArray(R.array.clothes);
            String [] prices=resources.getStringArray(R.array.clothes_prices);
            int [] images={R.raw.clothes1,R.raw.clothes2,R.raw.clothes3,R.raw.clothes4,R.raw.clothes5,R.raw.clothes6,R.raw.clothes7,R.raw.clothes8,R.raw.clothes9,R.raw.clothes10,R.raw.clothes11,R.raw.clothes12,R.raw.clothes13,R.raw.clothes14,R.raw.clothes15,R.raw.clothes16,R.raw.clothes17,R.raw.clothes18,R.raw.clothes19,R.raw.clothes20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        else if(code==5)
        {
            String [] products=resources.getStringArray(R.array.games);
            String [] prices=resources.getStringArray(R.array.game_prices);
            int[] images={R.raw.tv1,R.raw.tv2,R.raw.tv3,R.raw.tv4,R.raw.tv5,R.raw.tv6,R.raw.tv7,R.raw.tv9,R.raw.tv9,R.raw.tv10,R.raw.tv11,R.raw.tv12,R.raw.tv13,R.raw.tv14,R.raw.tv15,R.raw.tv16,R.raw.tv17,R.raw.tv18,R.raw.tv19,R.raw.tv20};

            imageshare(images);

            recyclerView=findViewById(R.id.recycler);

            monishadapter=new Monishadapter(products,prices,images,this);

            recyclerView.setAdapter(monishadapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonarea();
        }
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
                    int length=sharedPreferences.getInt("data2",0);
                    if(length!=0)
                    {
                        Intent i=new Intent(context,CartList.class);
                        i.putExtra("key5",show);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Not Items Currently present in the Cart !! Keep Shopping :)", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ignored){
                }

            }
        });
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

    void buttonarea()
    {
        Resources resources=getResources();
        SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
        SharedPreferences.Editor ed=sharedPreferences.edit();
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code=0;
                String [] products=resources.getStringArray(R.array.product_name);
                String [] prices=resources.getStringArray(R.array.product_prices);
                int [] images={R.raw.home1,R.raw.home2,R.raw.home3,R.raw.home4,R.raw.home5,R.raw.home6,R.raw.home7,R.raw.home8,R.raw.home9,R.raw.home10,R.raw.home11,R.raw.home12,R.raw.home13,R.raw.home14,R.raw.home15,R.raw.home16,R.raw.home17,R.raw.home18,R.raw.home19,R.raw.home20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code=1;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.phones);
                String [] prices=resources.getStringArray(R.array.phone_prices);
                int [] images= {R.drawable.phone1,R.drawable.phone20,R.drawable.phone2,R.drawable.phone3,R.drawable.phone4,R.drawable.phone5,R.drawable.phone6,R.drawable.phone7,R.drawable.phone8,R.drawable.phone9,R.drawable.phone10,R.drawable.phone11,R.drawable.phone12,R.drawable.phone13,R.drawable.phone14,R.drawable.phone15,R.drawable.phone16,R.drawable.phone17,R.drawable.phone18,R.drawable.phone19};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));


                SharedPreferences sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putInt("code",code);
                editor.apply();

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code=2;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.books);
                String [] prices=resources.getStringArray(R.array.booksprice);
                int[] images={R.raw.book1,R.raw.book2,R.raw.book3,R.raw.book4,R.raw.book5,R.raw.book6,R.raw.book7,R.raw.book8,R.raw.book9,R.raw.book10,R.raw.book11,R.raw.book12,R.raw.book13,R.raw.book14,R.raw.book15,R.raw.book16,R.raw.book17,R.raw.book18,R.raw.book19,R.raw.book20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code=3;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.laptops);
                String [] prices=resources.getStringArray(R.array.laptop_prices);
                int [] images={R.raw.laptop1,R.raw.laptop2,R.raw.laptop3,R.raw.laptop4,R.raw.laptop5,R.raw.laptop6,R.raw.laptop7,R.raw.laptop8,R.raw.laptop9,R.raw.laptop10,R.raw.laptop11,R.raw.laptop12,R.raw.laptop13,R.raw.laptop14,R.raw.laptop15,R.raw.laptop16,R.raw.laptop17,R.raw.laptop18,R.raw.laptop19,R.raw.laptop20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code=4;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.sports);
                String [] prices=resources.getStringArray(R.array.sports_prices);
                int [] images= {R.raw.sports1,R.raw.sports2,R.raw.sports3,R.raw.sports4,R.raw.sports5,R.raw.sports6,R.raw.sports7,R.raw.sports8,R.raw.sports9,R.raw.sports10,R.raw.sports11,R.raw.sports12,R.raw.sports13,R.raw.sports14,R.raw.sports15,R.raw.sports16,R.raw.sports17,R.raw.sports18,R.raw.sports19,R.raw.sports20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code=5;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.games);
                String [] prices=resources.getStringArray(R.array.game_prices);
                int[] images={R.raw.tv1,R.raw.tv2,R.raw.tv3,R.raw.tv4,R.raw.tv5,R.raw.tv6,R.raw.tv7,R.raw.tv9,R.raw.tv9,R.raw.tv10,R.raw.tv11,R.raw.tv12,R.raw.tv13,R.raw.tv14,R.raw.tv15,R.raw.tv16,R.raw.tv17,R.raw.tv18,R.raw.tv19,R.raw.tv20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code=6;
                Resources resources=getResources();
                String [] products=resources.getStringArray(R.array.clothes);
                String [] prices=resources.getStringArray(R.array.clothes_prices);
                int [] images={R.raw.clothes1,R.raw.clothes2,R.raw.clothes3,R.raw.clothes4,R.raw.clothes5,R.raw.clothes6,R.raw.clothes7,R.raw.clothes8,R.raw.clothes9,R.raw.clothes10,R.raw.clothes11,R.raw.clothes12,R.raw.clothes13,R.raw.clothes14,R.raw.clothes15,R.raw.clothes16,R.raw.clothes17,R.raw.clothes18,R.raw.clothes19,R.raw.clothes20};

                monishadapter=new Monishadapter(products,prices,images,context);

                recyclerView.setAdapter(monishadapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

                ed.putInt("code",code);
                ed.apply();
            }
        });
    }
}