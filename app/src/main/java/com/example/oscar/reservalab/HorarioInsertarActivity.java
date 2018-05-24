package com.example.oscar.reservalab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioInsertarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdHorario;
    EditText editHoraInicio;
    EditText editHoraFin;

   // @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);
        helper = new ControlBDReservacionLab(this);

        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editHoraInicio = (EditText) findViewById(R.id.editHorarioInicio);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
    }
    public void insertarHorario(View v) {
        Integer idHorario = Integer.valueOf(editIdHorario.getText().toString());
        String horaInicio = editHoraInicio.getText().toString();
        String horaFin = editHoraFin.getText().toString();
        String regInsertados;
        Horario horario = new Horario();
        horario.setIdHorario(idHorario);
        horario.setHoraInicio(horaInicio);
        horario.setHoraFin(horaFin);
        helper.abrir();
        regInsertados = helper.insertar(horario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editHoraInicio.setText("");
        editHoraFin.setText("");
    }
}
