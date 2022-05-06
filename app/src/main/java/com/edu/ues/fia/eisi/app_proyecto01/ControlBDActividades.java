package com.edu.ues.fia.eisi.app_proyecto01;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDActividades {

    private static final String[] camposCarrera = new String[]
            {"IDCARRERA", "NOMBRE_ESCUELA"};


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public ControlBDActividades(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "CONTROLDEACTIVIDADES.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE carrera(IDCARRERA VARCHAR(30) NOT NULL PRIMARY KEY,NOMBRE_ESCUELA VARCHAR(30));");
                //  db.execSQL("CREATE TABLE materia(codmateria VARCHAR(6) NOT NULL PRIMARY KEY,nommateria VARCHAR(30),unidadesval VARCHAR(1));");
                //  db.execSQL("CREATE TABLE nota(carnet VARCHAR(7) NOT NULL ,codmateria VARCHAR(6) NOT NULL ,ciclo VARCHAR(5) ,notafinal REAL ,PRIMARY KEY(carnet,codmateria,ciclo));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

    //Insertado a la tabla
    public String insertar(Carrera carrera) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDCARRERA", carrera.getIDCARRERA());
        carr.put("NOMBRE_ESCUELA", carrera.getNOMBRECARRERA());

        contador=db.insert("carrera", null, carr);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

    }


    //Actualizado a la tabla

    public String actualizar(Carrera carrera) {
        return null;
    }

    //Eliminado de un tupla de la Tabla

    public String eliminar(Carrera carrera) {
        return null;
    }


    //Consultar a la tabla

    public Carrera consultarCarrera(String IDCARREA) {
        return null;
    }


/*    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
            case 1:
            {
        //verificar que al insertar nota exista carnet del alumno y el codigo de materia
                Nota nota = (Nota)dato;
                String[] id1 = {nota.getCarnet()};
                String[] id2 = {nota.getCodmateria()};
                //abrir();
                Cursor cursor1 = db.query("alumno", null, "carnet = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("materia", null, "codmateria = ?", id2,
                        null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
                //verificar que al modificar nota exista carnet del alumno, el codigo de materia y el ciclo
                Nota nota1 = (Nota)dato;
                String[] ids = {nota1.getCarnet(), nota1.getCodmateria(),
                        nota1.getCiclo()};
                abrir();
                Cursor c = db.query("nota", null, "carnet = ? AND codmateria = ? AND
                        ciclo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                        //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                Alumno alumno = (Alumno)dato;
                Cursor c=db.query(true, "nota", new String[] {"carnet" }, "carnet='"+alumno.getCarnet()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {
                Materia materia = (Materia)dato;
                Cursor cmat=db.query(true, "nota", new String[] {
                                "codmateria" },
                        "codmateria='"+materia.getCodmateria()+"'",null, null, null, null, null);
                if(cmat.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 5:
            {
                //verificar que exista alumno
                Alumno alumno2 = (Alumno)dato;
                String[] id = {alumno2.getCarnet()};
                abrir();
                Cursor c2 = db.query("alumno", null, "carnet = ?", id, null, null,
                        null);
                if(c2.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 6:
            {
                    //verificar que exista Materia
                Materia materia2 = (Materia)dato;
                String[] idm = {materia2.getCodmateria()};
                abrir();
                Cursor cm = db.query("materia", null, "codmateria = ?", idm, null,
                        null, null);
                if(cm.moveToFirst()){
                    //Se encontro Materia
                    return true;
                }
                return false;
            }
            default:
                return false;
        }


    }*/

    public String llenarBDActividad() {
        final String[] IdCarrera = {"I10515", "A10507", "I10501", "I10502","I10503","I10504","I10511"};
        final String[] NombreCarrera = {"Ingenieria Sistemas Informaticos", "ARQUITECTURA", "INGENIERIA CIVIL",
                "INGENIERIA INDUSTRIAL", "INGENIERIA MECANICA","INGENIERIA ELECTRICA", "INGENIERIA DE QUIMICA Y ALIMENTOS"};

        abrir();
        db.execSQL("DELETE FROM CARRERA");

        Carrera carrera = new Carrera();
        for(int i=0;i<7;i++){
            carrera.setIDCARRERA(IdCarrera[i]);
            carrera.setNOMBRECARRERA(NombreCarrera[i]);
            insertar(carrera);
        }

        cerrar();
        return "Guardo Correctamente";



    }
}
