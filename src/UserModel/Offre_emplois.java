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
    private int IdOffre;
    private String titre;
    private String description;
    private String datePublication;
    private List<String> exigences;

    // Constructeur
    public Offre_emplois(int id,String titre, String description,String date) {
        this.IdOffre=id;
        this.titre = titre;
        this.description = description;
        this.datePublication = date;
        this.exigences= new ArrayList<>();
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
    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
public void setExigences(List<String> exigences) {
        this.exigences = exigences;
    }
public List<String> getExigences( ) {
       return exigences;
    }
}
