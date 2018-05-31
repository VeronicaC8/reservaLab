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
    EditText editCodAsignatura;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_asignatura_ingresar);

        helper= new ControlBDReservacionLab(this);
        editIdAsignacion=(EditText)findViewById(R.id.editIdAsignacion);
        editCodAsignatura=(EditText)findViewById(R.id.editCodAsignatura);
        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
    }

    public void insertarAsignacionAsignatura(View v){

        String regInsertados;
        Integer idAsignacionAsignatura=Integer.valueOf(editIdAsignacion.getText().toString());
        String codAsignatura=editCodAsignatura.getText().toString();
        String codLaboratorio=editCodLaboratorio.getText().toString();

        asignacionAsignatura asignacion= new asignacionAsignatura();
        asignacion.setIdAsignacionAsignatura(idAsignacionAsignatura);
        asignacion.setCodAsignatura(codAsignatura);
        asignacion.setCodLaboratorio(codLaboratorio);

        helper.abrir();
        regInsertados=helper.insertar(asignacion);
        helper.cerrar();

        Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();


    }

    public void limpiarTexto(View v){

        editIdAsignacion.setText("");
        editCodLaboratorio.setText("");
        editCodAsignatura.setText("");

    }
}
