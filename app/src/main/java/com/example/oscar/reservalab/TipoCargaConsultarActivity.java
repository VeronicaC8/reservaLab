package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoCargaConsultarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idTC;
    EditText editNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_carga_consultar);

        helper = new  ControlBDReservacionLab(this);

        idTC = (EditText) findViewById(R.id.idTC);
        editNombre = (EditText) findViewById(R.id.editNombre);

    }

    public void consultarTipoCarga(View v) {

        helper.abrir();
        TipoCarga tipoCarga = helper.consultarTipoCarga(idTC.getText().toString());
        helper.cerrar();
        if(tipoCarga == null)
            Toast.makeText(this, "Tipo de carga con Id: " + idTC.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre.setText(tipoCarga.getNombreTipoCarga());
        }
    }
    public void limpiarTexto(View v){
        idTC.setText("");
        editNombre.setText("");

    }

}
