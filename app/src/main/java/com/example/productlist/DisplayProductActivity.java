package com.example.productlist;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productlist.aman.BuyProductActivity;
import com.example.productlist.aman.OrderListAdapter;

public class DisplayProductActivity extends AppCompatActivity {

    private static final String REQUEST_CODE_NAME = "DisplayProductActivity";
    private ImageView imageView;
    private TextView Name,Price,Description;
    private ImageButton Back;
    private Button btnBuyNow,Cart;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
         SharedPreferences sharedPreferences = getSharedPreferences("Database",MODE_PRIVATE);

        imageView=findViewById(R.id.imageView3);
        Name=findViewById(R.id.tv_product_name);
        Price=findViewById(R.id.textView11);
        Description=findViewById(R.id.textView13);
        Back=findViewById(R.id.imageButton2);
        btnBuyNow =findViewById(R.id.btn_buy_now);
        Cart=findViewById(R.id.button3);

        int postion=getIntent().getIntExtra("key",0);
        int productimage=getIntent().getIntExtra("key3",0);
        String productname=getIntent().getStringExtra("key1");
        String productprice=getIntent().getStringExtra("key2");
        int visibility=getIntent().getIntExtra("key4",1);

        Resources resources=getResources();

        int code= sharedPreferences.getInt("code",0);
        if(code==0)
        {
            String [] description= resources.getStringArray(R.array.home_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==1)
        {
            String [] description= resources.getStringArray(R.array.phone_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==2)
        {
            String [] description= resources.getStringArray(R.array.books_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==3)
        {
            String [] description= resources.getStringArray(R.array.laptops_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==4)
        {
            String [] description= resources.getStringArray(R.array.sports_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==5)
        {
            String [] description= resources.getStringArray(R.array.games_desc);
            resource(productname,productprice,productimage,description,postion);
        }
        else if(code==6)
        {
            String [] description= resources.getStringArray(R.array.clothes_desc);
            resource(productname,productprice,productimage,description,postion);
        }

        if(visibility==0)
        {
          Cart.setVisibility(View.INVISIBLE);
        }


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
                Intent intent = new Intent(DisplayProductActivity.this, BuyProductActivity.class);
                intent.putExtra(OrderListAdapter.REQUEST_CODE,REQUEST_CODE_NAME);
                intent.putExtra("key1",productname);
                intent.putExtra("key2",productprice);
                intent.putExtra("key3",productimage);
                startActivity(intent);
            }
        });

        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    void resource(String name,String price,int Image,String [] description,int position)
    {
        Name.setText(name);
        Price.setText(price);
        imageView.setImageResource(Image);
        Description.setText(description[position]);
    }

}