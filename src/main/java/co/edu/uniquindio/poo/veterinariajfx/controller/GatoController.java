package co.edu.uniquindio.poo.veterinariajfx.controller;


import co.edu.uniquindio.poo.veterinariajfx.model.Gato;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.Collection;
import java.util.List;

public class GatoController {
    Veterinaria veterinaria;


    public GatoController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearGato(Mascota gato) {
        return veterinaria.agregarGato(gato);
    }

    public Collection<? extends Gato> obtenerListaMascotas() {
        return veterinaria.getListMascotas()
                .stream()
                .filter(m -> m instanceof Gato)
                .map(m -> (Gato) m)
                .toList();
    }


    public boolean eliminarGato(String id) {
        return veterinaria.eliminarGato(id);
    }


    public boolean actualizarGato(String id, Gato gato) {
        return veterinaria.actualizarGato(id, gato);
    }


}

