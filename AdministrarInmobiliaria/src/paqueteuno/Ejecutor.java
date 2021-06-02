/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecinco.EscrituraArchivoConstructora;
import paquetecinco.LecturaArchivosConstructora;
import paquetecuatro.Ciudad;
import paquetecuatro.EscrituraArchivoCiudad;
import paquetecuatro.LecturaArchivoCiudad;
import paquetedos.EscrituraArchivoPropietario;
import paquetedos.LecturaArchivoPropietario;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paqueteseis.EscrituraArchivoCasa;
import paqueteseis.EscrituraArchivoDepartamento;
import paqueteseis.LecturaArchivoCasa;
import paqueteseis.LecturaArchivoDepartamento;
import paquetetres.EscrituraArchivoUbicacion;
import paquetetres.LecturaArchivoUbicacion;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    
public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----SISTEMA DE GESTION INMOBILIARIA-----");
        boolean bandera = true;
        int opcion, datosIngresar;

        while (bandera) {
            System.out.print("\n> Escoja la opcion que desea ingresar\n"
                    + "1) Digite 1 si desea ingresar una Casa\n"
                    + "2) Digite 2 si desea ingresar un Departamento\n"
                    + "3) Digite 3 si desea ingresar propietarios\n"
                    + "4) Digite 4 si desea ingresar ubicaciones\n"
                    + "5) Digite 5 si desea ingresar ciudades\n"
                    + "6) Digite 6 si desea ingresar constructoras\n"
                    + "7) Digite 7 si desea ver los datos ingresados\n"
                    + "8) Digite 8 si desea salir\n"
                    + "--------------------------------------------------\n");
            opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion == 1) {
                System.out.print("Digite cuantas casas desea ingresar\n");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseCasa();
                }
            } else if (opcion == 2) {
                System.out.print("Digite cuantos Departamentos "
                        + "desea ingresar\n");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseDepartamento();
                }
            } else if (opcion == 3) {
                System.out.print("Digite cuantos propietarios desea"
                        + " ingresar\n> ");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingresePropietario();
                }
            } else if (opcion == 4) {
                System.out.print("Digite cuantas ubicaciones desea "
                        + "ingresar\n");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseUbicacion();
                }
            } else if (opcion == 5) {
                System.out.print("Digite cuantas ciudades desea ingresar\n");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseCiudad();
                }
            } else if (opcion == 6) {
                System.out.print("Digite cuantas constructoras "
                        + "desea ingresar\n");
                datosIngresar = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < datosIngresar; i++) {
                    ingreseConstructora();
                }
            } else if (opcion == 7) {
                System.out.print("Digite el dato que desea ver:\n"
                        + "1) Casa\n"
                        + "2) Departamentos\n"
                        + "3) Propietarios\n"
                        + "4) Ubicaciones\n"
                        + "5) Ciudades\n"
                        + "6) Constructoras\n"
                        + "7) Todos los datos\n");
                int verDatos = entrada.nextInt();
                mostrarDatos(verDatos);
            } else if (opcion == 8) {
                System.out.println("Opcion Incorrecta");
                bandera = false;
            }
        }
    }
    public static Propietario ingresePropietario() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoProp = "datos/propietarios.txt";
        Propietario p = new Propietario();
        String iden, verDatos, nom, apell;
        LecturaArchivoPropietario lecturaProp = new LecturaArchivoPropietario
        (nomArchivoProp);
        EscrituraArchivoPropietario archivoProp = new 
        EscrituraArchivoPropietario(nomArchivoProp);
        System.out.println("-----PROCESO PARA INGRESAR PROPIETARIOS-----");
        System.out.print("Ingrese su identificacion\n");
        iden = entrada.nextLine();
        lecturaProp.establecerObjetoBuscado(iden);
        lecturaProp.establecerBooleanBuscado();
        if (!lecturaProp.obtenerBooleanBuscado()) {
            p = new Propietario(lecturaProp.obtenerObjetoBuscado()
                    .obtenerNombre(),
                    lecturaProp.obtenerObjetoBuscado().obtenerApellido(), iden);
            System.out.printf("La identificacion con el numero %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", iden);
            verDatos = entrada.nextLine();
            if (verDatos.toLowerCase().equals("si")) {
                System.out.printf("Nombre : %s\n"
                        + "Apellido: %s\n",
                        lecturaProp.obtenerObjetoBuscado().obtenerNombre(),
                        lecturaProp.obtenerObjetoBuscado().obtenerApellido());

            }

        } else if (lecturaProp.obtenerBooleanBuscado()) {
            System.out.print("Ingrese el nombre\n");
            nom = entrada.nextLine();
            System.out.print("Ingrese su apellido\n");
            apell = entrada.nextLine();
            p = new Propietario(nom, apell, iden);
            archivoProp.establecerRegistroPropietario(p);
            archivoProp.establecerSalida();
            archivoProp.cerrarArchivo();
        }
        return p;
    }

    public static Ubicacion ingreseUbicacion() {
        Scanner entrada = new Scanner(System.in);
  
        String nomArchivoUbi = "datos/ubicaciones.txt";
        String verDatos, nomBarrio, numCasa, refe;
        Ubicacion u = new Ubicacion();
        EscrituraArchivoUbicacion archivoUbi = new EscrituraArchivoUbicacion
        (nomArchivoUbi);
        LecturaArchivoUbicacion lecturaUbi = new LecturaArchivoUbicacion
        (nomArchivoUbi);
        System.out.println("-----PROCESO PARA INGRESAR UBICACIONES-----");
        System.out.print("Ingrese el número de casa\n");
        numCasa = entrada.nextLine();
        
        lecturaUbi.establecerObjetoBuscado(numCasa);
        lecturaUbi.establecerBooleanBuscado();
        if (!lecturaUbi.obtenerBooleanBuscado()) {
            u = new Ubicacion(numCasa,
                    lecturaUbi.obtenerObjetoBuscado().obtenerNomBarrio(),
                    lecturaUbi.obtenerObjetoBuscado().obtenerReferencia());
            System.out.printf("El numero de casa %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n> ", numCasa);
            verDatos = entrada.nextLine();
            if (verDatos.toLowerCase().equals("si")) {
                System.out.printf("Barrio: %s\n"
                        + "Referencia: %s\n",
                        lecturaUbi.obtenerObjetoBuscado().obtenerNomBarrio(),
                        lecturaUbi.obtenerObjetoBuscado().obtenerReferencia());
            }
        } else if (lecturaUbi.obtenerBooleanBuscado()) {
            System.out.print("Ingrese el nombre de barrio\n> ");
            nomBarrio = entrada.nextLine();
            System.out.print("Ingrese una referencia\n> ");
            refe = entrada.nextLine();
            u = new Ubicacion(numCasa, nomBarrio, refe);
            archivoUbi.establecerRegistroUbicacion(u);
            archivoUbi.establecerSalida();
            archivoUbi.cerrarArchivo();

        }
        return u;
    }

    public static Ciudad ingreseCiudad() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCiu = "datos/ciudades.txt";
        Ciudad c = new Ciudad();
        String nomCiudad, verDatos, nomProvincia;
        EscrituraArchivoCiudad archivoCiu = new EscrituraArchivoCiudad
        (nomArchivoCiu);
        LecturaArchivoCiudad lecturaCiu = new LecturaArchivoCiudad
        (nomArchivoCiu);
        System.out.println("-----PROCESO PARA INGRESAR CIUDADES-----");
        System.out.print("Ingrese el nombre de la ciudad\n");
        nomCiudad = entrada.nextLine();
      
        lecturaCiu.establecerObjetoBuscado(nomCiudad);
        lecturaCiu.establecerBooleanBuscado();
        if (!lecturaCiu.obtenerBooleanBuscado()) {
            c = new Ciudad(nomCiudad,
                    lecturaCiu.obtenerObjetoBuscado().obtenerNomProvincia());
            System.out.printf("La ciudad %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n> ", nomCiudad);
            verDatos = entrada.nextLine();
            if (verDatos.toLowerCase().equals("si")) {
                System.out.printf("Provincia: %s\n",
                       lecturaCiu.obtenerObjetoBuscado().obtenerNomProvincia());

            }
        } else if (lecturaCiu.obtenerBooleanBuscado()) {
            System.out.print("Ingrese el nombre de la provinvia\n> ");
            nomProvincia = entrada.nextLine();
            c = new Ciudad(nomCiudad, nomProvincia);
            archivoCiu.establecerRegistroCiudad(c);
            archivoCiu.establecerSalida();
            archivoCiu.cerrarArchivo();
        }

        return c;

    }

    public static Constructora ingreseConstructora() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCons = "datos/constructoras.txt";
        Constructora cons = new Constructora();
        EscrituraArchivoConstructora archivoCons = new 
        EscrituraArchivoConstructora(nomArchivoCons);
        LecturaArchivosConstructora lecturaCons = new 
        LecturaArchivosConstructora(nomArchivoCons);
        String nomCons, idEmpresa, verDatos;
        System.out.println("-----PROCESO PARA INGRESAR CONSTRUCTORAS-----");
        System.out.print("Ingrese el Id de la empresa\n");
        idEmpresa = entrada.nextLine();

        lecturaCons.establecerObjetoBuscado(idEmpresa);
        lecturaCons.establecerBooleanBuscado();
        if (!lecturaCons.obtenerBooleanBuscado()) {
            cons = new Constructora(idEmpresa,
                  lecturaCons.obtenerObjetoBuscado().obtenerNomConstructora());
            System.out.printf("El numero de casa %s ya "
                    + "se encuentra registrada\n"
                    + "Digite (si) si desea ver los datos\n", idEmpresa);
            verDatos = entrada.nextLine();

            if (verDatos.toLowerCase().equals("si")) {
                System.out.printf("Constructora: %s\n",
                   lecturaCons.obtenerObjetoBuscado().obtenerNomConstructora());
            }
        } else if (lecturaCons.obtenerBooleanBuscado()) {
            System.out.print("Ingrese el nombre de la constructora\n> ");
            nomCons = entrada.nextLine();
            cons = new Constructora(idEmpresa, nomCons);
            archivoCons.establecerRegistroConstructora(cons);
            archivoCons.establecerSalida();
            archivoCons.cerrarArchivo();
        }

        return cons;
    }

    public static void ingreseCasa() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoCasa = "datos/casas.txt";
        double precioCuadrado;
        int numMetCuadrado, numCuartos;
        EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa
        (nomArchivoCasa);
        System.out.println("-----PROCESO PARA INGRESAR CASAS-----");
        Propietario p = ingresePropietario();
        System.out.print("Ingrese el precio por metro cuadrado\n ");
        precioCuadrado = entrada.nextDouble();
        System.out.print("Ingrese el numero de metros cuadrados\n ");
        numMetCuadrado = entrada.nextInt();
        Ubicacion u = ingreseUbicacion();
        Ciudad c = ingreseCiudad();
        System.out.print("Ingrese el numero de cuartos\n");
        numCuartos = entrada.nextInt();
        Constructora cons = ingreseConstructora();
        Casa cs = new Casa(p, precioCuadrado, numMetCuadrado, u,
                c, numCuartos, cons);
        cs.establecerCostFinal();
        archivoCasa.establecerRegistroCasa(cs);
        archivoCasa.establecerSalida();
        archivoCasa.cerrarArchivo();

    }

    public static void ingreseDepartamento() {
        Scanner entrada = new Scanner(System.in);
        String nomArchivoDepa = "datos/departamentos.txt";
        double precioCuadrado, valAliMens, precio;
        int numMetCuadrado;
        String nomEdi, ubiEdi;
        EscrituraArchivoDepartamento archivoDepa = new 
        EscrituraArchivoDepartamento(nomArchivoDepa);
        System.out.println("-----PROCESO PARA INGRESAR DEPARTAMENTOS-----");
        Propietario p = ingresePropietario();
        System.out.print("Ingrese el precio por metro cuadrado\n");
        precioCuadrado = entrada.nextDouble();
        System.out.print("Ingrese el numero de metros cuadrados\n");
        numMetCuadrado = entrada.nextInt();
        System.out.print("Ingrese el valor alicuota mensual\n");
        valAliMens = entrada.nextDouble();
        System.out.print("Ingrese el precio\n");
        precio = entrada.nextDouble();
        entrada.nextLine();
        Ubicacion u = ingreseUbicacion();
        Ciudad c = ingreseCiudad();
        System.out.print("Ingrese el nombre del edificio\n");
        nomEdi = entrada.nextLine();
        System.out.print("Ingrese ubicacion del departamento del edificio\n> ");
        ubiEdi = entrada.nextLine();
        Constructora cons = ingreseConstructora();
        Departamento depa = new Departamento(p, precioCuadrado,
                numMetCuadrado, valAliMens, precio, u, c, nomEdi, ubiEdi, cons);
        depa.establecerCostoFinal();
        archivoDepa.establecerRegistroDepa(depa);
        archivoDepa.establecerSalida();
        archivoDepa.cerrarArchivo();

    }

    public static void mostrarDatos(int n) {
        String nomArchivoCons = "datos/constructoras.txt";
        String nomArchivoCiu = "datos/ciudades.txt";
        String nomArchivoUbi = "datos/ubicaciones.txt";
        String nomArchivoProp = "datos/propietarios.txt";
        String nomArchivoCasa = "datos/casas.txt";
        String nomArchivoDepa = "datos/departamentos.txt";

        LecturaArchivosConstructora lecturaCons = new 
        LecturaArchivosConstructora(nomArchivoCons);
        LecturaArchivoCiudad lecturaCiu = new LecturaArchivoCiudad
        (nomArchivoCiu);
        LecturaArchivoUbicacion lecturaUbi = new LecturaArchivoUbicacion
        (nomArchivoUbi);
        LecturaArchivoPropietario lecturaProp = new LecturaArchivoPropietario
        (nomArchivoProp);
        LecturaArchivoCasa lecturaCasa = new LecturaArchivoCasa(nomArchivoCasa);
        LecturaArchivoDepartamento lecturaDepa = new LecturaArchivoDepartamento
        (nomArchivoDepa);
        lecturaCons.establecerListaConstructora();
        lecturaCiu.establecerListaCiudad();
        lecturaUbi.establecerListaUbicacion();
        lecturaProp.establecerListaPropietarios();
        lecturaCasa.establecerListaCasa();
        lecturaDepa.establecerListaDepartamento();
        switch (n) {
            case 1:
                if (lecturaCasa.obtenerListaCasa().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaCasa);
                }
                break;
            case 2:
                if (lecturaDepa.obtenerListaDepartamento().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaDepa);
                }
                break;
            case 3:
                if (lecturaProp.obtenerListaPropietarios().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaProp);
                }
                break;
            case 4:
                if (lecturaUbi.obtenerListaUbicacion().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaUbi);
                }
                break;
            case 5:
                if (lecturaCiu.obtenerListaCiudad().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaCiu);
                }
                break;
            case 6:
                if (lecturaCons.obtenerListaConstructora().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                } else {
                    System.out.println(lecturaCons);
                }
                break;
            case 7:
                if (lecturaCasa.obtenerListaCasa().isEmpty()
                        && lecturaDepa.obtenerListaDepartamento().isEmpty()
                        && lecturaProp.obtenerListaPropietarios().isEmpty()
                        && lecturaUbi.obtenerListaUbicacion().isEmpty()
                        && lecturaCiu.obtenerListaCiudad().isEmpty()
                        && lecturaCons.obtenerListaConstructora().isEmpty()) {
                    System.out.println("--No hay datos que mostrar--");
                }
                if (!lecturaCasa.obtenerListaCasa().isEmpty()) {
                    System.out.println(lecturaCasa);
                }
                if (!lecturaDepa.obtenerListaDepartamento().isEmpty()) {
                    System.out.println(lecturaDepa);
                }
                if (!lecturaProp.obtenerListaPropietarios().isEmpty()) {
                    System.out.println(lecturaProp);
                }
                if (!lecturaUbi.obtenerListaUbicacion().isEmpty()) {
                    System.out.println(lecturaUbi);
                }
                if (!lecturaCiu.obtenerListaCiudad().isEmpty()) {
                    System.out.println(lecturaCiu);
                }
                if (!lecturaCons.obtenerListaConstructora().isEmpty()) {
                    System.out.println(lecturaCons);
                }

                break;
            default:
                System.out.println("\033[0;1mOpcion Incorrecta");
                break;
        }
    }
}

