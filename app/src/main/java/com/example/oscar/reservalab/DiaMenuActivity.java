package com.example.oscar.reservalab;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiaMenuActivity extends ListActivity {

    String[] menu={"Insertar Registro","Eliminar Registro","Actualizar Registro", "Consultar Registro"};
    String[] activities={"DiaInsertarActivity","DiaEliminarActivity","DiaActualizarActivity","DiaConsultarActivity"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView=getListView();
       // listView.setBackgroundColor(Color.rgb(153, 255, 255));
       // setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
        try{
            Class<?> clase=Class.forName("com.example.oscar.reservalab."+nombreValue);
            Intent inte=new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
