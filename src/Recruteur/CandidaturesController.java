package Recruteur;

import UserModel.Candidat;
import UserModel.Candidature;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khadi
 */
public class CandidaturesController implements Initializable {

    @FXML
    private Button btnhome;
    @FXML
    private Button brnProfile;
    @FXML
    private Button Consulter;
    @FXML
    private Button Entretener;
    @FXML
    private Button entretiens;
    @FXML
    private TableView<Candidat> tableCandidat;
    private TableColumn<Candidat, Integer> idCandidat;
     private TableColumn<Candidat, String> firstname ;
    private TableColumn<Candidat, String> lastname ;
    private TableColumn<Candidat, String> username ;
    private TableColumn<Candidat, String> email;
    private TableColumn<Candidat,Integer> cin; 
    @FXML
    private TableView<Candidature> tableCanidatures;
    private TableColumn<Candidature, Integer> idCandidature;
     private TableColumn<Candidature, String> idOffre ;
    
    
    private ObservableList< Candidat > candidats = FXCollections.observableArrayList(
    );
     private ObservableList< Candidature > candidatures = FXCollections.observableArrayList(
    );
    @FXML
    private AnchorPane anchor1;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button back;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Initialiser quelques candidats
    Candidat premierCandidat = new Candidat(1, "Benali", "Khadija", "khaa", "khadija@example.com", 12345, "password1");
    Candidat deuxiemeCandidat = new Candidat(2, "Attia", "Yassmina", "yass", "yassmina@example.com", 67890, "password2");
   // Ajouter les candidats à la liste observable
    candidats.addAll(premierCandidat, deuxiemeCandidat);
 
    Candidature c1 = new Candidature(1,102);
    Candidature c2 = new Candidature(2,122);
    Candidature c3 = new Candidature(3,162);
    Candidature c4 = new Candidature(4,155);
   
    premierCandidat.candidatures.add(c1);
    premierCandidat.candidatures.add(c2);
    deuxiemeCandidat.candidatures.add(c3);
    deuxiemeCandidat.candidatures.add(c4);

        idCandidat = new TableColumn<>("IdCandidat");
        idCandidat.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname = new TableColumn<>("Firstname");
        firstname.setCellValueFactory(new PropertyValueFactory<>("nom"));
         lastname = new TableColumn<>("lastname");
        lastname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         username = new TableColumn<>("username");
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email = new TableColumn<>("email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        cin = new TableColumn<>("Cin");
        cin.setCellValueFactory(new PropertyValueFactory<>("Cin"));
        
           // Ajoutez les colonnes à la TableView
        tableCandidat.getColumns().addAll(idCandidat,firstname, lastname, username,email,cin);
        tableCandidat.setItems(candidats);
        idCandidature = new TableColumn<>("idCandidature");
        idCandidature.setCellValueFactory(new PropertyValueFactory<>("idCandidature"));
          idOffre = new TableColumn<>("idOffre");
        idOffre.setCellValueFactory(new PropertyValueFactory<>("idOffre"));
        tableCanidatures.getColumns().addAll(idCandidature,idOffre);
        tableCanidatures.setItems(candidatures);
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
            Logger.getLogger(CandidaturesController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CandidaturesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void handlebtnConsulter(ActionEvent event) {
        anchor1.setVisible(false);
        // Récupérez le candidat sélectionné
         Candidat candidatSelectionne = tableCandidat.getSelectionModel().getSelectedItem();
          if (candidatSelectionne != null) {
            // Chargez les candidatures du candidat dans la TableView des candidatures
            List<Candidature> candidaturesDuCandidat = candidatSelectionne.getCandidatures();
            tableCanidatures.setItems(FXCollections.observableList(candidaturesDuCandidat));

            // Rendez la TableView des candidatures visible
            anchor2.setVisible(true);
        } else {
          
    }}
    @FXML
    private void handlebtnEntretner(ActionEvent event) { try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Entretien.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) entretiens.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CandidaturesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnEntretiens(ActionEvent event) {
            try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Entretien.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) entretiens.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CandidaturesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnBack(ActionEvent event) {
        anchor2.setVisible(false);
        anchor1.setVisible(true);
        
    }
    
}
