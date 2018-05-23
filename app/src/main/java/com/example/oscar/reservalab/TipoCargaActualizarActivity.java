package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoCargaActualizarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText idTC;
    EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_carga_actualizar);
        helper = new  ControlBDReservacionLab(this);

        idTC = (EditText) findViewById(R.id.idTC);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }
    public void actualizarTC(View v) {
        TipoCarga tipoCarga = new TipoCarga();
        tipoCarga.setIdTipoCarga(idTC.getText().toString());
        tipoCarga.setNombreTipoCarga(editNombre.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(tipoCarga);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idTC.setText("");
        editNombre.setText("");
    }

}
