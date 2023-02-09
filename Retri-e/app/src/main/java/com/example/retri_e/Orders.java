package com.example.retri_e;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class Orders extends AppCompatActivity {
    ImageView image;
    TextView name, price;
    ListView listview;
    SQLiteDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Cursor resultSet = mydb.rawQuery("select * from orders", null);
        int img = 0;
        while (resultSet.moveToFirst()) {
            String name = resultSet.getString(0);
            String price = resultSet.getString(1);
            img = resultSet.getInt(3);
        }
        ArrayList itemName = new ArrayList<>(Arrays.asList(name, price, img));


    }
}
