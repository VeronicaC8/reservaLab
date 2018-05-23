package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class asignacionAsignaturaIngresarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdAsignacion;
    EditText editCodLaboratorio;
    EditText editCodigoAsignatura;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_asignatura_ingresar);

        helper= new ControlBDReservacionLab(this);
        editIdAsignacion=(EditText)findViewById(R.id.editIdAsignacion);
        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
        editCodigoAsignatura=(EditText)findViewById(R.id.editCodigoAsignatura);
    }

    public void insertar(View v){

        String regInsertados;
        Integer idAsignacionAsignatura=Integer.valueOf(editIdAsignacion.getText().toString());
        String codAsignatura=editIdAsignacion.getText().toString();
        String codLaboratorio=editCodigoAsignatura.getText().toString();

        asignacionAsignatura asignacion= new asignacionAsignatura();
        asignacion.setIdAsignacionAsignatura(idAsignacionAsignatura);
        asignacion.setCodLaboratorio(codLaboratorio);
        asignacion.setCodAsignatura(codAsignatura);

        helper.abrir();
        regInsertados=helper.insertar(asignacion);
        helper.cerrar();

        Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();


    }

    public void limpiarTexto(View v){

        editIdAsignacion.setText("");
        editCodLaboratorio.setText("");
        editCodigoAsignatura.setText("");

    }
}
