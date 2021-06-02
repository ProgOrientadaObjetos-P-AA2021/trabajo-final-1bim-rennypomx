/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author D E L L
 */
public class LecturaArchivoUbicacion {
    
  private ObjectInputStream entrada;
    private ArrayList<Ubicacion> ubicacion;
    private String nombreArchivo;
    private Ubicacion objetoBuscado;
    private boolean booleanBuscado;

    public LecturaArchivoUbicacion(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaUbicacion() {
        // 
        ubicacion = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    ubicacion.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public void establecerObjetoBuscado(String n) {
        establecerListaUbicacion();
        ArrayList<Ubicacion> listaUbicacion = obtenerListaUbicacion();
        for (int i = 0; i < listaUbicacion.size(); i++) {
            Ubicacion u = listaUbicacion.get(i);
            if (u.obtenerNumeroCasa().equals(n)) {
                objetoBuscado = u;
            }
        }
    }

    public void establecerBooleanBuscado() {
        boolean bandera = true;
        if (objetoBuscado != null) {
            bandera = false;
        }
        booleanBuscado = bandera;
    }

    public ArrayList<Ubicacion> obtenerListaUbicacion() {
        return ubicacion;
    }

    public Ubicacion obtenerObjetoBuscado() {
        return objetoBuscado;
    }

    public boolean obtenerBooleanBuscado() {
        return booleanBuscado;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "--------------------------\n"
                + "\t\tLista de Ubicaciones\n"
                + "--------------------------------------------------\n";
        for (int i = 0; i < obtenerListaUbicacion().size(); i++) {
            Ubicacion p = obtenerListaUbicacion().get(i);
            cadena = String.format("%sUbicacion %s\n"
                    + "---------------------------------------------\n"
                    + "Número de casa: %s\nNombre del barrio: %s\n"
                    + "Referencia: %s\n"
                    + "---------------------------------------------\n", 
                    cadena, i+1,
                    p.obtenerNumeroCasa(),
                    p.obtenerNomBarrio(),
                    p.obtenerReferencia());

        }

        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}

