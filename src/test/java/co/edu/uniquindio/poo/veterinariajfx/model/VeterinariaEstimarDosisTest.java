package co.edu.uniquindio.poo.veterinariajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class VeterinariaEstimarDosisTest {
    private static final Logger LOG = Logger.getLogger(VeterinariaEstimarDosisTest.class.getName());
    @Test
    public void EstimarDosis() {
        LOG.info("inicio test estimar dosis");
        Veterinaria veterinaria = new Veterinaria("Oscarin","1111");

        Perro perro = new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");

        double miligramosPorKilo = 1.5;

        double dosis = veterinaria.estimarDosis(perro.getPeso(),miligramosPorKilo);

        assertEquals(18.75,dosis, 0.1);

        LOG.info("fin testo estimar dosis");

    }
    @Test
    public void dosisInvalidas(){
        LOG.info("inicio test dosisInvalidas");
        Veterinaria veterinaria = new Veterinaria("Oscarin","1111");

        assertThrows(IllegalArgumentException.class,()-> veterinaria.estimarDosis(0,1.5));

    }



}