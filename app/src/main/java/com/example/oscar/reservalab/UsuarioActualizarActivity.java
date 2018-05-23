package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsuarioActualizarActivity extends Activity{

    ControlBDReservacionLab helper;
    EditText editIdUsuario;
    EditText editUsuario;
    EditText editcontrasena;
    EditText editTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_actualizar);
        helper = new ControlBDReservacionLab(this);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editcontrasena = (EditText) findViewById(R.id.editcontrasena);
        editTipoUsuario = (EditText) findViewById(R.id.editTipoUsu);
    }

    public void actualizarUsuario(View v) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(editIdUsuario.getText().toString()));
        usuario.setUsuario(editUsuario.getText().toString());
        usuario.setContrasenia(editcontrasena.getText().toString());
        usuario.setIdaccesoUsuario(Integer.parseInt(editTipoUsuario.getText().toString()));

        helper.abrir();
        String estado = helper.actualizar(usuario);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdUsuario.setText("");
        editUsuario.setText("");
        editcontrasena.setText("");
        editTipoUsuario.setText("");
    }
}
