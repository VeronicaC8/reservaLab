package com.example.oscar.reservalab;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Struct;

public class ControlBDReservacionLab {

    private static final String[] camposCiclo = new String[]{"idCiclo", "numCiclo", "anio"};
    private static final String[] camposAsignatura = new String[]{"codigoAsignatura", "nombreAsignatura", "numCiclo"};
    private static final String[] camposAsignacionAsignatura = new String[]{"idAsignacionAsignatura", "codigoAsignatura","codLaboratorio"};
    private static final String[] camposReservacion=new String[] {"idReservacion","codLaboratorio",  "idProfesor","idHora","idDia"};
    private static final String[] camposTipoCarga=new String[] {"idTipoCarga","nombreTipoCarga"};
    private static final String[] camposCarga=new String[] {"idCarga","idTipoCarga",  "codAsignatura","numGrupo"};
    private static final String[] camposProfesor=new String[]{"idProfesor","nombreProfesor","idUsuario","idAsignacionCarga"};
    private static final String[] camposAsignacionCarga=new String[]{"idAsignacionCarga","codigoAsignatura","idCiclo"};
    private static final String[] camposTipoComputo=new String[]{"idTipoComputo","codLaboratorio","nombreTipo","especificacionTecnica"};
    private static final String[] camposUsuario=new String[] {"idUsuario","usuario", "contrasena", "tipoUsuario"};
    private static final String[] camposAcceso=new String[] {"tipoUsuario","descripcion"};
    private static final String[]camposHorario=new String[]{"idHorario","horaInicio","horaFin"};
    private static final String[]camposDia=new String[]{"idDia","nomDia"};

    private static final String[]camposLaboratorio=new String[]{"codLaboratorio","idTipoComputo","plantaLaboratorio","cantidadEquiposLaboratorio"};


    private final Context context;
    public DatabaseHelper DBHelper;
    public SQLiteDatabase db;
    private static final String DROP_TABLE1 = "DROP TABLE IF EXISTS asignatura; ";
    private static final String DROP_TABLE2 = "DROP TABLE IF EXISTS ciclo; ";
    private static final String DROP_TABLE3 = "DROP TABLE IF EXISTS asignacionAsignatura; ";
    private static final String DROP_TABLE4 = "DROP TABLE IF EXISTS reservacion; ";
    private static final String DROP_TABLE5 = "DROP TABLE IF EXISTS tipoCarga; ";
    private static final String DROP_TABLE6 = "DROP TABLE IF EXISTS carga; ";
    private static final String DROP_TABLE7 = "DROP TABLE IF EXISTS profesor;";
    private static final String DROP_TABLE8 = "DROP TABLE IF EXISTS asignacionCarga;";
    private static final String DROP_TABLE9 = "DROP TABLE IF EXISTS tipoComputo;";
    private static final String DROP_TABLE10 ="DROP TABLE IF EXISTS usuario; ";
    private static final String DROP_TABLE11 ="DROP TABLE IF EXISTS accesoUsuario";
    private static final String DROP_TABLE12 ="DROP TABLE IF EXISTS dia;";
    private static final String DROP_TABLE13 ="DROP TABLE IF EXISTS horario;";
    private static final String DROP_TABLE14 ="DROP TABLE IF EXISTS laboratorio;";


    public ControlBDReservacionLab(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "reservacionLab2.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {

            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL("CREATE TABLE asignatura(codigoAsignatura VARCHAR(10) NOT NULL PRIMARY KEY, nombreAsignatura VARCHAR(30) NOT NULL, idCiclo INTEGER NOT NULL);");
                db.execSQL("CREATE TABLE ciclo(idCiclo Integer NOT NULL PRIMARY KEY, numCiclo Integer NOT NULL, anio Integer NOT NULL);");
                db.execSQL("CREATE TABLE asignacionAsignatura(idAsignacionAsignatura INTEGER NOT NULL PRIMARY KEY, codLaboratorio VARCHAR(10) NOT NULL, codigoAsignatura VARCHAR(10) NOT NULL);");
                db.execSQL("CREATE TABLE reservacion(idReservacion VARCHAR(3) NOT NULL PRIMARY KEY, codLaboratorio VARCHAR(6) NOT NULL, idProfesor VARCHAR(10) NOT NULL, idHora VARCHAR(10),idDia VARCHAR(10));");
                db.execSQL("CREATE TABLE tipoCarga(idTipoCarga VARCHAR(3) NOT NULL PRIMARY KEY, nombreTipoCarga VARCHAR(30) NOT NULL);");
                db.execSQL("CREATE TABLE carga(idCarga VARCHAR(3) NOT NULL PRIMARY KEY, idTipoCarga VARCHAR(10) NOT NULL, codAsignatura VARCHAR(10) NOT NULL, numGrupo INTEGER);");
                db.execSQL("CREATE TABLE profesor(idprofesor VARCHAR(10) NOT NULL PRIMARY KEY, nombreProfesor VARCHAR(30) NOT NULL,idUsuario VARCHAR(10) NOT NULL,idAsignacionCarga INTEGER NOT NULL);");
                db.execSQL("CREATE TABLE asignacionCarga(idAsignacionCarga INTEGER NOT NULL PRIMARY KEY, codigoAsignatura VARCHAR(10) NOT NULL, idCiclo INTEGER NOT NULL);");
                db.execSQL("CREATE TABLE tipoComputo(idTipoComputo INTEGER NOT NULL PRIMARY KEY, codLaboratorio VARCHAR(10) NOT NULL, nombreTipo VARCHAR(12) NOT NULL,especificacionTecnica VARCHAR(30) NOT NULL);");
                db.execSQL("CREATE TABLE usuario(idUsuario INTEGER NOT NULL PRIMARY KEY, contrasena VARCHAR(8) NOT NULL, usuario VARCHAR(10) NOT NULL,tipoUsuario INTEGER NOT NULL );");
                db.execSQL("CREATE TABLE accesoUsuario(tipoUsuario INTEGER NOT NULL PRIMARY KEY, descripcion VARCHAR(30) NOT NULL);");
                db.execSQL("CREATE TABLE horario(idHorario INTEGER NOT NULL PRIMARY KEY, horaInicio VARCHAR(8) NOT NULL, horaFin VARCHAR(8) NOT NULL);");
                db.execSQL("CREATE TABLE dia(idDia INTEGER NOT NULL PRIMARY KEY, nomDia VARCHAR(9) NOT NULL);");
                db.execSQL("CREATE TABLE laboratorio(codLaboratorio VARCHAR(6) NOT NULL PRIMARY KEY, idTipoComputo INTEGER NOT NULL, plantaLaboratorio INTEGER NOT NULL, cantidadEquiposLaboratorio INTEGER NOT NULL);");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        //  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


//        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                //Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE1);
                db.execSQL(DROP_TABLE2);
                db.execSQL(DROP_TABLE3);
                db.execSQL(DROP_TABLE4);
                db.execSQL(DROP_TABLE5);
                db.execSQL(DROP_TABLE6);
                db.execSQL(DROP_TABLE7);
                db.execSQL(DROP_TABLE8);
                db.execSQL(DROP_TABLE9);
                db.execSQL(DROP_TABLE10);
                db.execSQL(DROP_TABLE11);
                db.execSQL(DROP_TABLE12);
                db.execSQL(DROP_TABLE13);
                db.execSQL(DROP_TABLE14);
                onCreate(db);
            } catch (Exception e) {
                //Message.message(context,""+e);
            }
        }

    }

    public void abrir() throws SQLException {

        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

    //Insertar Hora

    public String insertar(Horario horario){
        String regInsertados="Registro Insertado No= ";
        long contador=0;
        ContentValues hor = new ContentValues();
        hor.put("idHorario", horario.getIdHorario());
        hor.put("horaInicio", horario.getHoraInicio());
        hor.put("horaFin", horario.getHoraFin());
        contador=db.insert("horario", null, hor);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(Dia dia){
        String regInsertados="Registro Insertado No = ";
        long contador=0;
        ContentValues di = new ContentValues();
        di.put("idDia", dia.getIdDia());
        di.put("nomDia",dia.getNomDia());
        contador=db.insert("dia", null, di);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    //Insertar TipoLaboratorio


    //Insertar laboratorio
    public String insertar(Laboratorio laboratorio){
        String regInsertados="Registro Insertado No= ";
        long contador=0;
        if(verificarIntegridad(laboratorio,22))
        {
            ContentValues labs = new ContentValues();
            labs.put("codLaboratorio", laboratorio.getCodLaboratorio());
            labs.put("idTipoComputo", laboratorio.getIdTipoComputo());
            labs.put("plantaLaboratorio", laboratorio.getPlantaLaboratorio());
            labs.put("cantidadEquiposLaboratorio", laboratorio.getCantidadEquiposLaboratorio());
            contador=db.insert("laboratorio", null, labs);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }





    //Actualizar Hora
    public String actualizar(Horario horario){
        return null;
    }


    public String actualizar(Dia dia){
        if(verificarIntegridad(dia,25)){
            String[] idias={String.valueOf(dia.getIdDia())};
            ContentValues cv=new ContentValues();
            cv.put("nomDia",dia.getNomDia());
            db.update("dia",cv,"idDia = ?",idias);
            return "Registro Actualizado Correctamente";
        }else {
            return "Registro con id Dia "+dia.getIdDia()+ "no existe";
        }
    }

    //Actualizar Tipo Computo


    //Actualizar laboratorio

    public String actualizar(Laboratorio laboratorio){
        if(verificarIntegridad(laboratorio,23)){
            String[] iddd={laboratorio.getCodLaboratorio(),String.valueOf(laboratorio.getIdTipoComputo())};
            ContentValues cv=new ContentValues();
            cv.put("plantaLaboratorio",laboratorio.getPlantaLaboratorio());
            cv.put("cantidadEquiposLaboratorio",laboratorio.getCantidadEquiposLaboratorio());
            db.update("laboratorio",cv,"codLaboratorio = ? AND idTipoComputo = ?",iddd);
            return "Registro Actualizado Correctamente";
        }else {
            return "Registro no actualizado";
        }
    }








    //Eliminar Hora
    public String eliminar(Horario horario){
        return null;
    }



    //Eliminar Dia
    public String eliminar(Dia dia){
        String regAfectados="filas afectadas";
        int contador=0;
        if(verificarIntegridad(dia,24)){
            contador+=db.delete("reservacion","idDia ='"+String.valueOf(dia.getIdDia())+"'",null);
        }
        contador+=db.delete("dia","idDia='"+dia.getIdDia()+"'",null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Tipo Computo


    //Eliminar laboratorio
    public String eliminar(Laboratorio laboratorio){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="codLaboratorio='"+laboratorio.getCodLaboratorio()+"'";
        where=where+" AND idTipoComputo = "+laboratorio.getIdTipoComputo();
        where=where+" AND plantaLaboratorio="+laboratorio.getPlantaLaboratorio();
        where=where+" AND cantidadEquiposLaboratorio="+laboratorio.getCantidadEquiposLaboratorio();
        contador+=db.delete("nota", where, null);
        regAfectados+=contador;
        return regAfectados;
    }






    public Horario consultarHorario(Integer idHorario){
        String[] id={String.valueOf(idHorario)};
        Cursor cursor=db.query("horario", camposHorario,"idHorario = ?", id,null,null,null);
        if(cursor.moveToFirst()){
            Horario horario=new Horario();
            horario.setIdHorario(cursor.getInt(0));
            horario.setHoraInicio(cursor.getString(1));
            horario.setHoraFin(cursor.getString(2));
            return horario;
        }else{
            return null;
        }
    }

    //Consultar Dia
    public Dia consultarDia(Integer idDia){
        String[] id={String.valueOf(idDia)};
        Cursor cursor=db.query("dia",camposDia,"idDia = ?",id,null,null,null);
        if(cursor.moveToFirst()){
            Dia dia=new Dia();
            dia.setIdDia(cursor.getInt(0));
            dia.setNomDia(cursor.getString(1));
            return dia;
        }else{
            return null;
        }
    }

    public Laboratorio consultarLaboratorio(String codLaboratorio){
        String[] id = {codLaboratorio};
        Cursor cursor = db.query("laboratorio", camposLaboratorio, "codLaboratorio = ? ", id, null, null, null);
        if(cursor.moveToFirst()){
            Laboratorio laboratorio = new Laboratorio();
            laboratorio.setCodLaboratorio(cursor.getString(0));
            laboratorio.setIdTipoComputo(cursor.getInt(1));
            laboratorio.setPlantaLaboratorio(cursor.getInt(2));
            laboratorio.setCantidadEquiposLaboratorio(cursor.getInt(3));
            return laboratorio;
        }else{
            return null;
        }
    }

    ///INSERTAR ASIGNATURA
    public String insertar(Asignatura asignatura) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        if (verificarIntegridad(asignatura, 1)) //Verifica integridad referencial
        {
            if (verificarIntegridad(asignatura, 3)) {
                regInsertados = "Asignatura existente";
            } else {
                ContentValues asig = new ContentValues();
                asig.put("codigoAsignatura", asignatura.getCodigoAsignatura());
                asig.put("nombreAsignatura", asignatura.getNombreAsignatura());
                asig.put("numCiclo", asignatura.getIdCiclo());
                contador = db.insert("asignatura", null, asig);
            }

        } else {
            regInsertados = "Error al Insertar el registro, " +
                    "Registro sin referencias. Verificar inserción";
        }

        return regInsertados;

    }
    // Eliminar Asignatura
    public String eliminar(Asignatura asignatura) {

        String regAfectados = "filas afectadas= ";
        int contador = 0;
        // 2 Verificar registro que exista
        if (verificarIntegridad(asignatura, 3)) {
            String where = "codigoAsignatura='" + asignatura.getCodigoAsignatura() + "'";
            where = where + " AND idCiclo='" + asignatura.getIdCiclo() + "'";
            contador += db.delete("asignatura", where, null);
            regAfectados += contador;
            return regAfectados;
        } else {
            return "Registro no Existe";
        }
    }
    //ACTUALIZAR ASIGNATURA

    public String actualizar(Asignatura asignatura) {
        if (verificarIntegridad(asignatura, 3)) {
            String[] id = {asignatura.getCodigoAsignatura()};
            ContentValues cv = new ContentValues();
            cv.put("codigoAsignatura", asignatura.getCodigoAsignatura());
            cv.put("nombreAsignatura", asignatura.getNombreAsignatura());
            cv.put("idCiclo", asignatura.getIdCiclo());
            db.update("asignatura", cv, "codigoAsignatura=?", id);
            return "Registro Actualizado Correctamente";
        } else {
            return "Registro con código de Asignatura" + asignatura.getCodigoAsignatura() + "No existe";
        }
    }

    //CONSULTAR ASIGNATURA
    public Asignatura consultarAsignatura(String codigoAsignatura){

        String[] id={codigoAsignatura};
        Cursor cursor = db.query("asignatura",camposAsignatura,"idCiclo =? ", id, null, null, null);

        if(cursor.moveToFirst()){
            Asignatura asignatura = new Asignatura();
            asignatura.setCodigoAsignatura(cursor.getString(0));
            asignatura.setNombreAsignatura(cursor.getString(1));
            asignatura.setIdCiclo(cursor.getInt(2));

            return asignatura;
        } else{
            return null;
        }

    }


    //==========================================================================================================

    //INSERTAR Usuario
    public String insertar(Usuario usuario) {
        String regInsertados = "Registro Insertado Nº=";
        long contador = 0;
        //Verificar que no exista usuario
        if (verificarIntegridad(usuario, 6)) {
            regInsertados = "Error al Insertar el registros, Registro Duplicado. Verificar inserción";

        } else {
            ContentValues usu = new ContentValues();
            usu.put("idUsuario", usuario.getIdUsuario());
            usu.put("usuario", usuario.getUsuario());
            usu.put("contrasena", usuario.getContrasenia());
            usu.put("tipoUsuario", usuario.getIdaccesoUsuario());

            contador = db.insert("usuario", null, usu);
            if (contador == -1 || contador == 0) {
                regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
            } else {
                regInsertados = regInsertados + contador;
            }

        }
        return regInsertados;
    }


    public String actualizar(Usuario usuario){
        if(verificarIntegridad(usuario,6)){
            String[] id={String.valueOf(usuario.getIdUsuario())};
            ContentValues us = new ContentValues();
            //us.put("idUsuario", usuario.getIdUsuario());
            us.put("usuario", usuario.getUsuario());
            us.put("contrasena", usuario.getContrasenia());
            us.put("tipoUsuario", usuario.getIdaccesoUsuario());

            db.update("usuario", us, "idUsuario=?", id);
            return "Usuario Actualizado Correctamente";
        }else{
            return "Usuario con código de Usuario "+ usuario.getIdUsuario() + "No existe";
        }
    }


    // Eliminar Usuario
    public String eliminar(Usuario usuario){

        String usuAfectados="filas afectadas= ";
        int contador=0;
        if(verificarIntegridad(usuario, 6)) {
            String where="idUsuario='"+usuario.getIdUsuario()+"'";
            contador+=db.delete("usuario", where,null);
            usuAfectados+=contador;
            return usuAfectados;
        } else { return "Registro no Existe"; }
    }

    //CONSULTAR Usuario
    public Usuario consultarUsuario(String idUsuario){

        String[] id={idUsuario};
        Cursor cursor = db.query("usuario",camposUsuario,"idUsuario =? ", id, null, null, null);


        if(cursor.moveToFirst()){
            Usuario us = new Usuario();
            us.setIdUsuario(cursor.getInt(0));
            us.setUsuario(cursor.getString(1));
            us.setContrasenia(cursor.getString(2));
            us.setIdaccesoUsuario(cursor.getInt(3));

            return us;
        } else{
            return null;
        }

    }

    public Usuario consultarLog(String usuario, String contrasena){

        String[] id={usuario,contrasena};
        Cursor cursor = db.query("usuario",camposUsuario,"usuario =? AND contrasena = ?", id, null, null, null);


        if(cursor.moveToFirst()){
            Usuario us = new Usuario();
            us.setIdUsuario(cursor.getInt(0));
            us.setUsuario(cursor.getString(1));
            us.setContrasenia(cursor.getString(2));
            us.setIdaccesoUsuario(cursor.getInt(3));

            return us;
        } else{
            return null;
        }

    }
    //==========================================================================================================
    //INSERTAR CICLO
    public String insertar(Ciclo ciclo) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues cicl = new ContentValues();
        cicl.put("idCiclo", ciclo.getIdCiclo());
        cicl.put("numCiclo", ciclo.getNumCiclo());
        cicl.put("anio", ciclo.getAnio());


        contador = db.insert("ciclo", null, cicl);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    //ACTUALIZAR CICLO
    public String actualizar(Ciclo ciclo) {
        if (verificarIntegridad(ciclo, 2)) {
            String[] id = {Integer.toString(ciclo.getIdCiclo())};
            ContentValues cv = new ContentValues();
            cv.put("idCiclo", ciclo.getIdCiclo());
            cv.put("numCiclo", ciclo.getNumCiclo());
            cv.put("anio", ciclo.getAnio());

            db.update("ciclo", cv, "idCiclo=?", id);
            return "Registro Actualizado Correctamente";
        } else {
            return "Registro con código de Asignatura" + ciclo.getNumCiclo() + "No existe";
        }
    }

    // Eliminar Ciclo
    public String eliminar(Ciclo ciclo){

        String regAfectados="filas afectadas= ";
        int contador=0; // 2 Verificar registro que exista
        if(verificarIntegridad(ciclo, 2))
        {
            contador+=db.delete("ciclo", "idCiclo='"+ciclo.getIdCiclo()+"'",null);

            regAfectados+=contador;


        }
        return regAfectados;
    }

    //CONSULTAR CICLO
    public Ciclo consultarCiclo(int idCiclo){

        String[] id={String.valueOf(idCiclo)};

        Cursor cursor = db.query("ciclo", camposCiclo, "idCiclo = ? ", id, null, null, null);
        if(cursor.moveToFirst()){
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(cursor.getInt(0));
            ciclo.setNumCiclo(cursor.getInt(1));
            ciclo.setAnio(cursor.getInt(2));


            return ciclo;
        }else{
            return null;
        }

    }

    //INSERTAR ASIGNNACION DE ASIGNATURA

    public String insertar(asignacionAsignatura asignacion) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;


        if (verificarIntegridad(asignacion, 6)) {
            regInsertados = "Asignacion existente";
        } else {
            ContentValues asig = new ContentValues();
            asig.put("idAsignacionAsignatura", asignacion.getIdAsignacionAsignatura());
            asig.put("conLaboratorio", asignacion.getCodLaboratorio());
            asig.put("codigoAsignatura", asignacion.getCodAsignatura());
            contador = db.insert("asignacion_asignatura", null, asig);
        }

        regInsertados = regInsertados + contador;
        return regInsertados;

    }

    //Eliminar Asignacion de asignatura

    public String eliminar(asignacionAsignatura asignacion) {

        String regAfectados = "filas afectadas= ";
        int contador = 0;
        // 2 Verificar registro que exista
        if (verificarIntegridad(asignacion, 6)) {
            if (verificarIntegridad(asignacion, 5)) { //verifica integridad referencial
                contador += db.delete("", "codLaboratorio='" + asignacion.getIdAsignacionAsignatura() + "'", null);
            }

            contador += db.delete("camposAsignacionAsignatura", "idAsignacionAsignatura='" + asignacion.getIdAsignacionAsignatura() + "'", null);
            regAfectados += contador;
        }

        else{
            return "Registro con asignacion" + asignacion.getIdAsignacionAsignatura() + "No existe";
        }return regAfectados;

    }

    //ACTUALIZAR ASIGNACION DE ASIGNATURA

    public String actualizar(asignacionAsignatura asignacion) {

        if (verificarIntegridad(asignacion, 6)) {
            String[] id = {Integer.toString(asignacion.getIdAsignacionAsignatura())};
            ContentValues cv = new ContentValues();
            cv.put("idAsignacionAsignatura", asignacion.getIdAsignacionAsignatura());
            cv.put("codLaboratorio", asignacion.getCodLaboratorio());
            cv.put("codigoAsignatura", asignacion.getCodAsignatura());
            db.update("asignacion_asignatura", cv, "idAsignacionAsignatura=?", id);
            return "Registro Actualizado Correctamente";
        } else {
            return "Registro con código de Asignacion" + asignacion.getIdAsignacionAsignatura() + "No existe";
        }
    }

    //Consultar asignacion de asignatura

    public asignacionAsignatura consultar(Integer idAsignacionAsignatura){

        String[] id={Integer.toString(idAsignacionAsignatura)};
        Cursor cursor = db.query("asignacionAsignatura",camposAsignacionAsignatura,"idCiclo =? ", id, null, null, null);

        if(cursor.moveToFirst()){
            asignacionAsignatura asignacion = new asignacionAsignatura();
            asignacion.setIdAsignacionAsignatura(cursor.getInt(0));
            asignacion.setCodAsignatura(cursor.getString(1));
            asignacion.setCodLaboratorio(cursor.getString(2));

            return asignacion;
        } else{
            return null;
        }

    }





    //Insertar Reservacion
    public String insertar(Reservacion reservacion){

        String regInsertados="Registro Nº= Insertado Correctamente ";
        long contador=0;

        if(verificarIntegridad(reservacion,7))// 2 Verificar registro duplicado
        {
            regInsertados= "Error al Insertar el registro, Ya existe esta reservacion. Verificar";
        }
       else {
            ContentValues reservaciones = new ContentValues();
            reservaciones.put("idReservacion", reservacion.getIdReservacion());
            reservaciones.put("codLaboratorio", reservacion.getCodLaboratorio());
            reservaciones.put("idProfesor", reservacion.getIdProfesor());
            reservaciones.put("idHora", reservacion.getIdHora());
            reservaciones.put("idDia", reservacion.getIdDia());
            contador=db.insert("reservacion", null, reservaciones);
        }

        regInsertados=regInsertados+contador;
        return regInsertados;

    }
    //Insertar Tipo de Carga
    public String insertar(TipoCarga tipoCarga){

        String regInsertados="Registro Nº= Insertado Correctamente ";
        long contador=0;


        // if(verificarIntegridad(tipoCarga,5))// 2 Verificar registro duplicado{
        //  regInsertados= "Error al Insertar el registro, Ya existe esta reservacion. Verificar"; }
        //else {
        ContentValues tiposcarga = new ContentValues();
        tiposcarga.put("idTipoCarga", tipoCarga.getIdTipoCarga());
        tiposcarga.put("nombreTipoCarga", tipoCarga.getNombreTipoCarga());
        contador=db.insert("tipoCarga", null, tiposcarga); //}


        regInsertados=regInsertados+contador;
        return regInsertados;

    }


    //Insertar Carga
    public String insertar(Carga carga){

        String regInsertados="Registro Nº= Insertado Correctamente ";
        long contador=0;

        /*if(verificarIntegridad(carga,9)) {  // 1 Verificar integridad referencial
          if(verificarIntegridad(carga,10))// 2 Verificar registro duplicado
           { regInsertados= "Error al Insertar el registro, Ya existe esta reservacion. Verificar"; }
            else { */
        ContentValues cargas = new ContentValues();
        cargas.put("idCarga", carga.getIdCarga());
        cargas.put("idTipoCarga", carga.getIdTipoCarga());
        cargas.put("codAsignatura", carga.getCodAsignatura());
        cargas.put("numGrupo", carga.getNumGrupo());

        contador=db.insert("carga", null, cargas);
       /*} }  else { regInsertados= "Error al Insertar el registro, Registro sin referencias. Verificar inserción"; }*/


        regInsertados=regInsertados+contador;
        return regInsertados;

    }



    //INSERTAR PROFESOR
    public String insertar(Profesor profesor) {
        String regInsertados = "Registro Insertado Nº=";
        long contador = 0;

        ContentValues prof = new ContentValues();
        prof.put("idProfesor", profesor.getIdProfesor());
        prof.put("nombreProfesor", profesor.getNombreProfesor());
        prof.put("idUsuario", profesor.getIdUsuario());
        prof.put("idAsignacionCarga", profesor.getIdAsignacionCarga());

        contador = db.insert("profesor", null, prof);

        if(contador == -1 || contador==0)
        {
            regInsertados="Error al insertar el registro,Registro duplicado.Verificar Insercion";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;

    }
    //INSERTAR TIPO COMPUTO
    public String insertar(TipoComputo tipoComputo) {

        String regInsertados = "Registro Insertado Nº=";
        long contador = 0;

        ContentValues tipo = new ContentValues();
        tipo.put("idTipoComputo", tipoComputo.getIdTipoComputo());
        tipo.put("codLaboratorio", tipoComputo.getCodLaboratorio());
        tipo.put("nombreTipo", tipoComputo.getNombreTipo());
        tipo.put("especificacionTecnica",tipoComputo.getEspecificacionTecnica());

        contador = db.insert("tipoComputo", null, tipo);

        if(contador == -1 || contador==0)
        {
            regInsertados="Error al insertar el registro,Registro duplicado.Verificar Insercion";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;

    }

    //Actualizar reservacion
    public String actualizar(Reservacion reservacion){
        if(verificarIntegridad(reservacion,7)){
            String[] id={reservacion.getIdReservacion()};
            ContentValues cv = new ContentValues();
            cv.put("idReservacion", reservacion.getIdReservacion());
            cv.put("codLaboratorio", reservacion.getCodLaboratorio());
            cv.put("idProfesor", reservacion.getIdProfesor());
            cv.put("idHora", reservacion.getIdHora());
            cv.put("idDia", reservacion.getIdDia());
            db.update("reservacion", cv, "idReservacion=?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con código de Reservacion"+ reservacion.getIdReservacion()+ "No existe";
        }
    }

    //Actualizaer Carga
    public String actualizar(TipoCarga tipoCarga){
        if(verificarIntegridad(tipoCarga,17)){
            String[] id={tipoCarga.getIdTipoCarga()};
            ContentValues cv = new ContentValues();
            cv.put("idTipoCarga", tipoCarga.getIdTipoCarga());
            cv.put("nombreTipoCarga", tipoCarga.getNombreTipoCarga());

            db.update("tipoCarga", cv, "idTipoCarga=?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Tipo de Carga No"+ tipoCarga.getIdTipoCarga()+ "No existe";
        }
    }

    //Actualizar TipoCarga

    public String actualizar(Carga carga){
        if(verificarIntegridad(carga,18)){
            String[] id={carga.getIdCarga()};
            ContentValues cv = new ContentValues();
            cv.put("idCarga", carga.getIdCarga());
            cv.put("idTipoCarga", carga.getIdTipoCarga());
            cv.put("codAsignatura",carga.getCodAsignatura());
            cv.put("numGrupo", carga.getNumGrupo());

            db.update("carga", cv, "idCarga=?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Tipo de Carga No"+ carga.getIdCarga()+ "No existe";
        }
    }










public String insertar(AsignacionCarga asignacionCarga) {

    String regInsertados = "Registro Insertado Nº=";
    long contador = 0;

    ContentValues asigna = new ContentValues();
    asigna.put("idAsignacionCarga", asignacionCarga.getIdAsignacionCarga());
    asigna.put("codigoAsignatura", asignacionCarga.getCodigoAsignatura());
    asigna.put("idCiclo", asignacionCarga.getIdCiclo());

    contador = db.insert("asignacionCarga", null, asigna);

    if(contador == -1 || contador==0)
    {
        regInsertados="Error al insertar el registro,Registro duplicado.Verificar Insercion";
    }
    else {
        regInsertados = regInsertados + contador;
    }
    return regInsertados;

}
    //ACTUALIZAR ASIGNACION CARGA
    public String actualizar(AsignacionCarga asignacionCarga){
        if(verificarIntegridad(asignacionCarga,12)){
            String[] id={String.valueOf(asignacionCarga.getIdAsignacionCarga())};
            ContentValues cv = new ContentValues();

            cv.put("codigoAsignatura", asignacionCarga.getCodigoAsignatura());
            cv.put("idCiclo", asignacionCarga.getIdCiclo());
            db.update("asignacionCarga", cv, "idAsignacionCarga =? ", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con Id de Asignacion de Carga"+ String.valueOf(asignacionCarga.getIdAsignacionCarga())+ "No existe";
        }
    }
    //ACTUALIZAR PROFESOR
    public String actualizar(Profesor profesor){
        if(verificarIntegridad(profesor,13)){
            String[] id={profesor.getIdProfesor()};
            ContentValues cv = new ContentValues();
            cv.put("idProfesor", profesor.getIdProfesor());
            cv.put("nombreProfesor", profesor.getNombreProfesor());
            cv.put("idUsuario", profesor.getIdUsuario());
            cv.put("idAsignacionCarga", profesor.getIdAsignacionCarga());
            db.update("profesor", cv, "idProfesor=? ", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con código de Profesor"+ profesor.getIdProfesor()+ "No existe";
        }
    }
    //ACTUALIZAR TIPO COMPUTO
    public String actualizar(TipoComputo tipoComputo){
        if(verificarIntegridad(tipoComputo,12)){
            String[] id={String.valueOf(tipoComputo.getIdTipoComputo())};
            ContentValues cv = new ContentValues();

            cv.put("codLaboratorio", tipoComputo.getCodLaboratorio());
            cv.put("nombreTipo", tipoComputo.getNombreTipo());
            cv.put("especificacionTecnica", tipoComputo.getEspecificacionTecnica());
            db.update("tipoComputo", cv, "idTipoComputo =? ", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con Id de Tipo de Computo"+ String.valueOf(tipoComputo.getIdTipoComputo())+ "No existe";
        }
    }



    // Eliminar Reservacion
    public String eliminar(Reservacion reservacion){

        String regAfectados="filas afectadas= "; int contador=0;
        // 2 Verificar registro que exista
        if(verificarIntegridad(reservacion, 17)) { String where="idReservacion='"+reservacion.getIdReservacion()+"'";
            contador+=db.delete("reservacion", where, null);
            regAfectados+=contador;
            return regAfectados;
        } else { return "Registro no Existe"; }
    }

    // Eliminar Tipo de Carga
    public String eliminar(TipoCarga tipoCarga){

        String regAfectados="filas afectadas= "; int contador=0;
        // 2 Verificar registro que exista
        if(verificarIntegridad(tipoCarga, 17)) { String where="idTipoCarga='"+tipoCarga.getIdTipoCarga()+"'";
            contador+=db.delete("tipoCarga", where, null);
            regAfectados+=contador;
            return regAfectados;
        } else { return "Registro no Existe"; }
    }

    // Eliminar Carga
    public String eliminar(Carga carga){

        String regAfectados="filas afectadas= "; int contador=0;
        // 2 Verificar registro que exista
        if(verificarIntegridad(carga, 18)) { String where="idCarga='"+carga.getIdCarga()+"'";
            contador+=db.delete("carga", where, null);
            regAfectados+=contador;
            return regAfectados;
        } else { return "Registro no Existe"; }
    }

    //ELIMINAR ASIGNACION DE CARGA
    public String eliminar(AsignacionCarga asignacionCarga){
        String regAfectados="Filas afectadas=";
        int contador=0;

        if(verificarIntegridad(asignacionCarga,2)){
            contador+=db.delete("Asignatura","codigoAsignatura='"+asignacionCarga.getCodigoAsignatura()+"'", null);
            contador+=db.delete("Ciclo","idCiclo='"+asignacionCarga.getIdCiclo()+"'", null);

        }
        contador+=db.delete("asignacionCarga","idAsignacionCarga='"+asignacionCarga.getIdAsignacionCarga()+"'",null);
        regAfectados+=contador;
        return regAfectados;
    }


    //ELIMINAR PROFESOR
    public String eliminar(Profesor profesor){
        String regAfectados="Filas afectadas=";
        int contador=0;

        if(verificarIntegridad(profesor,2)){ //VERIFICAR RELACION
            contador+=db.delete("usuario","idUsuario='"+profesor.getIdUsuario()+"'",null);
            contador+=db.delete("asignacionCarga","idAsignacionCarga='"+profesor.getIdAsignacionCarga()+"'",null);
        }
        contador+=db.delete("profesor","idProfesor='"+profesor.getIdProfesor()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //ELIMINAR TIPO COMPUTO
    public String eliminar(TipoComputo tipoComputo){
        String regAfectados="Filas afectadas=";
        int contador=0;

        if(verificarIntegridad(tipoComputo,2)){  //VERIFICAR RELACION
            contador+=db.delete("Laboratorio","codLaboratorio='"+tipoComputo.getCodLaboratorio()+"'", null);

        }
        contador+=db.delete("tipoComputo","idTipoComputo='"+tipoComputo.getIdTipoComputo()+"'",null);
        regAfectados+=contador;
        return regAfectados;
    }





    //CONSULTAR ASIGNATURA
//CONSULTAR ASIGNACION DE CARGA
    public AsignacionCarga consultarAsignacionCarga(int idAsignacionCarga){

        String[] id={String.valueOf(idAsignacionCarga)};
        Cursor cursor = db.query("asignacionCarga",camposAsignacionCarga,"idAsignacionCarga=? ",id,null,null,null);

        if(cursor.moveToFirst()){
            AsignacionCarga asignacionCarga = new AsignacionCarga();
            asignacionCarga.setIdAsignacionCarga(cursor.getInt(0));
            asignacionCarga.setCodigoAsignatura(cursor.getString(1));
            asignacionCarga.setIdCiclo(cursor.getInt(2));
            return asignacionCarga;
        } else{
            return null;
        }

    }
    //CONSULTAR PROFESOR
    public Profesor consultarProfesor(String idProfesor){

        String[] id={idProfesor};
        Cursor cursor = db.query("profesor",camposProfesor,"idProfesor=?",id,null,null,null);

        if(cursor.moveToFirst()){
            Profesor profesor = new Profesor();
            profesor.setIdProfesor(cursor.getString(0));
            profesor.setNombreProfesor(cursor.getString(1));
            profesor.setIdUsuario(cursor.getInt(2));
            profesor.setIdAsignacionCarga(cursor.getInt(3));
            return profesor;
        } else{
            return null;
        }

    }
    //CONSULTAR TIPO COMPUTO
    public TipoComputo consultarTipoComputo(int idTipoComputo){

        String[] id={String.valueOf(idTipoComputo)};
        Cursor cursor = db.query("tipoComputo",camposTipoComputo,"idTipoComputo=? ",id,null,null,null);

        if(cursor.moveToFirst()){
            TipoComputo tipoComputo = new TipoComputo();
            tipoComputo.setIdTipoComputo(cursor.getInt(0));
            tipoComputo.setCodLaboratorio(cursor.getString(1));
            tipoComputo.setNombreTipo(cursor.getString(2));
            tipoComputo.setEspecificacionTecnica(cursor.getString(3));
            return tipoComputo;
        } else{
            return null;
        }

    }

    //CONSULTAR Reservacion
    public Reservacion consultarReservacion(String idReservacion){

        String[] id = {idReservacion};

        Cursor cursor = db.query("reservacion",camposReservacion,"idReservacion =?", id, null, null, null);

        if(cursor.moveToFirst()){
            Reservacion reservacion = new Reservacion();
            reservacion.setIdReservacion(cursor.getString(0));
            reservacion.setCodLaboratorio(cursor.getString(1));
            reservacion.setIdProfesor(cursor.getString(2));
            reservacion.setIdHora(cursor.getString(3));
            reservacion.setIdDia(cursor.getString(4));
            return reservacion;
        } else{
            return null;
        }

    }

    //CONSULTAR Tipo de Cargas
    public TipoCarga consultarTipoCarga(String idTipoCarga){

        String[] id={idTipoCarga};
        Cursor cursor = db.query("tipoCarga",camposTipoCarga,"idTipoCarga =?", id, null, null, null);

        if(cursor.moveToFirst()){
            TipoCarga tipoCarga = new TipoCarga();
            tipoCarga.setIdTipoCarga(cursor.getString(0));
            tipoCarga.setNombreTipoCarga(cursor.getString(1));

            return tipoCarga;
        } else{
            return null;
        }

    }
    //CONSULTAR Carga
    public Carga consultarCarga(String idCarga){

        String[] id = {idCarga};

        Cursor cursor = db.query("carga",camposCarga,"idCarga =?", id, null, null, null);

        if(cursor.moveToFirst()){
            Carga carga = new Carga();
            carga.setIdCarga(cursor.getString(0));
            carga.setIdTipoCarga(cursor.getString(1));
            carga.setCodAsignatura(cursor.getString(2));
            carga.setNumGrupo(Integer.parseInt(cursor.getString(3)));
            return carga;
        } else{
            return null;
        }

    }


    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch (relacion){
            case 1: { // Verifica que al insertar Asignatura exista ciclo
                Asignatura asignatura = (Asignatura)dato;
                String[] id1 = {Integer.toString(asignatura.getIdCiclo())}; //Verifica que exista ciclo

                abrir();
                Cursor cursor1 = db.query("ciclo", null, "idCiclo = ?", id1, null, null, null);

                if(cursor1.moveToFirst()){ //Se encontraron datos ||
                    return true;
                } return false;
            }
            case 2: {
                //Verificar que exista ciclo
                Ciclo ciclo2 = (Ciclo) dato;
                String[] id = {String.valueOf(ciclo2.getNumCiclo())};
                abrir();
                Cursor c2 = db.query("ciclo", null, "idCiclo = ?", id, null, null, null);
                if (c2.moveToFirst()) { //Se encontro Ciclo

                    return true;}else
                return false;
            }



            case 3:{ //Verificar que exista asignatura
                Asignatura asignatura2 = (Asignatura)dato;
                String[] id = {asignatura2.getCodigoAsignatura()};
                abrir();
                Cursor c2 = db.query("asignatura", null, "codigoAsignatura = ?", id, null, null, null);
                if(c2.moveToFirst()){ //Se encontro Asignatura
                    return true;
                }
                return false;

            }

            case 4: { //Elimina las asignaturas
                Ciclo ciclo = (Ciclo)dato;
                Cursor c=db.query(true, "asignatura", new String[] { "codigoAsignatura" }, "idCiclo='"+ciclo.getIdCiclo()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else return false;
            }

            case 5:{ //Verificar que exista el codigo de la asignatura y el codigo de lab
                asignacionAsignatura asignacion=(asignacionAsignatura)dato;

                String[] id1 = {asignacion.getCodAsignatura()};
                String[] id2 = {asignacion.getCodLaboratorio()};
                abrir();
                Cursor cursor1 = db.query("asignatura", null, "codigoAsignatura = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("laboratorio", null, "codLaboratorio = ?", id2,
                        null, null, null);
                if(cursor2.moveToFirst() && cursor1.moveToFirst()){
//Se encontraron datos ||
                    return true;
                }


                return false;


            }

            case 6:{ //Verifica que exista la asignacion de asignatura

                asignacionAsignatura  asignacion2 = (asignacionAsignatura)dato;
                String[] id = {Integer.toString(asignacion2.getIdAsignacionAsignatura())};
                abrir();
                Cursor c2 = db.query("asignacion_asignatura", null, "idAsignacionAsignatura = ?", id, null, null, null);
                if(c2.moveToFirst()){ //Se encontro Asignatura
                    return true;
                }
                return false;
            }

            case 7:{
                //Verificar que exista reservacion
                Reservacion reservacion2 = (Reservacion) dato;
                String[] id = {reservacion2.getIdReservacion()};
                //String[] id2 = {(reservacion2.getIdHorario())}; //Verifica que exista horario
                abrir();
                //Cursor c2 = db.query("reservacion", null, "idReservacion = ? && idHorario = ?", id, null, null, null);
                Cursor c2 = db.query("reservacion", null, "idReservacion = ? ", id, null, null, null);
                if(c2.moveToFirst()){ //Se encontro reservacion
                    return true; }
                return false;
            }

            case 8: {//VERIFICAR QUE AL INSERTAR ASIGNACION EXISTA LA MATERIA Y EL CICLO
                AsignacionCarga asignacionCarga = (AsignacionCarga) dato;
                String[] id1 = {asignacionCarga.getCodigoAsignatura()};
                String[] id2 = {Integer.toString(asignacionCarga.getIdCiclo())};
                abrir();
                Cursor cursor1 = db.query("asignatura", null, "codigoAsignatura =?", id1, null, null, null);
                Cursor cursor2 = db.query("ciclo", null, "idciclo =?", id2, null, null, null);
                if (cursor2.moveToFirst() && cursor1.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 9:{
                //verificar que al modificar la asignacion de carga existan la materia  y el ciclo
                AsignacionCarga asignacionCarga1 = (AsignacionCarga)dato;
                String[]  ids = {asignacionCarga1.getCodigoAsignatura(),Integer.toString(asignacionCarga1.getIdCiclo())};
                abrir();
                Cursor c = db.query("asignacionCarga",null, "codigoAsignatura = ? AND idCiclo =?",ids, null, null, null);
                if(c.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 10: {
                //Verificar que al insertar el profesor exista el id usuario, y el id de asignacion de carga
                Profesor profesor = (Profesor) dato;
                String[] id3 = {Integer.toString(profesor.getIdUsuario())};
                String[] id4 = {Integer.toString(profesor.getIdAsignacionCarga())};
                abrir();
                Cursor cursor3 = db.query("usuario", null, "idUsuario =?", id3, null, null, null);
                Cursor cursor4 = db.query("asignacionCarga", null, "idAsignacionCarga =?", id4, null, null, null);
                if (cursor4.moveToFirst() && cursor3.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 11:{
                //Verificar que al modificar el maestro exista el usuario y la asignacion de carga
                Profesor profesor1 = (Profesor) dato;
                String[]  id5 = {Integer.toString(profesor1.getIdUsuario()),Integer.toString(profesor1.getIdAsignacionCarga())};
                abrir();
                Cursor c = db.query("profesor",null, "idUsuario = ? AND idAsignacionCarga =?",id5, null, null, null);
                if(c.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 12:
            {
//verificar que exista asignacion
                AsignacionCarga asignacionCarga3 = (AsignacionCarga) dato;
                String[] id11 = {Integer.toString(asignacionCarga3.getIdAsignacionCarga())};
                abrir();
                Cursor c2 = db.query("asignacionCarga", null, "idAsignacionCarga = ?", id11, null, null, null);
                if(c2.moveToFirst()){
//Se encontro Asignacion
                    return true;
                }
                return false;
            }
            case 13:
            {
//verificar que exista PROFESOR
                Profesor profesor3 = (Profesor) dato;
                String[] id12 = {profesor3.getIdProfesor()};
                abrir();
                Cursor c2 = db.query("profesor", null, "idProfesor = ?", id12, null, null, null);
                if(c2.moveToFirst()){
//Se encontro PROFESOR
                    return true;
                }
                return false;
            }
            case 14:
            {
                //verificar que exista tipo computo
                TipoComputo tipoComputo3 = (TipoComputo) dato;
                String[] id13 = {Integer.toString(tipoComputo3.getIdTipoComputo())};
                abrir();
                Cursor c2 = db.query("tipoComputo", null, "idTipoComputo = ?", id13, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro tipo computo
                    return true;
                }
                return false;
            }
                /*case 15: {//VERIFICAR QUE AL INSERTAR TIPO COMPUTO exista el codigo de Laboratorio
                    TipoComputo tipoComputo = (TipoComputo) dato;
                    String[] id1 = {tipoComputo.getCodLaboratorio()};
                    abrir();
                    Cursor cursor1 = db.query("laboratorio", null, "codLaboratorio =?", id1, null, null, null);
                    if(cursor1.moveToFirst()) {
                        return true;
                    }
                    return false;
                }
                case 16:{
                    //verificar que al modificar el tipo computo existan el codigo de laboratorio
                    TipoComputo tipoComputo1 = (TipoComputo) dato;
                    String[]  ids = {tipoComputo1.getCodLaboratorio()};
                    abrir();
                    Cursor c = db.query("tipoComputo",null, "codLaboratorio = ? ",ids, null, null, null);
                    if(c.moveToFirst()) {
                        return true;
                    }
                    return false;
                }*/
            case 17:{
                //Verificar que exista Tipo de Carga
                TipoCarga tipoCarga2 = (TipoCarga) dato;
                String[] id = {tipoCarga2.getIdTipoCarga()};
                abrir();
                Cursor c2 = db.query("tipoCarga", null, "idTipoCarga = ?", id, null, null, null);
                if(c2.moveToFirst()){ //Se encontro Tipo de Carga
                    return true; }
            }
            case 18:{
                //Verificar que exista  Carga
                Carga carga2 = (Carga) dato;
                String[] id = {carga2.getIdCarga()};
                abrir();
                Cursor c2 = db.query("carga", null, "idCarga = ?", id, null, null, null);
                if(c2.moveToFirst()){ //Se encontro Tipo de Carga
                    return true; }
            }
            case 19: { // Verifica que al insertar Usuario no exista
                Usuario usuario = (Usuario) dato;
                String[] us = {usuario.getUsuario()}; //Verifica que exista ciclo

                abrir();
                Cursor cur = db.query("usuario", null, "usuario = ?", us, null, null, null);

                if(cur.moveToFirst()){ //Se encontraron datos ||
                    return true;
                } return false;
            }

            case 20: { //Elimina
                Usuario usuario = (Usuario)dato;
                String[] idm = {String.valueOf(usuario.getIdUsuario())};
                abrir();
                Cursor cm = db.query("usuario", null, "idUsuario = ?", idm, null,
                        null, null);
                if(cm.moveToFirst()){
                    //Se encontro Materia

                    return true;
                }
                else return false;
            }
            case 22:
            {
                Laboratorio laboratorio=(Laboratorio)dato;
                String[] id1={String.valueOf(laboratorio.getIdTipoComputo())};
                abrir();
                Cursor cursor1=db.query("tipoComputo",null,"idTipoComputo = ?",id1,null,null,null);
                if(cursor1.moveToFirst()){
                    return true;
                }
                return false;
            }
            case 23:
            {
                //Verificar que al Actualizar  dia exista
                Laboratorio laboratorio2=(Laboratorio)dato;
                String[] ids={String.valueOf(laboratorio2.getIdTipoComputo()),laboratorio2.getCodLaboratorio()};
                abrir();
                Cursor c=db.query("laboratorio",null,"idTipoComputo = ? AND codLaboratorio",ids,null,null,null);
                if(c.moveToFirst()){
                    return true;
                }
                return false;
            }

            case 24:
            {        //Dia   Reservacion
                Dia dia =(Dia)dato;
                Cursor c=db.query(true,"reservacion",new String[]{"idDia"},"idDia = "+dia.getIdDia(),null,null,null,null,null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;

            }
            case 25: //Era el 5
                //Verificar que exista horario
            {
                Dia dia2=(Dia)dato;
                String[] id={String.valueOf(dia2.getIdDia())};
                abrir();
                Cursor c2 = db.query("dia",null,"idDia = ?",id,null,null,null);
                if(c2.moveToFirst()){
                    return true;
                }
                return true;
            }




            default:
                return false; }

    }

    public  String llenarBDReservacionLab(){

        //variables para asignatura VA
        final String[] VAcodigo={"PRN115", "HDP115", "COS115", "MEP115","ANS115"};
        final String[] VAnombre={"Progamacion 1", "Herramientas de Producctividad", "Comunicaciones", "Metodos probabilisticos", "Analisis Numerico"};
        final Integer[] VAnumCiclo={01,02};

        //usuario
        final Integer[] VIdUsuario={1,2};
        final String[] VUsuario={"juan","Pedro"};
        final String[] VContrasenia={"juan","Pedro"};
        final Integer[] VidaccesoUsuario={0,1};

        //acesoUsuario
        final Integer[] VtipoUsuario={0,1};
        final String[] Vdescripcion={"admin","profesor"};

        //Variables para Ciclo VC
        final Integer[] VCidCiclo={1,2,3,4};
        final Integer[] VCnumCico={01,02};
        final Integer[] VCanio={2017, 2018};

        final  Integer[] VHidHorario={1,2,3,4,5,6,7,8};
        final  String[] VHhoraInicio={"6:20 AM","8:05 AM","9:50 AM","11:35 AM","1:20 PM","3:05 PM","4:50 PM","6:35 PM"};
        final  String[] VHhoraFin={"8:00 AM","9:45 AM","11:30 AM","1:15 PM","3:00 PM","4:45 PM","6:30 PM","8:15 PM"};

        final  Integer[] VDidDia={1,2,3,4,5};
        final  String[] VDnomDia={"lunes","martes","miercoles","jueves","viernes"};

        final String[] VLcodLaboratorio={"LCOM-1","LCOM-2","LCOM-3","LCOM-4"};
        final Integer[] VLidTipoComputo={1,2,3,4};
        final Integer[] VLplantaLaboratorio={1,1,1,2};
        final Integer[] VLcantidadEquiposLaboratorio={25,31,16,21};

        abrir();
        db.execSQL("DELETE FROM asignatura;");
        db.execSQL("DELETE FROM ciclo;");
        db.execSQL("DELETE FROM usuario;");

        db.execSQL("DELETE FROM horario");
        db.execSQL("DELETE FROM dia");
        db.execSQL("DELETE FROM laboratorio;");


        Asignatura asignatura = new Asignatura();
        for(int i=0; i<2; i++){
            asignatura.setCodigoAsignatura(VAcodigo[i]);
            asignatura.setNombreAsignatura(VAnombre[i]);
            asignatura.setIdCiclo(VAnumCiclo[i]);
            insertar(asignatura);
        }

        Ciclo ciclo = new Ciclo();
        for(int i=0; i<2; i++){
            ciclo.setIdCiclo(VCidCiclo[i]);
            ciclo.setNumCiclo(VCnumCico[i]);
            ciclo.setAnio(VCanio[i]);
            insertar(ciclo);
        }

        Usuario us = new Usuario();
        for(int i=0; i<1; i++){
            us.setIdUsuario(VIdUsuario[i]);
            us.setUsuario(VUsuario[i]);
            us.setContrasenia(VContrasenia[i]);
            us.setIdaccesoUsuario(VidaccesoUsuario[i]);
            insertar(us);
        }

        Horario horario=new Horario();
        for(int i=0;i<4;i++){
            horario.setIdHorario(VHidHorario[i]);
            horario.setHoraInicio(VHhoraInicio[i]);
            horario.setHoraFin(VHhoraFin[i]);
            insertar(horario);
        }

        Dia dia=new Dia();
        for(int i=0;i<5;i++){
            dia.setIdDia(VDidDia[i]);
            dia.setNomDia(VDnomDia[i]);
            insertar(dia);
        }

        Laboratorio laboratorio=new Laboratorio();
        for(int i=0;i<4;i++){
            laboratorio.setCodLaboratorio(VLcodLaboratorio[i]);
            laboratorio.setIdTipoComputo(VLidTipoComputo[i]);
            laboratorio.setPlantaLaboratorio(VLplantaLaboratorio[i]);
            laboratorio.setCantidadEquiposLaboratorio(VLcantidadEquiposLaboratorio[i]);
            insertar(laboratorio);
        }







        cerrar();
        return "Guardado correctamente";

    }
}








