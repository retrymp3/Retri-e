package com.example.retri_e;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends Activity  {
    Button login,cancel;
    EditText username,password;
    DBHandler mydb;

    TextView attempts_left;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.button);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

        cancel = findViewById(R.id.button2);
        attempts_left = findViewById(R.id.textView4);
        attempts_left.setVisibility(View.GONE);
        mydb = new DBHandler(Login.this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "Fill in credentials.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result =mydb.checknamePassword(user,pass);
                    if(result==true){
                        Toast.makeText(Login.this, "Log in successfull.", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,Products.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();

                        attempts_left.setVisibility(View.VISIBLE);
                        attempts_left.setBackgroundColor(Color.RED);
                        counter--;
                        attempts_left.setText(Integer.toString(counter));

                        if (counter == 0) {
                            login.setEnabled(false);
                        }
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    }


