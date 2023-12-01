/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author khadi
 */
public class Cv {
    private final int idCandidat;
    private String diplome;
    private String experience;
    private List<String> competences;
    public Cv(int idCandidat ,String diplome, String experience) {
        this.idCandidat=idCandidat;
        this.diplome=diplome;
        this.experience=experience;
        this.competences = new ArrayList<>();
    }
      public int getIdCanidat() {
        return idCandidat;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    // Méthodes pour l'attribut experience
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    // Méthodes pour l'attribut competences
    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    // Méthode pour ajouter une compétence
    public void ajouterCompetence(String competence) {
        competences.add(competence);
    }

    // Méthode pour supprimer une compétence
    public void supprimerCompetence(String competence) {
        competences.remove(competence);
    }
}
