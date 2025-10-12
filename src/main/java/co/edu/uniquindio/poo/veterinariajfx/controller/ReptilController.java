package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Reptil;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class ReptilController {
    Veterinaria veterinaria;


    public ReptilController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearReptil(Mascota reptil) {
        return veterinaria.agregarReptil(reptil);
    }


    public List<Mascota> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarReptil(String id) {
        return veterinaria.eliminarReptil(id);
    }


    public boolean actualizarReptil(String id, Mascota reptil) {
        return veterinaria.actualizarReptil(id, reptil);
    }



}
