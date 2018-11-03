package com.example.marta.act2ad.ConexionesBD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creación de bases de datos.
 * @author marta
 */
public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //Código SQL:
    private final String DATABASE_CREATE_EST = "CREATE TABLE estudiantes" +
            "(_id integer primary key autoincrement, edad int, curso int, nombre TEXT, ciclo TEXT, media DOUBLE);",
            DATABASE_CREATE_PROF = "CREATE TABLE profesores " +
                                    "(_id integer primary key autoincrement, edad int, nombre TEXT, ciclo TEXT, cursTutor TEXT," +
                                    "despacho TEXT);";

    /**
     * CONSTRUCTOR
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * CREA LAS TABLAS.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_EST);
        db.execSQL(DATABASE_CREATE_PROF);

    }

    /**
     * ACTUALIZA LAS TABLAS, SI EXISTE LA TABLA LA ELIMINA.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS estudiantes");
        db.execSQL("DROP TABLE IF EXISTS profesores");
        onCreate(db);
    }

}

