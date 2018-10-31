package com.rzn.uts.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.rzn.uts.Model.Kota;

@Database(entities = {Kota.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract KotaDao kotaDao();

}