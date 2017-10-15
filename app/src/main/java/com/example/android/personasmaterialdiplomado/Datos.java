package com.example.android.personasmaterialdiplomado;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {
    private static ArrayList<Persona> personas = new ArrayList();

    public static void guardarPersona(Persona p) {
        personas.add(p);
    }

    public static void editarPersona(int pos, Persona p){
        personas.set(pos, p);
    }

    public static ArrayList<Persona> obtenerPersonas() {
        return personas;
    }

    public static boolean eliminarPersona(Persona p){
        for (int i = 0; i <personas.size() ; i++) {
            if(p.getCedula().equals(personas.get(i).getCedula())){
                personas.remove(i);
                return true;
            }
        }
        return false;

    }

}

