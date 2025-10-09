package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;


public class AveController {
    Veterinaria veterinaria;


    public AveController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearAve(Mascota ave) {
        return veterinaria.agregarAve(ave);
    }


    public List<Mascota> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarAve(String id) {
        return veterinaria.eliminarAve(id);
    }


    public boolean actualizarAve(String id, Ave ave) {
        return veterinaria.actualizarAve(id, ave);
    }


}
