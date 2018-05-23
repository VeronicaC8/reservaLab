package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignaturaEliminarActivity extends Activity {

    EditText editCod;
    ControlBDReservacionLab controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_eliminar);
        controlhelper = new ControlBDReservacionLab(this);
        editCod = (EditText) findViewById(R.id.editCod);

    }

    public void eliminar(View v) {
        String regEliminadas;
        Asignatura asignatura = new Asignatura();
        asignatura.setCodigoAsignatura(editCod.getText().toString());

        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(asignatura);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }

}
