/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;


public class Candidature {
    private int idCandidature;
    private int idOffre;
    private String statuts ="En attente";

    public Candidature(int idCandidature, int idOffre) {
        this.idCandidature = idCandidature;
        this.idOffre = idOffre;
    }

    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }
}