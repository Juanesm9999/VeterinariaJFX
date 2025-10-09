package co.edu.uniquindio.poo.veterinariajfx.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
    private String nombre;
    private String nit;
    private List<Propietario> listPropietarios;
    private List<Mascota> listMascotas;
    private List<Consulta> listConsultas;

    public Veterinaria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listMascotas = new ArrayList<>();
        this.listPropietarios = new ArrayList<>();
        this.listConsultas = new ArrayList<>();
    }

    // -------------------------------- CRUD Mascota ---------------------------------

    public boolean agregarMascota(Mascota mascota) {
        boolean centinela = false;
        if (!verificarMascota(mascota.getId())) {
            listMascotas.add(mascota);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                listMascotas.remove(mascota);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarMascota(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                mascota.setId(actualizado.getId());
                mascota.setNombre(actualizado.getNombre());
                mascota.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public List<Consulta> getListConsultas() {
        return listConsultas;
    }

    public void setListConsultas(List<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public boolean verificarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // --------------------------------------------------------------------------------------------------------------
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double estimarDosis(double pesoKg, double miligramosPorKilo) {
        if (pesoKg <= 0 || miligramosPorKilo <= 0) {
            throw new IllegalArgumentException("El peso y los miligramos por kilo deben ser mayores a cero");
        }
        return pesoKg * miligramosPorKilo;
    }


    public List<Propietario> MayorNumeroVisitas() {
        MayorNumeroVisitas();
        for (Propietario propietario : listPropietarios) {
            if(propietario.getPuntajeFidelidad())
        }
    }
    public int ClasificarUrgencia(TipoConsulta tipoConsulta) {
        int prioridad = 0;
        switch (tipoConsulta) {
            case TipoConsulta.URGENCIA:
                return prioridad = 1;

            case TipoConsulta.CONSULTA:
                return prioridad = 2;

            case TipoConsulta.VACUNACION:
                return prioridad = 3;
            case TipoConsulta.CONTROL_RUTINARIO:
                return prioridad = 4;

            default:
                return prioridad = 5;
        }
    }

    public List<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }

}
