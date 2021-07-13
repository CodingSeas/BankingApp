package com.pankajsirotha.bankingapp.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pankajsirotha.bankingapp.Parameter.parameter;
import com.pankajsirotha.bankingapp.model.Customer;

import java.util.ArrayList;
import java.util.List;


public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, parameter.DB_NAME, null, parameter.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + parameter.TABLE_NAME + "("
                + parameter.KEY_ID + " INTEGER PRIMARY KEY,"
                + parameter.KEY_NAME + " TEXT,"
                + parameter.KEY_EMAIL + " TEXT,"
                + parameter.KEY_PHONE + " TEXT,"
                + parameter.KEY_BALANCE + " REAL" + ")";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(parameter.KEY_NAME, customer.getName());
        values.put(parameter.KEY_EMAIL, customer.getEmail());
        values.put(parameter.KEY_PHONE, customer.getPhonenumber());
        values.put(parameter.KEY_BALANCE, customer.getBalance());

        db.insert(parameter.TABLE_NAME, null, values);
        Log.d("dbBANK", "Successfully inserted:");
        db.close();

    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + parameter.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(cursor.getString(0)));
                customer.setName(cursor.getString(1));
                customer.setEmail(cursor.getString(2));
                customer.setPhonenumber(cursor.getString(3));
                customer.setBalance(cursor.getFloat(4));
                customerList.add(customer);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return customerList;
    }

    public List<Customer> getCustomer(long id) {
        List<Customer> customerdetailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + parameter.TABLE_NAME+" WHERE "+parameter.KEY_ID+"= '"+id+"'";
        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToFirst();

        Customer customer = new Customer();
        customer.setId(Integer.parseInt(cursor.getString(0)));
        customer.setName(cursor.getString(1));
        customer.setEmail(cursor.getString(2));
        customer.setPhonenumber(cursor.getString(3));
        customer.setBalance(cursor.getFloat(4));
        customerdetailList.add(customer);

        db.close();
        cursor.close();
        return customerdetailList;
    }

    public List<Customer> getCustomername(String name) {
        List<Customer> customerdetailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + parameter.TABLE_NAME+" WHERE "+parameter.KEY_NAME+"= '"+name+"'";
        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToFirst();

        Customer customer = new Customer();
        customer.setId(Integer.parseInt(cursor.getString(0)));
        customer.setName(cursor.getString(1));
        customer.setEmail(cursor.getString(2));
        customer.setPhonenumber(cursor.getString(3));
        customer.setBalance(cursor.getFloat(4));
        customerdetailList.add(customer);

        db.close();
        cursor.close();
        return customerdetailList;
    }

    public void updatecustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(parameter.KEY_ID,customer.getId());
        contentValues.put(parameter.KEY_NAME,customer.getName());
        contentValues.put(parameter.KEY_EMAIL, customer.getEmail());
        contentValues.put(parameter.KEY_PHONE, customer.getPhonenumber());
        contentValues.put(parameter.KEY_BALANCE,customer.getBalance());


        db.update(parameter.TABLE_NAME, contentValues, parameter.KEY_ID + "=?", new String[]{String.valueOf(customer.getId())});
        db.close();
    }
}


