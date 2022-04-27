package com.edu.ues.fia.eisi.app_proyecto01;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends ListActivity {
    String[] menu={"Actividad","Detalle Actividad","Asistencia","Carrera",
            "Oferta Académica","Detalle Oferta",
            "Equipo Didáctico","Lista Equipo Didáctico","Escuela",
            "Horario","Lista Horario","Local","Materia","Miembro Universitario","Particular"};
            String[]
    activities={"AlumnoMenuActivity","NotaMenuActivity","MateriaMenuActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        if(position!=3){

            String nombreValue=activities[position];

            try{
                Class<?>
                        clase=Class.forName("com.edu.ues.fia.eisi.app_proyecto01."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{

//CODIGO PARA LLENAR BASE DE DATOS
        }
    }
}