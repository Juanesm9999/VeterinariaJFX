package co.edu.uniquindio.poo.veterinariajfx.model;

public class Gato extends Mascota{
    private Boolean isIndoor;
    private String CantidadHorasSuenio;
    private String NivelIndependencia;
    public Gato(String nombre,String id, String raza, Double peso,Integer edadEnMeses,String especie, Boolean IsIndoor,String CantidadHorasSuenio,String NivelIndependencia){
        super(nombre,id,raza,peso,edadEnMeses,especie);
        this.isIndoor = IsIndoor;
        this.CantidadHorasSuenio = CantidadHorasSuenio;
        this.NivelIndependencia = NivelIndependencia;

    }

    public Boolean getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(Boolean indoor) {
        isIndoor = indoor;
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

    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
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
