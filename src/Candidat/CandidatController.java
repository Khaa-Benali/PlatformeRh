package Candidat;
import UserModel.Candidat;
import java.io.IOException;
import java.net.URL;
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

public class CandidatController implements Initializable {

    @FXML
    private Button btnhome;
    @FXML
    private Button btnOffres;
    @FXML
    private Button btnApp;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("//Home.fxml"));
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
    private void handlebtnApp(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Applications.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnApp.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
