package co.edu.uniquindio.poo.veterinariajfx.controller;


import co.edu.uniquindio.poo.veterinariajfx.model.Gato;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class GatoController {
    Veterinaria veterinaria;


    public GatoController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    public boolean crearGato(Mascota gato) {
        return veterinaria.agregarGato(gato);
    }

    public Gato obtenerListaMascotas() {
        List<Mascota> listaGatos = veterinaria.getListMascotas();
        return null;
    }


    /*public Gato obtenerListaMascotas() {
        return (Gato) FXCollections.observableArrayList(veterinaria.getListMascotas());
    }*/


    public boolean eliminarGato(String id) {
        return veterinaria.eliminarGato(id);
    }


    public boolean actualizarGato(String id, Gato gato) {
        return veterinaria.actualizarGato(id, gato);
    }


}

