package com.pankajsirotha.bankingapp.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.pankajsirotha.bankingapp.Customertransfer;
import com.pankajsirotha.bankingapp.Data.MyDbHandler;
import com.pankajsirotha.bankingapp.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_akash extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akash);

        MyDbHandler db = new MyDbHandler(Activity_akash.this);

        listView = findViewById(R.id.listView);

        ArrayList<String> customers = new ArrayList<>();
        List<Customer> AllCustomers = db.getCustomer(1);
        for (Customer customer : AllCustomers ) {
            customers.add("Name: "+customer.getName());
            customers.add("Email: "+customer.getEmail());
            customers.add("PhoneNumber: "+customer.getPhonenumber());
            customers.add("Balance: "+customer.getBalance());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,customers);
        listView.setAdapter(arrayAdapter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivityvac();

            }
        });
        db.close();
    }
    public void openactivityvac(){
        Intent intent = new Intent(this, Customertransfer.class);
        startActivity(intent);
    }

    }
