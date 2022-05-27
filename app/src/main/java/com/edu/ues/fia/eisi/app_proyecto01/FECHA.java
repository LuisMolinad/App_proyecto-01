package com.edu.ues.fia.eisi.app_proyecto01;

public class FECHA {

    private int dia;
    private int mes;
    private int anio;

    public FECHA(int dia, int mes, int anio){
        dia = this.dia;
        mes = this.mes;
        anio = this.anio;
    }

    public FECHA(){}

    public String toString(){
        return dia + "/" + mes + "/" +anio;
    }

    public  int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAnio(){
        return anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean validarFecha(FECHA fecha){
        //Validamos el dia
        if ((fecha.getDia() > 0 && fecha.getDia() < 32 ) && ( fecha.getMes() < 13 && fecha.getMes() > 0) && ( fecha.getAnio() >= 2000 && fecha.getAnio() <= 2050) ){
            if (( fecha.getDia() >=30 && fecha.getMes() == 2) || ( fecha.getDia() >=31 && ( fecha.getMes() == 4 || fecha.getMes() == 6 || fecha.getMes() == 9 || fecha.getMes() == 11 ))){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public FECHA parseFecha(String myString){
        char[] myChars = myString.toCharArray();
        int contador = 0;

        String _dia = "", _mes = "", _anio = "";

        for (int i=0; i<myChars.length; i++){
            System.out.println(myChars[i]);

            if(myChars[i] == '/'){
                contador++;
            }
            else{

                if(contador == 0){
                    _dia += myChars[i];
                }
                else if(contador == 1){
                    _mes += myChars[i];
                }
                else if(contador == 2){
                    _anio += myChars[i];
                }
            }
        }

        dia = Integer.parseInt(_dia);
        mes = Integer.parseInt(_mes);
        anio = Integer.parseInt(_anio);

        FECHA fecha = new FECHA();

        fecha.setDia(dia);
        fecha.setMes(mes);
        fecha.setAnio(anio);


        return fecha;
    }
}
