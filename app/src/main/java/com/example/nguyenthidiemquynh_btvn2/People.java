package com.example.nguyenthidiemquynh_btvn2;

import android.app.Application;

import java.util.ArrayList;

public class People extends Application {
    public static ArrayList<Phone> data;
//
    @Override
    public void onCreate() {
        super.onCreate();
        if(data == null){
            data = new ArrayList<>();
        }
    }
    public static ArrayList<Phone> initDataForPhone(){
        data.add(new Phone(1,R.drawable.moore,"Zachary"," Moore","(273)-352-7112","zachary.moore@example.com","1/1/1999"));
        data.add(new Phone(2,R.drawable.thunes,"Dominic","Thunes","(067)-453-1128","dominic.thunes@example.com","1/1/1999"));
        data.add(new Phone(3,R.drawable.renard,"Apolline"," Reneard","(027)--155-0657","apolline.renard@example.com","1/1/1999"));
        data.add(new Phone(4,R.drawable.pascual,"Maria"," Pascual","(027)--155-0657","maria.pascual@example.com","1/1/1999"));
        data.add(new Phone(5,R.drawable.valkema,"Djordy"," Valkema","(167)-351-1900","djordy.valkema@example.com","1/1/1999"));
        data.add(new Phone(6,R.drawable.jones,"Jenny",": Jones","(015)-242-8092","jenny.jones@example.com","1/1/1999"));
        data.add(new Phone(7,R.drawable.catalbas,"Ceylan"," Catalbas","(536)-393-6219","ceylan.catalbas@example.com","1/1/1999"));
        data.add(new Phone(8,R.drawable.henry,"Seraina"," Herry","(536)-393-6219","ceylan.catalbas@example.com","1/1/1999"));
        return data;
    }
}
