package com.example.productlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.productlist.aman.BuyProductActivity;
import com.example.productlist.aman.OrderListAdapter;
import com.example.productlist.aman.OrderListModelClass;
import com.google.common.reflect.TypeToken;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CartList extends AppCompatActivity implements CartListInterface {
    public RecyclerView recyclerViewCartList, recyclerViewOrderList;
    private ImageView Back,Home;
    CartAdapter cartAdapter;
    OrderListAdapter orderListAdapter;
    ArrayList<OrderListModelClass> orderListDataHolder;
    private SharedPreferences sharedPreferences;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        sharedPreferences=getSharedPreferences("Database",MODE_PRIVATE);

        Back = findViewById(R.id.imageButton9);
        Home=findViewById(R.id.imageView);
        recyclerViewCartList = findViewById(R.id.recyclerview_cart_list);
        recyclerViewOrderList = findViewById(R.id.recyclerview_order_list);

        int productimage = getIntent().getIntExtra("key3", 0);
        String productname = getIntent().getStringExtra("key1");
        String productprice = getIntent().getStringExtra("key2");
        int show = getIntent().getIntExtra("key5", 1);

        onAddDataInOrderList();
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent i = new Intent(getApplicationContext(), DisplayProductActivity.class);
                        i.putExtra("key1", productname);
                        i.putExtra("key2", productprice);
                        i.putExtra("key3", productimage);
                        startActivity(i);
                finish();

            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        if (show == 1) {
            try {
                //SharedPreferences Array
                SharedPreferences sharedPreferences = getSharedPreferences("Database", MODE_PRIVATE);
                int length = sharedPreferences.getInt("data2", 0);
                String pnam = sharedPreferences.getString("data3", null);
                String ppric = sharedPreferences.getString("data4", null);
                String pimg = sharedPreferences.getString("data5", null);

//        actual formed SharedPreferences array
                String[] pnames = pnam.split(",");
                String[] pprices = ppric.split(",");
                String[] pimag = pimg.split(",");

                int[] pimages = new int[pimag.length];
                for (int i = 0; i < pimag.length; i++) {
                    pimages[i] = Integer.parseInt(pimag[i]);
                }

                //Newly Initialised array
                String[] pname = new String[length];
                String[] pprice = new String[length];
                int[] pimage = new int[length];

                for (int i = 0; i < length - 1; i++) {
                    pname[i] = pnames[i];
                    pprice[i] = pprices[i];
                    pimage[i] = pimages[i];
                }

                pname[length - 1] = productname;
                pprice[length - 1] = productprice;
                pimage[length - 1] = productimage;

                cartAdapter = new CartAdapter(pname, pprice, pimage, getApplicationContext(), this);
                recyclerViewCartList.setAdapter(cartAdapter);

                stringstorage(pname, pprice, pimage);

            } catch (Exception e) {
                SharedPreferences sharedPreferences = getSharedPreferences("Database", MODE_PRIVATE);
                int length = sharedPreferences.getInt("data2", 0);

                String[] pname = new String[length];
                String[] pprice = new String[length];
                int[] pimage = new int[length];

                pname[length - 1] = productname;
                pprice[length - 1] = productprice;
                pimage[length - 1] = productimage;

                cartAdapter = new CartAdapter(pname, pprice, pimage, getApplicationContext(), this);
                recyclerViewCartList.setAdapter(cartAdapter);

                stringstorage(pname, pprice, pimage);
            }
        } else {
            Back.setVisibility(View.INVISIBLE);
            SharedPreferences sharedPreferences = getSharedPreferences("Database", MODE_PRIVATE);
            int length = sharedPreferences.getInt("data2", 0);
            String pnam = sharedPreferences.getString("data3", null);
            String ppric = sharedPreferences.getString("data4", null);
            String pimg = sharedPreferences.getString("data5", null);

            String[] pnames = pnam.split(",");
            String[] pprices = ppric.split(",");
            String[] pimag = pimg.split(",");

            String[] pname = new String[length];
            String[] pprice = new String[length];
            int[] pimage = new int[length];

            int[] pimages = new int[pimag.length];
            for (int i = 0; i < pimag.length; i++) {
                pimages[i] = Integer.parseInt(pimag[i]);
            }

            for (int i = 0; i < length; i++) {
                pname[i] = pnames[i];
                pprice[i] = pprices[i];
                pimage[i] = pimages[i];
            }


            cartAdapter = new CartAdapter(pname, pprice, pimage, getApplicationContext(), this);
            recyclerViewCartList.setAdapter(cartAdapter);
        }
    }

    void stringstorage(String[] pname, String[] pprice, int[] pimage) {
        SharedPreferences sharedPreferences = getSharedPreferences("Database", MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();

        for (int i = 0; i < pname.length; i++) {
            str1.append(pname[i]).append(",");
            str2.append(pprice[i]).append(",");
            str3.append(pimage[i]).append(",");
        }

        ed.putString("data3", str1.toString());
        ed.putString("data4", str2.toString());
        ed.putString("data5", str3.toString());
        ed.apply();
    }

    @Override
    public void onItemClick(int position) {

        SharedPreferences sharedPreferences = getSharedPreferences("Database", Context.MODE_PRIVATE);
        int length = sharedPreferences.getInt("data2", 0);
        String pnam = sharedPreferences.getString("data3", null);
        String ppric = sharedPreferences.getString("data4", null);
        String pimg = sharedPreferences.getString("data5", null);

        String[] pnames = pnam.split(",");
        String[] pprices = ppric.split(",");
        String[] pimag = pimg.split(",");

        int[] pimages = new int[pimag.length];
        for (int i = 0; i < pimag.length; i++) {
            pimages[i] = Integer.parseInt(pimag[i]);
        }

        for (int i = position; i < pnames.length; i++) {
            if (i <= pnames.length - 2) {
                pnames[i] = pnames[i + 1];
                pprices[i] = pprices[i + 1];
                pimages[i] = pimages[i + 1];
            } else {
                break;
            }
        }

        length = length - 1;

        String[] pname = new String[length];
        String[] pprice = new String[length];
        int[] pimage = new int[length];

        for (int i = 0; i < length; i++) {
            pname[i] = pnames[i];
            pprice[i] = pprices[i];
            pimage[i] = pimages[i];
        }

        SharedPreferences.Editor ed = sharedPreferences.edit();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();

        for (int i = 0; i < pname.length; i++) {
            str1.append(pname[i]).append(",");
            str2.append(pprice[i]).append(",");
            str3.append(pimage[i]).append(",");
        }

        ed.putInt("data2", length);
        ed.putString("data3", str1.toString());
        ed.putString("data4", str2.toString());
        ed.putString("data5", str3.toString());
        ed.apply();

        recyclerViewCartList = findViewById(R.id.recyclerview_cart_list);
        recyclerViewCartList.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(pname, pprice, pimage, getApplicationContext(), this);
        recyclerViewCartList.setAdapter(cartAdapter);

    }

    public void onAddDataInOrderList() {
        Gson gson = new Gson();
        String orderList =  sharedPreferences.getString(BuyProductActivity.ORDER_LIST, null);
        Type type = new TypeToken<List<OrderListModelClass>>(){}.getType();
        orderListDataHolder = gson.fromJson(orderList, type);
        System.out.println(orderListDataHolder);

        orderListAdapter = new OrderListAdapter(CartList.this,orderListDataHolder);
        recyclerViewOrderList.setAdapter(orderListAdapter);
    }
}