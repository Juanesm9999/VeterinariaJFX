package co.edu.uniquindio.poo.veterinariajfx.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
    private String nombre;
    private String nit;
    private List<Propietario> listPropietarios;
    private List<Mascota> listMascotas;
    private List<Consulta> listConsultas;

    public Veterinaria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listMascotas = new ArrayList<>();
        this.listPropietarios = new ArrayList<>();
        this.listConsultas = new ArrayList<>();
    }
    //--------------------------------- CRUD Propietario --------------------------------

    public boolean agregarPropietario(Propietario propietario) {
        boolean centinela = false;
        if (!verificarPropietario(propietario.getId())) {
            listPropietarios.add(propietario);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarPropietario(String id) {
        boolean centinela = false;
        for (Propietario propietario: listPropietarios) {
            if (propietario.getId().equals(id)) {
                listMascotas.remove(propietario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarPropietario(String id, Propietario actualizado) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getId().equals(id)) {
                propietario.setId(actualizado.getId());
                propietario.setNombre(actualizado.getNombre());
                propietario.setDireccion(actualizado.getDireccion());
                propietario.setPuntajeFidelidad(actualizado.getPuntajeFidelidad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarPropietario(String id) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }


    //--------------------------------- CRUD Consulta --------------------------------

    public boolean agregarConsulta(Consulta consulta) {
        boolean centinela = false;
        if (!verificarConsulta(consulta.getId())) {
            listConsultas.add(consulta);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarConsulta(String id) {
        boolean centinela = false;
        for (Consulta consulta: listConsultas) {
            if (consulta.getId().equals(id)) {
                listMascotas.remove(consulta);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarConsulta(String id, Consulta actualizado) {
        boolean centinela = false;
        for (Consulta consulta : listConsultas) {
            if (consulta.getId().equals(id)) {
                consulta.setId(actualizado.getId());
                consulta.setListMascotas(actualizado.getListMascotas());
                consulta.setTipoConsulta(actualizado.getTipoConsulta());
                consulta.setFecha(actualizado.getFecha());
                consulta.setPrecioBase(actualizado.getPrecioBase());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarConsulta(String id) {
        boolean centinela = false;
        for (Consulta consulta : listConsultas) {
            if (consulta.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    //--------------------------------- CRUD Ave -------------------------------------

    public boolean agregarAve(Mascota ave) {
        boolean centinela = false;
        if (!verificarAve(ave.getId())) {
            listMascotas.add(ave);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarAve(String id) {
        boolean centinela = false;
        for (Mascota ave: listMascotas) {
            if (ave.getId().equals(id)) {
                listMascotas.remove(ave);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarAve(String id, Ave actualizado) {
        boolean centinela = false;
        for (Mascota ave : listMascotas) {
            if (ave.getId().equals(id)) {
                ave.setId(actualizado.getId());
                ave.setNombre(actualizado.getNombre());
                ave.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarAve(String id) {
        boolean centinela = false;
        for (Mascota ave : listMascotas) {
            if (ave.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }
    // -------------------------------- CRUD Gato ------------------------------------

    public boolean agregarGato(Mascota gato) {
        boolean centinela = false;
        if (!verificarGato(gato.getId())) {
            listMascotas.add(gato);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarGato(String id) {
        boolean centinela = false;
        for (Mascota gato: listMascotas) {
            if (gato.getId().equals(id)) {
                listMascotas.remove(gato);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarGato(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota gato : listMascotas) {
            if (gato.getId().equals(id)) {
                gato.setId(actualizado.getId());
                gato.setNombre(actualizado.getNombre());
                gato.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarGato(String id) {
        boolean centinela = false;
        for (Mascota gato : listMascotas) {
            if (gato.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }
    // -------------------------------- CRUD Perro ------------------------------------

    public boolean agregarPerro(Mascota perro) {
        boolean centinela = false;
        if (!verificarPerro(perro.getId())) {
            listMascotas.add(perro);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarPerro(String id) {
        boolean centinela = false;
        for (Mascota perro: listMascotas) {
            if (perro.getId().equals(id)) {
                listMascotas.remove(perro);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarPerro(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota perro : listMascotas) {
            if (perro.getId().equals(id)) {
                perro.setId(actualizado.getId());
                perro.setNombre(actualizado.getNombre());
                perro.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarPerro(String id) {
        boolean centinela = false;
        for (Mascota perro : listMascotas) {
            if (perro.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }



    // -------------------------------- CRUD Reptil -------------------------------------

    public boolean agregarReptil(Mascota reptil) {
        boolean centinela = false;
        if (!verificarReptil(reptil.getId())) {
            listMascotas.add(reptil);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarReptil(String id) {
        boolean centinela = false;
        for (Mascota reptil: listMascotas) {
            if (reptil.getId().equals(id)) {
                listMascotas.remove(reptil);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarReptil(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota reptil : listMascotas) {
            if (reptil.getId().equals(id)) {
                reptil.setId(actualizado.getId());
                reptil.setNombre(actualizado.getNombre());
                reptil.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarReptil(String id) {
        boolean centinela = false;
        for (Mascota reptil : listMascotas) {
            if (reptil.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }



    // -------------------------------- CRUD Mascota ---------------------------------

    public boolean agregarMascota(Mascota mascota) {
        boolean centinela = false;
        if (!verificarMascota(mascota.getId())) {
            listMascotas.add(mascota);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                listMascotas.remove(mascota);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarMascota(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                mascota.setId(actualizado.getId());
                mascota.setNombre(actualizado.getNombre());
                mascota.setRaza(actualizado.getRaza());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public List<Consulta> getListConsultas() {
        return listConsultas;
    }

    public void setListConsultas(List<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public boolean verificarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // --------------------------------------------------------------------------------------------------------------
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double estimarDosis(double peso, double miligramosPorKilo) {
        if (peso <= 0 || miligramosPorKilo <= 0) {
            throw new IllegalArgumentException("El peso y los miligramos por kilo deben ser mayores a cero");
        }
        return peso * miligramosPorKilo;
    }



    public List<Propietario> obtenerRankingPropietarios() {

        List<Propietario> propietariosUnicos = new ArrayList<>();


        for (int i = 0; i < listConsultas.size(); i++) {
            Consulta consulta = listConsultas.get(i);

            if (consulta != null && consulta.getListMascotas() != null) {
                List<Mascota> mascotas = consulta.getListMascotas();

                for (int k = 0; k < mascotas.size(); k++) {
                    Mascota mascota = mascotas.get(k);

                    if (mascota != null && mascota.getThePropietario() != null) {
                        Propietario propietario = mascota.getThePropietario();


                        boolean encontrado = false;
                        for (int j = 0; j < propietariosUnicos.size(); j++) {
                            if (propietariosUnicos.get(j).getNombre().equals(propietario.getNombre())) {
                                encontrado = true;

                                double puntajeActual = propietariosUnicos.get(j).getPuntajeFidelidad();
                                propietariosUnicos.get(j).setPuntajeFidelidad(puntajeActual + 1);
                                break;
                            }
                        }


                        if (!encontrado) {
                            propietario.setPuntajeFidelidad(1.0);
                            propietariosUnicos.add(propietario);
                        }
                    }
                }
            }
        }


        for (int i = 0; i < propietariosUnicos.size() - 1; i++) {
            for (int j = 0; j < propietariosUnicos.size() - 1 - i; j++) {
                if (propietariosUnicos.get(j).getPuntajeFidelidad() <
                        propietariosUnicos.get(j + 1).getPuntajeFidelidad()) {

                    Propietario temp = propietariosUnicos.get(j);
                    propietariosUnicos.set(j, propietariosUnicos.get(j + 1));
                    propietariosUnicos.set(j + 1, temp);
                }
            }
        }

        return propietariosUnicos;
    }




    public List<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }

}
