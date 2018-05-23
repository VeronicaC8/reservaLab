package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class ProfesorEliminarActivity extends Activity {
    EditText editIdProfesor;
    ControlBDReservacionLab controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_eliminar);
        controlhelper=new ControlBDReservacionLab (this);
        editIdProfesor=(EditText)findViewById(R.id.editIdProfesor);
    }
    public void eliminarProfesor(View v){
        String regEliminadas;
        Profesor profesor =new Profesor();
        profesor.setIdProfesor(editIdProfesor.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(profesor);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
