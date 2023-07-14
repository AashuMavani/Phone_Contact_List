package com.example.phone_contact_list.Model;

public class Contact {
    private  int id;
    private String name;
    private String surname;
    private String number;
    private String imgpath;



    public Contact(int id, String name, String surname, String number, String imgpath) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.imgpath=imgpath;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }






}
