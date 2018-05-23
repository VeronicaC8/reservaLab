package com.example.oscar.reservalab;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReservacionActualizarActivity extends Activity {


    Spinner cHora;
    Spinner cProfesor;
    Spinner cLaboratorio;
    Spinner cDia;
    EditText idReserva;
    ControlBDReservacionLab helper;
    List profesores;
    List horarios;
    List labs;
    List dias;


    ArrayList<String> lHorario;//CAMBIAR A CLASE HORARIO
    ArrayList<String> lProf;//CAMBIAR A CLASE PROFESOR
    ArrayList<String> lLab;//CAMBIAR A CLASE LABORATORIO
    ArrayList<String> lDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion_actualizar);
        helper = new ControlBDReservacionLab(this);

        cHora=(Spinner) findViewById(R.id.cHora);//enlace con el xml y el sppiner correspondiente a cHorario
        cLaboratorio=(Spinner) findViewById(R.id.cLaboratorio);//enlace con el xml y el sppiner correspondiente a cLaboratorio
        cProfesor=(Spinner) findViewById(R.id.cProfesor);
        cDia=(Spinner) findViewById(R.id.cDia);//enlace con el xml y el sppiner correspondiente a cProfesor
        idReserva = (EditText) findViewById(R.id.idReservacion);

        profesores = new ArrayList<>();
        profesores = obtenerProfesor();
        ArrayAdapter<String> adaptador = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,profesores);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cProfesor.setAdapter(adaptador);

        horarios = new ArrayList<>();
        horarios = obtenerProfesor();
        ArrayAdapter<String> adaptador2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,horarios);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cHora.setAdapter(adaptador2);

        labs = new ArrayList<>();
        labs= obtenerProfesor();
        ArrayAdapter<String> adaptador3 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,labs);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cLaboratorio.setAdapter(adaptador3);

        dias = new ArrayList<>();
        dias = obtenerProfesor();
        ArrayAdapter<String> adaptador4 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,dias);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cDia.setAdapter(adaptador4);
    }

    private List obtenerProfesor() {

        String tabla = "tipoCarga";
        helper.abrir();
        TipoCarga profesor = null;

        try {
            lProf = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                profesor = new TipoCarga();
                profesor.setIdTipoCarga(cursor.getString(0));
                profesor.setNombreTipoCarga(cursor.getString(1));
                lProf.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lProf);
    }

    private List obtenerHorario() {

        String tabla = "Dia";
        helper.abrir();
        TipoCarga horario = null;//CAMBIAR A LA ENTIDAD CORRESPONDIENTE

        try {
            lHorario = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                horario = new TipoCarga();//CAMBIAR A LA ENTIDAD CORRESPONDIENTE
                horario.setIdTipoCarga(cursor.getString(0));
                horario.setNombreTipoCarga(cursor.getString(1));
                lHorario.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lHorario);
    }

    private List obtenerLaboratorio() {

        String tabla = "Laboratorio";
        helper.abrir();
        TipoCarga labo = null;//CAMBIAR A LA ENTIDAD CORRESPONDIENTE

        try {
            lLab = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                labo = new TipoCarga(); //CAMBIAR A LA ENTIDAD CORRESPONDIENTE
                labo.setIdTipoCarga(cursor.getString(0));
                labo.setNombreTipoCarga(cursor.getString(1));

                lLab.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lLab);
    }


    private List obtenerDia() {

        String tabla = "Dia";
        helper.abrir();
        TipoCarga dia = null;

        try {
            lDia = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                dia = new TipoCarga();
                dia.setIdTipoCarga(cursor.getString(0));
                dia.setNombreTipoCarga(cursor.getString(1));
                lDia.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lProf);
    }

    public void actualizarR(View v) {

        String codLaboratorio=(String) cLaboratorio.getSelectedItem().toString();
        String idProfesor=(String) cProfesor.getSelectedItem().toString();
        String idHora=(String) cHora.getSelectedItem().toString();
        String idDia=(String) cDia.getSelectedItem().toString();


        Reservacion reserva=new Reservacion();
        reserva.setIdReservacion(idReserva.getText().toString());
        reserva.setCodLaboratorio(codLaboratorio);
        reserva.setIdProfesor(idProfesor);
        reserva.setIdHora(idHora);
        reserva.setIdDia(idDia);
        helper.abrir();
        String estado = helper.actualizar(reserva);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        idReserva.setText("");
    }
}
