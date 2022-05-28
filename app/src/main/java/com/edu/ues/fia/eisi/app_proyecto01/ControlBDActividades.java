package com.edu.ues.fia.eisi.app_proyecto01;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

public class ControlBDActividades {

    private static final String[] camposCarrera = new String[]
            {"IDCARRERA", "NOMBRECARRERA"};
    private static final String[] campoEscuela = new String[]
            {"IDESCUELA ", "IDCARRERA","NOMBRE_ESCUELA"};
    private static final String[] campoMateria = new String[]
            {"IDASIGNATURA","IDESCUELA", "UNIVALORATIVAS","NOMBREASIGNATURA"};
    /*  db.execSQL("CREATE TABLE usuario(IDUSUARIO VARCHAR(30) NOT NULL PRIMARY KEY,NOMUSUARIO VARCHAR(30),CLAVE CHAR(5),TIPOUSUARIO VARCHAR(30));"); */
    private static final String[] camposUsuario = new String[]
            {"IDUSUARIO","NOMUSUARIO", "CLAVE","TIPOUSUARIO"};
    private static final String[] camposAccesoUsuario = new String[]
            {"IDUSUARIO","IDOPCION"};

/*Katya*/

    private static final String[] campoEquipoDidactico = new String[]
            {"IDEQUIPO", "NOMBRE", "DESCRIPCIONEQUIPO"};
    private static final String[] campoListaEquipo = new String[]
            {"IDLISTAEQUIPO", "ID_DETALLE", "IDEQUIPO"};
    /*Rosalio*/
    private static final String[] campoMiembroUniversitario = new String[]
            {"IDMIEMBROUNIVERSITARIO", "IDASIGNATURA", "IDUSUARIO", "NOMBREMIEMBROUNIVERSITARIO", "TIPOMIEMBRO"};
    private static final String[] campoParticular = new String[]
            {"IDPARTICULAR", "IDUSUARIO", "NOMBREPARTICULAR", "APELLIDOPARTICULAR"};
    private static final String[] campoActividad = new String[]
            {"IDACTIVIDAD", "IDMIEMBROUNIVERSITARIO", "NOMBREACTIVIDAD", "FECHARESERVA", "DESDEACTIVIDAD", "HASTAACTIVIDAD", "APROBADO"};
    private static final String[] campoAsistencia = new String[]
            {"IDASISTENCIA", "ID_DETALLE", "IDMIEMBROUNIVERSITARIO", "CALIFICACION"};
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
        private static final int VERSION = 4;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE carrera(IDCARRERA VARCHAR(30) NOT NULL PRIMARY KEY,NOMBRECARRERA VARCHAR(30));");
                db.execSQL("CREATE TABLE escuela(IDESCUELA VARCHAR(20) NOT NULL PRIMARY KEY,IDCARRERA VARCHAR(30),NOMBRE_ESCUELA VARCHAR(50));");
                db.execSQL("CREATE TABLE materia(IDASIGNATURA VARCHAR(20) NOT NULL PRIMARY KEY,IDESCUELA VARCHAR(20),UNIVALORATIVAS INTEGER,NOMBREASIGNATURA VARCHAR(30));");
                //tablas de usuario
                db.execSQL("CREATE TABLE usuario(IDUSUARIO VARCHAR(30) NOT NULL PRIMARY KEY,NOMUSUARIO VARCHAR(30),CLAVE CHAR(5),TIPOUSUARIO VARCHAR(30));");
                db.execSQL("CREATE TABLE opcioncrud(IDOPCION VARCHAR(20) NOT NULL PRIMARY KEY,DESOPCION VARCHAR(30),NUMCRUD INTEGER);");
                db.execSQL("CREATE TABLE accesoUsuario(IDUSUARIO VARCHAR(30),IDOPCION VARCHAR(30),primary key (IDUSUARIO, IDOPCION));");
                //  db.execSQL("CREATE TABLE nota(carnet VARCHAR(7) NOT NULL ,codmateria VARCHAR(6) NOT NULL ,ciclo VARCHAR(5) ,notafinal REAL ,PRIMARY KEY(carnet,codmateria,ciclo));");

                //Tablas Katya

                /*==============================================================*/
                /* Table: EQUIPODIDACTICO                                       */
                /*==============================================================*/
                db.execSQL("create table EQUIPODIDACTICO  (\n" +
                        "   IDEQUIPO             VARCHAR2(30)                    not null,\n" +
                        "   NOMBRE               VARCHAR2(30)                    not null,\n" +
                        "   DESCRIPCIONEQUIPO    VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_EQUIPODIDACTICO primary key (IDEQUIPO)\n" +
                        ");\n");

                /*==============================================================*/
                /* Table: LISTAEQUIPO                                           */
                /*==============================================================*/

                db.execSQL("create table LISTAEQUIPO  (\n" +
                        "   IDLISTAEQUIPO        INTEGER                         not null,\n" +
                        "   ID_DETALLE           INTEGER,\n" +
                        "   IDEQUIPO             VARCHAR2(30),\n" +
                        "   constraint PK_LISTAEQUIPO primary key (IDLISTAEQUIPO)\n" +
                        ");\n");

                /*==============================================================*/
                /* Table: DETALLEACTIVIDAD                                      */
                /*==============================================================*/
                db.execSQL("create table DETALLEACTIVIDAD  (\n" +
                        "   ID_DETALLE           INTEGER                         not null,\n" +
                        "   GRUPO                INTEGER,\n" +
                        "   IDACTIVIDAD          VARCHAR2(30),\n" +
                        "   IDLOCAL              VARCHAR2(20),\n" +
                        "   DESCRIPCIONACTIVIDAD VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_DETALLEACTIVIDAD primary key (ID_DETALLE)\n" +
                        ");\n");





                //Tablas Rosalio
                /*==============================================================*/
                /* Table: MIEMBROS UNIVERSITARIOS                               */
                /*==============================================================*/
                db.execSQL("create table MIEMBROUNVERSITARIOS  (\n" +
                        "   IDMIEMBROUNIVERSITARIO VARCHAR2(30)                    not null,\n" +
                        "   IDASIGNATURA         VARCHAR2(20),\n" +
                        "   IDUSUARIO            VARCHAR2(30),\n" +
                        "   NOMBREMIEMBROUNIVERSITARIO VARCHAR2(50)                    not null,\n" +
                        "   TIPOMIEMBRO          VARCHAR2(10)                    not null,\n" +
                        "   primary key (IDMIEMBROUNIVERSITARIO)\n" +
                        ");\n");
                /*==============================================================*/
                /* Table: PARTICULAR                                            */
                /*==============================================================*/
                db.execSQL("create table PARTICULAR  (\n" +
                        "   IDPARTICULAR         VARCHAR2(20)                    not null,\n" +
                        "   IDUSUARIO            VARCHAR2(30),\n" +
                        "   NOMBREPARTICULAR     VARCHAR2(50)                    not null,\n" +
                        "   APELLIDOPARTICULAR   VARCHAR2(15)                    not null,\n" +
                        "   constraint PK_PARTICULAR primary key (IDPARTICULAR)\n" +
                        ");\n");
                /*==============================================================*/
                /* Table: ACTIVIDAD                                             */
                /*==============================================================*/
                db.execSQL("create table ACTIVIDAD  (\n" +
                        "   IDACTIVIDAD          VARCHAR2(30)                    not null,\n" +
                        "   IDMIEMBROUNIVERSITARIO VARCHAR2(30),\n" +
                        "   NOMBREACTIVIDAD      VARCHAR2(30)                    not null,\n" +
                        "   FECHARESERVA         VARCHAR2(15)                    not null,\n" +
                        "   DESDEACTIVIDAD       VARCHAR2(15)                    not null,\n" +
                        "   HASTAACTIVIDAD       VARCHAR2(15)                    not null,\n" +
                        "   APROBADO             VARCHAR2(2)                     not null,\n" +
                        "   constraint PK_ACTIVIDAD primary key (IDACTIVIDAD)\n" +
                        ");\n");
                /*==============================================================*/
                /* Table: ASISTENCIA                                            */
                /*==============================================================*/
                db.execSQL("create table ASISTENCIA  (\n" +
                        "   IDASISTENCIA         VARCHAR2(20)                    not null,\n" +
                        "   ID_DETALLE           INTEGER,\n" +
                        "   IDMIEMBROUNIVERSITARIO VARCHAR2(30),\n" +
                        "   CALIFICACION         INTEGER,\n" +
                        "   constraint PK_ASISTENCIA primary key (IDASISTENCIA)\n" +
                        ");\n");


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


    /*Verificar integridad*/
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
            case 1: {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                Cursor c = db.query(true, "MIEMBROUNVERSITARIOS", new String[]{"IDMIEMBROUNIVERSITARIO"}, "IDMIEMBROUNIVERSITARIO='" + miembroUniversitario.getIdMiembroUniversitario() + "'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 2: {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                String[] id = {miembroUniversitario.getIdMiembroUniversitario()};

                abrir();
                Cursor c = db.query("MIEMBROUNIVERSITARIOS", null, "IDMIEMBROUNIVERSITARIO = ?", id, null, null, null);
                if (c.moveToFirst()) {
                    //Se encontro fk y pk existentes
                    return true;
                } else {
                    return false;
                }
            }
            case 3: {
                Materia materia = (Materia) dato;
                Cursor c = db.query(true, "materia", new String[]{"IDASIGNATURA"}, "IDASIGNATURA='" + materia.getIDASIGNATURA() + "'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4: {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                String[] id2 = {miembroUniversitario.getIdUsuario()};
                String[] id3 = {miembroUniversitario.getIdAsignatura()};

                abrir();
                Cursor c2 = db.query("USUARIO", null, "IDUSUARIO = ?", id2, null, null, null);
                Cursor c3 = db.query("MATERIA", null, "IDASIGNATURA = ?", id3, null, null, null);

                if (c2.moveToFirst() && c3.moveToFirst()) {
                    //Se encontro fk y pk existentes
                    return true;
                }
                return false;
            }
            case 5: {
                //verificar que exista escuela y carrera
                Escuela escuela = (Escuela) dato;
                String[] id = {escuela.getIDESCUELA()};
                String[] id2 = {escuela.getIDCARRERA()};
                abrir();
                Cursor c2 = db.query("escuela", null, "IDESCUELA = ?", id, null, null,
                        null);
                Cursor c3 = db.query("carrera", null, "IDCARRERA = ?", id2, null, null,
                        null);
                if (c2.moveToFirst() && c3.moveToFirst()) {
                    //Se encontro fk y pk existentes
                    return true;
                }
                return false;
            }
            case 6: {
                //verificar que exista escuela y carrera
                Materia materia = (Materia) dato;
                String[] id4 = {materia.getIDASIGNATURA()};
                String[] id3 = {materia.getIDESCUELA()};
                abrir();
                Cursor c2 = db.query("materia", null, "IDASIGNATURA = ?", id4, null, null,
                        null);
                Cursor c3 = db.query("escuela", null, "IDESCUELA = ?", id3, null, null,
                        null);
                if (c2.moveToFirst() && c3.moveToFirst()) {
                    //Se encontro fk y pk existentes
                    return true;
                }
                return false;
            }

            /*Rosalio*/
            //Insertar
            case 20: {
                Particular particular = (Particular) dato;
                String[] id = {particular.getIDPUSUARIO()};
                abrir();
                Cursor c = db.query("USUARIO", null, "IDUSUARIO = ?", id, null, null, null);
                if (c.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Eliminar particular
            case 21:{
                Particular particular = (Particular) dato;
                Cursor c = db.query(true, "PARTICULAR", new String[]{"IDPARTICULAR"}, "IDPARTICULAR = '" + particular.getIDPARTICULAR() + "' ", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            //Insertar actividad
            case 22:{
                Actividad actividad = (Actividad) dato;
                String[] id = {actividad.getIdMiembroUniversitario()};
                abrir();
                Cursor c = db.query("MIEMBROUNVERSITARIOS", null, "IDMIEMBROUNIVERSITARIO = ?", id,null, null, null);
                if (c.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Eliminar actividad
            case 23:{
                Actividad actividad = (Actividad) dato;
                Cursor c = db.query("ACTIVIDAD", new String[]{"IDACTIVIDAD"}, "IDACTIVIDAD = '" + actividad.getIdActividad() + "'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            //Insertar asistencia
            case 24:{
                Asistencia asistencia = (Asistencia) dato;
                String[] id = {asistencia.getIdMiembroUniversitario()};
                abrir();
                Cursor c = db.query("MIEMBROUNVERSITARIOS", null, "IDMIEMBROUNIVERSITARIO = ?", id,null, null, null);
                if (c.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Eliminar asistencia
            case 25:{
                Asistencia asistencia = (Asistencia) dato;
                Cursor c = db.query(true, "ASISTENCIA", new String[]{"IDASISTENCIA"}, "IDASISTENCIA = '" + asistencia.getIdAsistencia() + "' ", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            //Katya
            //Insertar ListaEquipo
            case 30:{
                ListaEquipo listaequipo = (ListaEquipo) dato;
                String[] id = {Integer.toString(listaequipo.getID_DETALLE())};
                String[] id2 = {listaequipo.getIDEQUIPO()};
                abrir();
                Cursor c = db.query("DETALLEACTIVIDAD", null, "ID_DETALLE = ?", id,null, null, null);
                Cursor c2 = db.query("EQUIPODIDACTICO", null, "IDEQUIPO = ?", id2,null, null, null);
                if (c.moveToFirst()&& c2.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Actualizar
            case 33:{
                ListaEquipo listaequipo = (ListaEquipo) dato;
                String[] id = {Integer.toString(listaequipo.getID_DETALLE())};
                String[] id2 = {listaequipo.getIDEQUIPO()};
                abrir();
                Cursor c = db.query("DETALLEACTIVIDAD", null, "ID_DETALLE = ?", id,null, null, null);
                Cursor c2 = db.query("EQUIPODIDACTICO", null, "IDEQUIPO = ?", id2,null, null, null);
                if (c.moveToFirst()&& c2.moveToFirst()) {
                    return true;
                }
                return false;
            }



            case 35: {
                ListaEquipo listaequipo = (ListaEquipo) dato;
                Cursor c = db.query(true, "LISTAEQUIPO", new String[]{"IDLISTAEQUIPO"}, "IDLISTAEQUIPO='" + listaequipo.getIDLISTAEQUIPO() + "'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }


            //Insertar DetalleActividad
            case 40:{
                DetalleActividad detalleactividad = (DetalleActividad) dato;

         //     String[] id = {Integer.toString(detalleactividad.getGRUPO())};
                String[] id2 = {detalleactividad.getIDACTIVIDAD()};
         //     String[] id3 = {detalleactividad.getIDLOCAL()};
                abrir();
          //    Cursor c = db.query("DETALLEOFERTA", null, "GRUPO = ?", id,null, null, null);
                Cursor c2 = db.query("ACTIVIDAD", null, "IDACTIVIDAD = ?", id2,null, null, null);
          //    Cursor c3 = db.query("LOCAL", null, "IDLOCAL = ?", id3,null, null, null);

            //c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()
                if ( c2.moveToFirst()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /*LLenar base de datos */
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


        //tabla Usuario
        final String [] IDUSUARIO = {"01","02","03","04","05","06"};
        final String [] NOMUSUARIO = {"Luis","Katya","Rosalio","Vladimir","Andres","Alfredo"};
        final String [] CLAVE = {"PDM115","PDM115","PDM115","PDM115","PDM115","PDM115"};
        final String [] TIPOUSUARIO = {"ADMIN","PARTICULAR","ESTUDIANTE","COORDINADOR CATEDRA","AUXILIAR","DOCENTE","DEFAULT"};
        //tabla opcioncrud
        final String [] IDOPCION = {"0100","0200","0300","0400","0500","0600"};
        final String [] DESOPCION = {"Vistas administrador","Vistas Particular","Vistas estudiantes",
                "Vistas coordinadodr de catedra","Vistas de auxiliar","DOCENTE","DEFAULT"};
        final String [] NUMCRUD = {"1","2","3","4","5","6"};
        abrir();

        db.execSQL("DELETE FROM CARRERA");
        db.execSQL("DELETE FROM escuela");
        db.execSQL("DELETE FROM materia");
        db.execSQL("DELETE FROM usuario");
        db.execSQL("DELETE FROM accesoUSUARIO");
        db.execSQL("DELETE FROM opcioncrud");

//Llenao de usuario, opcion crud y acceso usuario
        USUARIO usuario = new USUARIO();
        for(int i=0;i<6;i++){
            usuario.setIDUSUARIO(IDUSUARIO[i]);
            usuario.setCLAVE(CLAVE[i]);
            usuario.setNOMUSUARIO(NOMUSUARIO[i]);
            usuario.setTIPOUSUARIO(TIPOUSUARIO[i]);
            insertarUsuario(usuario);
        }

        OPCIONCRUD opcioncrud = new OPCIONCRUD();
        for(int i=0;i<6;i++){
            opcioncrud.setIDOPCION(IDOPCION[i]);
            opcioncrud.setDESOPCION(DESOPCION[i]);
            opcioncrud.setNUMCRUD(NUMCRUD[i]);
            insertarOPCIONCRUD(opcioncrud);
        }
        ACCESOUSUARIO accesousuario = new ACCESOUSUARIO();
        for(int i=0;i<6;i++){
            accesousuario.setIDOPCION(IDOPCION[i]);
            accesousuario.setIDUSUARIO(IDUSUARIO[i]);

            insertarACCESOUSUARIO(accesousuario);
        }




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
    public String insertarUsuario (USUARIO usuario){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDUSUARIO", usuario.getIDUSUARIO());
        carr.put("CLAVE", usuario.getCLAVE());
        carr.put("NOMUSUARIO", usuario.getNOMUSUARIO());
        carr.put("TIPOUSUARIO", usuario.getTIPOUSUARIO());

        contador=db.insert("usuario", null, carr);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

    }

    public USUARIO consultarUsuario(String NOMUSUARIO) {
        String[] id = {NOMUSUARIO};
        /*  db.execSQL("CREATE TABLE usuario(IDUSUARIO VARCHAR(30) NOT NULL PRIMARY KEY,NOMUSUARIO VARCHAR(30),CLAVE CHAR(5),TIPOUSUARIO VARCHAR(30));"); */
        Cursor cursor = db.query("USUARIO", camposUsuario, "NOMUSUARIO = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            USUARIO usuario = new USUARIO();
            usuario.setIDUSUARIO(cursor.getString(0));
            usuario.setNOMUSUARIO(cursor.getString(1));
            usuario.setCLAVE(cursor.getString(2));
            usuario.setTIPOUSUARIO(cursor.getString(3));

            return usuario;
        }else{
            return null;
        }
    }
    public String insertarACCESOUSUARIO (ACCESOUSUARIO accesousuario){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDUSUARIO", accesousuario.getIDUSUARIO());
        carr.put("IDOPCION", accesousuario.getIDOPCION());
        contador=db.insert("accesoUsuario", null, carr);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

    }
    public ACCESOUSUARIO consultarACCESOUSUARIO(String idUsuario) {
        String[] id = {idUsuario};
        /*  db.execSQL("CREATE TABLE usuario(IDUSUARIO VARCHAR(30) NOT NULL PRIMARY KEY,NOMUSUARIO VARCHAR(30),CLAVE CHAR(5),TIPOUSUARIO VARCHAR(30));"); */
        Cursor cursor = db.query("accesoUsuario", camposAccesoUsuario, "IDUSUARIO = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            ACCESOUSUARIO accesousuario = new ACCESOUSUARIO();
            accesousuario.setIDUSUARIO(cursor.getString(0));
            accesousuario.setIDOPCION(cursor.getString(1));

            return accesousuario;
        }else{
            return null;
        }
    }

    public String insertarOPCIONCRUD(OPCIONCRUD opcioncrud){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDOPCION", opcioncrud.getIDOPCION());
        carr.put("NUMCRUD", opcioncrud.getNUMCRUD());
        carr.put("DESOPCION", opcioncrud.getDESOPCION());
        contador=db.insert("opcioncrud", null, carr);
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
    public String actualizarMateria(Materia materia) {
        // if(verificarIntegridad(alumno, 5)){
        if(verificarIntegridad(materia, 6)) {
            String[] id = {materia.getIDASIGNATURA()};
            ContentValues cv = new ContentValues();
            cv.put("IDESCUELA", materia.getIDESCUELA());
            cv.put("UNIVALORATIVAS", materia.getUNIDADESVALORATIVAS());
            cv.put("NOMBREASIGNATURA", materia.getNOMBREMATERIA());
            db.update("materia", cv, "IDASIGNATURA = ?", id);
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
    public String eliminarMateria(Materia materia) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(materia,3)) {
          contador+=db.delete("materia", "IDASIGNATURA='"+materia.getIDASIGNATURA()+"'", null);
            regAfectados+=contador;
            return regAfectados;
       }
        else   {
            return "Registro no existe ";
        }
       // contador+=db.delete("materia", "IDASIGNATURA='"+materia.getIDASIGNATURA()+"'", null);

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

    public Materia consultarMateria(String IDASIGNATURA) {
        String[] id = {IDASIGNATURA};
        Cursor cursor = db.query("materia", campoMateria, "IDASIGNATURA = ? ", id, null, null, null);
        if(cursor.moveToFirst()){
            Materia materia = new Materia();
            materia.setIDESCUELA(cursor.getString(1));
            materia.setUNIDADESVALORATIVAS(Integer.valueOf(cursor.getString(2)));
            materia.setNOMBREASIGNATURA(cursor.getString(3));
            return materia;
        }else{
            return null;
        }
    }
    public Cursor getAllValuesIdAsignatura() {

        return db.query("materia", new String[]{"IDASIGNATURA"},null , null, null, null, null);
    }


    /*Rosalio parte*/
    /*==============================================================*/
    /* Table: MIEMBROS UNIVERSITARIOS CRUD                          */
    /*==============================================================*/

    public String insertarMiembroUniversitario(MiembroUniversitario miembroUniversitario){
        String regInsertados = "Registro Insertado Nº = ";

        long contador=0;

        ContentValues carr = new ContentValues();

        if(verificarIntegridad(miembroUniversitario, 4)){
            carr.put("IDMIEMBROUNIVERSITARIO", miembroUniversitario.getIdMiembroUniversitario());
            carr.put("IDASIGNATURA", miembroUniversitario.getIdAsignatura());
            carr.put("IDUSUARIO", miembroUniversitario.getIdUsuario());
            carr.put("NOMBREMIEMBROUNIVERSITARIO",miembroUniversitario.getNombreMiembroUniversitario());
            carr.put("TIPOMIEMBRO", miembroUniversitario.getTipoMiembro());

            contador = db.insert("MIEMBROUNVERSITARIOS", null, carr);

            if(contador == -1 || contador == 0){
                regInsertados = "Error al insertar el registro, o registro duplicado favor verifivar insercion";
            }
            else {
                regInsertados = regInsertados + contador;
            }

            return regInsertados;
        }
        else {
            return "Verificar los datos";
        }
    }

    public String actualizarMiembroUniversitario(MiembroUniversitario miembroUniversitario){
            String[] id = {miembroUniversitario.getIdMiembroUniversitario()};
            String regActualizados = "El total de registros actualizados es: ";

            ContentValues cv = new ContentValues();
            long contador = 0;

            if(verificarIntegridad(miembroUniversitario, 1)){
                cv.put("IDMIEMBROUNIVERSITARIO", miembroUniversitario.getIdMiembroUniversitario());
                cv.put("IDASIGNATURA", miembroUniversitario.getIdAsignatura());
                cv.put("IDUSUARIO", miembroUniversitario.getIdUsuario());
                cv.put("NOMBREMIEMBROUNIVERSITARIO", miembroUniversitario.getNombreMiembroUniversitario());
                cv.put("TIPOMIEMBRO", miembroUniversitario.getTipoMiembro());
                contador = db.update("MIEMBROUNVERSITARIOS", cv, "IDMIEMBROUNIVERSITARIO = ?", id);

                if(contador == -1 || contador == 0){
                    regActualizados = "Error al actualizar el registro, favor verifivar insercion";
                }
                else {
                    regActualizados = regActualizados + contador;
                }

                return regActualizados;
            }
            else {
                return "Registro no existe";
            }
    }

    public String eliminarMiembroUniversitario(MiembroUniversitario miembroUniversitario){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(miembroUniversitario,1)) {
            contador+=db.delete("MIEMBROUNVERSITARIOS", "IDMIEMBROUNIVERSITARIO='"+miembroUniversitario.getIdMiembroUniversitario()+"'", null);
            regAfectados+=contador;
            return regAfectados;
        }
        else   {
            return "Registro no existe ";
        }
    }

    public MiembroUniversitario consultarMiembroUniversitario(String idMiembroUniversitario){
        String[] id = {idMiembroUniversitario};

        Cursor cursor = db.query("MIEMBROUNVERSITARIOS", campoMiembroUniversitario, "IDMIEMBROUNIVERSITARIO = ? ", id, null, null, null);

        if(cursor.moveToFirst()){
            MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
            miembroUniversitario.setIdAsignatura(cursor.getString(1));
            miembroUniversitario.setIdUsuario(cursor.getString(2));
            miembroUniversitario.setNombreMiembroUniversitario(cursor.getString(3));
            miembroUniversitario.setTipoMiembro(cursor.getString(4));

            return miembroUniversitario;
        }
        else {
            return null;
        }
    }

    /*==============================================================*/
    /* Table: ACTIVIDAD CRUD                                        */
    /*==============================================================*/
    //Insertar
    public String insertarActividad(Actividad actividad){
        String regInsertados = "Registro Insertado Nº = ";

        long contador=0;

        ContentValues carr = new ContentValues();

        if(verificarIntegridad(actividad, 22)){
            carr.put("IDACTIVIDAD", actividad.getIdActividad());
            carr.put("IDMIEMBROUNIVERSITARIO", actividad.getIdMiembroUniversitario());
            carr.put("NOMBREACTIVIDAD", actividad.getNombreActividad());
            carr.put("FECHARESERVA",actividad.getFechaReserva());
            carr.put("DESDEACTIVIDAD", actividad.getDesdeActividad());
            carr.put("HASTAACTIVIDAD", actividad.getHastaActividad());
            carr.put("APROBADO", actividad.getAprobado());

            contador = db.insert("ACTIVIDAD", null, carr);

            if(contador == -1 || contador == 0){
                regInsertados = "Error al insertar el registro, o registro duplicado favor verifivar insercion";
            }
            else {
                regInsertados = regInsertados + contador;
            }

            return regInsertados;
        }
        else {
            return "Verificar los datos";
        }
    }

    public String actualizarActividad(Actividad actividad){
        String[] id = {actividad.getIdActividad()};
        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        long contador = 0;

        if(verificarIntegridad(actividad, 22)){
            cv.put("IDMIEMBROUNIVERSITARIO", actividad.getIdMiembroUniversitario());
            cv.put("NOMBREACTIVIDAD", actividad.getNombreActividad());
            cv.put("FECHARESERVA",actividad.getFechaReserva());
            cv.put("DESDEACTIVIDAD", actividad.getDesdeActividad());
            cv.put("HASTAACTIVIDAD", actividad.getHastaActividad());
            cv.put("APROBADO", actividad.getAprobado());

            contador = db.update("ACTIVIDAD", cv, "IDACTIVIDAD = ?",id);

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar el registro, favor verifivar insercion";
            }
            else {
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro";
        }
    }

    //Consultar
    public Actividad consultarActividad(String idActividad){
        String[] id = {idActividad};

        Cursor cursor = db.query("ACTIVIDAD",campoActividad, "IDACTIVIDAD = ?", id, null,null,null);

        if(cursor.moveToFirst()){
            Actividad actividad = new Actividad();
            actividad.setIdMiembroUniversitario(cursor.getString(1));
            actividad.setNombreActividad(cursor.getString(2));
            actividad.setFechaReserva(cursor.getString(3));
            actividad.setDesdeActividad(cursor.getString(4));
            actividad.setHastaActividad(cursor.getString(5));
            actividad.setAprobado(cursor.getString(6));

            return actividad;
        }

        return null;
    }

    public String eliminarActividad(Actividad actividad){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;

        if(verificarIntegridad(actividad, 23)){
            contador += db.delete("ACTIVIDAD", "IDACTIVIDAD = '" + actividad.getIdActividad() + "'" , null);
            regAfectados += contador;

            return regAfectados;
        }
        else {
            return "No se encontreo el registro";
        }

    }

    /*==============================================================*/
    /* Table: CRUD PARTICULAR                                       */
    /*==============================================================*/
    /*Insertar*/

    public String insertarParticular(Particular particular){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        if(verificarIntegridad(particular, 20)){
            cv.put("IDPARTICULAR", particular.getIDPARTICULAR());
            cv.put("IDUSUARIO", particular.getIDPUSUARIO());
            cv.put("NOMBREPARTICULAR ", particular.getNOMBREPARTICULAR());
            cv.put("APELLIDOPARTICULAR", particular.getAPELLIDOPARTICULAR());

            contador = db.insert("PARTICULAR", null, cv);
            if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar el registro, el registro esta duplicado o algo, por favor revisar el dato que ud quiere insertar";
            }
            else {
                regInsertados = regInsertados + contador;
            }
            return  regInsertados;
        }
        else {
            return  "Error verificar datos";
        }
    }

    /*Consultar*/
    public Particular consultarParticular(String idParticular){
        String[] id = {idParticular};

        Cursor cursor = db.query("PARTICULAR", campoParticular, "IDPARTICULAR = ?", id,null,null,null);

        if(cursor.moveToFirst()){
            Particular particular = new Particular();
            particular.setIDPUSUARIO(cursor.getString(1));
            particular.setNOMBREPARTICULAR(cursor.getString(2));
            particular.setAPELLIDOPARTICULAR(cursor.getString(3));

            return particular;
        }
        return null;
    }

    /*Eliminar*/
    public String eliminarParticular(Particular particular){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;


        if(verificarIntegridad(particular, 21)){
            contador += db.delete("PARTICULAR", "IDPARTICULAR = '" + particular.getIDPARTICULAR().toString() + "' ",null);
            regAfectados += contador;

            return regAfectados;
        }
        else{
            return "No se encontro el registro";
        }
    }

    /*Actualizar*/
    public String actualizarParticular(Particular particular){
        String[] id = {particular.getIDPARTICULAR()};
        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(particular, 20)){
            cv.put("IDPARTICULAR", particular.getIDPARTICULAR());
            cv.put("IDUSUARIO", particular.getIDPUSUARIO());
            cv.put("NOMBREPARTICULAR", particular.getNOMBREPARTICULAR());
            cv.put("APELLIDOPARTICULAR", particular.getAPELLIDOPARTICULAR());

            contador = db.update("PARTICULAR", cv, "IDPARTICULAR = ?", id);

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+particular.getIDPARTICULAR();
        }

    }

    /*==============================================================*/
    /* Table: CRUD ASISTENCIA                                       */
    /*==============================================================*/
    //Insertar

    public String insertarAsistencia(Asistencia asistencia){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        if(verificarIntegridad(asistencia, 24)){
            cv.put("IDASISTENCIA", asistencia.getIdAsistencia());
            cv.put("ID_DETALLE", asistencia.getIdDetalle());
            cv.put("IDMIEMBROUNIVERSITARIO", asistencia.getIdMiembroUniversitario());
            cv.put("CALIFICACION", asistencia.getCalifacion());

            contador = db.insert("ASISTENCIA", null, cv);
            if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar el registro, el registro esta duplicado o algo, por favor revisar el dato que ud quiere insertar";
            }
            else {
                regInsertados = regInsertados + contador;
            }
            return  regInsertados;
        }
        else {
            return  "Error verificar datos";
        }
    }

    public Asistencia consultarAsistencia(String idAsistencia){
        String[] id = {idAsistencia};

        Cursor cursor = db.query("ASISTENCIA", campoAsistencia, "IDASISTENCIA = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            Asistencia asistencia = new Asistencia();
            asistencia.setIdDetalle(Integer.parseInt(cursor.getString(1)));
            asistencia.setIdMiembroUniversitario(cursor.getString(2));
            asistencia.setCalifacion(Integer.parseInt(cursor.getString(3)));

            return asistencia;
        }
        return null;
    }

    //Eliminar
    public String eliminarAsistencia(Asistencia asistencia){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;


        if(verificarIntegridad(asistencia, 25)){
            contador += db.delete("ASISTENCIA", "IDASISTENCIA = '" + asistencia.getIdAsistencia().toString() + "' ",null);
            regAfectados += contador;

            return regAfectados;
        }
        else{
            return "No se encontro el registro";
        }
    }

    //Actualizar
    public String actualizarAsistencia(Asistencia asistencia){
        String[] id = {asistencia.getIdAsistencia()};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(asistencia, 24)){
            cv.put("ID_DETALLE",asistencia.getIdDetalle() );
            cv.put("IDMIEMBROUNIVERSITARIO", asistencia.getIdMiembroUniversitario());
            cv.put("CALIFICACION", asistencia.getCalifacion());

            contador = db.update("ASISTENCIA", cv, "IDASISTENCIA = ?", id);

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+ asistencia.getIdAsistencia();
        }
    }

    //Parte Katya

    /*==============================================================*/
    /* Table: CRUD EquipoDidactico                                  */
    /*==============================================================*/
    /*Insertar*/

    public String insertarEquipoDidactico(EquipoDidactico equipodidactico){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        cv.put("IDEQUIPO", equipodidactico.getIDEQUIPO());
        cv.put("NOMBRE", equipodidactico.getNOMBRE());
        cv.put("DESCRIPCIONEQUIPO", equipodidactico.getDESCRIPCIONEQUIPO());

        contador = db.insert("EQUIPODIDACTICO", null, cv);
        if (contador == -1 || contador ==0){
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return  regInsertados;
    }
    /*Consultar*/
    public EquipoDidactico consultarEquipoDidactico(String idEquipo){
        String[] id = {idEquipo};

        Cursor cursor = db.query("EQUIPODIDACTICO", campoEquipoDidactico, "IDEQUIPO = ?", id,null,null,null);

        if(cursor.moveToFirst()){
            EquipoDidactico equipodidactico = new EquipoDidactico();
            equipodidactico.setNOMBRE(cursor.getString(1));
            equipodidactico.setDESCRIPCIONEQUIPO(cursor.getString(2));

            return equipodidactico;
        }
        return null;
    }
    /*Eliminar*/
    public String eliminarEquipoDidactico(EquipoDidactico equipodidactico){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;
            contador += db.delete("EQUIPODIDACTICO", "IDEQUIPO ='" + equipodidactico.getIDEQUIPO().toString() + "' ",null);
            regAfectados += contador;
            return regAfectados;
        }

    /*Actualizar*/
    public String actualizarEquipoDidactico(EquipoDidactico equipodidactico){
        String regActualizados = "El total de registros actualizados es: ";
        String[] id = {equipodidactico.getIDEQUIPO()};
            ContentValues cv = new ContentValues();
        int contador = 0;
            cv.put("NOMBRE", equipodidactico.getNOMBRE());
            cv.put("DESCRIPCIONEQUIPO", equipodidactico.getDESCRIPCIONEQUIPO());
            contador = db.update("EQUIPODIDACTICO", cv, "IDEQUIPO = ?", id);

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }


    /*==============================================================*/
    /* Table: CRUD LISTAEQUIPO                                      */
    /*==============================================================*/
    /*Insertar*/

    public String insertarListaEquipo(ListaEquipo listaequipo){
        String regInsertados = "Se insertó el registro llamado: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        if(verificarIntegridad(listaequipo, 30)){
            cv.put("IDLISTAEQUIPO", listaequipo.getIDLISTAEQUIPO());
            cv.put("ID_DETALLE", listaequipo.getID_DETALLE());
            cv.put("IDEQUIPO", listaequipo.getIDEQUIPO());

            contador = db.insert("LISTAEQUIPO", null, cv);
            if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar el registro, el registro esta duplicado, por favor revisar el dato que ud quiere insertar";
            }
            else {
                regInsertados = regInsertados + contador;
            }
            return  regInsertados;
        }
        else {
            return  "Error verificar datos";
        }
    }


    /*Consultar*/
    public ListaEquipo consultarListaEquipo(String idListaEquipo){
        String[] id = {idListaEquipo};

        Cursor cursor = db.query("LISTAEQUIPO", campoListaEquipo, "IDLISTAEQUIPO = ?", id,null,null,null);

        if(cursor.moveToFirst()){
            ListaEquipo listaequipo = new ListaEquipo();
            listaequipo.setID_DETALLE(cursor.getInt(1));
            listaequipo.setIDEQUIPO(cursor.getString(2));

            return listaequipo;
        }
        return null;
    }
    public String eliminarListaEquipo(ListaEquipo listaequipo){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;


        if(verificarIntegridad(listaequipo, 35)){
            contador += db.delete("LISTAEQUIPO", "IDLISTAEQUIPO = '" + Integer.toString(listaequipo.getIDLISTAEQUIPO()) + "' ",null);
            regAfectados += contador;

            return regAfectados;
        }
        else{
            return "No se encontro el registro";
        }
    }
    /*Actualizar*/

        public String actualizarListaEquipo(ListaEquipo listaequipo) {
            String[] id = {Integer.toString(listaequipo.getIDLISTAEQUIPO())};

            String regActualizados = "El total de registros actualizados es: ";

            ContentValues cv = new ContentValues();
            int contador = 0;

            if(verificarIntegridad(listaequipo, 33)){

                cv.put("ID_DETALLE", listaequipo.getID_DETALLE());
                cv.put("IDEQUIPO", listaequipo.getIDEQUIPO());
                contador = db.update("LISTAEQUIPO", cv, "IDLISTAEQUIPO = ?", id);
                if(contador == -1){
                    regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
                }
                     else{
                    regActualizados = regActualizados + contador;
                }
                         return regActualizados;
                 }
            else {
                return "No existe el registro con el id "+ listaequipo.getIDLISTAEQUIPO();
            }
        }



     /*

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+ asistencia.getIdAsistencia();
        }

    *//*Eliminar*//*




   /* public String actualizarAsistencia(Asistencia asistencia){
        String[] id = {asistencia.getIdAsistencia()};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(asistencia, 24)){
            cv.put("ID_DETALLE",asistencia.getIdDetalle() );
            cv.put("IDMIEMBROUNIVERSITARIO", asistencia.getIdMiembroUniversitario());
            cv.put("CALIFICACION", asistencia.getCalifacion());

            contador = db.update("ASISTENCIA", cv, "IDASISTENCIA = ?", id);

            if(contador == -1 || contador == 0){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+ asistencia.getIdAsistencia();
        }
    }*/
    /*==============================================================*/
    /* Table: CRUD DETALLEACTIVIDAD                                 */
    /*==============================================================*/
    /*Insertar*/

    public String insertarDetalleActividad(DetalleActividad detalleactividad){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        if(verificarIntegridad(detalleactividad, 40)){
            cv.put("ID_DETALLE", detalleactividad.getID_DETALLE());
            cv.put("GRUPO", detalleactividad.getGRUPO());
            cv.put("IDACTIVIDAD", detalleactividad.getIDACTIVIDAD());
            cv.put("IDLOCAL", detalleactividad.getIDLOCAL());
            cv.put("DESCRIPCIONACTIVIDAD", detalleactividad.getDESCRIPCIONACTIVIDAD());


            contador = db.insert("DETALLEACTIVIDAD", null, cv);
            if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar el registro, el registro esta duplicado, por favor revisar el dato que ud quiere insertar";
            }
            else {
                regInsertados = regInsertados + contador;
            }
            return  regInsertados;
        }
        else {
            return  "Error verificar datos";
        }
    }




}



