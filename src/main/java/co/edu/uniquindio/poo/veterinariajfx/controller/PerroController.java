package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class PerroController {
    Veterinaria veterinaria;


    public PerroController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearPerro(Mascota perro) {
        return veterinaria.agregarMascota(perro);
    }


    public List<Mascota> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarMascota(String id) {
        return veterinaria.eliminarMascota(id);
    }


    public boolean actualizarPerro(String id, Mascota perro) {
        return veterinaria.actualizarMascota(id, perro);
    }


}

