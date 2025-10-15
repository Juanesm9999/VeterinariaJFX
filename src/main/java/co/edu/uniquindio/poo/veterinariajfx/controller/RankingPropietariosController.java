package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Propietario;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;

import java.util.List;

public class RankingPropietariosController {
    private Veterinaria veterinaria;

    public RankingPropietariosController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public List<Propietario> obtenerRanking() {
        return veterinaria.obtenerRankingPropietarios();
    }
}