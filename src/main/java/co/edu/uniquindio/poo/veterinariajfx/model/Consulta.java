package co.edu.uniquindio.poo.veterinariajfx.model;

import java.time.LocalDate;
import java.util.List;

public class Consulta {
    private String id;
    private LocalDate fecha;
    private List<Mascota> listMascotas;
    private TipoConsulta tipoConsulta;
    private double precioBase;
    private Double costoTotal;

    public Consulta(String id,LocalDate fecha,List<Mascota>listMascotas,TipoConsulta tipoConsulta,Double precioBase,Double costoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.listMascotas = listMascotas;
        this.tipoConsulta = tipoConsulta;
        this.precioBase = 0;
        this.costoTotal = calcularCostoTotal();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }
    public Double calcularCostoConsulta(TipoConsulta tipoConsulta ,double precioBase,Integer edadEnMeses,Mascota mascota) {
       
        }
}