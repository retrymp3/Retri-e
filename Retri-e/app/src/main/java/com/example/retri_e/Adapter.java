package com.example.retri_e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

// Extends the Adapter class to RecyclerView.Adapter
// and implement the unimplemented methods
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList itemImg, itemName, price;
    Context context;


    public Adapter(Context context, ArrayList itemImg, ArrayList itemName, ArrayList price) {
        this.context = context;
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.price = price;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the Layout(Instantiates list_item.xml
        // layout file into View object)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        // Passing view to ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binding data to the into specified position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // TypeCast Object to int type
        //String[] price = {"603", "80", "70", "60", "50", "40", "30", "20", "50", "40"};
        //String[] wicket = {"2", "1", "0", "0", "1", "1", "0", "1", "1", "0"};
        int res = (int) itemImg.get(position);
        holder.images.setImageResource(res);
        holder.text1.setText((String) itemName.get(position));
        holder.text2.setText((String) price.get(position));

        holder.layoutclicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetails.class);
                Bundle bundle = new Bundle();
                for (int j = 0; j < 10; j++) {
                    if (position == j) {
                        bundle.putString("name", (String) itemName.get(j));
                        bundle.putString("price", (String) price.get(j));
                        bundle.putInt("image", (Integer) itemImg.get(j));
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Returns number of items
        // currently available in Adapter
        return itemImg.size();
    }

    // Initializing the Views
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView text1, text2;
        LinearLayout layoutclicker;

        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.itemImg);
            text1 = (TextView) view.findViewById(R.id.itemName);
            text2 = (TextView) view.findViewById(R.id.price);
            layoutclicker = (LinearLayout) view.findViewById(R.id.layoutclick);
        }
    }
}