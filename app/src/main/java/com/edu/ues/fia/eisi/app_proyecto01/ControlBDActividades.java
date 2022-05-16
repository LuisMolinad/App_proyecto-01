package com.edu.ues.fia.eisi.app_proyecto01;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDActividades {

    private static final String[] camposCarrera = new String[]
            {"IDCARRERA", "NOMBRECARRERA"};
    private static final String[] campoEscuela = new String[]
            {"IDESCUELA ", "IDCARRERA","NOMBRE_ESCUELA"};
    private static final String[] campoMateria = new String[]
            {"IDASIGNATURA","IDESCUELA", "UNIVALORATIVAS","NOMBREASIGNATURA"};
    //TODO: insertar los valores de tabla materia

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public ControlBDActividades(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }



    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "CONTROLDEACTIVIDADES.s3db";
        private static final int VERSION = 2;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE carrera(IDCARRERA VARCHAR(30) NOT NULL PRIMARY KEY,NOMBRECARRERA VARCHAR(30));");
                db.execSQL("CREATE TABLE escuela(IDESCUELA VARCHAR(20) NOT NULL PRIMARY KEY,IDCARRERA VARCHAR(30),NOMBRE_ESCUELA VARCHAR(50));");
                db.execSQL("CREATE TABLE materia(IDASIGNATURA VARCHAR(20) NOT NULL PRIMARY KEY,IDESCUELA VARCHAR(20),UNIVALORATIVAS INTEGER,NOMBREASIGNATURA VARCHAR(30));");
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
        carr.put("NOMBRECARRERA", carrera.getNOMBRECARRERA());

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

public String insertarEscuela (Escuela escuela){
    String regInsertados="Registro Insertado Nº= ";
    long contador=0;
    ContentValues carr = new ContentValues();
    carr.put("IDESCUELA", escuela.getIDESCUELA());
    carr.put("IDCARRERA", escuela.getIDCARRERA());
    carr.put("NOMBRE_ESCUELA", escuela.getNOMBRE_ESCUELA());

    contador=db.insert("escuela", null, carr);
    if(contador==-1 || contador==0)
    {
        regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
    }
    else {
        regInsertados=regInsertados+contador;
    }
    return regInsertados;

}

    public String insertarAsignatura (Materia materia){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDASIGNATURA", materia.getIDASIGNATURA());
        carr.put("IDESCUELA", materia.getIDESCUELA());
        carr.put("UNIVALORATIVAS", materia.getUNIDADESVALORATIVAS());
        carr.put("NOMBREASIGNATURA", materia.getNOMBREMATERIA());

        contador=db.insert("materia", null, carr);
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

    public String actualizarCarrera(Carrera carrera) {
       // if(verificarIntegridad(alumno, 5)){
            String[] id = {carrera.getIDCARRERA()};
            ContentValues cv = new ContentValues();
            cv.put("NOMBRECARRERA", carrera.getNOMBRECARRERA());
            db.update("carrera", cv, "IDCARRERA = ?", id);
            return "Registro Actualizado Correctamente";


    }

    public String actualizarEscuela(Escuela escuela) {
         if(verificarIntegridad(escuela, 5)) {
             String[] id = {escuela.getIDESCUELA()};
             ContentValues cv = new ContentValues();
             cv.put("IDCARRERA", escuela.getIDCARRERA());
             cv.put("NOMBRE_ESCUELA", escuela.getNOMBRE_ESCUELA());
             db.update("escuela", cv, "IDESCUELA = ? ", id);
             return "Registro Actualizado Correctamente";
         }else {
             return "Registro no existe ";
         }


    }

    //Eliminado de un tupla de la Tabla

    public String eliminar(Carrera carrera) {
        String regAfectados="filas afectadas= ";
        int contador=0;
       // if (verificarIntegridad(alumno,3)) {
        ///    contador+=db.delete("nota", "carnet='"+alumno.getCarnet()+"'", null);
      //  }
        contador+=db.delete("carrera", "IDCARRERA='"+carrera.getIDCARRERA()+"'", null);
        regAfectados+=contador;
        return regAfectados;

    }
    public String eliminarEscuela(Escuela escuela) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        // if (verificarIntegridad(alumno,3)) {
        ///    contador+=db.delete("nota", "carnet='"+alumno.getCarnet()+"'", null);
        //  }
        contador+=db.delete("escuela", "IDESCUELA='"+escuela.getIDESCUELA()+"'", null);
        regAfectados+=contador;
        return regAfectados;

    }


    //Consultar a la tabla

    public Carrera consultarCarrera(String IDCARRERA) {
        String[] id = {IDCARRERA};
        Cursor cursor = db.query("carrera", camposCarrera, "IDCARRERA = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Carrera carrera = new Carrera();
            carrera.setIDCARRERA(cursor.getString(0));
            carrera.setNOMBRECARRERA(cursor.getString(1));
            return carrera;
        }else{
            return null;
        }
    }
    public Cursor getAllValuesIdCARRERA() {

        return db.query("Carrera", new String[]{"IDCARRERA"},null , null, null, null, null);
    }

    public Escuela consultarEscuela(String IDESCUELA) {
        String[] id = {IDESCUELA};
        Cursor cursor = db.query("escuela", campoEscuela, "IDESCUELA = ? ", id, null, null, null);
        if(cursor.moveToFirst()){
            Escuela escuela = new Escuela();
            escuela.setIDCARRERA(cursor.getString(1));
            escuela.setNOMBRE_ESCUELA(cursor.getString(2));
            return escuela;
        }else{
            return null;
        }
    }
    public Cursor getAllValuesIdEscuela() {

        return db.query("escuela", new String[]{"IDESCUELA"},null , null, null, null, null);
    }

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
         /*   case 1:
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
            }*/
            case 5:
            {
                //verificar que exista alumno
                Escuela escuela = (Escuela) dato;
                String[] id = {escuela.getIDESCUELA()};
                String[] id2 = {escuela.getIDCARRERA()};
                abrir();
                Cursor c2 = db.query("escuela", null, "IDESCUELA = ?", id, null, null,
                        null);
                Cursor c3 = db.query("carrera", null, "IDCARRERA = ?", id2, null, null,
                        null);
                if(c2.moveToFirst() && c3.moveToFirst()){
                    //Se encontro fk y pk existentes
                    return true;
                }
                return false;
            }
     /*       case 6:
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
            }*/
            default:
                return false;
        }


    }

    public String llenarBDActividad() {
        //tabla carrera
        final String[] IdCarrera = {"I10515", "A10507", "I10501", "I10502","I10503","I10504","I10511"};
        final String[] NombreCarrera = {"Ingenieria Sistemas Informaticos", "ARQUITECTURA", "INGENIERIA CIVIL",
                "INGENIERIA INDUSTRIAL", "INGENIERIA MECANICA","INGENIERIA ELECTRICA", "INGENIERIA DE QUIMICA Y ALIMENTOS"};

        //TABLA ESCUELA
        final String [] idEscuela = {"EII","EIM","EIQA","EISI","EA","EIC","EIE"};
        final String [] nombreEscuela = {"ESCUELA DE INGENIERIA INDUSTRIAL","ESCUELA DE INGENIERIA MECANICA",
                "ESCUELA DE INGENIERIA QUIMICA Y ALIMENTOS","ESCUELA DE INGENIERIA DE SISTEMAS INFORMATICOS","ESCUELA DE ARQUITECTURA",
                "ESCUELA DE INGENIERIA CIVIL","ESCUELA DE INGENIERIA ELECTRICA"};

        //Tabla MATERIA
        final String [] idAsignatura = {"IAI115","PRN115","PRN215","PRN315","HDP115","ARC15","SIO"};
        final String [] idEscuelaM = {"EISI","EISI","EISI","EISI","EISI","EISI","EISI"};
        final Integer [] uniVal = {4,4,4,4,4,4,4};
        final String [] nombreAsgnatura = {"INTRODUCCION A LA INFORMATICA","PROGRAMACION I","PROGRAMACION II",
                "PROGRAMACION II","HERRAMIENTAS DE PRODUCTIVIDAD","ARQUITECTURA DE LA COMPUTACIÓN","SISTEMAS OPERATIVOS"};


        abrir();
        db.execSQL("DELETE FROM CARRERA");

        Carrera carrera = new Carrera();
        for(int i=0;i<7;i++){
            carrera.setIDCARRERA(IdCarrera[i]);
            carrera.setNOMBRECARRERA(NombreCarrera[i]);
            insertar(carrera);
        }
        Escuela escuela = new Escuela();
        for(int i=0;i<7;i++){
            escuela.setIDESCUELA(idEscuela[i]);
            escuela.setIDCARRERA(IdCarrera[i]);
            escuela.setNOMBRE_ESCUELA(nombreEscuela[i]);

            insertarEscuela(escuela);
        }

        Materia materia = new Materia();
        for(int i=0;i<7;i++){
            materia.setIDASIGNATURA(idAsignatura[i]);
            materia.setIDESCUELA(idEscuelaM[i]);
            materia.setUNIDADESVALORATIVAS(uniVal[i]);
            materia.setNOMBREASIGNATURA(nombreAsgnatura[i]);
            insertarAsignatura(materia);
        }
        cerrar();
        return "Guardo Correctamente";



    }
}
