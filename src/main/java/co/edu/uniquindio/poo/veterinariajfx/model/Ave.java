package co.edu.uniquindio.poo.veterinariajfx.model;

public class Ave extends Mascota{
    private String TIpoDePlumaje;
    private Boolean CapacidadDeVuelo;
    private String CantidadDeImitaciones;
    public Ave(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String TipoDePlumaje,Boolean CapacidadDeVuelo,String CapacidadDeImitaciones){
        super(nombre,id,raza,peso,edadEnMeses);
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

}
