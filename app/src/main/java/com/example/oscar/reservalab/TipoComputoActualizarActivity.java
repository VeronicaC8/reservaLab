package com.example.oscar.reservalab;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class TipoComputoActualizarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdTipoComputo;
    EditText editNombreTipo;
    EditText editEspecificacionTecnica;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_computo_actualizar);
        helper = new ControlBDReservacionLab(this);
        editIdTipoComputo = (EditText) findViewById(R.id.editIdTipoComputo);
        editNombreTipo = (EditText) findViewById(R.id.editNombreTipo);
        editEspecificacionTecnica = (EditText) findViewById(R.id.editEspecificacionTecnica);

    }
    public void actualizarTipoComputo(View v) {
        TipoComputo tipoComputo = new TipoComputo();
        tipoComputo.setIdTipoComputo(Integer.valueOf(editIdTipoComputo.getText().toString()));
        tipoComputo.setNombreTipo(editNombreTipo.getText().toString());
        tipoComputo.setEspecificacionTecnica(editEspecificacionTecnica.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(tipoComputo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdTipoComputo.setText("");
        editNombreTipo.setText("");
        editEspecificacionTecnica.setText("");
    }
}