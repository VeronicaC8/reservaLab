package com.example.oscar.reservalab;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoComputoInsertarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdTipoComputo;
    EditText editNombreTipo;
    EditText editEspecificacionTecnica;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_computo_insertar);
        helper = new ControlBDReservacionLab(this);
        editIdTipoComputo = (EditText) findViewById(R.id.editIdTipoComputo);
        editNombreTipo = (EditText) findViewById(R.id.editNombreTipo);
        editEspecificacionTecnica = (EditText) findViewById(R.id.editEspecificacionTecnica);


    }
    public void insertarTipoComputo(View v) {
        Integer idTipoComputo=Integer.valueOf(editIdTipoComputo.getText().toString());
        String nombreTipo = editNombreTipo.getText().toString();
        String especificacionTecnica = editEspecificacionTecnica.getText().toString();

        String regInsertados;
        TipoComputo tipoComputo=new TipoComputo();
        tipoComputo.setIdTipoComputo(idTipoComputo);
        tipoComputo.setNombreTipo(nombreTipo);
        tipoComputo.setEspecificacionTecnica(especificacionTecnica);

        helper.abrir();
        regInsertados=helper.insertar(tipoComputo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdTipoComputo.setText("");
        editNombreTipo.setText("");
        editEspecificacionTecnica.setText("");
    }
}