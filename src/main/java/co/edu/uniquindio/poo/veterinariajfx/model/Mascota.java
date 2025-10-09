package co.edu.uniquindio.poo.veterinariajfx.model;

import java.util.List;

public abstract class Mascota {
        // Atributos Propios
        protected String nombre;
        protected String id;
        protected String raza;
        protected Double peso;
        protected Integer edadEnMeses;
        protected String especie;


        // Atributos de Relaciones
        private Propietario thePropietario;
        private List<Consulta> listConsultas;

        public Mascota(String nombre, String id, String raza, Double peso, Integer edadEnMeses,String especie) {
            this.nombre = nombre;
            this.id = id;
            this.raza = raza;
            this.peso = peso;
            this.edadEnMeses = edadEnMeses;
            this.especie = especie;
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

        public String getRaza() {
            return raza;
        }

        public void setRaza(String raza) {
            this.raza = raza;
        }

        public Double getPeso() {
            return peso;
        }

        public void setPeso(Double peso) {
            this.peso = peso;
        }

        public Integer getEdadEnMeses() {
            return edadEnMeses;
        }

        public void setEdadEnMeses(Integer edadEnMeses) {
            this.edadEnMeses = edadEnMeses;
        }

        public String getEspecie() {
            return especie;
        }

        public void setEspecie(String especie) {
            this.especie = especie;
        }

        public Propietario getThePropietario() {
                    return thePropietario;
        }

        public List<Consulta> getlistConsultas() {
            return listConsultas;
        }

        public void setlistConsultas(List<Consulta> listConsultas) {
            listConsultas = listConsultas;
        }

    public void setThePropietario(Propietario thePropietario) {
                this.thePropietario = thePropietario;
        }
        public String CategoriaDeEdad(Integer edadEnMeses) {
            String categoria = "";
            if(edadEnMeses>0 && edadEnMeses<12){
                categoria = "Su mascota es joven";
            }

            if (edadEnMeses >= 13 && edadEnMeses <= 84) {
                categoria = "Su mascota es adulto";
            }

            if(edadEnMeses>84){
                categoria = "Su mascota es senior";
            }


            return categoria;
        }

        public Double EstimarDosisMedicamento(double peso){
            Double MiligramosPorKilo =
            Double dosisMedicamento = ;
            return dosisMedicamento;
        }
    public abstract double calcularCostoConsulta();

}

