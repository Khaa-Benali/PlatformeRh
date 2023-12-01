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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController implements Initializable {
     @FXML
    private Button btnComp;

    @FXML
    private Button btnRec;

    @FXML
    private Button btnhome;

    @FXML
    private ImageView imgLogo;

    @FXML
   public void handleBtnHome(ActionEvent event) {
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Utilize the Login button to retrieve the scene
        Stage stage = (Stage) btnhome.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnhome.setOnAction(event -> handleBtnHome( event));
 
        btnRec.setOnAction(event -> handleBtnRec( event));
        btnComp.setOnAction(event -> handleBtnComp( event));
    }

    @FXML
    private void handleBtnRec(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Recruteur.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Utilize the Login button to retrieve the scene
        Stage stage = (Stage) btnRec.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void handleBtnComp(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Entreprise.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Utilize the Login button to retrieve the scene
        Stage stage = (Stage) btnComp.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

   
}

