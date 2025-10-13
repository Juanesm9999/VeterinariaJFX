package co.edu.uniquindio.poo.veterinariajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class VeterinariaTopPropietariosTest {
    private static final Logger LOG = Logger.getLogger(AveTestAplicacionDescuento.class.getName());
    @Test
    void obtenerRankingPropietarios() {
        LOG.info ("inicio test ranking de propietarios ");
        Propietario propietario = new Propietario("juan","1123","jesusmaria",12.5);
        Propietario propietario2 = new Propietario("carlos","1223","jasusmaria",15.1);

        Perro perro = new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");
        Perro perro2 = new Perro("Firaias","1113618392","Criollo", 13.1, 11, "perro", Tamanio.GRANDE,"1","2");
        Perro perro3 = new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");

        perro.setThePropietario(propietario);
        perro2.setThePropietario(propietario2);
        perro3.setThePropietario(propietario);


        List<Mascota> mascotasConsulta1 = new ArrayList<>();
        mascotasConsulta1.add(perro);
        Consulta consulta1 = new Consulta("321", LocalDate.now(), TipoConsulta.CONSULTA, 10000, 0);

        List<Mascota> mascotasConsulta2 = new ArrayList<>();
        mascotasConsulta2.add(perro2);
        Consulta consulta2 = new Consulta("123", LocalDate.now(), TipoConsulta.URGENCIA, 10000, 0);

        List<Mascota> mascotasConsulta3 = new ArrayList<>();
        mascotasConsulta3.add(perro3);
        Consulta consulta3 = new Consulta("321", LocalDate.now(), TipoConsulta.CONTROL_RUTINARIO, 10000, 0);

        List<Consulta> listaConsultas = new ArrayList<>();
        listaConsultas.add(consulta1);
        listaConsultas.add(consulta2);
        listaConsultas.add(consulta3);

        Veterinaria veterinaria = new Veterinaria("Oscarin", "1234");
        veterinaria.setListConsultas(listaConsultas);

        List<Propietario> ranking = veterinaria.obtenerRankingPropietarios();

        assertEquals("Juan", ranking.get(0).getNombre());
        assertEquals(2.0, ranking.get(0).getPuntajeFidelidad(), 0.01);

        assertEquals("Carlos", ranking.get(1).getNombre());
        assertEquals(1.0, ranking.get(1).getPuntajeFidelidad(), 0.01);

        LOG.info("Fin test ranking de propietarios");
    }
}