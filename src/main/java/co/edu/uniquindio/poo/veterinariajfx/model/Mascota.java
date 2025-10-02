package co.edu.uniquindio.poo.veterinariajfx.model;

public abstract class Mascota {
    public class Mascota {
        // Atributos Propios
        protected String nombre;
        protected String id;
        protected String raza;
        protected Double peso;
        protected int EdadEnMeses;


        // Atributos de Relaciones
        private Propietario thePropietario;

        public Mascota(String nombre, String id) {
            this.nombre = nombre;
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Propietario getThePropietario() {
            return thePropietario;
        }

        public void setThePropietario(Propietario thePropietario) {
            this.thePropietario = thePropietario;
        }

    }


}
