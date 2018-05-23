package com.example.oscar.reservalab;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CicloActualizarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdCiclo;
    EditText editNumCiclo;
    EditText editAnio;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_actualizar);

        helper = new ControlBDReservacionLab(this);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editNumCiclo = (EditText) findViewById(R.id.editNumCiclo);
        editAnio = (EditText) findViewById(R.id.editAnio);

    }
    public void actualizarCiclo(View v) {
        Ciclo ciclo = new Ciclo();
        ciclo.setIdCiclo(Integer.valueOf(editIdCiclo.getText().toString()));
        ciclo.setNumCiclo(Integer.valueOf(editNumCiclo.getText().toString()));
        ciclo.setAnio(Integer.valueOf(editAnio.getText().toString()));

        helper.abrir();
        String estado = helper.actualizar(ciclo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdCiclo.setText("");
        editNumCiclo.setText("");
        editAnio.setText("");

    }
}