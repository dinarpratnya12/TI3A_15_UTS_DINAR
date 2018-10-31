package com.rzn.uts;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rzn.uts.Data.AppDatabase;
import com.rzn.uts.Model.Kota;
import com.rzn.uts.adapter.AdapterPerpusRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListKotaActivity extends AppCompatActivity {

    private AppDatabase db;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Kota> daftarKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kota);

        daftarKota = new ArrayList<>();

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"kotadb").allowMainThreadQueries().build();

        rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        daftarKota.addAll(Arrays.asList(db.kotaDao().selectAllKota()));

        adapter = new AdapterPerpusRecyclerView(daftarKota,this);
        rv.setAdapter(adapter);
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity,ListKotaActivity.class);
    }
}
