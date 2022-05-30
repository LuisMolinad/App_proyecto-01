package com.edu.ues.fia.eisi.app_proyecto01;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import java.util.List;

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
    private static final String[] campoDetalleActividad = new String[]
            {"ID_DETALLE", "IDGRUPO", "IDACTIVIDAD","IDLOCAL","DESCRIPCIONACTIVIDAD"};



    /*Rosalio*/
    private static final String[] campoMiembroUniversitario = new String[]
            {"IDMIEMBROUNIVERSITARIO", "IDASIGNATURA", "IDUSUARIO", "NOMBREMIEMBROUNIVERSITARIO", "TIPOMIEMBRO"};
    //==andres
    private static final String[] campoCiclo = new String []{"IDCICLO","NUMEROCICLO","FECHAINICIO","FECHAFIN","ANIO"};
    private static final String[] campoOfertaAcademica = new String[]{"IDMATERIAACTIVA","IDCICLO","IDASIGNATURA","NOMBREMATERIAACTIVA"};
    private static final String[] campoDetalleOferta = new String[]{"IDGRUPO","IDMATERIAACTIVA","NUMEROGRUPO","TAMANOGRUPO","TIPOGRUPO"};
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

    /*Alejandro*/
    private static final String[] campoHorario = new    String[]{"IDHORARIO","DESDEHORARIO","HASTAHORARIO","DIA"};
    private static final String[] campoListaHorario = new    String[]{"IDLISTAHORARIO","ID_DETALLE","IDHORARIO"};
    private static final String[] campoLocal = new    String[]{"IDLOCAL","NOMBRELOCAL","CUPO"};

    public ControlBDActividades(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }



    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "CONTROLDEACTIVIDADES.s3db";
        private static final int VERSION = 6;

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
                        "   IDGRUPO              VARCHAR(10),\n" +
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
                        "   TIPOMIEMBRO          VARCHAR2(20)                    not null,\n" +
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
                //==andres
                db.execSQL("create table CICLO (\n" +
                        "IDCICLO              VARCHAR(10)                    not null,\n" +
                        "NUMEROCICLO          INTEGER                        not null,\n" +
                        "FECHAINICIO          DATE                           not null,\n" +
                        "FECHAFIN             DATE                           not null,\n" +
                        "ANIO                 VARCHAR(4)                     not null,\n" +
                        "primary key (IDCICLO)\n" +
                        ");");
                db.execSQL("create table OFERTAACADEMICA (\n" +
                        "IDMATERIAACTIVA      VARCHAR(10)                    not null,\n" +
                        "IDCICLO              VARCHAR(10),\n" +
                        "IDASIGNATURA         VARCHAR(20),\n" +
                        "NOMBREMATERIAACTIVA  VARCHAR(30)                    not null,\n" +
                        "primary key (IDMATERIAACTIVA),\n" +
                        "foreign key (IDASIGNATURA)\n" +
                        "      references MATERIA (IDASIGNATURA),\n" +
                        "foreign key (IDCICLO)\n" +
                        "      references CICLO (IDCICLO)\n" +
                        ");");

                db.execSQL("create table DETALLEOFERTA (\n" +
                        "IDGRUPO              VARCHAR(10)                    not null,\n" +
                        "IDMATERIAACTIVA      VARCHAR(10),\n" +
                        "NUMEROGRUPO          INTEGER                        not null,\n" +
                        "TAMANOGRUPO          INTEGER                        not null,\n" +
                        "TIPOGRUPO            VARCHAR(15)                    not null,\n" +
                        "primary key (IDGRUPO),\n" +
                        "foreign key (IDMATERIAACTIVA)\n" +
                        "      references OFERTAACADEMICA (IDMATERIAACTIVA)\n" +
                        ");");

                //Alejandro
                /*==============================================================*/
                /* Table: HORARIO                                               */
                /*==============================================================*/
                db.execSQL("create table HORARIO  (\n" +
                        "   IDHORARIO            VARCHAR2(5)                     not null,\n" +
                        "   DESDEHORARIO         VARCHAR2(5)                     not null,\n" +
                        "   HASTAHORARIO         VARCHAR2(5)                     not null,\n" +
                        "   DIA                  CHAR(5)                         not null,\n" +
                        "   constraint PK_HORARIO primary key (IDHORARIO)\n" +
                        ");");

                /*==============================================================*/
                /* Table: LOCAL                                                 */
                /*==============================================================*/
                db.execSQL("create table LOCAL  (\n" +
                        "   IDLOCAL              VARCHAR2(20)                    not null,\n" +
                        "   NOMBRELOCAL          VARCHAR2(30)                    not null,\n" +
                        "   CUPO                 INTEGER                         not null,\n" +
                        "   constraint PK_LOCAL primary key (IDLOCAL)\n" +
                        ");");

                /*==============================================================*/
                /* Table: LISTAHORARIO                                          */
                /*==============================================================*/
                db.execSQL("create table LISTAHORARIO  (\n" +
                        "   IDLISTAHORARIO       INTEGER                         not null,\n" +
                        "   ID_DETALLE           INTEGER,\n" +
                        "   IDHORARIO            VARCHAR2(5),\n" +
                        "   constraint PK_LISTAHORARIO primary key (IDLISTAHORARIO)\n" +
                        ");");
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


                //Eliminar listaequipo
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

                String[] id = {(detalleactividad.getGRUPO())};
                String[] id2 = {detalleactividad.getIDACTIVIDAD()};
                String[] id3 = {detalleactividad.getIDLOCAL()};
                abrir();
                Cursor c = db.query("DETALLEOFERTA", null, "IDGRUPO = ?", id,null, null, null);
                Cursor c2 = db.query("ACTIVIDAD", null, "IDACTIVIDAD = ?", id2,null, null, null);
                Cursor c3 = db.query("LOCAL", null, "IDLOCAL = ?", id3,null, null, null);

            //c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()
                if ( c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Actualizar Detalleactividad
            case 100:{
                DetalleActividad detalleactividad = (DetalleActividad) dato;

                String[] id = {(detalleactividad.getGRUPO())};
                String[] id2 = {detalleactividad.getIDACTIVIDAD()};
                String[] id3 = {detalleactividad.getIDLOCAL()};
                abrir();
                Cursor c = db.query("DETALLEOFERTA", null, "IDGRUPO = ?", id,null, null, null);
                Cursor c2 = db.query("ACTIVIDAD", null, "IDACTIVIDAD = ?", id2,null, null, null);
                Cursor c3 = db.query("LOCAL", null, "IDLOCAL = ?", id3,null, null, null);

                //c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()
                if ( c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 42: {
                DetalleActividad detalleactividad = (DetalleActividad) dato;
                Cursor c = db.query(true, "DETALLEACTIVIDAD", new String[]{"ID_DETALLE"}, "ID_DETALLE='" + detalleactividad.getID_DETALLE() + "'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 43:{
                //verificar que exista el ciclo
                Ciclo ciclo2 = (Ciclo)dato;
                String[]id={ciclo2.getIdCiclo()};
                abrir();
                Cursor c2=db.query("CICLO",null,"IDCICLO= ?",id,null,null,null,null);
                if(c2.moveToFirst()){
                    return true;
                }
                return false;
            }
            case 44:{
                //verificar que exista la OfertaAcademica
                OfertaAcademica ofertaAcademica2 = (OfertaAcademica) dato;
                String[]id={ofertaAcademica2.getIdMateriaActiva()};
                abrir();
                Cursor c2=db.query("OFERTAACADEMICA",null,"IDMATERIAACTIVA= ?",id,null,null,null);
                if(c2.moveToFirst()){
                    return true;
                }
                return false;
            }
            case 45:{
                //verificar que exista la OfertaAcademica
                DetalleOferta detalleOferta2 = (DetalleOferta) dato;
                String[]id={detalleOferta2.getIdGrupo()};
                abrir();
                Cursor c2=db.query("DETALLEOFERTA",null,"IDGRUPO= ?",id,null,null,null,null);
                if(c2.moveToFirst()){
                    return true;
                }
                return false;
            }
            case 46:{
                //verificar que ninguna ofertaAcademica tenga un idCiclo al borrar el ciclo
                Ciclo ciclo = (Ciclo)dato;
                Cursor c=db.query(true,"OFERTAACADEMICA",new String[]{"IDCICLO"},"IDCICLO='"+ciclo.getIdCiclo()+"'",null,null,null,null,null);
                if(c.moveToFirst())
                return true;
                else
                return false;
            }
            case 47:{
                //verificar que al insertar una ofertaAcademica exista el ciclo y la materia
                OfertaAcademica ofertaAcademica =(OfertaAcademica)dato;
                String[] id1={ofertaAcademica.getIdCiclo()};
                String[] id2={ofertaAcademica.getIdAsignatura()};
                abrir();
                Cursor cursor1 = db.query("CICLO",null,"IDCICLO= ?",id1,null,null,null);
                Cursor cursor2 = db.query("materia",null,"IDASIGNATURA= ?",id2,null,null,null);
                if(cursor1.moveToFirst()&&cursor2.moveToFirst()){
                    return true;
                }
                return false;
            }
            case 48:{
                //verificar que ninguna ofertaacademica sea llave foranea en un detalleOferta
                OfertaAcademica ofertaAcademica=(OfertaAcademica)dato;
                Cursor c=db.query(true,"DETALLEOFERTA",new String[]{"IDMATERIAACTIVA"},"IDMATERIAACTIVA='"+ofertaAcademica.getIdMateriaActiva()+"'",null,null,null,null,null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 49:{
                //verificar que al insertar un detalle oferta, exista la oferta academica
                DetalleOferta detalleOferta =(DetalleOferta)dato;
                String[]id={detalleOferta.getIdMateriaActiva()};
                abrir();
                Cursor cursor = db.query("OFERTAACADEMICA",null,"IDMATERIAACTIVA= ?",id,null,null,null);
                if(cursor.moveToFirst()){
                    return true;
                }
                return false;
            }

            //Alejandro
            //InsertarListaHorario
            case 50: {
                ListaHorario listaHorario = (ListaHorario) dato;
                String[] id = {Integer.toString(listaHorario.getID_DETALLE())};
                String[] id2 = {Integer.toString(listaHorario.getIDHORARIO())};

                abrir();
                Cursor c = db.query("DETALLEACTIVIDAD", null, "ID_DETALLE = ?", id,null, null, null);
                Cursor c2 = db.query("HORARIO", null, "IDHORARIO = ?", id2,null, null, null);

                //c.moveToFirst()&& c2.moveToFirst()&& c3.moveToFirst()
                if ( c.moveToFirst()&& c2.moveToFirst()) {
                    return true;
                }
                return false;
            }

            //Actualizar
            case 51:{
                ListaHorario listaHorario = (ListaHorario) dato;
                String[] id = {Integer.toString(listaHorario.getID_DETALLE())};
                String[] id2 = {Integer.toString(listaHorario.getIDHORARIO())};

                abrir();
                Cursor c = db.query("DETALLEACTIVIDAD", null, "ID_DETALLE = ?", id,null, null, null);
                Cursor c2 = db.query("HORARIO", null, "IDHORARIO = ?", id2,null, null, null);
                if (c.moveToFirst()&& c2.moveToFirst()) {
                    return true;
                }
                return false;
            }
            //Eliminar
            case 52:{
                ListaHorario listaHorario = (ListaHorario) dato;
                Cursor c = db.query(true, "LISTAHORARIO", new String[]{"IDLISTAHORARIO"}, "IDLISTAHORARIO = '" + listaHorario.getIDLISTAHORARIO() + "' ", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
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

        //==ANDRES
        //tabla ciclo
        final String [] idCiclo = {"01","02","03","04"};
        final Integer [] numeroCiclo = {1,2,1,1};
        final String [] fechaInicio = {"2021-02-20","2021-07-20","2022-02-19","2022-02-19"};
        final String [] fechaFin = {"2021-06-20","2021-12-20","2022-06-19","2022-06-19"};
        final String [] anio = {"2021","2021","2022","2022"};
        //tabla oferta academica
        final String [] idMateriaActiva ={"01","02","03"};
        final String [] idCicloOferta={"01","02","03"};
        final String [] idAsignaturaOferta={"IAI115","PRN115","PRN215"};
        final String [] nombreMateriaActiva={"INTRODUCCION A LA INFORMATICA Presencial 2021","PROGRAMACION I DISTANCIA 2021","PROGRAMACION II DISTANCIA 2022"};
        //tabla detalle oferta
        final String [] idGrupo={"001","002","003"};
        final String [] idMateriaActivaDetalleOferta={"01","02","03"};
        final Integer [] numeroGrupo= {1,2,3};
        final Integer [] tamanoGrupo={10,20,30};
        final String [] tipoGrupo={"Laboratorio","Discusion","Teorico"};

        //Katya
        //TABLA: EQUIPO DIDACTICO

        final String [] IDEQUIPO={"0101","0102","0103","0104"};
        final String [] NOMBRE={"Laptop","Impresora","Silla","Proyector"};
        final String [] DESCRIPCIONEQUIPO={"Computadora portátil: Laptop HP PAVILON X360 convertible 14-DY0005LA","Impresora Multifunconal HP 315",
                "Silla Ejecutiva Paris Xtech","Infocus IN1188HD 3000-Lumen Full HD"};

        //TABLA: LISTA EQUIPO DIDACTICO
        final Integer [] IDLISTAEQUIPO= {001,002,003};
        final Integer [] ID_DETALLE={11,12,13};
        final String [] IDEQUIPOLISTA={"0101","0102","0103","0104"};

        //TABLA: DETALLE ACTIVIDAD
        final Integer [] ID_DETALLEACTIVIDAD= {011,012,013};
        final String [] IDGRUPO={"001","002","003"};
        final String [] IDACTIVIDAD={"001","002","003","004"};
        final String [] IDLOCAL={"0101","0102","0103","0104"};
        final String [] DESCRIPCIONACTIVIDAD={"Ponencia sobre Ciberseguridad","Bienvenida al ciclo 2 - 2022","Taller: Salud Mental","Examen Parcial"};



        //Alejandro
        //Tabla Horario
        final  String[] IDHORARIO={"01","02","03"};
        final  String[] DESDEHORARIO={"7:00","11:00","1:00"};
        final  String[] HASTAHORARIO={"12:00","3:00","5:00"};
        final  String[] DIA={"Lunes","Martes","Miercoles","Jueves","Viernes"};

        //Tabla local
        //final  String[] IDLOCAL = {"01","02","03"};
        final  String[] NOMBRELOCAL = {"Marmol","BIB11","BIB32"};
        final  String[] CUPO = {"100","80","50"};

        //Rosalio

        //Tabla Actividad
        //final String [] IDACTIVIDAD={"001","002","003","004"};
        final String [] IDMIEMBROUNIVERSITARIO = {"01","02","03","04"};
        final String [] NOMBREACTIVIDAD = {"Foro SGG115", "Conferencia anual MAT115", "Cena becarios", "Reunion con las asociaciones"};
        final String [] FECHARESERVA = {"24/05/2000", "21/05/2000", "5/11/2005", "1/8/2015"};
        final String [] DESDEACTIVIDAD = {"5/8/2017","6/7/2020","24/05/2000", "21/05/2000"};
        final String [] HASTAACTIVIDAD = {"14/3/2015","24/05/2000", "21/05/2000", "5/11/2005"};
        final String [] APROBADO = {"Si", "Si", "No", "No"};

        //Tabla miembroUniversitario
        //final String [] IDMIEMBROUNIVERSITARIO = {"01","02","03","04"};
        //final String [] idAsignatura = {"IAI115","PRN115","PRN215","PRN315","HDP115","ARC15","SIO"};
        //final String [] IDUSUARIO = {"01","02","03","04","05","06"};
        final String [] NOMBREMIEMBROUNIVERSITARIO = {"Rosalio Andres", "Katya Carbajal", "Alejandro Abenabi", "Christian Duque"};
        final String [] TIPOMIEMBRO = {"Estudiante", "Estudiante", "Estudiante", "Egresado"};

        //Asistencia
        final String [] IDASISTENCIA = {"01","02","03"};
        //final Integer [] ID_DETALLEACTIVIDAD= {011,012,013};
        //final String [] IDMIEMBROUNIVERSITARIO = {"01","02","03","04"};
        final Integer [] CALIFICACION = {9,10,5};

        //Particular
        final String [] IDPARTICULAR = {"01","02","03","04"};
        //final String [] IDUSUARIO = {"01","02","03","04","05","06"};
        final String [] NOMBREPARTICULAR = {"Katya", "Andres", "Alejandro", "Luis Christian"};
        final String [] APELLIDOPARTICULAR = {"Guillen", "Osorio", "Duque", "Ayala"};

        abrir();

        db.execSQL("DELETE FROM CARRERA");
        db.execSQL("DELETE FROM escuela");
        db.execSQL("DELETE FROM materia");
        db.execSQL("DELETE FROM usuario");
        db.execSQL("DELETE FROM accesoUSUARIO");
        db.execSQL("DELETE FROM opcioncrud");
        db.execSQL("DELETE FROM CICLO");
        db.execSQL("DELETE FROM OFERTAACADEMICA");
        db.execSQL("DELETE FROM DETALLEOFERTA");
        db.execSQL("DELETE FROM EQUIPODIDACTICO");
        db.execSQL("DELETE FROM LISTAEQUIPO");
        db.execSQL("DELETE FROM DETALLEACTIVIDAD");
        db.execSQL("DELETE FROM HORARIO");
        db.execSQL("DELETE FROM ACTIVIDAD");
        db.execSQL("DELETE FROM MIEMBROUNVERSITARIOS");
        db.execSQL("DELETE FROM ASISTENCIA");
        db.execSQL("DELETE FROM PARTICULAR");

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
        Ciclo ciclo = new Ciclo();
        for(int i=0;i<4;i++){
            ciclo.setIdCiclo(idCiclo[i]);
            ciclo.setNumeroCiclo(numeroCiclo[i]);
            ciclo.setFechaInicio(fechaInicio[i]);
            ciclo.setFechaFin(fechaFin[i]);
            ciclo.setAnio(anio[i]);
            insertarCiclo(ciclo);
        }
        Horario horario = new Horario();
        for(int i=0;i<3;i++){
            horario.setIDHORARIO(IDHORARIO[i]);
            horario.setDESDEHORARIO(DESDEHORARIO[i]);
            horario.setHASTAHORARIO(HASTAHORARIO[i]);
            horario.setDIA(DIA[i]);
            insertarHorario(horario);
        }


        Local local = new Local();
        for(int i=0;i<3;i++){
            local.setIDLOCAL(IDLOCAL[i]);
            local.setNOMBRELOCAL(NOMBRELOCAL[i]);
            local.setCUPO(Integer.valueOf(CUPO[i]));
            insertarLocal(local);
        }


        Carrera carrera = new Carrera();
        for(int i=0;i<7;i++){
            carrera.setIDCARRERA(IdCarrera[i]);
            carrera.setNOMBRECARRERA(NombreCarrera[i]);
            insertar(carrera);
        }
        /*TABLA LOCAL
         */
        //Llenado de Equipo Didactico
        EquipoDidactico equipo = new EquipoDidactico();
        for(int i=0;i<4;i++){
            equipo.setIDEQUIPO(IDEQUIPO[i]);
            equipo.setNOMBRE(NOMBRE[i]);
            equipo.setDESCRIPCIONEQUIPO(DESCRIPCIONEQUIPO[i]);
            insertarEquipoDidactico(equipo);
        }

        //Particular
        Particular particular = new Particular();
        for (int i = 0; i < IDPARTICULAR.length ; i++){
            particular.setIDPARTICULAR(IDPARTICULAR[i]);
            particular.setIDPUSUARIO(IDUSUARIO[i]);
            particular.setNOMBREPARTICULAR(NOMBREPARTICULAR[i]);
            particular.setAPELLIDOPARTICULAR(APELLIDOPARTICULAR[i]);

            insertarParticular(particular);
        }

        //Escuela
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


        OfertaAcademica ofertaAcademica = new OfertaAcademica();
        for(int i=0;i<3;i++){
            ofertaAcademica.setIdMateriaActiva(idMateriaActiva[i]);
            ofertaAcademica.setIdCiclo(idCicloOferta[i]);
            ofertaAcademica.setIdAsignatura(idAsignaturaOferta[i]);
            ofertaAcademica.setNombreMateriaActiva(nombreMateriaActiva[i]);
            insertarOfertaAcademica(ofertaAcademica);
        }
        DetalleOferta detalleOferta = new DetalleOferta();
        for(int i=0;i<3;i++){
            detalleOferta.setIdGrupo(idGrupo[i]);
            detalleOferta.setIdMateriaActiva(idMateriaActivaDetalleOferta[i]);
            detalleOferta.setNumeroGrupo(numeroGrupo[i]);
            detalleOferta.setTamanoGrupo(tamanoGrupo[i]);
            detalleOferta.setTipoGrupo(tipoGrupo[i]);
            insertarDetalleOferta(detalleOferta);
        }

        //Miembro universitario
        MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
        for (int i = 0; i < IDMIEMBROUNIVERSITARIO.length ; i++){
            miembroUniversitario.setIdMiembroUniversitario(IDMIEMBROUNIVERSITARIO[i]);
            miembroUniversitario.setIdAsignatura(idAsignatura[i]);
            miembroUniversitario.setIdUsuario(IDUSUARIO[i]);
            miembroUniversitario.setNombreMiembroUniversitario(NOMBREMIEMBROUNIVERSITARIO[i]);
            miembroUniversitario.setTipoMiembro(TIPOMIEMBRO[i]);

            insertarMiembroUniversitario(miembroUniversitario);
        }

        //Tabla actividad
        Actividad actividad = new Actividad();
        for(int i = 0; i< IDACTIVIDAD.length;  i++){
            actividad.setIdActividad(IDACTIVIDAD[i]);
            actividad.setIdMiembroUniversitario(IDMIEMBROUNIVERSITARIO[i]);
            actividad.setNombreActividad(NOMBREACTIVIDAD[i]);
            actividad.setFechaReserva(FECHARESERVA[i]);
            actividad.setDesdeActividad(DESDEACTIVIDAD[i]);
            actividad.setHastaActividad(HASTAACTIVIDAD[i]);
            actividad.setAprobado(APROBADO[i]);

            insertarActividad(actividad);
        }

        DetalleActividad detalleActividad = new DetalleActividad();
        for(int i=0;i<3;i++){
            detalleActividad.setID_DETALLE(ID_DETALLEACTIVIDAD[i]);
            detalleActividad.setGRUPO(IDGRUPO[i]);
            detalleActividad.setIDACTIVIDAD(IDACTIVIDAD[i]);
            detalleActividad.setIDLOCAL(IDLOCAL[i]);
            detalleActividad.setDESCRIPCIONACTIVIDAD(DESCRIPCIONACTIVIDAD[i]);
            insertarDetalleActividad(detalleActividad);
        }



        //Llenado de ListaEquipo
        ListaEquipo ListaEquipo = new ListaEquipo();
        for(int i=0;i<3;i++){
            ListaEquipo.setIDLISTAEQUIPO(IDLISTAEQUIPO[i]);
            ListaEquipo.setID_DETALLE(ID_DETALLE[i]);
            ListaEquipo.setIDEQUIPO(IDEQUIPOLISTA[i]);

            insertarListaEquipo(ListaEquipo);
        }

        //Asistencia
        Asistencia asistencia = new Asistencia();
        for (int i = 0; i < IDASISTENCIA.length ; i++){
            asistencia.setIdAsistencia(IDASISTENCIA[i]);
            asistencia.setIdDetalle(ID_DETALLE[i]);
            asistencia.setIdMiembroUniversitario(IDMIEMBROUNIVERSITARIO[i]);
            asistencia.setCalifacion(CALIFICACION[i]);

            insertarAsistencia(asistencia);
        }

        /*TABLA LISTA HORARIO







         */

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
    /*andres*/
    public String insertarCiclo(Ciclo ciclo){
        String regInsertados="Registro insertado N° =";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDCICLO",ciclo.getIdCiclo());
        carr.put("NUMEROCICLO",ciclo.getNumeroCiclo());
        carr.put("FECHAINICIO",ciclo.getFechaInicio());
        carr.put("FECHAFIN",ciclo.getFechaFin());
        carr.put("ANIO",ciclo.getAnio());
        contador=db.insert("CICLO",null,carr);
        if(contador==-1||contador==0)
        {
            regInsertados="Error al Insertar el registro, Registro Duplicado.Verificar insercción";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarOfertaAcademica(OfertaAcademica ofertaAcademica){
        String regInsertados="Registro insertado N° =";
        long contador=0;
        if(verificarIntegridad(ofertaAcademica,47)) {
            ContentValues carr = new ContentValues();
            carr.put("IDMATERIAACTIVA", ofertaAcademica.getIdMateriaActiva());
            carr.put("IDCICLO", ofertaAcademica.getIdCiclo());
            carr.put("IDASIGNATURA", ofertaAcademica.getIdAsignatura());
            carr.put("NOMBREMATERIAACTIVA", ofertaAcademica.getNombreMateriaActiva());
            contador = db.insert("OFERTAACADEMICA", null, carr);
        }
        if(contador==-1){
            regInsertados="Error al Insertar el registro, Registro Duplicado.Verificar insercción";
        }
        else if(contador==0){
            regInsertados="Error al insertar. Id ciclo o id Asignatura no existen.";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarDetalleOferta(DetalleOferta detalleOferta){
        String regInsertados="Registro insertado N° =";
        long contador=0;
        if(verificarIntegridad(detalleOferta,49)) {
            ContentValues carr = new ContentValues();
            carr.put("IDGRUPO", detalleOferta.getIdGrupo());
            carr.put("IDMATERIAACTIVA", detalleOferta.getIdMateriaActiva());
            carr.put("NUMEROGRUPO", detalleOferta.getNumeroGrupo());
            carr.put("TAMANOGRUPO", detalleOferta.getTamanoGrupo());
            carr.put("TIPOGRUPO", detalleOferta.getTipoGrupo());
            contador = db.insert("DETALLEOFERTA", null, carr);
        }
        if(contador==-1){
            regInsertados="Error al Insertar el registro, Registro Duplicado.Verificar insercción";
        }
        else if(contador==0){
            regInsertados="Error al insertar. Id materia activa no existe.";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public Ciclo consultarCiclo(String idCiclo){
        String[] id={idCiclo};
        Cursor cursor=db.query("CICLO",campoCiclo,"IDCICLO= ?",id,null,null,null,null);
        if(cursor.moveToFirst()){
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(cursor.getString(0));
            ciclo.setNumeroCiclo(Integer.parseInt(cursor.getString(1)));
            ciclo.setFechaInicio(cursor.getString(2));
            ciclo.setFechaFin(cursor.getString(3));
            ciclo.setAnio(cursor.getString(4));
            return ciclo;
        }
        else{return null;}
    }
    public OfertaAcademica consultarOfertaAcademica(String idMateriaActiva){
        String[] id={idMateriaActiva};
        Cursor cursor=db.query("OFERTAACADEMICA",campoOfertaAcademica,"IDMATERIAACTIVA= ?",id,null,null,null);
        if(cursor.moveToFirst()){
            OfertaAcademica ofertaAcademica = new OfertaAcademica();
            ofertaAcademica.setIdMateriaActiva(cursor.getString(0).toString());
            ofertaAcademica.setIdCiclo(cursor.getString(1).toString());
            ofertaAcademica.setIdAsignatura(cursor.getString(2).toString());
            ofertaAcademica.setNombreMateriaActiva(cursor.getString(3).toString());
            return ofertaAcademica;
        }
        else{return null;}
    }
    public DetalleOferta consultarDetellaOferta(String idDetalleOferta){
        String[] id={idDetalleOferta};
        Cursor cursor=db.query("DETALLEOFERTA",campoDetalleOferta,"IDGRUPO= ?",id,null,null,null);
        if(cursor.moveToFirst()){
            DetalleOferta detalleOferta = new DetalleOferta();
            detalleOferta.setIdGrupo(cursor.getString(0));
            detalleOferta.setIdMateriaActiva(cursor.getString(1));
            detalleOferta.setNumeroGrupo(Integer.valueOf(cursor.getString(2)));
            detalleOferta.setTamanoGrupo(Integer.valueOf(cursor.getString(3)));
            detalleOferta.setTipoGrupo(cursor.getString(4));
            return detalleOferta;
        }
        else{return null;}
    }

    public String eliminarCiclo(Ciclo ciclo){
        String regAfectados="Filas afectadas= ";
        int contador=0;
        if(verificarIntegridad(ciclo,46)){
            regAfectados="No se puede eliminar. El ciclo "+ciclo.getIdCiclo().toString()+" es llave foranea en otros registros.";
        }else{
            String where="IDCICLO='"+ciclo.getIdCiclo()+"'";
            contador+=db.delete("CICLO",where,null);
            regAfectados+=contador;
        }
        return regAfectados;
    }
    public String eliminarOfertaAcademica(OfertaAcademica ofertaAcademica){
        String regAfectados="Filas afectadas= ";
        int contador=0;
        if(verificarIntegridad(ofertaAcademica,48)){
            regAfectados="No se puede eliminar. La oferta académica "+ofertaAcademica.getIdMateriaActiva().toString()+" es llave foranea en otros registros.";
        }
        else{
        String where="IDMATERIAACTIVA='"+ofertaAcademica.getIdMateriaActiva()+"'";
        contador+=db.delete("OFERTAACADEMICA",where,null);
        regAfectados+=contador;
        }
        return regAfectados;
    }
    public String eliminarDetalleOferta(DetalleOferta detalleOferta){
        String regAfectados="Filas afectadas= ";
        int contador=0;
        String where="IDGRUPO='"+detalleOferta.getIdGrupo()+"'";
        contador+=db.delete("DETALLEOFERTA",where,null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String actualizarCiclo(Ciclo ciclo){
        if(verificarIntegridad(ciclo, 43)){
            String[] id = {ciclo.getIdCiclo()};
            ContentValues cv = new ContentValues();
            cv.put("NUMEROCICLO", ciclo.getNumeroCiclo());
            cv.put("FECHAINICIO", ciclo.getFechaInicio());
            cv.put("FECHAFIN", ciclo.getFechaFin());
            cv.put("ANIO",ciclo.getAnio());
            db.update("CICLO", cv, "IDCICLO = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ID " + ciclo.getIdCiclo() + " no existe";
        }
    }
    public String actualizarOfertaAcademica(OfertaAcademica ofertaAcademica){
        if(verificarIntegridad(ofertaAcademica, 47)){
            String[] id = {ofertaAcademica.getIdMateriaActiva()};
            ContentValues cv = new ContentValues();
            cv.put("IDCICLO",ofertaAcademica.getIdCiclo());
            cv.put("IDASIGNATURA",ofertaAcademica.getIdAsignatura());
            cv.put("NOMBREMATERIAACTIVA",ofertaAcademica.getNombreMateriaActiva());
            db.update("OFERTAACADEMICA", cv, "IDMATERIAACTIVA = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Error al actualizar. Id ciclo o id Asignatura no existen.";
        }
    }
    public String actualizarDetalleOferta(DetalleOferta detalleOferta){
        if(verificarIntegridad(detalleOferta,49)){
            String[] id = {detalleOferta.getIdGrupo()};
            ContentValues cv = new ContentValues();
            cv.put("IDMATERIAACTIVA",detalleOferta.getIdMateriaActiva());
            cv.put("NUMEROGRUPO",detalleOferta.getNumeroGrupo());
            cv.put("TAMANOGRUPO",detalleOferta.getTamanoGrupo());
            cv.put("TIPOGRUPO",detalleOferta.getTipoGrupo());
            db.update("DETALLEOFERTA", cv, "IDGRUPO= ?",id);
            return "Registro Actualizado correctamente";
        }
        else{
            return "Error al actualizar. Id materia activa no existe.";
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

    /*Eliminar*/

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
            cv.put("IDGRUPO", detalleactividad.getGRUPO());
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

    /*Consultar*/

    public DetalleActividad consultarDetalleActividad(String idDetalleActividad){
        String[] id = {idDetalleActividad};

        Cursor cursor = db.query("DETALLEACTIVIDAD", campoDetalleActividad, "ID_DETALLE = ?", id,null,null,null);

        if(cursor.moveToFirst()){
            DetalleActividad idDetalle = new DetalleActividad();
            idDetalle.setID_DETALLE(Integer.parseInt(cursor.getString(0)));
            idDetalle.setGRUPO(cursor.getString(1));
            idDetalle.setIDACTIVIDAD(cursor.getString(2));
            idDetalle.setIDLOCAL(cursor.getString(3));
            idDetalle.setDESCRIPCIONACTIVIDAD(cursor.getString(4));

            return idDetalle;
        }
        return null;
    }


    /*Actualizar*/

    public String actualizarDetalleActividad(DetalleActividad detalleactividad) {

        String[] id = {Integer.toString(detalleactividad.getID_DETALLE())};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(detalleactividad, 100)){
            cv.put("ID_DETALLE", detalleactividad.getID_DETALLE());
            cv.put("IDGRUPO", detalleactividad.getGRUPO());
            cv.put("IDACTIVIDAD", detalleactividad.getIDACTIVIDAD());
            cv.put("IDLOCAL", detalleactividad.getIDLOCAL());
            cv.put("DESCRIPCIONACTIVIDAD", detalleactividad.getDESCRIPCIONACTIVIDAD());

            contador = db.update("DETALLEACTIVIDAD", cv, "ID_DETALLE = ?", id);
            if(contador == -1){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+ detalleactividad.getID_DETALLE();
        }
        }


    /*public String actualizarAsistencia(Asistencia asistencia){
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





        /*String[] id = {Integer.toString(detalleactividad.getID_DETALLE())};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(detalleactividad, 41)){

            cv.put("IDGRUPO", detalleactividad.getGRUPO());
            cv.put("IDACTIVIDAD", detalleactividad.getIDACTIVIDAD());
            cv.put("IDLOCAL", detalleactividad.getIDLOCAL());
            cv.put("DESCRIPCIONACTIVIDAD", detalleactividad.getDESCRIPCIONACTIVIDAD());

            contador = db.update("DETALLEACTIVIDAD", cv, "ID_DETALLE = ?", id);
            if(contador == -1){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else {
            return "No existe el registro con el id "+ detalleactividad.getID_DETALLE();
        }*/

    /*Eliminar*/

    public String eliminarDetalleActividad(DetalleActividad detalleactividad){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;


        if(verificarIntegridad(detalleactividad, 42)){
            contador += db.delete("DETALLEACTIVIDAD", "ID_DETALLE = '" + Integer.toString(detalleactividad.getID_DETALLE()) + "' ",null);
            regAfectados += contador;

            return regAfectados;
        }
        else{
            return "No se encontro el registro";
        }
    }

    //Alejandro
    /*==============================================================*/
    /* Table: CRUD HORARIO                                          */
    /*==============================================================*/

    /*Insertar*/

    public String insertarHorario(Horario horario){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        cv.put("IDHORARIO", horario.getIDHORARIO());
        cv.put("DESDEHORARIO", horario.getDESDEHORARIO());
        cv.put("HASTAHORARIO", horario.getHASTAHORARIO());
        cv.put("DIA", horario.getDIA());


        contador = db.insert("HORARIO", null, cv);
        if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar el horario, el horario esta duplicado, por favor revisar el dato que ud quiere insertar";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return  regInsertados;

    }

    /*Consultar*/
    public Horario consultarHorario(String idHorario){
        String[] id = {idHorario};

        Cursor cursor = db.query("HORARIO", campoHorario, "IDHORARIO = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            Horario horario = new Horario();
            horario.setDESDEHORARIO(cursor.getString(1));
            horario.setHASTAHORARIO(cursor.getString(2));
            horario.setDIA(cursor.getString(3));

            return horario;
        }
        return null;
    }

    /*Actualizar*/
    public String actualizarHorario(Horario horario) {
        String[] id = {horario.getIDHORARIO()};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        cv.put("IDHORARIO", horario.getIDHORARIO());
        cv.put("DESDEHORARIO", horario.getDESDEHORARIO());
        cv.put("HASTAHORARIO", horario.getHASTAHORARIO());
        cv.put("DIA", horario.getDIA());

        contador = db.update("HORARIO", cv, "IDHORARIO = ?", id);
        if(contador == -1){
            regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
        }
        else{
            regActualizados = regActualizados + contador;
        }
        return regActualizados;
    }

    /*Eliminar*/

    public String eliminarHorario(Horario horario){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;
        contador += db.delete("HORARIO", "IDHORARIO ='" + horario.getIDHORARIO().toString() + "' ",null);
        regAfectados += contador;
        return regAfectados;
    }

/*==============================================================*/
/* Table: CRUD LOCAL                                            */
/*==============================================================*/

    /*Insertar*/
    public String insertarLocal(Local local){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();

        cv.put("IDLOCAL", local.getIDLOCAL());
        cv.put("NOMBRELOCAL", local.getNOMBRELOCAL());
        cv.put("CUPO", local.getCUPO());


        contador = db.insert("LOCAL", null, cv);
        if (contador == -1 || contador ==0){
            regInsertados = "Error al insertar el local, el local esta duplicado, por favor revisar el dato que ud quiere insertar";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return  regInsertados;
    }

    /*Consultar*/
    public Local consultarLocal(String idLocal){
        String[] id = {idLocal};

        Cursor cursor = db.query("LOCAL", campoLocal, "IDLOCAL = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            Local local = new Local();
            local.setNOMBRELOCAL(cursor.getString(1));
            local.setCUPO(Integer.parseInt(cursor.getString(2)));

            return local;
        }
        return null;
    }

    /*Actualizar*/
    public String actualizarLocal(Local local) {
        String[] id = {local.getIDLOCAL()};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        cv.put("IDLOCAL", local.getIDLOCAL());
        cv.put("NOMBRELOCAL", local.getNOMBRELOCAL());
        cv.put("CUPO", local.getCUPO());

        contador = db.update("LOCAL", cv, "IDLOCAL = ?", id);
        if(contador == -1){
            regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
        }
        else{
            regActualizados = regActualizados + contador;
        }
        return regActualizados;
    }

    /*Eliminar*/

    public String eliminarLocal(Local local){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;
        contador += db.delete("LOCAL", "IDLOCAL ='" + local.getIDLOCAL().toString() + "' ",null);
        regAfectados += contador;
        return regAfectados;
    }

    /*==============================================================*/
    /* Table: CRUD LISTAHORARIO                                     */
    /*==============================================================*/
    public String insertarListaHorario(ListaHorario listaHorario){
        String regInsertados = "Se han insertado un total de: ";
        long contador = 0;
        ContentValues cv = new ContentValues();
        if(verificarIntegridad(listaHorario, 50)){
            cv.put("IDLISTAHORARIO", listaHorario.getIDLISTAHORARIO());
            cv.put("ID_DETALLE", listaHorario.getID_DETALLE());
            cv.put("IDHORARIO", listaHorario.getIDHORARIO());


            contador = db.insert("LISTAHORARIO", null, cv);
            if (contador == -1 || contador ==0){
                regInsertados = "Error al insertar la lista horario, la lista horario esta duplicada, por favor revisar el dato que ud quiere insertar";
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
    public ListaHorario consultarListaHorario(String idListaHorario){
        String[] id = {idListaHorario};

        Cursor cursor = db.query("LISTAHORARIO", campoListaHorario, "IDLISTAHORARIO = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            ListaHorario horario = new ListaHorario();
            horario.setIDHORARIO(Integer.parseInt(cursor.getString(1)));
            horario.setID_DETALLE(Integer.parseInt(cursor.getString(2)));

            return horario;
        }
        return null;
    }

    /*Actualizar*/
    public String actualizarListaHorario(ListaHorario listaHorario) {
        String[] id = {Integer.toString(listaHorario.getIDHORARIO())};

        String regActualizados = "El total de registros actualizados es: ";

        ContentValues cv = new ContentValues();
        int contador = 0;

        if(verificarIntegridad(listaHorario, 51)){
            cv.put("IDHORARIO", listaHorario.getIDHORARIO());
            cv.put("ID_DETALLE", listaHorario.getID_DETALLE());
            cv.put("IDHORARIO", listaHorario.getIDHORARIO());

            contador = db.update("LISTAHORARIO", cv, "IDHORARIO = ?", id);
            if(contador == -1){
                regActualizados = "Error al actualizar los registros, favor verficar insercion de datos";
            }
            else{
                regActualizados = regActualizados + contador;
            }
            return regActualizados;
        }
        else{
            return "No existe el registro con el id "+ listaHorario.getIDLISTAHORARIO();
            }
    }

    /*Eliminar*/

    public String eliminarListaHorario(ListaHorario listaHorario){
        String regAfectados = "La cantidad de datos eliminados es: ";
        int contador = 0;


        if(verificarIntegridad(listaHorario, 52)){
            contador += db.delete("LISTAHORARIO", "IDLISTAHORARIO = '" + Integer.toString(listaHorario.getIDLISTAHORARIO()) + "' ",null);
            regAfectados += contador;

            return regAfectados;
        }
        else{
            return "No se encontro el registro";
        }
    }
}









