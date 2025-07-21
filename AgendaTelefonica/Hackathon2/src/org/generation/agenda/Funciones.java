package org.generation.agenda;

import java.util.*;

public class Funciones implements Constantes{

    // -- CREAR VARIABLES Y LISTA -- \\
    List<Contacto> contactosLista;
    int cantidadMaximaContactos = 0;

    // -- CREAR LISTA DE CONTACTOS -- \\
    public void crearListaContactos(int tamano){
        if(tamano != 0){
            cantidadMaximaContactos = tamano;
            contactosLista = new ArrayList<>(tamano);
        }
        else {
            cantidadMaximaContactos = 10;
            contactosLista = new ArrayList<>(10);
        }
    }

    // -- TAMAÑO LISTA --\\
    public int cantidadContactos(){
        return contactosLista.size();
    }

    // -- CONTACTO EXISTENTE -- \\
    //private void existeContacto(Contacto contacto){ System.out.println(contactosLista.contains(contacto));}

    // -- TAMAÑO RESTANTE -- \\
    public int tamanodisponible()
    {System.out.println("Espacios disponibles: " + (cantidadMaximaContactos - cantidadContactos()) + "\nEspacios utilizados: " + cantidadContactos());
        return cantidadMaximaContactos - cantidadContactos();
    }

    // -- AGREGAR CONTACTO -- \\
    public void agregarContacto(Contacto contacto){
        if(buscarContacto(contacto.getNombre(), contacto.getApellido()) != MENSAJE_DE_CONTACTO_NO_ENCONTRADO)
        {
            System.out.println("El contacto: " + contacto + " Ya existe"); // VALIDADOR DE CONTACTO EXISTE O NO
        }
        else
        {
            if(cantidadContactos() < cantidadMaximaContactos) // VERIFICADOR DE ESPACIO DE AGENDA
            {
                contactosLista.add(contacto);
            }
            else
            {
                System.out.println("Tamaño excedido contacto: " + contacto + " no ingresado");
            }
        }
    } //agregarContacto


    // -- MOSTRAR CONTACTOS --\\
    public String mostrarContactos(){
        StringBuilder listaContactosL = new StringBuilder();
        Collections.sort(contactosLista, new Comparator<Contacto>() { // ORDENA ALFABETICAMENTE LA AGENDA
            @Override
            public int compare(Contacto c1, Contacto c2) {
                return new String(c1.getNombre()).compareTo(new String(c2.getNombre()));
            }
        });
        Iterator<Contacto> iterator = contactosLista.iterator();
        while (iterator.hasNext())
        {
            listaContactosL.append(iterator.next());
        }
        return listaContactosL.toString();
    }//mostrarContactos

    // -- BUSCAR CONTACTO -- \\
    public String buscarContacto(String nombre, String apellido){
        Iterator<Contacto> iterador = contactosLista.iterator();
        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();
        while (iterador.hasNext())
        {
            Contacto contacto = iterador.next();
            String apellido2 = contacto.getApellido().toLowerCase();
            String nombre2 = contacto.getNombre().toLowerCase();
            if(nombre2.equals(nombre) && apellido2.equals(apellido))
            {
                return contacto.getTelefono();
            }
        }// while
        return MENSAJE_DE_CONTACTO_NO_ENCONTRADO;
    } //buscarContacto

    // -- ELIMINAR CONTACTO -- \\
    public void eliminarContacto(String nombre, String apellido){
        Iterator<Contacto> iterador = contactosLista.iterator();
        nombre = nombre.toLowerCase();
        boolean fueEncontrado = false;
        apellido = apellido.toLowerCase();
        while (iterador.hasNext() && !fueEncontrado) // BUSCAR CONTACTO
        {
            Contacto contacto = iterador.next();
            String apellido2 = contacto.getApellido().toLowerCase();
            String nombre2 = contacto.getNombre().toLowerCase();
            if(nombre2.equals(nombre) && apellido2.equals(apellido)) // ELIMINAR CONTACTO SI FUE ENCONTRADO
            {
                contactosLista.remove(contacto);
                System.out.println("Contacto eliminado");
                fueEncontrado = true;
                break;
            }
        }// while
        if(!fueEncontrado){
            System.out.println("El contacto no existe"); // CONTACTO NO ENCONTRADO PARA ELIMINACION
        }
    } //eliminarContacto

    // -- MODIFICAR TELEFONO -- \\
    public void modificarTelContacto(String nombre, String apellido, String telefono){
        int validadorMod = 0;
        Iterator<Contacto> iterador = contactosLista.iterator();
        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();
        while (iterador.hasNext()) // BUSCAR CONTACTO
        {
            Contacto contacto = iterador.next();
            String apellido2 = contacto.getApellido().toLowerCase();
            String nombre2 = contacto.getNombre().toLowerCase();
            if(nombre2.equals(nombre) && apellido2.equals(apellido))
            {
                contacto.setTelefono(telefono);
                validadorMod = 1;
                break;
            }
        }// while

        if(validadorMod == 1)
        {
            System.out.println("Contacto modificado");
        }
        else
        {
            System.out.println("Contacto no encontrado para modificacion");
        }
    } //modificarTelContacto


}// class

