package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DriverView {
    @FXML
    private TextField dFrom;
    @FXML
    private TextField dDestination;
    @FXML
    private TextField dTime;
    @FXML
    private TextField dPhone;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    int page;

    ArrayList<Booking> list = Controller.getArrayList();

    public void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void acceptBooking(ActionEvent event) throws IOException {

    }

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
