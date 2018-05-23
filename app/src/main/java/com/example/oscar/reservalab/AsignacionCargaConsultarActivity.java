package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignacionCargaConsultarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdAsignacionCarga;
    EditText editCodigoAsignatura;
    EditText editIdCiclo;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_carga_consultar);
        helper = new ControlBDReservacionLab(this);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);
        editCodigoAsignatura = (EditText) findViewById(R.id.editCodigoAsignatura);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
    }
    public void consultar(View v) {
        helper.abrir();
        AsignacionCarga asignacionCarga = helper.consultarAsignacionCarga(Integer.parseInt(editIdAsignacionCarga.getText().toString()));
        helper.cerrar();
        if(asignacionCarga == null)
            Toast.makeText(this, "Asignacion con id " +
                    editIdAsignacionCarga.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCodigoAsignatura.setText(asignacionCarga.getCodigoAsignatura());
            editIdCiclo.setText(String.valueOf(asignacionCarga.getIdCiclo()));
        }
    }
    public void limpiarTexto(View v){
        editIdAsignacionCarga.setText("");
        editCodigoAsignatura.setText("");
        editIdCiclo.setText("");
    }
}