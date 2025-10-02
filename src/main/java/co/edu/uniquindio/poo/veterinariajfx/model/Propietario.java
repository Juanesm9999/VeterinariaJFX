package co.edu.uniquindio.poo.veterinariajfx.model;

public class Propietario {
    public class Propietario {
        // Atributos Propios
        private String nombre;
        private String id;
        private Double PuntajeFidelidad;

        // Atributos de Relaciones
        private Mascota[] listMascotas;

        public Propietario(String nombre, String id){
            this.nombre = nombre;
            this.id = id;
            listMascotas = new Mascota[10];
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

        public Mascota[] getListMascotas() {
            return listMascotas;
        }

        public void setListMascotas(Mascota[] listMascotas) {
            this.listMascotas = listMascotas;
        }
    }

}
