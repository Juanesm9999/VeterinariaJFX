package co.edu.uniquindio.poo.veterinariajfx.model;

public class Reptil extends Mascota{
    private Habitat habitat;
    private String temperaturaOptima;
    private NivelPeligrosidad nivelPeligrosidad;
    public Reptil(String nombre,String id, String raza, Double peso,Integer edadEnMeses,Habitat HAbitat,String temperaturaOptima,NivelPeligrosidad nivelPeligrosidad){
        super(nombre,id,raza,peso,edadEnMeses);
        this.habitat = habitat;
        this.temperaturaOptima = temperaturaOptima;
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getTemperaturaOptima() {
        return temperaturaOptima;
    }

    public void setTemperaturaOptima(String temperaturaOptima) {
        this.temperaturaOptima = temperaturaOptima;
    }

    public NivelPeligrosidad getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setNivelPeligrosidad(NivelPeligrosidad nivelPeligrosidad) {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }
}
