package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;


import java.util.LinkedList;
import java.util.List;


public class AveController {
    Veterinaria veterinaria;


    public AveController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearAve(Ave ave) {
        return veterinaria.agregarAve(ave);
    }


    public List<Ave> obtenerListaAves() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarCliente(String cedula) {
        return veterinaria.eliminarAve(cedula);
    }


    public boolean actualizarCliente(String id, Ave ave) {
        return veterinaria.actualizarAve(id, ave);
    }


}
