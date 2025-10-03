package co.edu.uniquindio.poo.veterinariajfx.model;

public abstract class Mascota {
    // Atributos Propios
    protected String nombre;
    protected String id;
    protected String raza;
    protected Double peso;
    protected int EdadEnMeses;


    // Atributos de Relaciones
    private Propietario thePropietario;

    public Mascota(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Propietario getThePropietario() {
        return thePropietario;
    }

    public void setThePropietario(Propietario thePropietario) {
        this.thePropietario = thePropietario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getEdadEnMeses() {
        return EdadEnMeses;
    }

    public void setEdadEnMeses(int edadEnMeses) {
        EdadEnMeses = edadEnMeses;
    }
}



