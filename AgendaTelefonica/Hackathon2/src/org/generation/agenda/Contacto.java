package org.generation.agenda;

public class Contacto {

    private String nombre;
    private String apellido;
    private String telefono;

    // -- CONSTRUCTOR -- \\

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // -- GETTERS Y SETTERS -- \\
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // -- TOSTRING -- \\
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Telefono: " + telefono + "\n";
    }
}//CLASS