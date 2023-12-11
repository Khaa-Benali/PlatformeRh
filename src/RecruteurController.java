import static UserModel.SoundPlayer.playSound;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RecruteurController implements Initializable {

    @FXML
    private Button btnhome;
    @FXML
    private Button btnEntretiens;
    @FXML
    private Button btnCandidatures;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnhome.setOnAction(event -> handlebrnHome(event));
        btnEntretiens.setOnAction(event -> handlebtnEntretiens(event));
        btnCandidatures.setOnAction(event -> handlebtnCandidatures(event));
                playSound("C:\\Users\\khadi\\OneDrive\\Documents\\NetBeansProjects\\interfacesPRFX\\src\\welcomeIyed.mp3");
    }    

    @FXML
    private void handlebrnHome(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnhome.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RecruteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnEntretiens(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Recruteur/Entretien.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnEntretiens.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RecruteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnCandidatures(ActionEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Recruteur/CandidatRec.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnCandidatures.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RecruteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
