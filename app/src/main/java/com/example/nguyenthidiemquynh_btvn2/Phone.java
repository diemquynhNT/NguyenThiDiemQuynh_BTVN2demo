package com.example.nguyenthidiemquynh_btvn2;

import java.io.Serializable;
import java.util.List;

public class Phone implements Serializable, Comparable<Phone> {
    int id;
    int ImgPeople;
    String fname;
    String lname;
    String numberPhone;
    String mail;
    String birthday;

    public Phone(int id, int imgPeople, String fname, String lname, String numberPhone, String mail, String birthday) {
        this.id = id;
        ImgPeople = imgPeople;
        this.fname = fname;
        this.lname = lname;
        this.numberPhone = numberPhone;
        this.mail = mail;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public int getImgPeople() {
        return ImgPeople;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getMail() {
        return mail;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgPeople(int imgPeople) {
        ImgPeople = imgPeople;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //sort
    @Override
    public int compareTo(Phone phones) {
        if(fname.compareToIgnoreCase(phones.fname)==0)
        {
            return lname.compareToIgnoreCase(phones.lname);
        }

        return fname.compareToIgnoreCase(phones.fname);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                ", ImgPeople=" + ImgPeople +
                ", numberPhone='" + numberPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
