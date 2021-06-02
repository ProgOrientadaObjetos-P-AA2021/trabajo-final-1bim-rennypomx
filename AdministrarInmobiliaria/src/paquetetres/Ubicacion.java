/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable{
    
    private String numeroCasa;
    private String nombreBarrio;
    private String referencia;
    public Ubicacion(){
    }
    public Ubicacion(String numCasa, String nombreBarrio, String refer){
        numeroCasa = numCasa;
        nombreBarrio = nombreBarrio;
        referencia = refer;
    }
    
    public void establecerNumeroCasa(String n) {
        numeroCasa = n;
    }

    public void establecerNomBarrio(String n) {
        nombreBarrio = n;
    }

    public void establecerReferencia(String n) {
        referencia = n;
    }

    public String obtenerNumeroCasa() {
        return numeroCasa;
    }

    public String obtenerNomBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("DATOS DE LA UBICACIÓN\n"
                + "Número de casa: %s\n"
                + "Nombre del barrio: %s\n"
                + "Referencia: %s\n",
                obtenerNumeroCasa(),
                obtenerNomBarrio(),
                obtenerReferencia());
        return cadena;
    }
    
}

