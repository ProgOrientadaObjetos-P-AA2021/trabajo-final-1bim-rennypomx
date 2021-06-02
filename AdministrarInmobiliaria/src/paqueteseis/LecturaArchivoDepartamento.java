/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

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
public class LecturaArchivoDepartamento {
   private ObjectInputStream entrada;
    private ArrayList<Departamento> depa;
    private String nombreArchivo;

    public LecturaArchivoDepartamento(String n) {
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

    public void establecerListaDepartamento() {
        // 
        depa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    depa.add(registro);
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

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return depa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "-------------------------------------------------\n"
                + "\t\tLista de Departamentos\n"
                + "----------------------------------------------------\n";
        for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento p = obtenerListaDepartamento().get(i);
            cadena = String.format("%sPropietario %s\n"
                    + "------------------------------------------------------\n"
                    + "\tNombre: %s\n"
                    + "\tApellido: %s\n"
                    + "\tIdentificacion: %s\n"
                    + "Precio por metro Cuadrado: %s\n"
                    + "Numero de metro cuadrado: %s\n"
                    + "Valor Alícuota Mensual: %s\n"
                    + "Costo Final: %s\n"
                    + "Precio: %s\n"
                    + "Ubicacion:\n\tNúmero de casa: %s\n"
                    + "\tNombre del barrio: %s\n\tReferencia: %s\n"
                    + "Ciudad:\n\tNombre de la ciudad: %s\n"
                    + "\tNombre de la provincia: %s\n"
                    + "Nombre del edificio: %s\n"
                    + "Constructora:\n\tNombre de la constructora: %s\n"
                    + "\tId de la empresa: %s\n"
                    + "----------------------------------------------------\n",
                    cadena, i+1, p.obtenerPropietario().obtenerNombre(),
                    p.obtenerPropietario().obtenerApellido(),
                    p.obtenerPropietario().obtenerIdentificacion(),
                    p.obtenerPrecMetCuadrado(),
                    p.obtenerNumMetCuadrado(),
                    p.obtenerValAliMensual(),
                    p.obtenerCostoFinal(),
                    p.obtenerPrecio(),
                    p.obtenerUbicacion().obtenerNumeroCasa(),
                    p.obtenerUbicacion().obtenerNomBarrio(),
                    p.obtenerUbicacion().obtenerReferencia(),
                    p.obtenerCiudad().obtenerNomCiudad(),
                    p.obtenerCiudad().obtenerNomProvincia(),
                    p.obtenerNomEdificio(),
                    p.obtenerConstructora().obtenerNomConstructora(),
                    p.obtenerConstructora().obtenerIdEmpresa());
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
