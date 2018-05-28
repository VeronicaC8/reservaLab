package com.example.oscar.reservalab;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoComputoConsultarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdTipoComputo;
    EditText editNombreTipo;
    EditText editEspecificacionTecnica;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_computo_consultar);
        helper = new ControlBDReservacionLab(this);
        editIdTipoComputo = (EditText) findViewById(R.id.editIdAsignacionCarga);
        editNombreTipo = (EditText) findViewById(R.id.editNombreTipo);
        editEspecificacionTecnica = (EditText) findViewById(R.id.editEspecificacionTecnica);
    }
    public void consultar(View v) {
        helper.abrir();
        TipoComputo tipoComputo = helper.consultarTipoComputo(Integer.parseInt(editIdTipoComputo.getText().toString()));
        helper.cerrar();
        if(tipoComputo == null)
            Toast.makeText(this, "Tipo de Computo con id " +
                    editIdTipoComputo.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombreTipo.setText(tipoComputo.getNombreTipo());
            editEspecificacionTecnica.setText(tipoComputo.getEspecificacionTecnica());

        }
    }
    public void limpiarTexto(View v){
        editIdTipoComputo.setText("");
        editNombreTipo.setText("");
        editEspecificacionTecnica.setText("");
    }
}