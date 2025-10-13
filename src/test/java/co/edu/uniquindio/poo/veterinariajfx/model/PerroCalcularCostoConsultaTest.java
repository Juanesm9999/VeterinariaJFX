package co.edu.uniquindio.poo.veterinariajfx.model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerroCalcularCostoConsultaTest {
    private static final Logger LOG = Logger.getLogger(PerroCalcularCostoConsultaTest.class.getName());
    @Test
    public void testCalcularCostoConsulta(){
        LOG.info("inicio test calcular costo consulta perro ");
        Perro perro1= new Perro("Firais","1113618192","Criollo", 12.5, 12, "perro", Tamanio.GRANDE,"1","2");

        TipoConsulta tipoConsulta = TipoConsulta.CONSULTA;
        double precioBase=10000;
        double costoTotal=0;
        String especie= "Perro";

        double resultado = perro1.CalcularCostoConsulta(tipoConsulta,precioBase, perro1.getEdadEnMeses(), costoTotal,especie);
        assertEquals(precioBase, resultado, 0.1);

        LOG.info("fin test calcular costo consulta perro");

    }

}