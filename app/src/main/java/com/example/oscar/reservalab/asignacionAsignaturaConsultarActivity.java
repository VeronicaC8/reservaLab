package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class asignacionAsignaturaConsultarActivity extends Activity {

    ControlBDReservacionLab helper;

    EditText editIdAsignacion;
    EditText editCodLaboratorio;
    EditText editCodigoAsignatura;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_asignatura_consultar);
        helper = new ControlBDReservacionLab(this);

        editIdAsignacion = (EditText) findViewById(R.id.editIdAsignacion);
        editCodLaboratorio = (EditText) findViewById(R.id.editCodLaboratorio);
        editCodigoAsignatura = (EditText) findViewById(R.id.editCodigoAsignatura);

    }

    public void consultar(View v) {
        helper.abrir();
        asignacionAsignatura asignacion = helper.consultar(Integer.parseInt(editIdAsignacion.getText().toString()));
        helper.cerrar();
        if(asignacion == null)
            Toast.makeText(this,"Asignacion con id" + editIdAsignacion.getText().toString()+ "No encontrado", Toast.LENGTH_SHORT).show();
        else
        {
            editCodLaboratorio.setText(asignacion.getCodLaboratorio());
            editCodigoAsignatura.setText(asignacion.getCodAsignatura());

        }


    }
    public void limpiarTexto(View v){
        editIdAsignacion.setText("");
        editCodLaboratorio.setText("");
        editCodigoAsignatura.setText("");

    }

}
