package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class TableController {
    @FXML
    private TableView<Booking> table;
    @FXML
    private TableColumn<Booking, Integer> no;
    @FXML
    private TableColumn<Booking, String> time;
    @FXML
    private TableColumn<Booking, String> from;
    @FXML
    private TableColumn<Booking, String> destination;
    @FXML
    private TableColumn<Booking, String> phone;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // DEFINE VARIABLES
    private ArrayList<User> userList = Controller.getUserList();
    private ObservableList<Booking> list = FXCollections.observableArrayList();
    private ArrayList<Booking> bookList;

    private String matric = Controller.getMatric();
    private String pageType = Controller.getPageType();

    // GO HOME PAGE METHOD
    public void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO PASSENGER HOME
    public void pHomepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("7PassengerHome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO DRIVER HOME
    public void dHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("9DriverHome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // INSERT TABLE DATA
    public void startTable() {
        try {
            for (int i = 0; i < userList.size(); i++) {
                // FIND BOOKING LIST BASED ON MATRIC SESSION
                if (userList.get(i).getMatric().equals(matric)) {
                    // IF PASSENGER, DISPLAY PASSENGER BOOKING, IF DRIVER, DISPLAY ACCEPTED BOOKING
                    if (pageType == "USER") {
                        for (int j = 0; j < userList.get(i).getBookingList().size(); j++) {
                            bookList = userList.get(i).getBookingList();
                            list.add(bookList.get(j));
                        }
                    } else if (pageType == "USER+") {
                        for (int j = 0; j < userList.get(i).getAcceptedList().size(); j++) {
                            bookList = userList.get(i).getAcceptedList();
                            list.add(bookList.get(j));
                        }
                    }
                }
            }

            // INSERT DATA INTO TABLE
            time.setCellValueFactory(new PropertyValueFactory<Booking, String>("time"));
            from.setCellValueFactory(new PropertyValueFactory<Booking, String>("from"));
            destination.setCellValueFactory(new PropertyValueFactory<Booking, String>("destination"));
            phone.setCellValueFactory(new PropertyValueFactory<Booking, String>("phoneNumber"));

            table.setItems(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
