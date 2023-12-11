/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;
import java.util.List;

public class Offre_emplois {

    public static void add(Offre_emplois nouvelleOffre) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private SimpleIntegerProperty idOffre;
    private SimpleStringProperty titre;
    private SimpleStringProperty description;
    private SimpleObjectProperty<Date> datePublication;
    private SimpleStringProperty exigences;

    public Offre_emplois(int idOffre, String titre, String description, Date datePublication, List<String> exigences) {
        this.idOffre = new SimpleIntegerProperty(idOffre);
        this.titre = new SimpleStringProperty(titre);
        this.description = new SimpleStringProperty(description);
        this.datePublication = new SimpleObjectProperty<>(datePublication);
        this.exigences = new SimpleStringProperty(String.join(", ", exigences));
    }

    public SimpleIntegerProperty idOffreProperty() {
        return idOffre;
    }

    public SimpleStringProperty titreProperty() {
        return titre;
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public SimpleObjectProperty<Date> datePublicationProperty() {
        return datePublication;
    }

    public SimpleStringProperty exigencesProperty() {
        return exigences;
    }

    public int getIdOffre() {
        return idOffre.get();
    }

    public String getTitre() {
        return titre.get();
    }

    public String getDescription() {
        return description.get();
    }

    public Date getDatePublication() {
        return datePublication.get();
    }

    public String getExigences() {
        return exigences.get();
    }
}