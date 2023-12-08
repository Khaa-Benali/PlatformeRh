package Candidat;
import UserModel.Candidat;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CandidatController implements Initializable {

    @FXML
    private Button btnhome;
    @FXML
    private Button btnOffres;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelId;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelCin;
    @FXML
    private Label labelusernamme;
    @FXML
    private Button btnCv;
    @FXML
    private AnchorPane idProfile;
    @FXML
    private Button updateProfile;
    @FXML
    private AnchorPane idCV;
    @FXML
    private Button updateCV;
    @FXML
    private Label Experince;
    @FXML
    private Label diplome;
    @FXML
    private AnchorPane idProfile1;
    @FXML
    private Button updateProfileConfirm;
    @FXML
    private TextField Identifiant;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField Email;
    @FXML
    private TextField Username;
    @FXML
    private TextField Cin;
    @FXML
    private ListView<String> listCompetences;
    @FXML
    private AnchorPane idCVupdate;
    @FXML
    private Button confirmCV;
    @FXML
    private TextField comp;
    @FXML
    private Button btnplus;
   

      @FXML
     private ListView<String> listCompetences1;
     private ObservableList<String> competencesList = FXCollections.observableArrayList();
     private ObservableList<String> competencesList1 = FXCollections.observableArrayList();
    @FXML
    private TextField updiplome;
    @FXML
    private TextField upexperience;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         listCompetences.setItems(competencesList1);
        listCompetences1.setItems(competencesList);
         btnhome.setOnAction( event -> handlebtnHome(event) );
         btnOffres.setOnAction( event -> handlebtnOffres(event) );
         updateProfileConfirm.setOnAction( event -> handlebtnUpdateConfirm(event) );
         btnCv.setOnAction( event -> handlebtnCv(event) );
         updateProfile.setOnAction( event -> handlebtnUpdate(event) );
         btnplus.setOnAction( event -> handlebtnplus(event) );
          confirmCV.setOnAction( event -> handlebtnconfirmCV(event) );
         updateCV.setOnAction( event -> handlebtnUpdateCv(event) );
         
         
    }    
    public void setCandidatDetails(Candidat candidat) {
       labelId.setText(String.valueOf(candidat.getId()));
        labelNom.setText(candidat.getNom());
        labelPrenom.setText(candidat.getPrenom());
        labelusernamme.setText(candidat.getUsername());
        labelEmail.setText(candidat.getEmail());
        labelCin.setText(String.valueOf(candidat.getCin()));
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
            Logger.getLogger(CandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnOffres(ActionEvent event) {
          try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Opportunites.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnOffres.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @FXML
    private void handlebtnUpdate(ActionEvent event) {
        //coppier les données
        Identifiant.setText( labelId.getText()) ;
        Firstname.setText( labelNom.getText());
        Lastname.setText(labelPrenom.getText());
        Username.setText(labelusernamme.getText());
        Cin.setText(labelCin.getText());
        Email.setText(labelEmail.getText());
        
        idProfile.setVisible(false);
        idProfile1.setVisible(true);
        
    }

    @FXML
    private void handlebtnCv(ActionEvent event) {
        idCV.setVisible(true);       
    }

    @FXML
    private void handlebtnUpdateConfirm(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Confirmer la mise à jour du profil");
    alert.setContentText("Êtes-vous sûr de vouloir mettre à jour le profil?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK){
        labelId.setText( labelId.getText()) ;
        labelNom.setText( Firstname.getText());
        labelPrenom.setText(Lastname.getText());
        labelusernamme.setText(Username.getText());
        labelCin.setText(Cin.getText());
        labelEmail.setText(Email.getText());
        
        idProfile1.setVisible(false);
        idProfile.setVisible(true);
     } else {
        // L'utilisateur a annulé l'opération, ne rien faire
    }
    }

    @FXML
    private void handlebtnUpdateCv(ActionEvent event) {
         idCV.setVisible(false);
         idCVupdate.setVisible(true);
    }

    @FXML
    private void handlebtnconfirmCV(ActionEvent event) {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Confirmer la mise à jour du CV");
    alert.setContentText("Êtes-vous sûr de vouloir mettre à jour votre cv?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK){
           // Récupérer les données de la liste de compétences
    List<String> competences = new ArrayList<>(listCompetences1.getItems());

    // Récupérer les données des champs updiplome et upexperience
    String diplomeValue = updiplome.getText();
    String experienceValue = upexperience.getText();

    // Mettre à jour les labels diplome et experience
    diplome.setText(diplomeValue);
    Experince.setText(experienceValue);

    // Mettre à jour la liste de compétences
    listCompetences.setItems(FXCollections.observableArrayList(competences));

    // Changer la visibilité des AnchorPanes
    idCVupdate.setVisible(false);
    idCV.setVisible(true);
     } else {
        // L'utilisateur a annulé l'opération, ne rien faire
    }
    }

    @FXML
    private void handlebtnplus(ActionEvent event) {
     String nouvelleCompetence = comp.getText();
     competencesList.add(nouvelleCompetence);
     comp.clear();
    }
    private void showAlert(String title, String header, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.showAndWait();
}

}
