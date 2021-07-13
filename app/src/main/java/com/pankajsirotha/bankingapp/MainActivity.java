package com.pankajsirotha.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(v -> openactivityvac());
    }
    public void openactivityvac(){
        Intent intent = new Intent(this, viewallcustomer.class);
        startActivity(intent);

    }


}