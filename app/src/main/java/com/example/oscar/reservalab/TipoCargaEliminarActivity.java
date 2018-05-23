package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoCargaEliminarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_carga_eliminar);
        helper = new  ControlBDReservacionLab(this);

        idTC = (EditText) findViewById(R.id.idTC);
    }
    public void eliminarTC(View v){
        String regEliminadas;
        TipoCarga tipoCarga = new TipoCarga();
        tipoCarga.setIdTipoCarga(idTC.getText().toString());
        helper.abrir();
        regEliminadas=  helper.eliminar(tipoCarga);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }

}
