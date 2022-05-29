package com.edu.ues.fia.eisi.app_proyecto01;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorServicio {
    public static String obtenerRespuestaPeticion(String url, Context ctx) {
        String respuesta = " ";
        // Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 5000);
        HttpConnectionParams.setSoTimeout(parametros, 8000);
        // Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }
    public static String obtenerRespuestaPost(String url, JSONObject obj,
                                              Context ctx) {
        String respuesta = " ";
        try {
            HttpParams parametros = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(parametros, 3000);
            HttpConnectionParams.setSoTimeout(parametros, 5000);
            HttpClient cliente = new DefaultHttpClient(parametros);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            StringEntity nuevaEntidad = new StringEntity(obj.toString());
            httpPost.setEntity(nuevaEntidad);
            Log.v("Peticion",url);
            Log.v("POST", httpPost.toString());
            HttpResponse httpRespuesta = cliente.execute(httpPost);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                respuesta = Integer.toString(codigoEstado);
                Log.v("respuesta",respuesta);
            }
            else{
                Log.v("respuesta",Integer.toString(codigoEstado));
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }
//Creo que este se reutiiza
    public static void insertar(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+ resultado.getJSONArray("resultado"), Toast.LENGTH_LONG).show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error registro duplicado", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static String obtenerCarreraJSON(String json, Context ctx) {
        try {
            JSONArray objs = new JSONArray(json);
            if (objs.length() != 0)
                //NOTAFINAL PROMEDIO
                return objs.getJSONObject(0).getString("CARRE");
            else {
                Toast.makeText(ctx, "Error carrera no existe", Toast.LENGTH_LONG).show();
                return " ";
            }
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error con la respuesta JSON", Toast.LENGTH_LONG).show();
            return " ";
        }
    }
    public static List<Escuela> obtenerEscuelaExterno(String json, Context ctx)
    {
        List<Escuela> listaMaterias = new ArrayList<Escuela>();
        try {
            JSONArray materiasJSON = new JSONArray(json);
            for (int i = 0; i < materiasJSON.length(); i++) {
                JSONObject obj = materiasJSON.getJSONObject(i);
                Escuela materia = new Escuela();
                materia.setIDESCUELA(obj.getString("IDESCUELA"));
                materia.setIDCARRERA(obj.getString("IDCARRERA"));
                materia.setNOMBRE_ESCUELA(obj.getString("NOMBRE_ESCUELA"));
                listaMaterias.add(materia);
            }
            return listaMaterias;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseOO de JSON", Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }

    public static List<Actividad> obtenerActividadExterno(String json, Context ctx){
        List<Actividad> listaActividad = new ArrayList<Actividad>();
        Actividad _actividad = new Actividad();

        try{
            JSONArray actividadJson = new JSONArray(json);

            for(int i = 0; i < actividadJson.length(); i++){
                JSONObject obj = actividadJson.getJSONObject(i);
                _actividad.setIdActividad(obj.getString("IDACTIVIDAD"));
                _actividad.setIdMiembroUniversitario(obj.getString("IDMIEMBROUNIVERSITARIO"));
                _actividad.setNombreActividad(obj.getString("NOMBREACTIVIDAD"));
                _actividad.setFechaReserva(obj.getString("FECHARESERVA"));
                _actividad.setDesdeActividad(obj.getString("DESDEACTIVIDAD"));
                _actividad.setHastaActividad(obj.getString("HASTACTIVIDAD"));
                _actividad.setAprobado(obj.getString("APROBADO"));

                listaActividad.add(_actividad);

            }
            return listaActividad;
        }
        catch (Exception e){
            Toast.makeText(ctx, "Error en parseOO de JSON", Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }


    public static void ActualizarCarreraExterno(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado2 = new JSONObject(json);
            Toast.makeText(ctx, "Registro Actualizado"+ resultado2.getJSONArray("resultado"), Toast.LENGTH_LONG).show();
            int respuesta = resultado2.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro Actualizado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error no existe", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static void ActualizarEscuelaExterno(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado2 = new JSONObject(json);
            Toast.makeText(ctx, "Registro Actualizado"+ resultado2.getJSONArray("resultado"), Toast.LENGTH_LONG).show();
            int respuesta = resultado2.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro Actualizado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error no existe", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static void EliminarescuelaExterno(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado2 = new JSONObject(json);
            Toast.makeText(ctx, "Registro Actualizado"+ resultado2.getJSONArray("resultado"), Toast.LENGTH_LONG).show();
            int respuesta = resultado2.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro Actualizado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error no existe", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
