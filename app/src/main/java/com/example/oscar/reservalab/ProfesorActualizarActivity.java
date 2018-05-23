package com.example.oscar.reservalab;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.file.ProviderNotFoundException;

public class ProfesorActualizarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdProfesor;
    EditText editNombreProfesor;
    EditText editIdUsuario;
    EditText editIdAsignacionCarga;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_actualizar);
        helper = new ControlBDReservacionLab(this);
        editIdProfesor = (EditText) findViewById(R.id.editIdProfesor);
        editNombreProfesor = (EditText) findViewById(R.id.editNombreProfesor);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);

    }
    public void actualizarProfesor(View v) {
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(editIdProfesor.getText().toString());
        profesor.setNombreProfesor(editNombreProfesor.getText().toString());
        profesor.setIdUsuario(Integer.valueOf(editIdUsuario.getText().toString()));
        profesor.setIdAsignacionCarga(Integer.valueOf(editIdAsignacionCarga.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(profesor);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdProfesor.setText("");
        editNombreProfesor.setText("");
        editIdUsuario.setText("");
        editIdAsignacionCarga.setText("");
    }
}