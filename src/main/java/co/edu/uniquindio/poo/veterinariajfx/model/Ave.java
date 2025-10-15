package co.edu.uniquindio.poo.veterinariajfx.model;

public class Ave extends Mascota{
    private String TipoDePlumaje;
    private Boolean isVueloCorto;
    private String CantidadDeImitaciones;


    public Ave(String id, String nombre, String raza, Double peso, Integer edadEnMeses,
               String especie, String TipoDePlumaje, Boolean isVueloCorto, String CantidadDeImitaciones){
        super(id, nombre, raza, peso, edadEnMeses, especie);
        this.TipoDePlumaje = TipoDePlumaje;
        this.isVueloCorto = isVueloCorto;
        this.CantidadDeImitaciones = CantidadDeImitaciones;
    }

    public String getTipoDePlumaje() {
        return TipoDePlumaje;
    }

    public void setTipoDePlumaje(String TipoDePlumaje) {
        this.TipoDePlumaje = TipoDePlumaje;
    }

    public Boolean isVueloCorto() {
        return isVueloCorto;
    }

    public boolean getIsVueloCorto() {
        return isVueloCorto;
    }

    public void setIsVueloCorto(Boolean IsVueloCorto) {
        this.isVueloCorto = IsVueloCorto;
    }

    public String getCantidadDeImitaciones() {
        return CantidadDeImitaciones;
    }

    public void setCantidadDeImitaciones(String cantidadDeImitaciones) {
        CantidadDeImitaciones = cantidadDeImitaciones;
    }

    @Override
    public double CalcularCostoConsulta(boolean tipoConsulta, double precioBase, Integer edadEnMeses, double costoTotal, String Especie){
        precioBase = precioBase * 1.25;

        if(getEdadEnMeses() > 84){
            costoTotal = precioBase * 1.5;
        }

        if(getlistConsultas() != null) {
            for(int i = 0; i < getlistConsultas().size(); i++){
                Consulta consulta = getlistConsultas().get(i);
                if(consulta.getId().equals(id)){
                    if(consulta.getTipoConsulta().equals(tipoConsulta)){
                        costoTotal = precioBase * 1.75;
                    }
                }
            }
        }

        return costoTotal;
    }
}