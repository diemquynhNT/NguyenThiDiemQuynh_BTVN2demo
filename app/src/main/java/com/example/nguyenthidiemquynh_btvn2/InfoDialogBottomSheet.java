package com.example.nguyenthidiemquynh_btvn2;

import android.app.AlertDialog;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class InfoDialogBottomSheet extends BottomSheetDialog {
    TextView txFullName, txPhone, txEmail,txBirthday;
    ImageView imImage;
    ImageButton btnClose, btnEdit, btnDelete;
    ActivityResultLauncher mLauncher;
    Phone phones;
    PhoneAdapter phoneAdapter;

//
    public InfoDialogBottomSheet(@NonNull Context context, Phone phones, ActivityResultLauncher mLauncher,PhoneAdapter phoneAdapter) {
        super(context);
        this.phones = phones;
        this.mLauncher= mLauncher;
        this.phoneAdapter=phoneAdapter;
    }

    public void findView(){
        View view = getLayoutInflater().inflate(R.layout.activity_info,null);


        txFullName = view.findViewById(R.id.fullName);
        txPhone=view.findViewById(R.id.txPhone);
        txEmail=view.findViewById(R.id.txEmail);
        txBirthday=view.findViewById(R.id.txBirthday);
        imImage = view.findViewById(R.id.userImage);

        //cancel
        btnClose=view.findViewById(R.id.cancelBtn);
        btnClose.setOnClickListener( v -> {
            this.dismiss();
        });

        //edit
        btnEdit=view.findViewById(R.id.editBtn);
        btnEdit.setOnClickListener(v->{
            Intent intent = new Intent(getContext(), addedit_Activity.class);
            intent.putExtra("contact", phones);
            intent.putExtra("flag", 2 );
            mLauncher.launch(intent);
            dismiss();

        });

        btnDelete=view.findViewById(R.id.deleteBtn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("Contacts");
                builder.setMessage("Delete ".concat(phones.getFname()+phones.getLname()).concat(" ?"));
                builder.setNegativeButton("No", (dialogInterface, i) -> {
                    dialogInterface.cancel();


        });
                builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                    phoneAdapter.deleteContact(phones);
                    dialogInterface.dismiss();
                    dismiss();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        txFullName.setText(phones.getFname()+phones.getLname());
        txEmail.setText(phones.getMail());
        txPhone.setText(phones.getNumberPhone());
        txBirthday.setText(phones.getBirthday());
        //txBirthday.setText(person.getBirthday());
        imImage.setImageResource(phones.getImgPeople());



        setContentView(view);
    }
}
