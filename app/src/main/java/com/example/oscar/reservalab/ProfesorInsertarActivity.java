package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfesorInsertarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdProfesor;
    EditText editNombreProfesor;
    EditText editIdUsuario;
    EditText editIdAsignacionCarga;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_insertar);
        helper = new ControlBDReservacionLab(this);
        editIdProfesor = (EditText) findViewById(R.id.editIdProfesor);
        editNombreProfesor = (EditText) findViewById(R.id.editNombreProfesor);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);

    }
    public void insertarProfesor(View v) {
        String idProfesor=editIdProfesor.getText().toString();
        String nombreProfesor=editNombreProfesor.getText().toString();
        Integer idUsuario=Integer.valueOf(editIdUsuario.getText().toString());
        Integer idAsignacionCarga=Integer.valueOf(editIdAsignacionCarga.getText().toString());
        String regInsertados;
        Profesor profesor=new Profesor();
        profesor.setIdProfesor(idProfesor);
        profesor.setNombreProfesor(nombreProfesor);
        profesor.setIdUsuario(idUsuario);
        profesor.setIdAsignacionCarga(idAsignacionCarga);
        helper.abrir();
        regInsertados=helper.insertar(profesor);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdProfesor.setText("");
        editNombreProfesor.setText("");
        editIdUsuario.setText("");
        editIdAsignacionCarga.setText("");
    }
}