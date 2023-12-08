import Candidat.CandidatController;
import UserModel.Candidat;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SignUpController implements Initializable {
static LinkedList<Candidat> list = new LinkedList<>();
      @FXML
    private Label Login;

    @FXML
    private Button btnSignup;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private TextField email;

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField lastname;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField firstname;
    @FXML
    private TextField id;
    @FXML
    private TextField cin;
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        Login.setOnMouseClicked(event -> handleLogin());
        btnSignup.setOnAction( event -> handleBtnSignup(event) );
    }    
    @FXML
    public void handleLogin() {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Utilisez le bouton Login pour récupérer la scène
            Stage stage = (Stage) Login.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 @FXML
private void handleBtnSignup(ActionEvent event) {
    try {
        int candidatId = Integer.parseInt(id.getText());
        int candidatCin = Integer.parseInt(cin.getText());
        String nom = lastname.getText();
        String prenom = firstname.getText();
        String user = username.getText();
        String mail = email.getText();
        String pass = password.getText();
        String confirmPass = confirmpassword.getText();

            if (!pass.equals(confirmPass)) {
                showAlert("Erreur","Error" ,"Les mots de passe ne correspondent pas.");
                return;
            }
        Candidat candidat = new Candidat(candidatId, nom, prenom, user, mail, candidatCin, pass);
        list.add(candidat);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Candidat/Candidat.fxml"));
        Parent root = loader.load();
        CandidatController candidatController = loader.getController();
        candidatController.setCandidatDetails(candidat);
 

        // Now, you can show the scene
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnSignup.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
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
