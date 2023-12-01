import UserModel.Candidat;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController implements Initializable {
     @FXML
    private Button btnLogin;

    @FXML
    private Label createAccount;
    @FXML
    private PasswordField password;

  @FXML
    private TextField username;

    @FXML private ImageView imgLogo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       createAccount.setOnMouseClicked(event -> handleCreateAccount( ));
       btnLogin.setOnAction(event -> handleBtnLogin(event));
    }    
    @FXML
    public void handleCreateAccount() {
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Utilisez le bouton Login pour récupérer la scène
            Stage stage = (Stage) createAccount.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@FXML
    private void handleBtnLogin(ActionEvent event) {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        // Assuming 'list' is the list of Candidat instances from SignUpController
         Optional<Candidat> matchingCandidat = SignUpController.list.stream()
                .filter(c -> c.getUsername().equals(enteredUsername) && c.getMotDePasse().equals(enteredPassword))
                .findFirst();

        if (matchingCandidat.isPresent()) {
            // Username and password match
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Candidat/Candidat.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                // Utilize the Login button to retrieve the scene
                Stage stage = (Stage) btnLogin.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Username or password is incorrect, you may show an error message
            System.out.println("Invalid username or password");
        }
    }
}
