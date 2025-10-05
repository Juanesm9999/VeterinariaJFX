package co.edu.uniquindio.poo.veterinariajfx.model;

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
        listMascotas = new ArrayList<>();
        listPropietarios = new ArrayList<>();
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


    public boolean actualizarCliente(String id, Mascota actualizado) {
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



    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }

}
