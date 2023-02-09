package com.example.retri_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    TextView name, price, totalPrice, itemInCart;
    ImageView image;
    SeekBar seekBar;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        name=(TextView) findViewById(R.id.Name);
        price=(TextView) findViewById(R.id.Price);
        image=(ImageView) findViewById(R.id.imageView2);
        totalPrice=(TextView) findViewById(R.id.TotalPrice);
        itemInCart=(TextView) findViewById(R.id.textView8);
        seekBar=(SeekBar) findViewById(R.id.seekBar) ;
        buy=(Button) findViewById(R.id.button5);
        Bundle bundle=getIntent().getExtras();
        String Name=bundle.getString("name");
        String P=bundle.getString("price");
        String Price=P.replace("Price: ","");
        int img=bundle.getInt("image");
        //String img1=img.replace("R.drawable.","");

        //String Wicket=bundle.getString("wicket");
        name.setText(Name);
        price.setText(Price);
        totalPrice.setText(Price);
        image.setImageResource(img);
        //wicket.setText(Wicket);
        int Pri=Integer.parseInt( P.replace("Price: $",""));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                itemInCart.setText(Integer.toString(i));
                totalPrice.setText("$"+Integer.toString(i*Pri));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetails.this, PaymentSelect.class);
                bundle.putString("name", Name);
                bundle.putString("price", Price);
                bundle.putInt("image", img);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}