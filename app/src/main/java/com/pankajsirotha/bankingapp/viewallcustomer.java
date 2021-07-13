package com.pankajsirotha.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pankajsirotha.bankingapp.Data.MyDbHandler;
import com.pankajsirotha.bankingapp.model.Activity_Amrit;
import com.pankajsirotha.bankingapp.model.Activity_Sahil;
import com.pankajsirotha.bankingapp.model.Activity_Shubhendra;
import com.pankajsirotha.bankingapp.model.Activity_abhimanyu;
import com.pankajsirotha.bankingapp.model.Activity_akash;
import com.pankajsirotha.bankingapp.model.Activity_deepak;
import com.pankajsirotha.bankingapp.model.Activity_karan;
import com.pankajsirotha.bankingapp.model.Activity_manoj;
import com.pankajsirotha.bankingapp.model.Activity_raj;
import com.pankajsirotha.bankingapp.model.Activity_sagar;
import com.pankajsirotha.bankingapp.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class viewallcustomer extends AppCompatActivity {
    ListView listView;
    public static String nameofCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewallcustomer);

        MyDbHandler db =new MyDbHandler(viewallcustomer.this);
        if (db.getAllCustomers().isEmpty()) {
            //First customer
            Customer akash = new Customer();
            akash.setName("Akash");
            akash.setEmail("akashchoudhary56@gmail.com");
            akash.setPhonenumber("9051203133");
            akash.setBalance(90020.45f);

            db.addCustomer(akash);

            //Second customer
            Customer amrit = new Customer();
            amrit.setName("Amrit");
            amrit.setEmail("amritsharma@gmail.com");
            amrit.setPhonenumber("9863245267");
            amrit.setBalance(9220200.6f);

            db.addCustomer(amrit);

            //Third customer
            Customer  raj = new Customer();
            raj.setName("Raj");
            raj.setEmail("kumarraj@gmail.com");
            raj.setPhonenumber("9867825565");
            raj.setBalance(48650.80f);

            db.addCustomer(raj);

            //Fourth customer
            Customer Abhimanyu = new Customer();
            Abhimanyu.setName("Abhimanyu");
            Abhimanyu.setEmail("pandavmanu@gmail.com");
            Abhimanyu.setPhonenumber("9871165132");
            Abhimanyu.setBalance(850000);

            db.addCustomer(Abhimanyu);

            //Fifth customer
            Customer Manoj = new Customer();
            Manoj.setName("Manoj");
            Manoj.setEmail("manojrajput56@gmail.com");
            Manoj.setPhonenumber("7562318984");
            Manoj.setBalance(98560.30f);

            db.addCustomer(Manoj);

            //Sixth customer
            Customer Deepak = new Customer();
            Deepak.setName("Deepak");
            Deepak.setEmail("bhistdeepak34@gmail.com");
            Deepak.setPhonenumber("8354789651");
            Deepak.setBalance(16025779.0f);

            db.addCustomer(Deepak);

            //Seventh customer
            Customer Karan = new Customer();
            Karan.setName("Karan");
            Karan.setEmail("karansamayal@gmail.com");
            Karan.setPhonenumber("8759325631");
            Karan.setBalance(8025621.0f);


            db.addCustomer(Karan);

            //Eigth customer
            Customer Sagar = new Customer();
            Sagar.setName("Sagar");
            Sagar.setEmail("sagaarvadav1990@gmail.com");
            Sagar.setPhonenumber("7368521598");
            Sagar.setBalance(304578912.5f);


            db.addCustomer(Sagar);

            //Nineth customer
            Customer Sahil = new Customer();
            Sahil.setName("Sahil");
            Sahil.setEmail("sahiltomar@gmail.com");
            Sahil.setPhonenumber("9245265942");
            Sahil.setBalance(725025689.7f);


            db.addCustomer(Sahil);

            //Tenth customer
            Customer Shubhendra = new Customer();
            Shubhendra.setName("Shubhendra");
            Shubhendra.setEmail("Shubhendrakumarl@gmail.com");
            Shubhendra.setPhonenumber("9364587210");
            Shubhendra.setBalance(802867863.9f);


            db.addCustomer(Shubhendra);
        }


        ArrayList<String> customers = new ArrayList<>();
        listView = findViewById(R.id.listView);

        List<Customer> AllCustomers = db.getAllCustomers();
        for (Customer customer:AllCustomers) {
            customers.add(customer.getName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,customers);
        listView.setAdapter(arrayAdapter);
        db.close();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    nameofCustomer = "Akash";
                    Intent intent = new Intent(view.getContext(), Activity_akash.class);
                    startActivity(intent);

                }
                if (position == 1){
                    nameofCustomer ="Amrit";
                    Intent intent = new Intent(view.getContext(), Activity_Amrit.class);
                    startActivity(intent);

                }
                if (position == 2){
                    nameofCustomer ="Raj";
                    Intent intent = new Intent(view.getContext(), Activity_raj.class);
                    startActivity(intent);

                }
                if (position == 3){
                    nameofCustomer ="Abhimanyu";
                    Intent intent = new Intent(view.getContext(), Activity_abhimanyu.class);
                    startActivity(intent);

                }
                if (position == 4){
                    nameofCustomer ="Manoj";
                    Intent intent = new Intent(view.getContext(), Activity_manoj.class);
                    startActivity(intent);

                }
                if (position == 5) {
                    nameofCustomer = "Deepak";
                    Intent intent = new Intent(view.getContext(), Activity_deepak.class);
                    startActivity(intent);
                }
                if (position == 6){
                    nameofCustomer ="Karan";
                    Intent intent = new Intent(view.getContext(), Activity_karan.class);
                    startActivity(intent);

                }
                if (position == 7){
                    nameofCustomer ="Sagar";
                    Intent intent = new Intent(view.getContext(), Activity_sagar.class);
                    startActivity(intent);

                }
                if (position == 8){
                    nameofCustomer ="Sahil";
                    Intent intent = new Intent(view.getContext(), Activity_Sahil.class);
                    startActivity(intent);

                }
                if (position == 9){
                    nameofCustomer ="Shubhendra";
                    Intent intent = new Intent(view.getContext(), Activity_Shubhendra.class);
                    startActivity(intent);

                }

            }
        });

    }
    public static String detail(){
        return nameofCustomer;
    }

}