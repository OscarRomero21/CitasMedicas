package com.example.citasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cita);

        Database_admin obj_db = new Database_admin();

        ListView listRecords = (ListView) findViewById(R.id.listInfoCita);
        Button btnInfoCita = (Button) findViewById(R.id.btnInfoCita);

        btnInfoCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj_db.connectSQL();
                ArrayList<String> data = obj_db.consultCitas();
                ArrayAdapter adapter = new ArrayAdapter<String>(InfoCita.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                        data);
                listRecords.setAdapter(adapter);
            }
        });
    }
}