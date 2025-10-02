package co.edu.uniquindio.poo.veterinariajfx.model;

public class Veterinaria {
    private String nombre;
    private String nit;

    public Veterinaria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}
