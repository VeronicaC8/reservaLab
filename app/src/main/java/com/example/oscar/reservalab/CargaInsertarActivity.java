package com.example.oscar.reservalab;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CargaInsertarActivity extends AppCompatActivity {


    Spinner cAsignatura;
    Spinner cTipo;
    ControlBDReservacionLab helper;
    EditText idCarga1;
    EditText editGrupo;
    List asignaturas;
    List tipos;


    ArrayList<String> lAsig;
    ArrayList<String> lTipos;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_insertar);
        helper = new ControlBDReservacionLab(this);

        idCarga1 = (EditText) findViewById(R.id.idCarga1);
        editGrupo = (EditText) findViewById(R.id.editGrupo);


        cAsignatura=(Spinner) findViewById(R.id.cAsignatura);//enlace con el xml y el sppiner correspondiente a cAsignatura
        cTipo=(Spinner) findViewById(R.id.cTipo);//enlace con el xml y el sppiner correspondiente a cTipo


        asignaturas = new ArrayList<>(); //Metodo para guardar la lista obtenida de la funcion obtenerAsignatura
        asignaturas = obtenerAsignatura();
        ArrayAdapter<String> adaptador = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,asignaturas);// Asignarla a un adaptador para el spinner
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cAsignatura.setAdapter(adaptador);

        tipos = new ArrayList<>();//Metodo para guardar la lista obtenida de la funcion obtenerTipo
        tipos = obtenerTipo();
        ArrayAdapter<String> adaptador2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,tipos);// Asignarla a un adaptador para el spinner
        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cTipo.setAdapter(adaptador2);

    }


    private List obtenerTipo() {

        String tabla = "tipoCarga";
        helper.abrir();
        TipoCarga tcarga = null;

        try {
            lTipos = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                tcarga = new TipoCarga();
                tcarga.setIdTipoCarga(cursor.getString(0));
                tcarga.setNombreTipoCarga(cursor.getString(1));
                lTipos.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lTipos);
    }

    private List obtenerAsignatura() {

        String tabla = "tipoCarga";
        helper.abrir();
        TipoCarga asignatura = null;//CAMBIAR A LA ENTIDAD CORRESPONDIENTE

        try {
            lAsig = new ArrayList<>();

            Cursor cursor = helper.db.rawQuery("SELECT * FROM " + tabla, null);

            while (cursor.moveToNext()) {
                asignatura= new TipoCarga();//CAMBIAR A LA ENTIDAD CORRESPONDIENTE
                asignatura.setIdTipoCarga(cursor.getString(0));
                asignatura.setNombreTipoCarga(cursor.getString(1));
                lAsig.add(cursor.getString(1));

            }


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return (lAsig);
    }

    public void insertarCarga(View v) {


        String idCarga= idCarga1.getText().toString();
        String numGrupo= editGrupo.getText().toString();
        String regInsertados;
        String codAsignatura=(String) cAsignatura.getSelectedItem().toString();
        String idTipoCarga=(String) cTipo.getSelectedItem().toString();


        Carga carga=new Carga();
        carga.setIdCarga(idCarga);
        carga.setCodAsignatura(codAsignatura);
        carga.setIdTipoCarga(idTipoCarga);
        carga.setNumGrupo(Integer.parseInt(numGrupo));
        helper.abrir();
        regInsertados=helper.insertar(carga);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();





    }




}
