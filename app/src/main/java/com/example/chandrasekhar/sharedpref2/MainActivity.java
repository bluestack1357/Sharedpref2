package com.example.chandrasekhar.sharedpref2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displaytext;
    EditText useredittext;
    EditText paswordedit;
    Button addbutton;
    Button displaybutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displaytext=(TextView)findViewById(R.id.displaytext);
        useredittext=(EditText)findViewById(R.id.useredittext);
        paswordedit=(EditText)findViewById(R.id.paswordedit);
        addbutton=(Button)findViewById(R.id.addbutton);
        displaybutton=(Button)findViewById(R.id.displaybutton);


    }
    public void addonclick(View view){
        SharedPreferences sharedPref=getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",useredittext.getText().toString());
        editor.putString("pasword",paswordedit.getText().toString());

        editor.apply();
        useredittext.setText("");
        paswordedit.setText("");

        Toast.makeText(this,"Hey u added successfully",Toast.LENGTH_LONG).show();
    }

    public void displayonclick(View view){
        SharedPreferences sharedPref=getSharedPreferences("userInfo",MODE_PRIVATE);
        String name=sharedPref.getString("username","");
        String paswordd=sharedPref.getString("pasword","");

        displaytext.setText("username :"+name +" \n"+"    "+"pasword :"+ paswordd);

        Toast.makeText(this,"Hey u got ur info cool",Toast.LENGTH_LONG).show();

    }
}
