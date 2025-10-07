package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;


import java.util.LinkedList;
import java.util.List;


public class MascotaController {
    Veterinaria veterinaria;


    public MascotaController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearMascota(Mascota mascota) {
        return veterinaria.agregarMascota(mascota);
    }


    public List<Mascota> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarMascota(String id) {
        return veterinaria.eliminarMascota(id);
    }


    public boolean actualizarMascota(String id, Mascota mascota) {
        return veterinaria.actualizarMascota(id, mascota);
    }


}
