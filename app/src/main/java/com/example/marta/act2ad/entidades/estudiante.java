package com.example.marta.act2ad.entidades;

/**
 * CREACIÓN DE ESTUDIANTES EN BD.
 * @author marta
 */
public class estudiante {
    private Integer id;
    private int edad, curso;
    private String nom, ciclo;
    private double media;

    /**
     * CONSTRUCTOR
     * @param id
     * @param edad
     * @param curso
     * @param nom
     * @param ciclo
     * @param media
     */
    public estudiante(Integer id, int edad, int curso, String nom, String ciclo, double media) {
        this.id = id;
        this.edad = edad;
        this.curso = curso;
        this.nom = nom;
        this.ciclo = ciclo;
        this.media = media;
    }


    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return curso
     */
    public int getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return ciclo
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     *
     * @param ciclo
     */
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    /**
     *
     * @return media
     */
    public double getMedia() {
        return media;
    }

    /**
     *
     * @param media
     */
    public void setMedia(double media) {
        this.media = media;
    }
}
