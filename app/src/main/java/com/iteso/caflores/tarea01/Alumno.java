package com.iteso.caflores.tarea01;

/**
 * Created by caflores on 9/3/2017.
 */

public class Alumno {

    protected String name;
    protected String phone;
    protected String scholarship;
    protected String gendre;
    protected String book;
    protected String athlete;

    @Override
    public String toString() {
        String temp = "Nombre: " + name + "\n" +
                "Telefono: " + phone + "\n" +
                "Escolaridad: " + scholarship + "\n" +
                "Genero: " + gendre + "\n" +
                "Libro favorito: " + book + "\n" +
                "Practica deporte: " + athlete + "\n";
        return temp;
    }

    public void setName(String a){
        name = a;
    }

    public void setPhone(String a){
        phone = a;
    }

    public void setScholarship(String a){
        scholarship = a;
    }

    public void setGendre(String a){
        gendre = a;
    }

    public void setBook(String a){
        book = a;
    }

    public void setAthlete(String a){
        athlete = a;
    }
}
