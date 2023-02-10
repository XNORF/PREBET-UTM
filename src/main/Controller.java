package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField pMatric;
    @FXML
    private TextField dMatric;

    private int pageNumber;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String matric;
    private String matricPattern = "[a-zA-Z][0-9][0-9][a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9]";
    public ArrayList<Booking> book = new ArrayList<Booking>();

    public void StartApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        book.add(new Booking("KTDI, UTMJB", "PARADIGM MALL", "10:30AM", "012-3456789"));
        book.add(new Booking("PARADIGM MALL", "KTC, UTMJB", "9:30AM", "011-2233445"));
        book.add(new Booking("KTF, UTMJB", "TAMAN UNIVERSITI", "4:10PM", "012-5667788"));

    }

    public void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2PASSENGER.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void dPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("3DRIVER.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pLogin(ActionEvent event) throws IOException {
        matric = pMatric.getText();

        if (matric.matches(matricPattern)) {
            Parent root = FXMLLoader.load(getClass().getResource("4PassengerYes.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            try {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Matric");
                alert.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void dLogin(ActionEvent event) throws IOException {
        matric = dMatric.getText();

        if (matric.matches(matricPattern)) {
            pageNumber = 1;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("5DriverYes.fxml"));
            root = loader.load();
            DriverView driverView = loader.getController();
            driverView.displayBooking(pageNumber, book);
            // Parent root = FXMLLoader.load(getClass().getResource("5DriverYes.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            try {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Matric");
                alert.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createBooking(ActionEvent event) throws IOException {

    }

}
