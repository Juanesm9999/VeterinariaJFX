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

    public abstradouble calcularCostoConsulta(boolean tipoConsulta ,double precioBase,Integer edadEnMeses,double costoTotal,String Especie) {
        for (int i = 0; i < listMascotas.size(); i++) {

            if (mascota.getEspecie().equalsIgnoreCase("Ave") || mascota.getEspecie().equalsIgnoreCase("Reptil")) {
                costoTotal = precioBase * 1.50;
            }
            if(mascota.getEdadEnMeses() >84 ) {
                costoTotal = precioBase + 5000;
            }
            if(mascota.getTipoConsulta()= TipoConsulta.URGENCIA){
                costoTotal= precioBase + 4000;
            }

        }
        return costoTotal;
    }
    public String FechaVacunacion() {
        String fechaVacunacion = "";
        for (Mascota mascota : listMascotas) {
            if(mascota.getEspecie().equalsIgnoreCase("Perro") || mascota.getEspecie().equalsIgnoreCase("Gato")){
                fechaVacunacion = "Se le sugiere vacunar a su mascota cada 12 meses";
            }
            if(mascota.getEspecie().equalsIgnoreCase("Ave")){
                fechaVacunacion = "Se le sugiere vacunar a su mascota cada 8 meses";
            }
            if(mascota.getEspecie().equalsIgnoreCase("Reptil")){
                fechaVacunacion = "Se le sugiere vacunar a su mascota cada 18 meses";
            }

        }
        return fechaVacunacion;
    }

    public List<Propietario> MayorNumeroVisitas() {
        MayorNumeroVisitas();
        for (Propietario propietario : listPropietarios) {
            if(propietario.getPuntajeFidelidad())
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
