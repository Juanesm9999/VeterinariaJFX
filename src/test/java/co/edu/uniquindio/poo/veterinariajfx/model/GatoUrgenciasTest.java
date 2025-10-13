package co.edu.uniquindio.poo.veterinariajfx.model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GatoUrgenciasTest {
    private static final Logger LOG = Logger.getLogger(GatoUrgenciasTest.class.getName());

    @Test
    public void calcularCostoUrgencias() {
        LOG.info("inicio test calcular costo urgencias");
        Gato gato = new Gato("Victor", "1113618192", "Siames", 8.2, 85, "GATO", true, "8", "2");

        List<Mascota> mascotas = List.of(gato);
        Consulta consulta = new Consulta("1113618192",LocalDate.now(),TipoConsulta.URGENCIA,10000,0.0);
        gato.getlistConsultas().add(consulta);
        TipoConsulta tipoConsulta = TipoConsulta.URGENCIA;
        double precioBase = 10000;
        double costoTotal = 0;
        String especie = "Gato";

        double resultado = gato.CalcularCostoConsulta(tipoConsulta, precioBase, gato.getEdadEnMeses(), costoTotal, especie);
        assertEquals(17500, resultado, 0.1);

        LOG.info("fin test calcular costo urgencias");
    }
}