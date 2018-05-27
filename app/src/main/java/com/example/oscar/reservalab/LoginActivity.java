package com.example.oscar.reservalab;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ControlBDReservacionLab helper;
    ControlBDReservacionLab BDhelper;
    EditText et1,et2,et3;
    private Cursor fila;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new ControlBDReservacionLab(this);
        et1=findViewById(R.id.etusu);
        et2=findViewById(R.id.etcon);
        BDhelper=new ControlBDReservacionLab(this);

    }
    public void llenarBase(){
        BDhelper=new ControlBDReservacionLab(this);
        BDhelper.abrir();
        BDhelper.llenarBDReservacionLab();
        BDhelper.cerrar();
    }
    public void ingresar(View v){
        helper.abrir();
        Usuario usuario =helper.consultarLog(et1.getText().toString(),et2.getText().toString());
        helper.cerrar();
        if(usuario == null)
            Toast.makeText(this, "Usuario  " + et1.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            if(usuario.getIdaccesoUsuario() ==0) {
                Intent ven = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Usuario  " + et1.getText().toString() + " Administrador", Toast.LENGTH_LONG).show();

                startActivity(ven);
            }else {
                Intent ven = new Intent(this, Main2Activity.class);
                startActivity(ven);
                Toast.makeText(this, "Usuario  " + et1.getText().toString() + " profesor", Toast.LENGTH_LONG).show();
            }
        }
    }
}
