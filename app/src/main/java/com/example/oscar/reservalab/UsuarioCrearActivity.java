package com.example.oscar.reservalab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class UsuarioCrearActivity extends Activity {
    ControlBDReservacionLab helper;
    EditText editIdUsuario;
    EditText editUsuario;
    EditText editcontrasena;
    EditText editTipoUsuario;
    Spinner comboTipo;
    ArrayList<String> listaTipo;
    ArrayList<AccesoUsuario> tipoList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_crear);
        helper = new ControlBDReservacionLab(this);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editcontrasena = (EditText) findViewById(R.id.editcontrasena);
        editTipoUsuario = (EditText) findViewById(R.id.editTipoUsu);
    }




    public void insertarUsuario(View v) {
        Integer  idusu=Integer.valueOf(editIdUsuario.getText().toString());
        String usu=editUsuario.getText().toString();
        String con=editcontrasena.getText().toString();
        Integer tusu=Integer.valueOf(editTipoUsuario.getText().toString());
        String regInsertados;
        Usuario us=new Usuario();
        us.setIdUsuario(idusu);
        us.setUsuario(usu);
        us.setContrasenia(con);
        us.setIdaccesoUsuario(tusu);
        helper.abrir();
        regInsertados=helper.insertar(us);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdUsuario.setText("");
        editUsuario.setText("");
        editcontrasena.setText("");
        editTipoUsuario.setText("");
    }

}
