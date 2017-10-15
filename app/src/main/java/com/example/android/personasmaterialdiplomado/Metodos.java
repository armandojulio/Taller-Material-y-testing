package com.example.android.personasmaterialdiplomado;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 07/10/2017.
 */

public class Metodos {
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static boolean exitePersona(ArrayList<Persona> personas, String cedula){
        for (int i = 0; i <personas.size() ; i++) {
            if(personas.get(i).getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    public static boolean comparar(Persona p1, Persona p2) {
        if ((p1.getFoto() == p2.getFoto()) && (p1.getCedula().equals(p2.getCedula())) &&
                (p1.getNombre().equals(p2.getNombre())) && (p1.getApellido().equals(p2.getApellido())) &&
                (p1.getSexo() == p2.getSexo())){
            return true;
        } else{
            return false;
        }
    }

    public static int obtenerPosicion(ArrayList<Persona> personas, Persona p){
        int pos=0;
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getCedula().equals(p.getCedula())){
                pos = i;
            }
        }
        return pos;
    }





}
