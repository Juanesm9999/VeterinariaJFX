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
    @Override
    public double CalcularCostoConsulta(boolean tipoConsulta , double precioBase, Integer edadEnMeses, double costoTotal, String Especie){
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
