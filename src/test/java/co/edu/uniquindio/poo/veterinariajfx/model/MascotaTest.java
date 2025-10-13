package co.edu.uniquindio.poo.veterinariajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
class MascotaTest {
    private static final Logger LOG = Logger.getLogger(AveTestAplicacionDescuento.class.getName());
    @Test
    public void proximaVacunacion() {
        LOG.info("inicio test proxima vacunacion");
        Perro perro = new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");
        Gato gato1 = new Gato("Victor", "1113618192", "Siames", 8.2, 85, "GATO", true, "8", "2");
        Ave ave = new Ave("nose","65465","pajarin",1.5,2,"ave","suave",Boolean.TRUE,"nada");
        Reptil reptil = new Reptil("oSCARIN","11123","turtle",15.2,120,"Tortuga",Habitat.ACUATICO,"25",NivelPeligrosidad.INOFENSIVO);


        String proximaFechaPerro = perro.sugerirProximaVacunacion("Perro");
        assertEquals("12 meses", proximaFechaPerro);

        String proximaFechaGato = gato1.sugerirProximaVacunacion("Gato");
        assertEquals("12", proximaFechaGato);

        String proximaFechaAve = ave.sugerirProximaVacunacion("Ave");
        assertEquals("8", proximaFechaAve);

        String proximaFechaReptil = reptil.sugerirProximaVacunacion("Reptil");
        assertEquals("18", proximaFechaReptil);


        LOG.info("fin test proxima vacunacion");



    }
}