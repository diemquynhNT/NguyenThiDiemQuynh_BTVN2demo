package com.example.nguyenthidiemquynh_btvn2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PhoneAdapter.Listener {
    RecyclerView rvPhone;
    ArrayList<Phone> peoplephone;
    PhoneAdapter phoneAdapter;
    ///ArrayList<Phone> people;
    Phone phones;
    SearchView searchView;
    FloatingActionButton floatingActionButton;

    int pos;

    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            Phone phones = (Phone) result.getData().getSerializableExtra("contact");
                            phoneAdapter.addContact(phones);
                        } else {
                            Phone phones = (Phone) result.getData().getSerializableExtra("contact");
                            phoneAdapter.editContact(phones, pos);
                        }
                    }
                }
            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPhone = findViewById(R.id.rvPhone);
        peoplephone = People.initDataForPhone();

        phoneAdapter = new PhoneAdapter(peoplephone, MainActivity.this);
        rvPhone.setAdapter(phoneAdapter);

        rvPhone.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvPhone.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));


        floatingActionButton = findViewById(R.id.btnadd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this, addedit_Activity.class);
                intent.putExtra("contact", phones);
                intent.putExtra("flag", 1);
                mLauncher.launch(intent);
            }
        });

    }

    public void onItemListener(Phone p) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Contact");
//        builder.setIcon(getDrawable(p.getImgPeople()));
//        builder.setMessage(p.getFname()+p.getLname()+"\n"+p.getNumberPhone());
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();

        InfoDialogBottomSheet dialog = new InfoDialogBottomSheet(MainActivity.this, p, mLauncher, phoneAdapter);
        dialog.findView();
        dialog.show();

    }

    //


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnsort){
            Collections.sort(peoplephone);
            phoneAdapter.notifyDataSetChanged();
        }
        if(item.getItemId() == R.id.nvsearch){
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mnmain, menu);

        SearchView searchView  = (SearchView) menu.findItem(R.id.nvsearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                phoneAdapter.getFilter().filter(query);
                return false;
            }
//
            @Override
            public boolean onQueryTextChange(String newText) {
                phoneAdapter.getFilter().filter(newText);

//                if(newText.isEmpty()){
//                    fabAddContact.setVisibility(View.VISIBLE);
//                }else {
//                    fabAddContact.setVisibility(View.INVISIBLE);
//                }
                return false;
            }
        });

        return true;


    }
}


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.mnmain, menu);
//
//        SearchView searchView  = (SearchView) menu.findItem(R.id.nvsearch).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                phoneAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                phoneAdapter.getFilter().filter(newText);
//
////                if(newText.isEmpty()){
////                    fabAddContact.setVisibility(View.VISIBLE);
////                }else {
////                    fabAddContact.setVisibility(View.INVISIBLE);
////                }
//                return false;
//            }
//        });
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.mnsort){
////            Collections.sort(contacts);
////            phoneAdapter.notifyDataSetChanged();
//        }
//        if(item.getItemId() == R.id.nvsearch){
//            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//




