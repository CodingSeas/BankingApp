package com.pankajsirotha.bankingapp.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phonenumber;
    private float balance;

    public Customer(String name, String email, String phonenumber, float balance){
        this.name = name;
        this.email =email;
        this.phonenumber = phonenumber;
        this.balance = balance;
    }
    public Customer(int id, String name, String email, String phonenumber, float balance){
        this.id =id;
        this.name = name;
        this.email =email;
        this.phonenumber = phonenumber;
        this.balance = balance;
    }
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}