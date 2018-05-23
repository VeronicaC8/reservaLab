package com.example.oscar.reservalab;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ReservacionConsultarActivity extends Activity {


    ControlBDReservacionLab helper;
    EditText idReservacion;
    EditText codLab;
    EditText idDia;
    EditText idHora;
    EditText idProf;

    ArrayList<String> lLab;//CAMBIAR A CLASE LABORATORIO


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion_consultar);
        helper = new ControlBDReservacionLab(this);

        idReservacion = (EditText) findViewById(R.id.idReservacion);
        codLab= (EditText) findViewById(R.id.codLab);
        idDia= (EditText) findViewById(R.id.idDia);
        idHora = (EditText) findViewById(R.id.idHora);
        idProf = (EditText) findViewById(R.id. idProf);


    }


    public void consultarReserva(View v) {

        helper.abrir();
        Reservacion reserva = helper.consultarReservacion(idReservacion.getText().toString());
        helper.cerrar();
        if(reserva == null)
            Toast.makeText(this, "Reservacion con Id: " + idReservacion.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            codLab.setText(reserva.getCodLaboratorio().toString());
            idDia.setText(reserva.getIdDia().toString());
            idHora.setText(reserva.getIdHora().toString());
            idProf.setText(reserva.getIdProfesor().toString());
        }
    }

}
