package com.example.nguyenthidiemquynh_btvn2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PhoneAdapter.Listener {
    RecyclerView rvPhone;
    ArrayList<Phone> peoplephone;
    PhoneAdapter phoneAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPhone = findViewById(R.id.rvPhone);
        peoplephone=People.initDataForPhone();

        phoneAdapter = new PhoneAdapter(peoplephone,MainActivity.this);
        rvPhone.setAdapter(phoneAdapter);

        rvPhone.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvPhone.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));



        }
    public void onItemListener(Phone p){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Contact");
        builder.setIcon(getDrawable(p.getImgPeople()));
        builder.setMessage(p.getName()+"\n"+p.getNumberPhone());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}