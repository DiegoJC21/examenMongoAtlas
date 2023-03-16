package com.example.examenmongo;

public class Cancion {
    private int idCancion;
    private String nombre;
    private String artista;
    private String año;
    private String genero;

    public Cancion() {
    }

    public Cancion(int idCancion, String nombre, String artista, String año, String genero) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.artista = artista;
        this.año = año;
        this.genero = genero;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "idCancion=" + idCancion +
                ", nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", año='" + año + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
