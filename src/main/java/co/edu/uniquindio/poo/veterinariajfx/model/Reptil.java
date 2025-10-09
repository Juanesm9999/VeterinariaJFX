package co.edu.uniquindio.poo.veterinariajfx.model;

public class Reptil extends Mascota{
    private Habitat habitat;
    private String temperaturaOptima;
    private NivelPeligrosidad nivelPeligrosidad;
    public Reptil(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String especie, Habitat HAbitat,String temperaturaOptima,NivelPeligrosidad nivelPeligrosidad){
        super(nombre,id,raza,peso,edadEnMeses,especie);
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
    public double CalcularCostoConsulta(boolean tipoConsulta ,double precioBase,Integer edadEnMeses,double costoTotal,String Especie){
        precioBase = precioBase * 1.25;

        if(getEdadEnMeses()>84){
            costoTotal = precioBase * 1.5;
        }
        for(int i=0;i < getlistConsultas().size();i++){
            Consulta consulta = getlistConsultas().get(i);
            if(consulta.getId().equals(id)){
                if(consulta.getTipoConsulta().equals(tipoConsulta)){
                    costoTotal = precioBase * 1.75;
                }
            }

        }

        return costoTotal;
    }

}
