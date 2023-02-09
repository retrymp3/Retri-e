package com.example.retri_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Arrays;

public class Products extends AppCompatActivity {
    Button b1;

    RecyclerView recyclerView;
    //private String[] head={"Custom List View"}; //To set the heading using a listview.
    private ListView mListView;
    private ArrayAdapter aAdapter;

    // Using ArrayList to store images data
    ArrayList itemImg = new ArrayList<>(Arrays.asList(R.drawable.avatar2, R.drawable.avatar3,
            R.drawable.avatar4, R.drawable.avatar5,
            R.drawable.avatar6, R.drawable.avatar4,
            R.drawable.avatar2, R.drawable.berserk_tee, R.drawable.avatar5, R.drawable.avatar2));
    ArrayList itemName = new ArrayList<>(Arrays.asList("God Of War", "Sekiro", "Elden Ring", "Berserk", "Call of Duty", "Elden Ring", "Ragnarok", "Tshirt", "Berserk", "Kratos"));

    ArrayList price = new ArrayList<>(Arrays.asList("Price: $80", "Price: $40", "Price: $60", "Price: $70", "Price: $30", "Price: $50", "Price: $100", "Price: $40", "Price: $75", "Price: $1000" ));

    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        b1= findViewById(R.id.button);
        //Populating the list view using the textview(heading).
        // mListView = (ListView) findViewById(R.id.heading);
        //aAdapter = new ArrayAdapter<String>(this, R.layout.activity_textview, head);
        //mListView.setAdapter(aAdapter);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sending reference and data to Adapter
        Adapter adapter = new Adapter(Products.this, itemImg, itemName, price);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        int images[]={R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4};

        v_flipper=findViewById(R.id.v_flipper);
        for(int i=0;i< images.length; i++){
            flipperImages(images[i]);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Products.this, Orders.class);
                startActivity(intent);
            }
        });
    }
    public void flipperImages(int images){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(images);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

}