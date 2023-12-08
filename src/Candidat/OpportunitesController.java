package Candidat;
import UserModel.Candidature;
import UserModel.Offre_emplois;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class OpportunitesController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfile;
    @FXML
    private Text poste1;
    @FXML
    private Text date1;
    @FXML
    private Text titre1;
    @FXML
    private Button btnApply1;
    @FXML
    private Text poste2;
    @FXML
    private Text date2;
    @FXML
    private Text titre2;
    @FXML
    private Button btnApply2;
   
    @FXML
    private Button delete;
    @FXML
    private TableView<Candidature> tableView;
private TableColumn<Candidature, Integer> idCandidatureColumn;

private TableColumn<Candidature, Integer> idOffreColumn;
    @FXML
    private Text ID1;
    @FXML
    private Text ID2;
    private ObservableList<Candidature> candidatures = FXCollections.observableArrayList(
            new Candidature(1,125),
            new Candidature(2,126)
    );
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btnHome.setOnAction( event -> handlebtnHome(event) );
         btnProfile.setOnAction( event -> handlebtnProfile(event) );
         btnApply1.setOnAction( event -> handlebtnApply1( event ));
         btnApply2.setOnAction( event -> handlebtnApply2( event ));
         // Initialisez vos colonnes
        idCandidatureColumn = new TableColumn<>("IdCandidature");
        idCandidatureColumn.setCellValueFactory(new PropertyValueFactory<>("idCandidature"));

        idOffreColumn = new TableColumn<>("IdOffre");
        idOffreColumn.setCellValueFactory(new PropertyValueFactory<>("idOffre"));

        // Ajoutez les colonnes à la TableView
        tableView.getColumns().addAll(idCandidatureColumn, idOffreColumn);

        // Remplissez la TableView avec des données
        tableView.setItems(candidatures);
    }    

    @FXML
    private void handlebtnHome(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnHome.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpportunitesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnProfile(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Candidat.fxml"));
            Parent root = loader.load();         
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnProfile.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpportunitesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnApply1(ActionEvent event) {
       int id=Integer.parseInt(ID1.getText());
       String poste= poste1.getText();
       String date= date1.getText();
       String titre= titre1.getText();
       Offre_emplois offre = new Offre_emplois(id,titre,poste,date);
       Candidature candidature = new Candidature(3, id);
       candidatures.add(candidature);
    }

    @FXML
    private void handlebtnApply2(ActionEvent event) {
       int id=Integer.parseInt(ID2.getText());
       String poste= poste2.getText();
       String date= date2.getText();
       String titre= titre2.getText();
       Offre_emplois offre = new Offre_emplois(id,titre,poste,date);
       Candidature candidature = new Candidature(4, id);
       candidatures.add(candidature);
    }
    @FXML
    private void handlebtnDelete(ActionEvent event) {
         //Obtenez la ligne sélectionnée dans la TableView
    Candidature selectedCandidature = tableView.getSelectionModel().getSelectedItem();

    if (selectedCandidature != null) {
        // Affichez une alerte de confirmation avec les détails de la ligne
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Confirmer la suppression de la candidature ?");
        alert.setContentText("ID Candidature: " + selectedCandidature.getIdCandidature() +
                             "\nID Offre: " + selectedCandidature.getIdOffre());

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // L'utilisateur a confirmé la suppression, supprimez la ligne de la liste
            candidatures.remove(selectedCandidature);
            // Actualisez la TableView
            tableView.refresh();
        }
    } else {
        // Aucune ligne sélectionnée, affichez une alerte d'erreur
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner une candidature à supprimer.");
        alert.showAndWait();
    }
    }
    
   

}
