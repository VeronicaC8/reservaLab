package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CargaConsultarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idCarga;
    EditText idTC;
    EditText codAsig;
    EditText numG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_consultar);
        helper = new  ControlBDReservacionLab(this);

        idCarga = (EditText) findViewById(R.id.idCarga);
        idTC = (EditText) findViewById(R.id.idTC);
        codAsig = (EditText) findViewById(R.id.codAsig);
        numG = (EditText) findViewById(R.id.numG);

    }

    public void consultarCarga(View v) {

        helper.abrir();
        Carga carga = helper.consultarCarga(idCarga.getText().toString());
        helper.cerrar();
        if(carga == null)
            Toast.makeText(this, "Carga con Id: " + idCarga.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            idTC.setText(carga.getIdTipoCarga().toString());
            codAsig.setText(carga.getCodAsignatura().toString());
            numG.setText(carga.getNumGrupo().toString());
        }
    }
    public void limpiarTexto(View v){
        idCarga.setText("");
        idTC.setText("");
        codAsig.setText("");
        numG.setText("");

    }
}
