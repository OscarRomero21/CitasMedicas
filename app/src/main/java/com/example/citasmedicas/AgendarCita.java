package com.example.citasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgendarCita extends AppCompatActivity {

    private EditText txtEspecialidad;
    private EditText txtSede;
    private EditText txtFecha;

    private EditText txtCedula;
    private Button btnRegistraCita;
    private Database_admin obj_db;
    private ModeloCitas obj_citas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);
        initialize();

        btnRegistraCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean confirm = obj_db.connectSQL();
                if (confirm) {
                    set_user();
                    boolean confirm2 = obj_db.insert_record_cita(obj_citas.getEspecialidad(),obj_citas.getSede(),obj_citas.getFecha(), obj_citas.getCedula());
                    if (confirm2) {
                        Toast.makeText(AgendarCita.this, "User Connection", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(AgendarCita.this, "Failed Register", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(AgendarCita.this, "Failed Connection", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void initialize() {
        txtEspecialidad =  findViewById(R.id.txtEspecialidad);
        txtSede =  findViewById(R.id.txtSede);
        txtFecha =  findViewById(R.id.txtFecha);
        txtCedula =  findViewById(R.id.txtCedula);
        btnRegistraCita =  findViewById(R.id.btnRegistraCita);
        obj_db = new Database_admin();
        obj_citas = new ModeloCitas();
    }

    private void set_user(){
        obj_citas.setEspecialidad(txtEspecialidad.getText().toString());
        obj_citas.setFecha(txtSede.getText().toString());
        obj_citas.setSede(txtFecha.getText().toString());
        obj_citas.setCedula(txtCedula.getText().toString());

    }
}