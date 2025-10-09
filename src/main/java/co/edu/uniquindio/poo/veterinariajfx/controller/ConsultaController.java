package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Consulta;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;


import java.util.List;


public class ConsultaController {
    Veterinaria veterinaria;


    public ConsultaController(Veterinaria consulta) {
        this.veterinaria = veterinaria;
    }


    public boolean crearConsulta(Consulta consulta) {
        return veterinaria.agregarConsulta(consulta);
    }


    public List<Consulta> obtenerListaMascotas() {
        return veterinaria.getListConsultas();
    }


    public boolean eliminarConsulta(String id) {
        return veterinaria.eliminarConsulta(id);
    }


    public boolean actualizarConsulta(String id, Consulta consulta) {
        return veterinaria.actualizarConsulta(id, consulta);
    }


}