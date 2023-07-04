package com.example.citasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Acciones extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones);

        Database_admin obj_db = new Database_admin();

        Button btnConsultUser = findViewById(R.id.btnConsultUser);
        Button btnProgramCita = findViewById(R.id.btnProgramCita);
        Button btnConsultCita = findViewById(R.id.btnConsultCita);


        btnConsultUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConsult();
            }

            public void openConsult(){
                boolean confirm = obj_db.connectSQL();
                if (confirm){
                    Intent inten_consult = new Intent(Acciones.this, InfoUser.class);
                    startActivity(inten_consult);
                }
                else {
                    Toast.makeText(Acciones.this, "Error connecting to SQL", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnProgramCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConsult();
            }

            public void openConsult(){
                boolean confirm = obj_db.connectSQL();
                if (confirm){
                    Intent inten_consult = new Intent(Acciones.this, AgendarCita.class);
                    startActivity(inten_consult);
                }
                else {
                    Toast.makeText(Acciones.this, "Error connecting to SQL", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnConsultCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConsult();
            }

            public void openConsult(){
                boolean confirm = obj_db.connectSQL();
                if (confirm){
                    Intent inten_consult = new Intent(Acciones.this, InfoCita.class);
                    startActivity(inten_consult);
                }
                else {
                    Toast.makeText(Acciones.this, "Error connecting to SQL", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}