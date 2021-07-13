package com.pankajsirotha.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pankajsirotha.bankingapp.Data.MyDbHandler;
import com.pankajsirotha.bankingapp.model.Customer;


import java.util.ArrayList;
import java.util.List;

public class Customertransfer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public EditText mEditText;
    public String Customertotransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customertransfer);

        MyDbHandler db = new MyDbHandler(Customertransfer.this);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayList<String> customers = new ArrayList<>();
        List<Customer> AllCustomers = db.getAllCustomers();
        for (Customer customer : AllCustomers) {
            customers.add(customer.getName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, customers);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        db.close();


        Button button = findViewById(R.id.button2);
            button.setOnClickListener(v -> openactivityvac());
    }
    public void openactivityvac(){
        Intent intent = new Intent(this, viewallcustomer.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Customertotransfer = parent.getItemAtPosition(position).toString();
        Toast.makeText(this,"Selected "+ Customertotransfer,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void onClick(View v) {
        MyDbHandler db = new MyDbHandler(Customertransfer.this);
        mEditText =findViewById(R.id.editTextNumberDecimal);

        String Customernamecheck = viewallcustomer.detail();
        Log.d("CustomerCheck",Customernamecheck);
        Log.d("text", Customertotransfer);


        if (Customertotransfer.equals(Customernamecheck)) {
            Toast.makeText(Customertransfer.this, "Can't Transfer to Same person.", Toast.LENGTH_LONG).show();
        }
        else {
            float transfermoney = Float.parseFloat(mEditText.getText().toString());

            List<Customer> list = db.getCustomername(Customernamecheck);
            List<Customer> listoftextname = db.getCustomername(Customertotransfer);

            ArrayList<String> customersdata = new ArrayList<>();
            for (Customer customer : list ) {
                customersdata.add(String.valueOf(customer.getId()));
                customersdata.add(customer.getName());
                customersdata.add(customer.getEmail());
                customersdata.add(customer.getPhonenumber());
                customersdata.add(""+customer.getBalance());
            }

            ArrayList<String> customersdata1 = new ArrayList<>();
            for (Customer customer : listoftextname ) {
                customersdata1.add(String.valueOf(customer.getId()));
                customersdata1.add(customer.getName());
                customersdata1.add(customer.getEmail());
                customersdata1.add(customer.getPhonenumber());
                customersdata1.add(""+customer.getBalance());
            }

            if (Customertotransfer.equals("Akash")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Amrit")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);


                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Raj")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }

            }
            if (Customertotransfer.equals("Abhimanyu")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Manoj")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Deepak")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);


                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Karan")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Sagar")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);


                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Sahil")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);


                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }
            }
            if (Customertotransfer.equals("Shubhendra")) {
                int id_customer1 = Integer.parseInt(customersdata.get(0));
                String name_customer1 = customersdata.get(1);
                String email_customer1 = customersdata.get(2);
                String phone_customer1= customersdata.get(3);
                float new_balance1 = (Float.parseFloat(customersdata.get(4))- transfermoney);

                int id_customer2 = Integer.parseInt(customersdata1.get(0));
                String name_customer2 = customersdata1.get(1);
                String email_customer2 = customersdata1.get(2);
                String phone_customer2 = customersdata1.get(3);
                float new_balance2 = (Float.parseFloat(customersdata1.get(4)) + transfermoney);

                if (new_balance1 > 0) {
                    Toast.makeText(Customertransfer.this, "Tranfered Amount (" + transfermoney + ")", Toast.LENGTH_LONG).show();
                    Customer customer1 = new Customer();
                    customer1.setId(id_customer1);
                    customer1.setName(name_customer1);
                    customer1.setEmail(email_customer1);
                    customer1.setPhonenumber(phone_customer1);
                    customer1.setBalance(new_balance1);
                    db.updatecustomer(customer1);

                    Customer customer2 = new Customer();
                    customer2.setId(id_customer2);
                    customer2.setName(name_customer2);
                    customer2.setEmail(email_customer2);
                    customer2.setPhonenumber(phone_customer2);
                    customer2.setBalance(new_balance2);
                    db.updatecustomer(customer2);

                    Log.d("this",""+customer1+customer2);
                    db.close();
                }
                else {
                    Toast.makeText(this, "Insufficient Balance in Bank.", Toast.LENGTH_SHORT).show();
                }

            }
            else{
                Toast.makeText(this,"Thank You for Using Our Service.",Toast.LENGTH_SHORT).show();
            }
        }
        db.close();

    }
}

