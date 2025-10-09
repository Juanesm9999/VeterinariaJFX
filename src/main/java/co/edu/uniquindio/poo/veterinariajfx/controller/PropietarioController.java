package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Propietario;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class PropietarioController {
    Veterinaria veterinaria;


    public PropietarioController(Propietario propietario) {
        this.veterinaria = veterinaria;
    }


    public boolean crearPropietario(Propietario propietario) {
        return veterinaria.agregarPropietario(propietario);
    }


    public List<Propietario> obtenerListaPropietarios() {
        return veterinaria.getListPropietarios();
    }


    public boolean eliminarPropietario(String id) {
        return veterinaria.eliminarPropietario(id);
    }


    public boolean actualizarPropietario(String id, Propietario propietario) {
        return veterinaria.actualizarPropietario(id, propietario);
    }



}
