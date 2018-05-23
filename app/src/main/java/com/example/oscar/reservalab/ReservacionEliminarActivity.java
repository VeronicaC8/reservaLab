package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ReservacionEliminarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idReservacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion_eliminar);
        helper = new  ControlBDReservacionLab(this);

        idReservacion = (EditText) findViewById(R.id.idReservacion);

    }

    public void eliminarR(View v){
        String regEliminadas;
        Reservacion reservacion = new Reservacion();
        reservacion.setIdReservacion(idReservacion.getText().toString());
        helper.abrir();
        regEliminadas=  helper.eliminar(reservacion);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();


    }
}
