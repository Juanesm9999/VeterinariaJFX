package co.edu.uniquindio.poo.veterinariajfx.model;

public class Perro extends Mascota{
    private Tamanio tamanio;
    private String nivelAdiestramiento;
    private String NecesidadPaseosDiarios;

    public Perro(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String especie,Tamanio tamanio,String nivelAdiestramiento,String NecesidadPaseosDiarios) {
        super(nombre,id,raza,peso,edadEnMeses,especie);
        this.tamanio = tamanio;
        this.nivelAdiestramiento = nivelAdiestramiento;
        this.NecesidadPaseosDiarios = NecesidadPaseosDiarios;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    public String getNivelAdiestramiento() {
        return nivelAdiestramiento;
    }

    public void setNivelAdiestramiento(String nivelAdiestramiento) {
        this.nivelAdiestramiento = nivelAdiestramiento;
    }

    public String getNecesidadPaseosDiarios() {
        return NecesidadPaseosDiarios;
    }

    public void setNecesidadPaseosDiarios(String necesidadPaseosDiarios) {
        NecesidadPaseosDiarios = necesidadPaseosDiarios;
    }

}
