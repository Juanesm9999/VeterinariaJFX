package co.edu.uniquindio.poo.veterinariajfx.model;

public abstract class Mascota {
        // Atributos Propios
        protected String nombre;
        protected String id;
        protected String raza;
        protected Double peso;
        protected Integer edadEnMeses;


        // Atributos de Relaciones
        private Propietario thePropietario;

        public Mascota(String nombre, String id, String raza, Double peso, Integer edadEnMeses) {
            this.nombre = nombre;
            this.id = id;
            this.raza = raza;
            this.peso = peso;
            this.edadEnMeses = edadEnMeses;
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


