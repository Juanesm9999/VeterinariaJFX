package co.edu.uniquindio.poo.veterinariajfx.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


class ConsultaTest {
    private static final Logger LOG = Logger.getLogger(ConsultaTest.class.getName());
    @Test
    public void nivelEmergencia() {
        LOG.info("inicio test nivel emergencia");
        Gato gato = new Gato("Victor", "1113618192", "Siames", 8.2, 85, "GATO", true, "8", "2");
        Perro perro1= new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");

        List<Mascota> listMascotas = new ArrayList<>();
        listMascotas.add(gato);
        listMascotas.add(perro1);
        Consulta consulta = new Consulta("1322", LocalDate.now(),TipoConsulta.URGENCIA,10000,0);

        int prioridad = consulta.clasificarUrgencia(consulta.getTipoConsulta());
        assertEquals(1, prioridad);

        LOG.info("fin test nivel emergencia");

    }

}