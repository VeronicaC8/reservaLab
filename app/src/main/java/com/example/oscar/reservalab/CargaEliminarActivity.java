package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CargaEliminarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idCarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_eliminar);
        helper = new  ControlBDReservacionLab(this);

        idCarga = (EditText) findViewById(R.id.idCarga);
    }
    public void eliminarC(View v){
        String regEliminadas;
        Carga carga = new Carga();
        carga.setIdCarga(idCarga.getText().toString());
        helper.abrir();
        regEliminadas=  helper.eliminar(carga);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();


    }
}
