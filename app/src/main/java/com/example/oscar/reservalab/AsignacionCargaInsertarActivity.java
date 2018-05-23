package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignacionCargaInsertarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdAsignacionCarga;
    EditText editCodigoAsignatura;
    EditText editIdCiclo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_carga_insertar);
        helper = new ControlBDReservacionLab(this);
        editIdAsignacionCarga = (EditText) findViewById(R.id.editIdAsignacionCarga);
        editCodigoAsignatura = (EditText) findViewById(R.id.editCodigoAsignatura);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);

    }
    public void insertarAsignacionCarga(View v) {
        Integer idAsignacionCarga=Integer.valueOf(editIdAsignacionCarga.getText().toString());
        String codigoAsignatura=editCodigoAsignatura.getText().toString();
        Integer idCiclo=Integer.valueOf(editIdCiclo.getText().toString());
        String regInsertados;
        AsignacionCarga asignacionCarga=new AsignacionCarga();
        asignacionCarga.setIdAsignacionCarga(idAsignacionCarga);
        asignacionCarga.setCodigoAsignatura(codigoAsignatura);
        asignacionCarga.setIdCiclo(idCiclo);
        helper.abrir();
        regInsertados=helper.insertar(asignacionCarga);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdAsignacionCarga.setText("");
        editCodigoAsignatura.setText("");
        editIdCiclo.setText("");
    }
}