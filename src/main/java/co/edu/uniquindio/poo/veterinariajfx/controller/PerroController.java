package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Gato;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Perro;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.Collection;
import java.util.List;

public class PerroController {
    static Veterinaria veterinaria;


    public PerroController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public static boolean crearPerro(Mascota perro) {
        return veterinaria.agregarPerro(perro);
    }


    public Collection<? extends Perro> obtenerListaMascotas() {
        return veterinaria.getListMascotas()
                .stream()
                .filter(m -> m instanceof Perro)
                .map(m -> (Perro) m)
                .toList();
    }


    public boolean eliminarPerro(String id) {
        return veterinaria.eliminarPerro(id);
    }


    public boolean actualizarPerro(String id, Mascota perro) {
        return veterinaria.actualizarMascota(id, perro);
    }


}

