/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;
import UserModel.Candidat;

/**
 *
 * @author khadi
 */
public class Candidature {
    private Candidat candidat;
    private int idCandidature;
    private Offre_emplois offre;
    private String statut; // Peut être "Acceptée", "Refusée", etc.
    
    //constructeur 
    public Candidature(int idCandidat , Offre_emplois offre) {
    this.idCandidature=idCandidature;
    this.offre=offre;
    }
    // getters setters
    public Candidat geCandidat (){
        return candidat;}
    public int getIdCandidat (){
        return idCandidature;}
    //get offre set offre
    public Offre_emplois getOffre() {
        return offre;
    }

    public void setOffre(Offre_emplois offre) {
        this.offre = offre;
    }
}
