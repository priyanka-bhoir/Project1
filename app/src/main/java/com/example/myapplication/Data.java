package com.example.myapplication;

public class Data {
    String Id;
    String Fname;
    String Lname;
    String Mobile;
    String Web;
    String Email;
    String Password;

    public String getId() {
        return Id;
    }



    public Data(String fname, String lname, String mobile, String web, String email,String password) {
        Fname = fname;
        Lname = lname;
        Mobile = mobile;
        Web = web;
        Email = email;
        Password=password;
    }
    public Data(String fname, String lname, String mobile, String web, String email,String password,String id) {
        Id=id;
        Fname = fname;
        Lname = lname;
        Mobile = mobile;
        Web = web;
        Email = email;
        Password=password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
