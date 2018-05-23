package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CicloEliminarActivity extends Activity {


    EditText editIdCiclo;
    ControlBDReservacionLab controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_eliminar);
        controlhelper = new ControlBDReservacionLab(this);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);

    }

    public void eliminar(View v) {
        String regEliminadas;
        Ciclo ciclo = new Ciclo();
        ciclo.setIdCiclo(Integer.valueOf(editIdCiclo.getText().toString()));

        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(ciclo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }

}