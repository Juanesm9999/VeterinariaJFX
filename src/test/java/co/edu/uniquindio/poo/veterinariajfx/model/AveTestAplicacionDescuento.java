package co.edu.uniquindio.poo.veterinariajfx.model;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class AveTestAplicacionDescuento {
    private static final Logger LOG = Logger.getLogger(AveTestAplicacionDescuento.class.getName());
    @Test
    public void aplicacionDescuento() {
        LOG.info("inicio test aplicacion descuento");
        Ave ave = new Ave("Marti","1113618192", "nose", 1.2,36,"Ave","Frondoso",true, "si");

        TipoConsulta tipoConsulta = TipoConsulta.CONTROL_RUTINARIO;
        double precioBase = 10000;
        double costoTotal = 0;
        String especie = "Ave";

        double resultado = ave.CalcularCostoConsulta(tipoConsulta,precioBase,ave.getEdadEnMeses(),costoTotal, especie);

        assertEquals(8000, resultado, 0.1);

        LOG.info("fin test aplicacion descuento");

    }


}