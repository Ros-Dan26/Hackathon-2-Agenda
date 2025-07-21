package org.generation.agenda;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
class FuncionesTest {

    Funciones funciones;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        funciones = new Funciones();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Prueba de Crear Lista")
    void crearListaContactos() {
        int size = 10;
        funciones.crearListaContactos(size);

        assertEquals(size, funciones.tamanodisponible());
    }

    @org.junit.jupiter.api.Test
    void tamanodisponible() {
        int size = 10;
        funciones.crearListaContactos(size);

        assertEquals(0, funciones.cantidadContactos());
    }

    @org.junit.jupiter.api.Test
    void agregarContacto() {

        Contacto contacto = new Contacto("Daniel", "Arias", "5511223344");

        funciones.crearListaContactos(5);
        funciones.agregarContacto(contacto);

        assertEquals(contacto, funciones.contactosLista.get(0));
    }

    @org.junit.jupiter.api.Test
    void mostrarContactos() {
        Contacto contacto = new Contacto("Daniel", "Arias", "5511223344");

        funciones.crearListaContactos(5);
        funciones.agregarContacto(contacto);

        assertEquals(contacto.toString(), funciones.mostrarContactos());
    }

    @org.junit.jupiter.api.Test
    void buscarContacto() {
        Contacto contacto = new Contacto("Daniel", "Arias", "5511223344");

        funciones.crearListaContactos(5);
        funciones.agregarContacto(contacto);

        assertEquals(contacto.getTelefono(), funciones.buscarContacto(contacto.getNombre(), contacto.getApellido()));
    }

    @org.junit.jupiter.api.Test
    void eliminarContacto() {
        Contacto contacto = new Contacto("Daniel", "Arias", "5511223344");

        funciones.crearListaContactos(5);
        funciones.agregarContacto(contacto);
        funciones.eliminarContacto(contacto.getNombre(), contacto.getApellido());

        assertEquals(Constantes.MENSAJE_DE_CONTACTO_NO_ENCONTRADO, funciones.buscarContacto(contacto.getNombre(), contacto.getApellido()));
    }

    @org.junit.jupiter.api.Test
    void modificarTelContacto() {
        Contacto contacto = new Contacto("Daniel", "Arias", "5511223344");

        funciones.crearListaContactos(5);
        funciones.agregarContacto(contacto);
        funciones.modificarTelContacto(contacto.getNombre(), contacto.getApellido(), "5588779911");

        assertEquals("5588779911", funciones.buscarContacto(contacto.getNombre(), contacto.getApellido()));
    }
}
