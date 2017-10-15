package com.example.android.personasmaterialdiplomado;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void igualesIncorrecto(){

        assertFalse(Metodos.comparar(new Persona(1, "1140", "Armando", "julio", 0),
                new Persona(0, "1104", "Armando", "jose", 0)));
    }

    @Test
    public void igualescorrecto(){
        assertTrue(Metodos.comparar(new Persona(0, "1140", "Armando", "julio", 0),
                new Persona(0, "1140", "Armando", "julio", 0)));

    }


}