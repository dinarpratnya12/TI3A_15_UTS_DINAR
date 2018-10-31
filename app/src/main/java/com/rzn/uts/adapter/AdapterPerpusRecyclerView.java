package com.rzn.uts.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rzn.uts.R;
import com.rzn.uts.InputActivity;
import com.rzn.uts.Data.AppDatabase;
import com.rzn.uts.Model.Kota;

import java.util.ArrayList;

public class AdapterPerpusRecyclerView extends RecyclerView.Adapter<AdapterPerpusRecyclerView.ViewHolder>{

    private ArrayList<Kota> daftarKota;
    private Context context;
    private AppDatabase db;

    public AdapterPerpusRecyclerView(ArrayList<Kota> kotas, Context ctx) {
        this.daftarKota = kotas;
        this.context = ctx;
        db = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"kotadb").allowMainThreadQueries().build();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kota, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {

        final int id = daftarKota.get(position).getIdKota();
        final String name = daftarKota.get(position).getNamaKota();
        holder.txtList.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftarKota.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtList;

        public ViewHolder(View v) {
            super(v);
            txtList = v.findViewById(R.id.txtListKota);
        }
    }
}
