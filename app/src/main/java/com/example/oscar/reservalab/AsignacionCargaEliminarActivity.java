package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AsignacionCargaEliminarActivity extends Activity {
    EditText editIdAsignacionCarga;
    ControlBDReservacionLab controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_carga_eliminar);
        controlhelper=new ControlBDReservacionLab (this);
        editIdAsignacionCarga=(EditText)findViewById(R.id.editIdAsignacionCarga);
    }
    public void eliminarAsignacionCarga(View v){
        String regEliminadas;
        AsignacionCarga asignacionCarga=new AsignacionCarga();
        asignacionCarga.setIdAsignacionCarga(Integer.valueOf(editIdAsignacionCarga.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(asignacionCarga);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
