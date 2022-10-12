package com.example.nguyenthidiemquynh_btvn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneVH> {
    ArrayList<Phone> peoplephone;
   Listener listener;


    public PhoneAdapter(ArrayList<Phone> peoplephone,Listener listener) {
        this.peoplephone = peoplephone;
        this.listener= listener;
    }



    @NonNull
    @Override
    public PhoneVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_row,parent,false);
        return new PhoneVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneVH holder, int position) {
        Phone phone =peoplephone.get(position);
        holder.imgpeople.setImageResource(phone.getImgPeople());
        holder.txName.setText(phone.getName());
        holder.txnumber.setText(phone.getNumberPhone());
        holder.txMail.setText(phone.getMail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemListener(phone);
            }
        });

    }

    @Override
    public int getItemCount() {
        return peoplephone.size();
    }

    class PhoneVH extends RecyclerView.ViewHolder{
        CircleImageView imgpeople;
        TextView txName,txnumber,txMail;
        public PhoneVH(@NonNull View itemView) {

            super(itemView);
            imgpeople = itemView.findViewById(R.id.imgpeople);
            txName = itemView.findViewById(R.id.txname);
            txnumber = itemView.findViewById(R.id.txnumber);
            txMail = itemView.findViewById(R.id.txMail);


        }
  }
    interface Listener{
        void onItemListener(Phone phone);
    }


}
