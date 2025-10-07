package co.edu.uniquindio.poo.veterinariajfx.model;

public class Gato extends Mascota{
    private Boolean IsIndoor;
    private String CantidadHorasSuenio;
    private String NivelIndependencia;
    public Gato(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String especie, Boolean IsIndoor,String CantidadHorasSuenio,String NivelIndependencia){
        super(nombre,id,raza,peso,edadEnMeses,especie);
        this.IsIndoor = IsIndoor;
        this.CantidadHorasSuenio = CantidadHorasSuenio;
        this.NivelIndependencia = NivelIndependencia;

    }

    public Boolean getIndoor() {
        return IsIndoor;
    }

    public void setIndoor(Boolean indoor) {
        IsIndoor = indoor;
    }

    public String getCantidadHorasSuenio() {
        return CantidadHorasSuenio;
    }

    public void setCantidadHorasSuenio(String cantidadHorasSuenio) {
        CantidadHorasSuenio = cantidadHorasSuenio;
    }

    public String getNivelIndependencia() {
        return NivelIndependencia;
    }

    public void setNivelIndependencia(String nivelIndependencia) {
        NivelIndependencia = nivelIndependencia;
    }
}
