package com.edu.ues.fia.eisi.app_proyecto01;

public class Rutas {
    private static String ruta = "http://192.168.1.8/Proyecto01Servicios/";

    public static String insert(String string){
        String cadena = ruta + string + "/insert.php";
        return cadena;
    }
    public static String update(String string){
        String cadena = ruta + string + "/update.php";
        return cadena;
    }
    public static String query(String string){
        String cadena = ruta + string + "/query.php";
        return cadena;
    }
    public static String conexion(String string){
        String cadena = ruta + string + "/conexion.php";
        return cadena;
    }
    public static String delete(String string){
        String cadena = ruta + string + "/delete.php";
        return cadena;
    }
}
