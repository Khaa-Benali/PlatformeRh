package Entreprise;

import UserModel.Offre_emplois;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OffresController implements Initializable {
    ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    private Button HomeBtn;
    @FXML
    private Button btnProfile;
    @FXML
    private ListView<String> exigencesId;
    @FXML
    private Button supprimerExigenceBtn;
    @FXML
    private Button ajouterExigenceBtn;
    @FXML
    private TextField nouvelleExigenceField;
    @FXML
    private TableView<Offre_emplois> offreTableV;
    @FXML
    private TableColumn<Offre_emplois, String> titreColumn;
    @FXML
    private TableColumn<Offre_emplois, String> descriptionColumn;
    @FXML
    private TableColumn<Offre_emplois, Date> datePublicationColumn;
    @FXML
    private TableColumn<Offre_emplois, String> exigencesColumn;
    @FXML
    private TableColumn<Offre_emplois, Integer> idColumn;
    @FXML
    private TextField titre;
    @FXML
    private DatePicker datepublication;
    @FXML
    private TextField descri;
    @FXML
    private TextField ID;
    @FXML
    private Button addOppor;
    @FXML
    private Button deletBtn;
    @FXML
    private Text IdT;
    @FXML
    private Text TitreT;
    @FXML
    private Text DescriptionT;
    @FXML
    private Text DatePT;
    @FXML
    private Text ExigencesT;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HomeBtn.setOnAction(event -> handleHomeButton(event));
        btnProfile.setOnAction(event -> clickedProfile(event));
        addOppor.setOnAction(event -> addOpportunity(event));
        deletBtn.setOnAction(event -> handledeleteButton(event));
        ajouterExigenceBtn.setOnAction(event -> ajouterExigence(event));
        supprimerExigenceBtn.setOnAction(event -> supprimerExigence(event));

        
      

        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        datePublicationColumn.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
        exigencesColumn.setCellValueFactory(new PropertyValueFactory<>("exigences"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idOffre"));

        // Ajout des éléments à la liste
        list.addAll("Maitrise de la langue de programmation JAVA", "Autre exigence 1", "Autre exigence 2");

        // Ajout des éléments à la ListView
        exigencesId.getItems().addAll(list);

        // Gestionnaire d'événements pour le bouton de suppression
        supprimerExigenceBtn.setOnAction(this::supprimerExigence);

        // Désactiver le bouton de suppression tant qu'aucun élément n'est sélectionné
        supprimerExigenceBtn.disableProperty().bind(exigencesId.getSelectionModel().selectedItemProperty().isNull());

        // Set the SelectionMode of ListView to MULTIPLE
        exigencesId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void handleHomeButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Utilize the clickedEntret button to retrieve the scene
            Stage stage = (Stage) HomeBtn.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickedProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Entreprise.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Utilize the clickedEntret button to retrieve the scene
            Stage stage = (Stage) btnProfile.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimerExigence(ActionEvent event) {
        int selectedIndex = exigencesId.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            list.remove(selectedIndex);
            exigencesId.getItems().setAll(list);
        }
    }

    @FXML
    private void ajouterExigence(ActionEvent event) {
        String nouvelleExigence = nouvelleExigenceField.getText().trim();
        if (!nouvelleExigence.isEmpty()) {
            list.add(nouvelleExigence);
            exigencesId.getItems().setAll(list);
            nouvelleExigenceField.clear();
        }
    }

    @FXML
    private void selectionnerExigence(MouseEvent event) {
        if (event.getClickCount() == 1) {
            int selectedIndex = exigencesId.getSelectionModel().getSelectedIndex();
        }
    }

    @FXML
    private void addOpportunity(ActionEvent event) {
        System.out.println("hello");
        String IDText = ID.getText();
        String titreText = titre.getText();
        String descriText = descri.getText();

        // Retrieve the selected date from the DatePicker
        LocalDate datePublicationValue = datepublication.getValue();
        Date datePublication = datePublicationValue != null ? java.sql.Date.valueOf(datePublicationValue) : null;

        // Retrieve the selected items from the ListView
        ObservableList<String> exigencesSelectedItems = exigencesId.getSelectionModel().getSelectedItems();

        // Check for empty fields
        if (exigencesSelectedItems.isEmpty() || IDText.isEmpty() || titreText.isEmpty() || descriText.isEmpty()
                || datePublication == null) {
            showAlert("Error", "Missing Information", "Please fill in all fields.");
            return;
        }

        // Create a new instance of Offre_emplois with the entered values
        Offre_emplois newOffre = new Offre_emplois(Integer.parseInt(IDText), titreText, descriText, datePublication,
                exigencesSelectedItems);

        // Add the new instance to the TableView's data
        offreTableV.getItems().add(newOffre);
        // Set the text of Text objects after retrieving values
    IdT.setText(IDText);
    TitreT.setText(titreText);
    DescriptionT.setText(descriText);
    DatePT.setText(datePublicationValue.toString());
    ExigencesT.setText(String.join(", ", exigencesSelectedItems));


        // Clear the input fields
        clearInputFields();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearInputFields() {
        ID.clear();
        titre.clear();
        descri.clear();
        datepublication.getEditor().clear(); // Clear the DatePicker text field
        exigencesId.getSelectionModel().clearSelection();
    }

    @FXML
    private void handledeleteButton(ActionEvent event) {
        // Get the selected item from the TableView
    Offre_emplois selectedOffre = offreTableV.getSelectionModel().getSelectedItem();

    if (selectedOffre != null) {
        // Remove the selected item from the TableView
        offreTableV.getItems().remove(selectedOffre);
        // Clear the Text objects
        IdT.setText("");
        TitreT.setText("");
        DescriptionT.setText("");
        DatePT.setText("");
        ExigencesT.setText("");
    } else {
        // If no item is selected, show an alert
        showAlert("Error", "No Selection", "Please select an item to delete.");
    }
    }
}