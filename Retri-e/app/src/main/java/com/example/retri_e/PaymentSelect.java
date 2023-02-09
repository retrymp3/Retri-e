package com.example.retri_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentSelect extends AppCompatActivity {
    Button confirm;
    RadioButton rdbtn1,rdbtn2,rdbtn3,rdbtn4;
    DBHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_select);
        confirm=(Button) findViewById(R.id.button6);
        rdbtn1=(RadioButton) findViewById(R.id.radioButton);
        rdbtn2=(RadioButton) findViewById(R.id.radioButton2);
        rdbtn3=(RadioButton) findViewById(R.id.radioButton3);
        rdbtn4=(RadioButton) findViewById(R.id.radioButton4);
        Bundle bundle=getIntent().getExtras();
        String Name=bundle.getString("name");
        String P=bundle.getString("price");
        String Price=P.replace("Price: ","");
        int img=bundle.getInt("image");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googlePayUrl = "https://pay.google.com";
                String phonepeUrl="https://www.phonepe.com/";
                String paytmUrl="https://paytm.com/";

                if(rdbtn1.isChecked()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googlePayUrl));
                    startActivity(intent);
                    mydb.insertItems(Name, Price, img);
                }
                else if(rdbtn2.isChecked()){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(phonepeUrl));
                    startActivity(intent);
                    mydb.insertItems(Name, Price, img);
                }
                else if(rdbtn3.isChecked()){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(paytmUrl));
                    startActivity(intent);
                    mydb.insertItems(Name, Price, img);
                }
                else if(rdbtn4.isChecked()){
                    Intent intent = new Intent(view.getContext(), ThankYou.class);
                    startActivity(intent);
                    mydb.insertItems(Name, Price, img);
                }
            }
        });
    }
}