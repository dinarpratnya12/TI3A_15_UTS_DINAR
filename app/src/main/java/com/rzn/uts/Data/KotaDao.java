package com.rzn.uts.Data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rzn.uts.Model.Kota;
 @Dao
public interface KotaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertKota(Kota kota);

     @Query("SELECT * FROM tblKota")
     Kota[] selectAllKota();
}
