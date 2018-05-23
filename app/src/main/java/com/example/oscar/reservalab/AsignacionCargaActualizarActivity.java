package com.example.oscar.reservalab;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AsignacionCargaActualizarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdAsignacionCarga;
    EditText editCodigoAsignatura;
    EditText editIdCiclo;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_carga_actualizar);
        helper = new ControlBDReservacionLab(this);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);
        editCodigoAsignatura = (EditText) findViewById(R.id.editCodigoAsignatura);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);

    }
    public void actualizarAsignacionCarga(View v) {
        AsignacionCarga asignacionCarga = new AsignacionCarga();
        asignacionCarga.setIdAsignacionCarga(Integer.valueOf(editIdAsignacionCarga.getText().toString()));
        asignacionCarga.setCodigoAsignatura(editCodigoAsignatura.getText().toString());
        asignacionCarga.setIdCiclo(Integer.valueOf(editIdCiclo.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(asignacionCarga);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdAsignacionCarga.setText("");
        editCodigoAsignatura.setText("");
        editIdCiclo.setText("");
    }
}