package com.example.citasmedicas;

import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;
import java.sql.SQLException;

public class Database_admin {
   private Connection connect;
   private String url = "jdbc:mysql://35.238.165.59:3306/citasMedicas";
   private String user = "ooromeropi";
   private String passw = "Jero210821$";

   public boolean connectSQL() {
      try {
         StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                 .detectAll()
                 .penaltyLog()
                 .build();
         StrictMode.setThreadPolicy(policy);
         connect = DriverManager.getConnection(url, user, passw);
         Log.i("MyTag", "Successful Connection");
         return true;
      } catch (Exception err) {
         Log.i("MyTag", err.toString());
         return true;
      }

   }

   public boolean insert_record(int id, String nombres, String numContacto, String email, String direccion, String password) {
      try {
         String instruction = "INSERT INTO users VALUES (" + id + ",'" + nombres + "','" + numContacto + "','" + email + "','" + direccion + "','" + password + "')";
         connect.prepareStatement(instruction).execute();
         return true;
      } catch (Exception err) {
         Log.i("MyTag", err.toString());
         return false;
      }
   }


   public boolean insert_record_cita (String Especialidad, String Sede, String Fecha, String Cedula) {
      try {
         String instruction = "INSERT INTO citasProgramadas (Especialidad,Sede,Fecha,Cedula) VALUES ('" + Especialidad + "','" + Sede + "','" + Fecha + "','" + Cedula + "')";
         connect.prepareStatement(instruction).execute();
         return true;
      } catch (Exception err) {
         Log.i("MyTag", err.toString() );

         return false;
      }
   }

   public boolean validateCredentials(int id, String password) {
      ResultSet  resultado = null;
      Statement declaracion = null;
      try {
              String query = "SELECT * FROM users WHERE id = " + id + " AND password = '" + password + "'";
              declaracion = connect.createStatement();
              resultado = declaracion.executeQuery(query);
              //Log.i("MyTag", con);
         boolean hayresultados = resultado.next();
         if (hayresultados) {
            return true;
         } else {
            return false;
         }



      } catch (Exception err) {
         Log.i("MyTag", err.toString());
         return false;
      }
   }

   public ArrayList<String> consultUser () {
      String instructionSQL = "SELECT * FROM users";
      ArrayList <String> datos = new ArrayList <String>();
      try {
         ResultSet results = connect.prepareStatement(instructionSQL).executeQuery();
         while (results.next()) {
            datos.add(results.getString("id") + " " + results.getString("nombres") + " "
                    + results.getString("numContacto") + " " + results.getString("email")+ " " + results.getString("direccion"));
         }
      } catch (Exception err) {
         Log.d("myTag", err.toString());
      }
      return datos;
}

   public ArrayList<String> consultCitas () {
      String instructionSQL = "SELECT * FROM citasProgramadas";
      ArrayList <String> datos = new ArrayList <String>();
      try {
         ResultSet results = connect.prepareStatement(instructionSQL).executeQuery();
         while (results.next()) {
            datos.add(results.getString("Especialidad") + " " + results.getString("Sede") + " "
                    + results.getString("Fecha") + " " + results.getString("Cedula"));
         }
      } catch (Exception err) {
         Log.d("myTag", err.toString());
      }
      return datos;
   }


}