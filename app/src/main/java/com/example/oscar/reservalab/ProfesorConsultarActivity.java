package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfesorConsultarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdProfesor;
    EditText editNombreProfesor;
    EditText editIdUsuario;
    EditText editIdAsignacionCarga;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_consultar);
        helper = new ControlBDReservacionLab(this);
        editIdProfesor = (EditText) findViewById(R.id.editIdProfesor);
        editNombreProfesor = (EditText) findViewById(R.id.editNombreProfesor);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);
    }
    public void consultar(View v) {
        helper.abrir();
        Profesor profesor = helper.consultarProfesor(editIdProfesor.getText().toString());
        helper.cerrar();
        if(profesor == null)
            Toast.makeText(this, "Profesor con id " +
                    editIdProfesor.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombreProfesor.setText(profesor.getNombreProfesor());
            editIdUsuario.setText(String.valueOf(profesor.getIdUsuario()));
            editIdAsignacionCarga.setText(String.valueOf(profesor.getIdAsignacionCarga()));
        }
    }
    public void limpiarTexto(View v){
        editIdProfesor.setText("");
        editNombreProfesor.setText("");
        editIdUsuario.setText("");
        editIdAsignacionCarga.setText("");
    }
}