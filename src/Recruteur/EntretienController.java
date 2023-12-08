package Recruteur;
import UserModel.Entretien;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button AddEValuation;
    @FXML
    private TableView<Entretien> tableauEntr;
    @FXML
    private TableColumn<Entretien, Integer> idEntretienColumn;
    @FXML
    private TableColumn<Entretien, String> dateColumn;
    @FXML
    private TableColumn<Entretien, String> heureColumn;
    @FXML
    private TableColumn<Entretien, String> lieuColumn;
    @FXML
    private TableColumn<Entretien, Integer> idCandidatureColumn; 
     @FXML
    private TableColumn<Entretien,String> type; 

    private ObservableList<Entretien> entretiens;

    public EntretienController() {
        this.entretiens = FXCollections.observableArrayList(
                new Entretien(123,1,"12/12/2023","Tunis" ,"10:00","technique") );
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // Initialisez vos colonnes
        idCandidatureColumn.setCellValueFactory(new PropertyValueFactory<>("idCandidature"));
        idEntretienColumn.setCellValueFactory(new PropertyValueFactory<>("idEntretien"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
         lieuColumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        heureColumn.setCellValueFactory(new PropertyValueFactory<>("heure"));
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
       
        

        // Ajoutez les colonnes à la TableView
        tableauEntr.getColumns().addAll(idCandidatureColumn,idEntretienColumn, dateColumn, lieuColumn,heureColumn,type);
        tableauEntr.setItems(entretiens);
    }    
    @FXML
    private void handlebtnHome(ActionEvent event) {
    }

    @FXML
    private void handlbtnCandi(ActionEvent event) {
    }

    @FXML
    private void handlebtnProfile(ActionEvent event) {
    }

    @FXML
    private void handlebtnAdd(ActionEvent event) {
    }

    @FXML
    private void handlebtnUpdate(ActionEvent event) {
    }

    @FXML
    private void handlebtndelete(ActionEvent event) {
    }

    @FXML
    private void handlebtnAddEValuation(ActionEvent event) {
    }
    
}
