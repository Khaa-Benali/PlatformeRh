package Recruteur;
import UserModel.Entretien;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EntretienController implements Initializable {

    @FXML
    private Button btnhome;
    @FXML
    private Button btnCandidatures;
    @FXML
    private Button brnProfile;
    @FXML
    private TextField idEntext;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private DatePicker date;
    @FXML
    private TextField heure;
    @FXML
    private TextField lieu;
    @FXML
    private TextField candidature;
    @FXML
    private TextField note;
    @FXML
    private TextField com;
    @FXML
    private TableView<Entretien> tableauEntr;
    
    private TableColumn<Entretien, Integer> idEntretienColumn;
    private TableColumn<Entretien, String> dateColumn;
    private TableColumn<Entretien, String> heureColumn;
    private TableColumn<Entretien, String> lieuColumn;
    private TableColumn<Entretien, Integer> idCandidatureColumn; 
    private TableColumn<Entretien,String> type; 
    private TableColumn<Entretien, Integer> idnote;
    private TableColumn<Entretien, String> idcomn;
    
 
    private ObservableList<Entretien> entretiens = FXCollections.observableArrayList(
           new Entretien(1,126,"1/12/2023","9:30","Tunis","technique",9,"Excelent"),
            new Entretien(2,126,"1/03/2023","8:30","Tunis","technique",5,"Passable")
    );
    @FXML
    private ChoiceBox<String> idType;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> types = FXCollections.observableArrayList("technique", "Rh");
        idType.setItems(types);
        // Initialisez vos colonnes
        idCandidatureColumn = new TableColumn<>("IdCandidature");
        idCandidatureColumn.setCellValueFactory(new PropertyValueFactory<>("idCandidature"));
        
        idEntretienColumn = new TableColumn<>("idEntretien");
        idEntretienColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        
        dateColumn = new TableColumn<>("date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
         lieuColumn = new TableColumn<>("lieu");
         lieuColumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
         
          heureColumn = new TableColumn<>("Heure");
        heureColumn.setCellValueFactory(new PropertyValueFactory<>("Heure"));
        
        type = new TableColumn<>("type");
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        
         idnote = new TableColumn<>("Note");
        idnote.setCellValueFactory(new PropertyValueFactory<>("Note"));
        
      idcomn = new TableColumn<>("Commentaire");
      idcomn.setCellValueFactory(new PropertyValueFactory<>("commentaires"));

        
        // Ajoutez les colonnes à la TableView
        tableauEntr.getColumns().addAll(idCandidatureColumn,idEntretienColumn, dateColumn, lieuColumn,heureColumn,type,idnote,idcomn);
        tableauEntr.setItems(entretiens);
    }    
    @FXML
    private void handlebtnHome(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnhome.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EntretienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlbtnCandi(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Candidatures.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnCandidatures.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EntretienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnProfile(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Recruteur.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) brnProfile.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EntretienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnAdd(ActionEvent event) {
            try {
        // Récupérer les valeurs des champs de texte
        int idCandidature = Integer.parseInt(candidature.getText());
        String dateValue = date.getValue().toString();
        String heureValue = heure.getText();
        String lieuValue = lieu.getText();
        String typeValue = idType.getValue(); // Récupérer la valeur de la ChoiceBox
        int noteValue = Integer.parseInt(note.getText());
        String commentaireValue = com.getText();

        // Créer un nouvel objet Entretien
        Entretien nouvelEntretien = new Entretien(
                /* Vous devez définir l'id d'entretien. 
                Pour l'exemple, nous utilisons simplement le nombre d'éléments dans la liste + 1. 
                Vous pouvez adapter cette logique selon vos besoins. */
                entretiens.size() + 1, 
                idCandidature, dateValue, heureValue, lieuValue, typeValue, noteValue, commentaireValue
        );

        // Ajouter le nouvel entretien à la liste
        entretiens.add(nouvelEntretien);

        // Rafraîchir la TableView
        tableauEntr.setItems(entretiens);

        // Effacer les champs de texte après l'ajout
           // Effacer les champs de texte après l'ajout
    idEntext.clear();
    candidature.clear();
    date.getEditor().clear(); // Effacer la date
    heure.clear();
    lieu.clear();
    idType.setValue(null); // Effacer la ChoiceBox
    note.clear();
    com.clear();

    } catch (NumberFormatException e) {
        // Gérer l'exception si la conversion en nombre échoue
        showAlert("Erreur", "Valeur incorrecte", "Assurez-vous que les champs numériques sont corrects.");
    }

    }

 // Ajoutez une variable pour stocker temporairement les données de la ligne sélectionnée
private Entretien entretienTemporaire;

@FXML
private void handlebtnUpdate(ActionEvent event) {
    // Obtenez la ligne sélectionnée
    Entretien entretienSelectionne = tableauEntr.getSelectionModel().getSelectedItem();

    if (entretienSelectionne != null) {
        if (entretienTemporaire == null) {
            // Première clique, sauvegardez les données actuelles
            entretienTemporaire = new Entretien(
                    entretienSelectionne.getId(),
                    entretienSelectionne.getIdCandidature(),
                    entretienSelectionne.getDate(),
                    entretienSelectionne.getHeure(),
                    entretienSelectionne.getLieu(),
                    entretienSelectionne.getType(),
                    entretienSelectionne.getNote(),
                    entretienSelectionne.getCommentaires()
            );

            // Remplissez les champs de texte avec les valeurs de la ligne sélectionnée
            idEntext.setText(String.valueOf(entretienTemporaire.getId()));
            candidature.setText(String.valueOf(entretienTemporaire.getIdCandidature()));
            date.setValue(LocalDate.parse(entretienTemporaire.getDate(), DateTimeFormatter.ofPattern("d/MM/yyyy")));
            heure.setText(entretienTemporaire.getHeure());
            lieu.setText(entretienTemporaire.getLieu());
            idType.setValue(entretienTemporaire.getType());
            note.setText(String.valueOf(entretienTemporaire.getNote()));
            com.setText(entretienTemporaire.getCommentaires());

            // Affichez un message d'information pour indiquer que les modifications sont en cours
            showAlert("Modifications en cours", "","Veuillez effectuer les modifications et cliquer sur 'Update' à nouveau.");
        } else {
            // Deuxième clique, mettez à jour les données avec les nouvelles valeurs
            entretienTemporaire.setIdCandidature(Integer.parseInt(candidature.getText()));
            entretienTemporaire.setDate(date.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
            entretienTemporaire.setHeure(heure.getText());
            entretienTemporaire.setLieu(lieu.getText());
            entretienTemporaire.setType(idType.getValue());
            entretienTemporaire.setNote(Integer.parseInt(note.getText()));
            entretienTemporaire.setCommentaires(com.getText());

            // Mise à jour des données dans la liste et rafraîchissement de la TableView
            int index = tableauEntr.getItems().indexOf(entretienSelectionne);
            tableauEntr.getItems().set(index, entretienTemporaire);

            // Remise à zéro de la variable temporaire
            entretienTemporaire = null;
            
            idEntext.clear();
            date.setValue(null); 
            candidature.clear();
            heure.clear();
            lieu.clear();
            idType.setValue(null); 
            note.clear();
            com.clear();
            // Affichez un message de confirmation
            showAlert("Mise à jour réussie", "","Les données ont été mises à jour avec succès.");
        }
    } else {
        showAlert("Sélection invalide", "Aucune ligne sélectionnée", "Veuillez sélectionner une ligne à mettre à jour.");
    }
}

@FXML
private void handlebtndelete(ActionEvent event) {
    // Obtenez l'entretien sélectionné dans la TableView
    Entretien selectedEntretien = tableauEntr.getSelectionModel().getSelectedItem();

    if (selectedEntretien != null) {
        // Affichez une boîte de dialogue de confirmation avec les détails de la ligne
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Confirmer la suppression de l'entretien ?");
        alert.setContentText("ID Entretien: " + selectedEntretien.getId() +
                             "\nID Candidature: " + selectedEntretien.getIdCandidature() +
                             "\nDate: " + selectedEntretien.getDate() +
                             "\nHeure: " + selectedEntretien.getHeure() +
                             "\nLieu: " + selectedEntretien.getLieu() +
                             "\nType: " + selectedEntretien.getType() +
                             "\nNote: " + selectedEntretien.getNote() +
                             "\nCommentaires: " + selectedEntretien.getCommentaires());

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // L'utilisateur a confirmé la suppression, supprimez la ligne de la liste
            entretiens.remove(selectedEntretien);
            // Actualisez la TableView
            tableauEntr.refresh();
        }
    } else {
        // Aucune ligne sélectionnée, affichez une boîte de dialogue d'erreur
        showAlert("Erreur de suppression", "Aucune ligne sélectionnée", "Veuillez sélectionner un entretien à supprimer.");
    }
}

    private void showAlert(String title,String header, String content) 
     {
         Alert alert = new Alert(Alert.AlertType.ERROR);
       
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(content);
       alert.showAndWait();
    }
}
