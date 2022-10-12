package com.example.nguyenthidiemquynh_btvn2;

public class Phone {
    int id;
    int ImgPeople;
    String name;
    String numberPhone;
    String mail;

    public Phone(int id, int imgPeople, String name, String numberPhone, String mail) {
        this.id = id;
        ImgPeople = imgPeople;
        this.name = name;
        this.numberPhone = numberPhone;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public int getImgPeople() {
        return ImgPeople;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgPeople(int imgPeople) {
        this.ImgPeople = imgPeople;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
