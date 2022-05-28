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
    /*  db.execSQL("CREATE TABLE usuario(IDUSUARIO VARCHAR(30) NOT NULL PRIMARY KEY,NOMUSUARIO VARCHAR(30),CLAVE CHAR(5),TIPOUSUARIO VARCHAR(30));"); */
    private static final String[] camposUsuario = new String[]
            {"IDUSUARIO","NOMUSUARIO", "CLAVE","TIPOUSUARIO"};
    private static final String[] camposAccesoUsuario = new String[]
            {"IDUSUARIO","IDOPCION"};


    /*Rosalio*/
    private static final String[] campoMiembroUniversitario = new String[]
            {"IDMIEMBROUNIVERSITARIO", "IDASIGNATURA", "IDUSUARIO", "NOMBREMIEMBROUNIVERSITARIO", "TIPOMIEMBRO"};
    //==andres
    private static final String[] campoCiclo = new String []{"IDCICLO","NUMEROCICLO","FECHAINICIO","FECHAFIN","ANIO"};
    private static final String[] campoOfertaAcademica = new String[]{"IDMATERIAACTIVA","IDCICLO","IDASIGNATURA","NOMBREMATERIASACTIVAS"};
    private static final String[] campoDetalleOferta = new String[]{"IDGRUPO","IDMATERIAACTIVA","NUMEROGRUPO","TAMANOGRUPO","TIPOGRUPO"};
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
        private static final int VERSION = 3;

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
                        "   FECHARESERVA         DATE                            not null,\n" +
                        "   DESDEACTIVIDAD       DATE                            not null,\n" +
                        "   HASTAACTIVIDAD       DATE                            not null,\n" +
                        "   APROBADO             SMALLINT                        not null,\n" +
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
                        "NOMBREMATERIAACTIVA  VARCHAR(20)                    not null,\n" +
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
            /*
            case 1:
            {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                String[] id = {miembroUniversitario.getIdMiembroUniversitario()};
                String[] id2 = {miembroUniversitario.getIdUsuario()};
                String[] id3 = {miembroUniversitario.getIdAsignatura()};

                abrir();
                Cursor c = db.query("MIEMBROUNIVERSITARIOS", null, "IDMIEMBROUNIVERSITARIO = ?", id, null, null, null);
                Cursor c2 = db.query("USUARIO", null, "IDUSUARIO = ?", id2, null, null, null);
                Cursor c3 = db.query("MATERIA", null, "IDASIGNATURA = ?", id3, null, null, null);

                if( c.moveToFirst() && c2.moveToFirst() && c3.moveToFirst()){
                    //Se encontro fk y pk existentes
                    return true;
                }
                    return false;
            }
             */
            case 1:
            {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                Cursor c=db.query(true, "MIEMBROUNVERSITARIOS", new String[] {"IDMIEMBROUNIVERSITARIO" }, "IDMIEMBROUNIVERSITARIO='"+miembroUniversitario.getIdMiembroUniversitario()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 2:
            {
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                String[] id = {miembroUniversitario.getIdMiembroUniversitario()};

                abrir();
                Cursor c = db.query("MIEMBROUNIVERSITARIOS", null, "IDMIEMBROUNIVERSITARIO = ?", id, null, null, null);
                if( c.moveToFirst()){
                    //Se encontro fk y pk existentes
                    return true;
                }
                else {
                    return false;
                }
            }
            case 4:{
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                String[] id2 = {miembroUniversitario.getIdUsuario()};
                String[] id3 = {miembroUniversitario.getIdAsignatura()};

                abrir();
                Cursor c2 = db.query("USUARIO", null, "IDUSUARIO = ?", id2, null, null, null);
                Cursor c3 = db.query("MATERIA", null, "IDASIGNATURA = ?", id3, null, null, null);

                if( c2.moveToFirst() && c3.moveToFirst()){
                    //Se encontro fk y pk existentes
                    return true;
                }
                return false;
            }
            case 3:
            {
                Materia materia = (Materia) dato;
                Cursor c=db.query(true, "materia", new String[] {"IDASIGNATURA" }, "IDASIGNATURA='"+materia.getIDASIGNATURA()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 5:
            {
                //verificar que exista escuela y carrera
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
            case 6:
            {
                //verificar que exista escuela y carrera
                Materia materia = (Materia) dato;
                String[] id4 = {materia.getIDASIGNATURA()};
                String[] id3 = {materia.getIDESCUELA()};
                abrir();
                Cursor c2 = db.query("materia", null, "IDASIGNATURA = ?", id4, null, null,
                        null);
                Cursor c3 = db.query("escuela", null, "IDESCUELA = ?", id3, null, null,
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
        final String [] idCiclo = {"01","02","03"};
        final Integer [] numeroCiclo = {1,2,1};
        final String [] fechaInicio = {"2021-02-20","2021-07-20","2022-02-19"};
        final String [] fechaFin = {"2021-06-20","2021-12-20","2022-06-19"};
        final String [] anio = {"2021","2021","2022"};
        //tabla oferta academica
        final String [] idMateriaActiva ={"01","02","03"};
        final String [] idCicloOferta={"01","02","03"};
        final String [] idAsignaturaOferta={"IAI115","PRN115","PRN215"};
        final String [] nombreMateriaActiva={"INTRODUCCION A LA INFORMATICA","PROGRAMACION I","PROGRAMACION II"};
        //tabla detalle oferta
        final String [] idGrupo={"001","002","003"};
        final String [] idMateriaActivaDetalleOferta={"01","02","03"};
        final Integer [] numeroGrupo= {1,2,3};
        final Integer [] tamanoGrupo={10,20,30};
        final String [] tipoGrupo={"Laboratorio","Discusión","Teórico"};
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
        Ciclo ciclo = new Ciclo();
        for(int i=0;i<3;i++){
            ciclo.setIdCiclo(idCiclo[i]);
            ciclo.setNumeroCiclo(numeroCiclo[i]);
            ciclo.setFechaInicio(fechaInicio[i]);
            ciclo.setFechaFin(fechaFin[i]);
            ciclo.setAnio(anio[i]);
            insertarCiclo(ciclo);
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
            detalleOferta.setIdMateriaActiva(idMateriaActiva[i]);
            detalleOferta.setNumeroGrupo(numeroGrupo[i]);
            detalleOferta.setTamanoGrupo(tamanoGrupo[i]);
            detalleOferta.setTipoGrupo(tipoGrupo[i]);
            insertarDetalleOferta(detalleOferta);
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

    /*
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
     */
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
        ContentValues carr = new ContentValues();
        carr.put("IDMATERIAACTIVA",ofertaAcademica.getIdMateriaActiva());
        carr.put("IDCICLO",ofertaAcademica.getIdCiclo());
        carr.put("IDASIGNATURA",ofertaAcademica.getIdAsignatura());
        carr.put("NOMBREMATERIAACTIVA",ofertaAcademica.getNombreMateriaActiva());
        contador=db.insert("OFERTAACADEMICA",null,carr);
        if(contador==-1||contador==0)
        {
            regInsertados="Error al Insertar el registro, Registro Duplicado.Verificar insercción";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarDetalleOferta(DetalleOferta detalleOferta){
        String regInsertados="Registro insertado N° =";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("IDGRUPO",detalleOferta.getIdGrupo());
        carr.put("IDMATERIAACTIVA",detalleOferta.getIdMateriaActiva());
        carr.put("NUMEROGRUPO",detalleOferta.getNumeroGrupo());
        carr.put("TAMANOGRUPO",detalleOferta.getTamanoGrupo());
        carr.put("TIPOGRUPO",detalleOferta.getTipoGrupo());
        contador=db.insert("DETALLEOFERTA",null,carr);
        if(contador==-1||contador==0)
        {
            regInsertados="Error al Insertar el registro, Registro Duplicado.Verificar insercción";
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
            ciclo.setNumeroCiclo(Integer.valueOf(cursor.getString(1)));
            ciclo.setFechaInicio(cursor.getString(2));
            ciclo.setFechaFin(cursor.getString(3));
            ciclo.setAnio(cursor.getString(4));
            return ciclo;
        }
        else{return null;}
    }
    public OfertaAcademica consultarOfertaAcademica(String idOfertaAcademica){
        String[] id={idOfertaAcademica};
        Cursor cursor=db.query("OFERTAACADEMICA",campoOfertaAcademica,"IDMATERIAACTIVA= ?",id,null,null,null);
        if(cursor.moveToFirst()){
            OfertaAcademica ofertaAcademica = new OfertaAcademica();
            ofertaAcademica.setIdMateriaActiva(cursor.getString(0));
            ofertaAcademica.setIdCiclo(cursor.getString(1));
            ofertaAcademica.setIdAsignatura(cursor.getString(2));
            ofertaAcademica.setNombreMateriaActiva(cursor.getString(3));
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
    public Ciclo actualizarCiclo(String idCiclo){

    }
}
