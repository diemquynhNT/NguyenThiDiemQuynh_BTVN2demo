package com.example.nguyenthidiemquynh_btvn2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneVH> implements Filterable {
    ArrayList<Phone> phones;
    Context context;
    ArrayList<Phone> phonesFilter;
   Listener listener;

    public PhoneAdapter(ArrayList<Phone> phones,Listener listener) {
        this.phones = phones;
        this.listener= listener;
        this.phonesFilter=phones;
    }



    @NonNull
    @Override
    public PhoneVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_row,parent,false);
        return new PhoneVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneVH holder, int position) {
       // Phone phone =phones.get(position);
        Phone phone = phonesFilter.get(position);

        holder.txfname.setText(phone.getFname().concat(" "));
        holder.txdname.setText(phone.getLname().concat(" "));
        holder.txnumber.setText(phone.getNumberPhone());
        holder.txMail.setText(phone.getMail());

        if(phone.getImgPeople()==0)
        {
            holder.imgpeople.setImageResource(R.drawable.account);
        }else{
            holder.imgpeople.setImageResource(phone.getImgPeople());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listener.onItemListener(position,phone);
                listener.onItemListener(phone);
            }
        });

    }

    @Override
    public int getItemCount() {
        return phonesFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new PhoneFilter();
    }


    class PhoneVH extends RecyclerView.ViewHolder{
        CircleImageView imgpeople;
        TextView txfname,txdname,txnumber,txMail;
        public PhoneVH(@NonNull View itemView) {

            super(itemView);
            imgpeople = itemView.findViewById(R.id.imgpeople);
            txfname = itemView.findViewById(R.id.txfname);
            txdname = itemView.findViewById(R.id.txdname);
            txnumber = itemView.findViewById(R.id.txnumber);
            txMail = itemView.findViewById(R.id.txMail);


        }
  }

    interface Listener{
        void onItemListener(Phone phone);
    }
  //class loc
  class PhoneFilter extends Filter{

      @Override
      protected FilterResults performFiltering(CharSequence charSequence) {
          String charString = charSequence.toString();
          if (charString.isEmpty()) {
              phonesFilter = phones;
          } else {
              List<Phone> filteredList = new ArrayList<>();
              for (Phone row : phones) {
                  if (row.getLname().toLowerCase().contains(charString.toLowerCase()) ||
                          row.getNumberPhone().contains(charSequence) || row.getFname().contains(charSequence)) {
                      filteredList.add(row);
                  }
              }

              phonesFilter = (ArrayList<Phone>) filteredList;
          }

          FilterResults filterResults = new FilterResults();
          filterResults.values = phonesFilter;
          return filterResults;

      }

      @Override
      protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

          phonesFilter=(ArrayList<Phone>) filterResults.values;
          notifyDataSetChanged();
      }
  }
    public void addContact(Phone phones){
        phonesFilter.add(phones);
        notifyDataSetChanged();
    }
    public void editContact(Phone phones, int pos){
        phonesFilter.set(pos, phones);
        notifyDataSetChanged();
    }

    public void deleteContact(int pos){
        phonesFilter.remove(pos);
        notifyDataSetChanged();
    }

    public void deleteContact(Phone phones){
        phonesFilter.remove(phones);
        notifyDataSetChanged();
    }





}
