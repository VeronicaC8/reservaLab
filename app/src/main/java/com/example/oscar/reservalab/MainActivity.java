package com.example.oscar.reservalab;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] menu={"Ciclo","Asignatura","Asignacion de Asignatura", "Reservacion","Tipo de Carga", "Carga","Profesor","Asignacion Carga","TipoComputo","Usuario","Dia","Horario","Laboratorio","LLenar Base de Datos"};
    String[] activities={"CicloMenuActivity","AsignaturaMenuActivity","asignacionAsignaturaMenuActivity","ReservacionMenuActivity", "TipoCargaMenuActivity","CargaMenuActivity","ProfesorMenuActivity","AsignacionCargaMenuActivity","TipoComputoMenuActivity","UsuarioMenuActivity","DiaMenuActivity","HorarioMenuActivity","LaboratorioMenuActivity"};
    ControlBDReservacionLab BDhelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBDReservacionLab(this);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=13){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("com.example.oscar.reservalab."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);

            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            BDhelper=new ControlBDReservacionLab(this);
            BDhelper.abrir();
            String tost=BDhelper.llenarBDReservacionLab();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();


        }
    }
}
