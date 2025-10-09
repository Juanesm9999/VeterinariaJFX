package co.edu.uniquindio.poo.veterinariajfx.model;

public class Ave extends Mascota{
    private String TIpoDePlumaje;
    private Boolean CapacidadDeVuelo;
    private String CantidadDeImitaciones;
    public Ave(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String especie,String TipoDePlumaje,Boolean CapacidadDeVuelo,String CapacidadDeImitaciones){
        super(nombre,id,raza,peso,edadEnMeses,especie);
        this.TIpoDePlumaje = TipoDePlumaje;
        this.CapacidadDeVuelo = CapacidadDeVuelo;
        this.CantidadDeImitaciones = CapacidadDeImitaciones;
    }

    public String getTIpoDePlumaje() {
        return TIpoDePlumaje;
    }

    public void setTIpoDePlumaje(String TIpoDePlumaje) {
        this.TIpoDePlumaje = TIpoDePlumaje;
    }

    public Boolean getCapacidadDeVuelo() {
        return CapacidadDeVuelo;
    }

    public void setCapacidadDeVuelo(Boolean capacidadDeVuelo) {
        CapacidadDeVuelo = capacidadDeVuelo;
    }

    public String getCantidadDeImitaciones() {
        return CantidadDeImitaciones;
    }

    public void setCantidadDeImitaciones(String cantidadDeImitaciones) {
        CantidadDeImitaciones = cantidadDeImitaciones;
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
