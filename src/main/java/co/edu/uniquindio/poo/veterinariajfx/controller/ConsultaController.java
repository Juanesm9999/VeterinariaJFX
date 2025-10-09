package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Consulta;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;


import java.util.LinkedList;
import java.util.List;


public class ConsultaController {
    Veterinaria veterinaria;


    public ConsultaController(Consulta consulta) {
        this.veterinaria = veterinaria;
    }


    public boolean crearMascota(Consulta consulta) {
        return veterinaria.agregarConsulta(consulta);
    }


    public List<Consulta> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }


    public boolean eliminarMascota(String id) {
        return veterinaria.eliminarMascota(id);
    }


    public boolean actualizarMascota(String id, Mascota mascota) {
        return veterinaria.actualizarMascota(id, mascota);
    }


}