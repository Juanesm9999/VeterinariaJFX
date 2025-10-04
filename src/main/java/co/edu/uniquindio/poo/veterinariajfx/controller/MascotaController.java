package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;


import java.util.LinkedList;


public class MascotaController {
    Veterinaria veterinaria;


    public MascotaController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearMascota(Mascota mascota) {
        return veterinaria.agregarMascota(mascota);
    }


    public LinkedList<Mascota> obtenerListaMascotas() {
        return veterinaria.getMascota();
    }


    public boolean eliminarCliente(String cedula) {
        return empresa.eliminarCliente(cedula);
    }


    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return empresa.actualizarCliente(cedula, cliente);
    }


}
