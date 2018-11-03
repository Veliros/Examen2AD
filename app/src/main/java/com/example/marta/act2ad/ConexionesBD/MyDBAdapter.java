package com.example.marta.act2ad.ConexionesBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.marta.act2ad.ConexionesBD.ConexionSQLiteHelper;

import java.util.ArrayList;

/**
 * @author marta
 */
public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbescuela.db";
    private static final String DATABASE_TABLE_PROF = "profesores";
    private static final String DATABASE_TABLE_EST = "estudiantes";
    private static final int DATABASE_VERSION = 1;

    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String TUTOR = "tutor";
    private static final String DESPACHO = "despacho";
    private static final String CURSO = "curso";
    private static final String NOTA = "media";

    private static final String DATABASE_CREATE_PROFESORES = "CREATE TABLE " + DATABASE_TABLE_PROF +
            " (_id integer primary key autoincrement, nombre text, edad text, ciclo text, tutor text, " +
            "despacho text);";
    private static final String DATABASE_DROP_PROFESORES = "DROP TABLE IF EXISTS "
            + DATABASE_CREATE_PROFESORES + ";";

    private static final String DATABASE_CREATE_ALUMNOS = "CREATE TABLE " + DATABASE_TABLE_EST +
            " (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, " +
            "media text);";
    private static final String DATABASE_DROP_ALUMNOS = "DROP TABLE IF EXISTS " + DATABASE_CREATE_ALUMNOS
            + ";";


    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private ConexionSQLiteHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    /**
     *
     * @param c
     */
    public MyDBAdapter(Context c) {
        context = c;
        dbHelper = new ConexionSQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * ABRIR BASE DE DATOS.
     */
    public void open() {
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = dbHelper.getReadableDatabase();
        }

    }

    /**
     * CREAR PROFESOR
     * @param nomProf
     * @param edadProf
     * @param cicloProf
     * @param tutCurs
     * @param despProf
     */
    public void insertarProfesor(String nomProf, String edadProf, String cicloProf, String tutCurs, String despProf) {
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Inserta los valores.
        newValues.put(EDAD, edadProf);
        newValues.put(NOMBRE, nomProf);
        newValues.put(CICLO, cicloProf);
        newValues.put(TUTOR, tutCurs);
        newValues.put(DESPACHO, despProf);
        db.insert(DATABASE_TABLE_PROF, null, newValues);
    }

    /**
     * CREAR ESTUDIANTE
     * @param nomEst
     * @param edadEst
     * @param cicloEst
     * @param cursoEst
     * @param notaEst
     */
    public void insertarEstudiante(String nomEst, String edadEst, String cicloEst, String cursoEst, String notaEst) {
        //Nuevo registro:
        ContentValues newValues = new ContentValues();

        //Insertamos los valores de los campos:
        newValues.put(NOMBRE, nomEst);
        newValues.put(EDAD, edadEst);
        newValues.put(CICLO, cicloEst);
        newValues.put(CURSO, cursoEst);
        newValues.put(NOTA, notaEst);
        db.insert(DATABASE_TABLE_EST, null, newValues);
    }


    /**
     *
     * @return estudiantes
     */
    public ArrayList<String> recuperarEst(){
        ArrayList<String> estudiantes = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_EST,null,null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                estudiantes.add(cursor.getString(1)+" "+cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return estudiantes;
    }

    /**
     *
     * @return profes
     */
    public ArrayList<String> recuperarProf(){
        ArrayList<String> profes = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_PROF,null,null,null,null,
                null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                profes.add(cursor.getString(1)+" "+cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return profes;
    }

    public ArrayList<String> recuperarCiclo(){
        ArrayList<String> estudiantes = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_EST,null,null,null,
                "ciclo",null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                estudiantes.add(cursor.getString(1)+" "+cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return estudiantes;
    }

    public ArrayList<String> recuperarCurso(){
        ArrayList<String> estudiantes = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_EST,null,null,null,
                "curso",null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                estudiantes.add(cursor.getString(1)+" "+cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return estudiantes;
    }

}
