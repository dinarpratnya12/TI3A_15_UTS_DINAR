package com.rzn.uts;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rzn.uts.Data.AppDatabase;
import com.rzn.uts.Model.Kota;

public class InputActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"kotadb").build();

        final EditText edtKota = findViewById(R.id.EditKota);
        final Button btnInput = findViewById(R.id.btnInput);
        final Button btnCek = findViewById(R.id.btnCek);

        final Kota kota = (Kota) getIntent().getSerializableExtra("data");

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kota k = new Kota();
                k.setNamaKota(edtKota.getText().toString());

                insertKota(k);
            }
        });

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ListKotaActivity.getActIntent(InputActivity.this));
            }
        });
    }

    private void insertKota(final Kota kota) {
        new AsyncTask<Void, Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.kotaDao().insertKota(kota);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(InputActivity.this,"Insert Sukses",Toast.LENGTH_SHORT).show();
            }
        }.execute();
        finish();
    }

}
