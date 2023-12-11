import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author khadi
 */
public class EntrepriseController implements Initializable {

    @FXML
    private Button btnOffres;
    @FXML
    private Button btnhome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnhome.setOnAction(event -> handlebtnHome(event));
        btnOffres.setOnAction(event -> handlebtnOffres(event));
        
    }    

    @FXML
    private void handlebtnOffres(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Entreprise/Offres.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnOffres.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EntrepriseController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebtnHome(ActionEvent event) {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnhome.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EntrepriseController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}
