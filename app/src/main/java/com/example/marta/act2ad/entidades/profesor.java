package com.example.marta.act2ad.entidades;

/**
 * CREA PROFESORES EN BD
 * @author marta
 */
public class profesor {
    private Integer id;
    private int edad;
    private String nom, ciclo, cursTutor, despacho;

    /**
     * CONSTRUCTOR
     * @param id
     * @param edad
     * @param nom
     * @param ciclo
     * @param cursTutor
     * @param despacho
     */
    public profesor(Integer id, int edad, String nom, String ciclo, String cursTutor, String despacho) {
        this.id = id;
        this.edad = edad;
        this.nom = nom;
        this.ciclo = ciclo;
        this.cursTutor = cursTutor;
        this.despacho = despacho;
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
     * @return cursTutor
     */
    public String getCursTutor() {
        return cursTutor;
    }

    /**
     *
     * @param cursTutor
     */
    public void setCursTutor(String cursTutor) {
        this.cursTutor = cursTutor;
    }

    /**
     *
     * @return despacho
     */
    public String getDespacho() {
        return despacho;
    }

    /**
     *
     * @param despacho
     */
    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
}
