package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class asignacionAsignaturaEliminarActivity extends Activity {

    EditText editCodAsigancion;
    ControlBDReservacionLab controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_asignatura_eliminar);
        controlhelper = new ControlBDReservacionLab(this);
        editCodAsigancion = (EditText) findViewById(R.id.editCodAsigancion);

    }

    public void eliminar(View v) {
        String regEliminadas;
        asignacionAsignatura asignacion = new asignacionAsignatura();
        asignacion.setIdAsignacionAsignatura(Integer.valueOf(editCodAsigancion.getText().toString()));

        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(asignacion);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }

}
