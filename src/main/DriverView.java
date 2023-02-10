package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

//CONTROLLER FOR DRIVER VIEW SCENE

public class DriverView {
    // DEFINE ALL GUI ID
    @FXML
    private TextField dFrom;
    @FXML
    private TextField dDestination;
    @FXML
    private TextField dTime;
    @FXML
    private TextField dPhone;
    @FXML
    private TextField cdFrom;
    @FXML
    private TextField cdDestination;
    @FXML
    private TextField cdTime;
    @FXML
    private TextField cdPhone;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    int page;

    // GET ARRAYLIST FROM PREVIOUS CLASS
    ArrayList<Booking> list = Controller.getArrayList();

    // HOME METHOD
    public void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // ACCEPT BOOKING METHOD
    public void acceptBooking(ActionEvent event) throws IOException {
        Alert alert = new Alert(null);
        // CONFIRMATION
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Accept Booking?");

        // ONCE CONFIRMED, DISPLAY SELECTED RIDE TO BE CARRY OUT
        if (alert.showAndWait().get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("6CurrentRide.fxml"));
            root = loader.load();
            DriverView driverView = loader.getController();
            try {
                driverView.displayCurrent(page);

            } catch (Exception e) {
                System.out.println(e);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    // COMPLETE RIDE
    public void completeBooking(ActionEvent event) throws IOException {
        Alert alert = new Alert(null);
        // CONFIRMATION
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ride complete?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            // ONCE CONFIRMED, DISPLAY MESSAGE, DELETED COMPLETED BOOKED DATA FROM ARRAYLIST
            // AND GO TO HOME PAGE
            alert.setAlertType(AlertType.INFORMATION);
            alert.setTitle("Complete");
            alert.setHeaderText("Ride complete!");
            alert.show();
            Controller.deleteList(page);
            Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    // DISPLAY BOOKING DATA
    public void displayBooking(int page, ArrayList<Booking> book) {
        try {
            this.page = page;
            dFrom.setText(list.get(page).getFrom());
            dDestination.setText(list.get(page).getDestination());
            dTime.setText(list.get(page).getTime());
            dPhone.setText(list.get(page).getPhoneNumber());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DISPLAY ACCEPTED BOOKING DATA
    public void displayCurrent(int index) {
        System.out.println(list.get(index).getFrom());
        System.out.println(list.get(index).getDestination());
        System.out.println(list.get(index).getTime());
        System.out.println(list.get(index).getPhoneNumber());

        cdFrom.setText(list.get(index).getFrom());
        cdDestination.setText(list.get(index).getDestination());
        cdTime.setText(list.get(index).getTime());
        cdPhone.setText(list.get(index).getPhoneNumber());

        this.page = index;

    }

    // NAVIGATE BETWEEN EACH ARRAYLIST DATA (NEW PAGE FOR EACH ARRAYLIST)
    public void newPage(ActionEvent event) {
        String button = ((Node) event.getSource()).getId();

        if (button.equals("nextButton")) {
            page += 1;
            if (page < list.size()) {
                displayBooking(page, list);
            } else {
                page -= 1;
            }
        } else if (button.equals("previousButton")) {
            page -= 1;
            if (page >= 0) {
                displayBooking(page, list);
            } else {
                page += 1;
            }
        }
    }
}
