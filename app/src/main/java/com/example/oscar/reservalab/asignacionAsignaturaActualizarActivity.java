package com.example.oscar.reservalab;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class asignacionAsignaturaActualizarActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdAsignacion;
    EditText editCodLaboratorio;
    EditText editCodigoAsignatura;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_asignatura_actualizar);

        helper = new ControlBDReservacionLab(this);
        editIdAsignacion = (EditText) findViewById(R.id.editIdAsignacion);
        editCodLaboratorio = (EditText) findViewById(R.id.editCodLaboratorio);
        editCodigoAsignatura = (EditText) findViewById(R.id.editCodigoAsignatura);

    }
    public void actualizarAsignatura(View v) {
        asignacionAsignatura asignacion = new asignacionAsignatura();
        asignacion.setIdAsignacionAsignatura(Integer.valueOf(editIdAsignacion.getText().toString()));
        asignacion.setCodLaboratorio(editCodLaboratorio.getText().toString());
        asignacion.setCodAsignatura(editCodigoAsignatura.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(asignacion);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdAsignacion.setText("");
        editCodLaboratorio.setText("");
        editCodigoAsignatura.setText("");

    }
}
