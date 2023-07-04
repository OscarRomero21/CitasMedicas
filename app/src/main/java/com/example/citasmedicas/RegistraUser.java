package com.example.citasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistraUser extends AppCompatActivity {

    private EditText txtName;
    private EditText intCedula;
    private EditText txtCelular;
    private EditText txtEmail;
    private EditText txtLugar;

    private EditText txtPassw;
    private Button btnRegister;

    private Database_admin obj_db;

    private ModeloUser obj_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_user);
        initialize();

        btnRegister.setOnClickListener(view -> {

            boolean confirm = obj_db.connectSQL();
            if (confirm) {
                set_user();
                boolean confirm2 = obj_db.insert_record(obj_user.getId(),obj_user.getNombres(),obj_user.getNumContacto(),obj_user.getEmail(),obj_user.getDireccion(),obj_user.getPassword());
                if (confirm2) {
                    Toast.makeText(RegistraUser.this, "User Connection", Toast.LENGTH_LONG).show();
                    txtName.setText("");
                    intCedula.setText("");
                    txtCelular.setText("");
                    txtEmail.setText("");
                    txtLugar.setText("");
                    txtPassw.setText("");
                }
                else {
                    Toast.makeText(RegistraUser.this, "Failed Register", Toast.LENGTH_LONG).show();
                }

            }
            else {
               Toast.makeText(RegistraUser.this, "Failed Connection", Toast.LENGTH_LONG).show();
            }


        });
    }
    private void initialize() {
        txtName =  findViewById(R.id.txtName);
        intCedula =  findViewById(R.id.intCedula);
        txtCelular =  findViewById(R.id.txtCelular);
        txtEmail =  findViewById(R.id.txtEmail);
        txtLugar =  findViewById(R.id.txtLugar);
        txtPassw =  findViewById(R.id.txtPassw);
        btnRegister =  findViewById(R.id.btnRegister);
        obj_db = new Database_admin();
        obj_user = new ModeloUser();
    }

    private void set_user(){
        obj_user.setNombres(txtName.getText().toString());
        obj_user.setId(Integer.parseInt(intCedula.getText().toString()));
        obj_user.setNumContacto(txtCelular.getText().toString());
        obj_user.setEmail(txtEmail.getText().toString());
        obj_user.setDireccion(txtLugar.getText().toString());
        obj_user.setPassword(txtPassw.getText().toString());
    }
}
