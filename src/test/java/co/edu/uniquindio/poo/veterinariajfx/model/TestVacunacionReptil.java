package co.edu.uniquindio.poo.veterinariajfx.model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestVacunacionReptil {
    private static final Logger LOG = Logger.getLogger(TestVacunacionReptil.class.getName());
    @Test
    public void calcularVacunacion() {
        LOG.info("inicio test calcular costo Vacunacion");
        Reptil reptil = new Reptil("Oscarin","1113618193","tortuga",12.5,14,"reptil",Habitat.ACUATICO,"25",NivelPeligrosidad.INOFENSIVO);

        TipoConsulta tipoConsulta = TipoConsulta.VACUNACION;
        double precioBase=10000;
        double costoTotal=0;
        String especie= "Reptil";

        double resultado = reptil.CalcularCostoConsulta(tipoConsulta,precioBase,reptil.getEdadEnMeses(),costoTotal, especie);
        assertEquals(13000,resultado, 0.1);

        LOG.info("fin test calcular costo Vacunacion");
    }
}