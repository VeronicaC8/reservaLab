package com.example.oscar.reservalab;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LaboratorioMenuActivity extends ListActivity {

    String[] menu={"Insertar Registro","Eliminar Registro","Actualizar Registro", "Consultar Registro"};
    String[] activities={"LaboratorioInsertarActivity","LaboratorioEliminarActivity","LaboratorioActualizarActivity","LaboratorioConsultarActivity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
  //      ListView listView=getListView();
  //      listView.setBackgroundColor(Color.rgb(0,0,25));

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
 //       l.getChildAt(position).setBackgroundColor(Color.rgb(128,128,255));
        try{
            Class<?> clase=Class.forName("com.example.oscar.reservalab."+nombreValue);
            Intent inte=new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
