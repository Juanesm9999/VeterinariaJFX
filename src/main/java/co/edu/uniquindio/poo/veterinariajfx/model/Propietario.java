package co.edu.uniquindio.poo.veterinariajfx.model;

public class Propietario {
    // Atributos Propios
    private String nombre;
    private String id;
    private String direccion;
    private Double PuntajeFidelidad;

    // Atributos de Relaciones
    private Mascota[] listMascotas;

    public Propietario(String nombre, String id, String direccion, Double PuntajeFidelidad) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;  // AGREGADO: inicializar direccion
        this.PuntajeFidelidad = PuntajeFidelidad;  // AGREGADO: inicializar PuntajeFidelidad
        listMascotas = new Mascota[10];
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPuntajeFidelidad() {
        return PuntajeFidelidad;
    }

    public void setPuntajeFidelidad(Double puntajeFidelidad) {
        PuntajeFidelidad = puntajeFidelidad;
    }

    public Mascota[] getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(Mascota[] listMascotas) {
        this.listMascotas = listMascotas;
    }
}