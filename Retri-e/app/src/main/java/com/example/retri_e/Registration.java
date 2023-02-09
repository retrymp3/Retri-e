package com.example.retri_e;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DBHandler mydb;
    EditText n,pass,email,no;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        button = (Button) findViewById(R.id.button1);
        n = (EditText) findViewById(R.id.edittext1);
        pass = (EditText) findViewById(R.id.edittext2);
        email = (EditText) findViewById(R.id.edittext4);
        no = (EditText) findViewById(R.id.edittext3);
        mydb = new DBHandler(this);
        addData();




    }
    private void addData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.insertData(n.getText().toString(), pass.getText().toString(), no.getText().toString(), email.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(Registration.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registration.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Registration.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}



