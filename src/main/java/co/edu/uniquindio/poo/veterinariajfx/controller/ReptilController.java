package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class ReptilController {
    Veterinaria veterinaria;


    public ReptilController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearReptil(Ave ave) {
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
}
