package com.example.citasmedicas;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar;

    private EditText txtidLoguin;
    private EditText txtpassLoguin;
    private Button btnIngress;

    private Database_admin obj_db;

    private ModeloUser obj_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        btnRegistrar.setOnClickListener(view -> {
            Intent intent_registrar = new Intent(MainActivity.this, RegistraUser.class);
            startActivity(intent_registrar);
        });

     /*   btnIngress.setOnClickListener(view -> {
            Intent intent_registrar = new Intent(MainActivity.this, Acciones.class);
            startActivity(intent_registrar);
            txtidLoguin.setText("");
            txtpassLoguin.setText("");

        });
*/

         btnIngress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean confirm = obj_db.connectSQL();
                if (confirm) {
                    set_user();
                    boolean  confirm2 = obj_db.validateCredentials(obj_user.getId(), obj_user.getPassword());
                    if (confirm2) {
                        Intent intent_registrar = new Intent(MainActivity.this, Acciones.class);
                        startActivity(intent_registrar);
                        txtidLoguin.setText("");
                        txtpassLoguin.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Failed Login", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Failed Connection", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }




  public void initialize() {
      btnRegistrar =  findViewById(R.id.btnRegistrar);
      btnIngress =  findViewById(R.id.btnIngress);
      txtidLoguin =  findViewById(R.id.txtidLoguin);
      txtpassLoguin =  findViewById(R.id.txtpassLoguin);
      obj_db = new Database_admin();
      obj_user = new ModeloUser();


  }

    public void set_user(){
        obj_user.setId(Integer.parseInt(txtidLoguin.getText().toString()));
        obj_user.setPassword(txtpassLoguin.getText().toString());
    }
}

