package com.example.oscar.reservalab;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class ReservacionInsertarActivity extends Activity{


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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion_insertar);
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
        horarios = obtenerHorario();
        ArrayAdapter<String> adaptador2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,horarios);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cHora.setAdapter(adaptador2);

        labs = new ArrayList<>();
        labs= obtenerDia();
        ArrayAdapter<String> adaptador3 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,labs);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cLaboratorio.setAdapter(adaptador3);

        dias = new ArrayList<>();
        dias = obtenerDia();
        ArrayAdapter<String> adaptador4 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,dias);
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cDia.setAdapter(adaptador4);


    }


    private List obtenerProfesor() {

        String tabla = "profesor";
        helper.abrir();
        Profesor profesor = null;

        try {
            lProf = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                profesor = new Profesor();
                profesor.setIdProfesor(cursor.getString(0));
                profesor.setNombreProfesor(cursor.getString(1));
                lProf.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lProf);
    }

    private List obtenerHorario() {

        String tabla = "horario";
        helper.abrir();
        Horario horario = null;//CAMBIAR A LA ENTIDAD CORRESPONDIENTE

        try {
            lHorario = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                horario = new Horario();//CAMBIAR A LA ENTIDAD CORRESPONDIENTE
                horario.setHoraInicio(cursor.getString(1));
                horario.setHoraFin(cursor.getString(2));
                lHorario.add(cursor.getString(1)+"-"+ cursor.getString(2));


            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lHorario);
    }

    private List obtenerLaboratorio() {

        String tabla = "laboratorio";
        helper.abrir();
        Laboratorio labo = null;//CAMBIAR A LA ENTIDAD CORRESPONDIENTE

        try {
            lLab = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                labo = new Laboratorio(); //CAMBIAR A LA ENTIDAD CORRESPONDIENTE
                labo.setCodLaboratorio(cursor.getString(0));
                lLab.add(cursor.getString(0));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lLab);
    }


    private List obtenerDia() {

        String tabla = "dia";
        helper.abrir();
        Dia dia = null;

        try {
            lDia = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                dia = new Dia();
                dia.setIdDia(Integer.parseInt(cursor.getString(0)));
                dia.setNomDia(cursor.getString(1));
                lDia.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lDia);
    }

    public void insertarReservacion(View v) {


        String idReservacion= idReserva.getText().toString();
        String codLaboratorio=(String) cLaboratorio.getSelectedItem().toString();
        String idProfesor=(String) cProfesor.getSelectedItem().toString();
        String idHora=(String) cHora.getSelectedItem().toString();
        String idDia=(String) cDia.getSelectedItem().toString();
        String regInsertados;

        Reservacion reserva=new Reservacion();
        reserva.setIdReservacion(idReservacion);
        reserva.setCodLaboratorio(codLaboratorio);
        reserva.setIdProfesor(idProfesor);
        reserva.setIdHora(idHora);
        reserva.setIdDia(idDia);
        helper.abrir();
        regInsertados=helper.insertar(reserva);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();



    }

}
