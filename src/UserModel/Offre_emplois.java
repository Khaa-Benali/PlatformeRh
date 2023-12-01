/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;
import java.util.Date; 
import java.util.List; 
import java.util.ArrayList;
/**
 *
 * @author khadi
 */
public class Offre_emplois {
    private String titre;
    private String description;
    private Date datePublication;
    private List<String> exigences;

    // Constructeur
    public Offre_emplois(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.datePublication = new Date();
        this.exigences= new ArrayList<>();// La date de publication est initialement la date actuelle
    }

    // Getters et setters pour l'attribut titre
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    // Getters et setters pour l'attribut description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters et setters pour l'attribut datePublication
    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }
public void setExigences(List<String> exigences) {
        this.exigences = exigences;
    }
public List<String> getExigences( ) {
       return exigences;
    }
    // Vous pouvez également ajouter d'autres getters et setters si nécessaire...
}
