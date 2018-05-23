package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoCargaInsertarActivity extends Activity {


    ControlBDReservacionLab helper;
    EditText idTCarga;
    EditText editNombre;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_carga_insertar);

        helper = new ControlBDReservacionLab(this);
        idTCarga = (EditText) findViewById(R.id.idTCarga);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }
    public void insertarTCarga(View v) {

        String idTipoCarga=idTCarga.getText().toString();
        String nombreTipoCarga=editNombre.getText().toString();
        String regInsertados;
        TipoCarga tipoCarga=new TipoCarga();
        tipoCarga.setIdTipoCarga(idTipoCarga);
        tipoCarga.setNombreTipoCarga(nombreTipoCarga);
        helper.abrir();
        regInsertados=helper.insertar(tipoCarga);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();


    }



}
