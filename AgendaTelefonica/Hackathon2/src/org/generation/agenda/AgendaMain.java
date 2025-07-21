package org.generation.agenda;

import java.util.Scanner;

public class AgendaMain implements Constantes {

    public static void main(String[] args) {

        // -- Creacion de escaners -- \\
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);

        Funciones funciones = new Funciones(); // Esta clase se encarga de administrar contactos

        int selectorOpciones = 6, tamanoAgenda = 0, selectorTamano = 0;

        System.out.println("Bienvenido. \nPara iniciar debe configurar el espacio de su agenta. \nIngrese '0' si desea el tamaño predeterminado de 10 \nIngrese '1' si desea configurar usted el tamaño para su agenda");
        selectorTamano = scanner3.nextInt();

        // -- Definir tamaño de la agenda -- \\
        if(selectorTamano == 0)
        {
            System.out.println("La capacidad de la agenda ha sido establecida para 10 contactos");
            funciones.crearListaContactos(tamanoAgenda);
        }
        else
        {
            while (tamanoAgenda <= 0)
            {
                System.out.println("Ingrese el tamaño que desea para su agenda");
                tamanoAgenda = scanner4.nextInt();
                if (tamanoAgenda <= 0)
                {
                    System.out.println("Ingrese un tamaño valido mayor a 0");
                }
                else
                {
                    funciones.crearListaContactos(tamanoAgenda);
                    System.out.println("La capacidad de la agenda ha sido establecida para " + tamanoAgenda + " contactos");
                }
            }
        }

        // -- MENU PRINCIPAL -- \\
        while(selectorOpciones != 0)
        {
            String nombreNContacto = "", apellidoNContacto = "", telefonoNContacto = "";

            System.out.println("¿Que desea realizar? \n[1]. Mostrar Contactos \n[2]. Agregar Contacto \n[3]. Modificar Numero de Contacto \n[4]. Eliminar Contacto \n[5]. Buscar Contacto \n[0]. Salir");
            selectorOpciones = scanner5.nextInt();

            switch (selectorOpciones)
            {
                case LISTAR_CONTACTOS:
                    System.out.println(funciones.mostrarContactos());
                    funciones.tamanodisponible();
                    break;

                case AGREGAR_CONTACTOS:
                    System.out.println("Ingrese el nombre: ");
                    nombreNContacto = leeCadena(nombreNContacto, scanner);
                    System.out.println("Ingrese el apellido: ");
                    apellidoNContacto = leeCadena(apellidoNContacto, scanner1);
                    System.out.println("Ingrese el numero: ");
                    telefonoNContacto = leeCadena(telefonoNContacto, scanner2);

                    funciones.agregarContacto(new Contacto(nombreNContacto, apellidoNContacto, telefonoNContacto));
                    funciones.tamanodisponible();
                    break;

                case MODIFICAR_TELEFONO:
                    System.out.println("Ingrese el nombre y apellido del contacto y el nuevo numero de telefono: ");
                    System.out.println("Ingrese el nombre: ");
                    nombreNContacto = scanner.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellidoNContacto = scanner1.nextLine();
                    System.out.println("Ingrese el numero: ");
                    telefonoNContacto = scanner2.nextLine();

                    funciones.modificarTelContacto(nombreNContacto, apellidoNContacto, telefonoNContacto);
                    break;

                case ELIMINAR_CONTACTO:
                    System.out.println("Ingrese el nombre y apellido del contacto a eliminar");
                    System.out.println("Ingrese el nombre: ");
                    nombreNContacto = scanner1.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellidoNContacto = scanner2.nextLine();
                    funciones.eliminarContacto(nombreNContacto, apellidoNContacto);
                    funciones.tamanodisponible();
                    break;

                case BUSCAR_CONTACTO:
                    System.out.println();
                    System.out.println("Ingrese el nombre y apellido del contacto a buscar");
                    System.out.println("Ingrese el nombre: ");
                    nombreNContacto = scanner1.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellidoNContacto = scanner2.nextLine();

                    System.out.println("El telefono del contacto buscado es: " + funciones.buscarContacto(nombreNContacto, apellidoNContacto));
                    break;
            }
        }
    }//main

    // -- VALIDACION DE CADENA VACIA -- \\
    public static String leeCadena(String cadena, Scanner scannerlocal)
    {
        cadena = scannerlocal.nextLine();
        if(cadena.isEmpty())
        {
            System.out.println("Cadena vacia. Ingrese nuevamente ");
            return leeCadena(cadena, scannerlocal);
        }
        else {
            return cadena;
        }
    }

}//class
