package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.stage.Stage;

//CONTROLLER FOR SIMPLE UI SCENE

public class Controller {
    // DEFINE ALL GUI ID
    @FXML
    private TextField pMatric;
    @FXML
    private TextField dMatric;
    @FXML
    private TextField pFrom;
    @FXML
    private TextField pDestination;
    @FXML
    private TextField pTime;
    @FXML
    private TextField pPhone;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // DEFINE NESCESSARY VARIABLES
    private int pageNumber;

    // VARIABLES FOR CHECKING MATRIC
    private static String matric;
    private String matricPattern = "[a-zA-Z][0-9][0-9][a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9]";

    // ARRAYLIST FOR BOOKING OBJECT
    public static ArrayList<Booking> book = new ArrayList<Booking>();

    // ARRAYLIST FOR USER
    public static ArrayList<User> user = new ArrayList<User>();
    final String passenger = "USER";
    final String driver = "USER+";
    public static String pageType;

    // GET ARRAYLIST DATA FOR BOOKING OBJECT
    public static ArrayList<Booking> getArrayList() {
        return book;
    }

    // GET BOOKING LIST WITH INDEX PARAMETER
    public static ArrayList<Booking> getList(int index) {
        return book;
    }

    // GET USER LIST
    public static ArrayList<User> getUserList() {
        return user;
    }

    public static String getMatric() {
        return matric;
    }

    public static String getPageType() {
        return pageType;
    }

    // DELETE A BOOKING DATA
    public static void deleteList(int index) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getMatric().equals(matric)) {
                user.get(i).addAcceptedBooking(book.get(index));
                System.out.println(user.get(i).getAcceptedList());
            }
        }
        book.remove(index);
    }

    // GO HOME PAGE METHOD
    public void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1HOME.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO BOOKING HISTORY PAGE METHOD (PASSENGER)
    public void bookHistory(ActionEvent event) throws IOException {
        pageType = passenger;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("8pBookingHistory.fxml"));
        root = loader.load();
        TableController table = loader.getController();
        // INVOKE BOOKING TABLE TO DISPLAY TO NEXT PAGE
        table.startTable();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO BOOKED HISTORY PAGE METHOD (DRIVER)
    public void bookedHistory(ActionEvent event) throws IOException {
        pageType = driver;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("10dBookedHistory.fxml"));
        root = loader.load();
        TableController table = loader.getController();
        // INVOKE BOOKING TABLE TO DISPLAY TO NEXT PAGE
        table.startTable();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO PASSENGER LOGIN PAGE METHOD
    public void pPage(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("2PASSENGER.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // GO DRIVER LOGIN PAGE METHOD
    public void dPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("3DRIVER.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // GO PASSENGER HOMEPAGE
    public void pHomepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("7PassengerHome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // PASSENGER LOGIN METHOD + GO TO PASSENGER HOME PAGE
    public void pHome(ActionEvent event) throws IOException {
        matric = pMatric.getText();

        // VALIDATE MATRIC PATTERN FOR LOGIN
        if (matric.matches(matricPattern)) {
            if (!user.isEmpty()) {
                Boolean found = false;
                for (int i = 0; i < user.size(); i++) {
                    if (user.get(i).getMatric().equals(matric)) {
                        found = true;
                        break;
                    } else {
                        found = false;
                    }
                }
                if (!found) {
                    user.add(new User(matric, passenger));
                }
            } else {
                user.add(new User(matric, passenger));
            }
            Parent root = FXMLLoader.load(getClass().getResource("7PassengerHome.fxml"));
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

    // GO TO BOOKING FORM PAGE
    public void pBooking(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("4PassengerYes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // DRIVER LOGIN METHOD + GO TO DRIVER HOME PAGE
    public void dHome(ActionEvent event) throws IOException {
        matric = dMatric.getText();

        // SAMPLE DATA IF NO DATA IN APPLICATION
        if (book.isEmpty()) {
            book.add(new Booking("KTDI, UTMJB", "PARADIGM MALL", "10:30AM",
                    "012-3456789"));
            book.add(new Booking("PARADIGM MALL", "KTC, UTMJB", "9:30AM",
                    "011-2233445"));
            book.add(new Booking("KTF, UTMJB", "TAMAN UNIVERSITI", "4:10PM",
                    "012-5667788"));
        }

        // VALIDATE MATRIC PATTERN FOR LOGIN
        if (matric.matches(matricPattern)) {
            pageNumber = 0;

            if (!user.isEmpty()) {
                Boolean found = false;
                for (int i = 0; i < user.size(); i++) {
                    if (user.get(i).getMatric().equals(matric)) {
                        found = true;
                        if (!user.get(i).getUserType().equals(driver)) {
                            user.get(i).setUserType(driver);
                        }
                        break;
                    } else {
                        found = false;
                    }
                }

                if (!found) {
                    user.add(new User(matric, driver));
                }

            } else {
                user.add(new User(matric, driver));
            }
            Parent root = FXMLLoader.load(getClass().getResource("9DriverHome.fxml"));
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

    // GO TO BOOKING LIST PAGE
    public void bookingList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("5DriverYes.fxml"));
        root = loader.load();
        DriverView driverView = loader.getController();
        // LIST BOOKING DATA PER OBJECT IN BOOKING LIST
        driverView.displayBooking(pageNumber, book);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println(book);
    }

    // CREATE BOOKING
    public void createBooking(ActionEvent event) throws IOException {
        Alert alert = new Alert(null);
        Boolean status = true;

        // PATTERNS FOR VALIDATING TIME AND PHONE NUMBER
        String timeRegex = "([1-9]|[1][0-2]):[0-5][0-9][P|A]M";
        String phoneRegex = "[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]?";

        // CHECK IF ANY INVALID DATA OR EMPTY VALUES
        if (pFrom.getText().isBlank() || pDestination.getText().isBlank() || pTime.getText().isBlank()
                || pPhone.getText().isBlank()) {
            alert.setAlertType(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter all information");
            alert.show();
            status = false;
        } else if (!pTime.getText().matches(timeRegex)) {
            alert.setAlertType(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter valid time");
            alert.setContentText("eg. 10:00PM, 7:10AM");
            alert.show();
            status = false;
        } else if (!pPhone.getText().matches(phoneRegex)) {
            alert.setAlertType(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter valid phone number");
            alert.show();
            status = false;
        }

        // IF NO ERROR, PROMPT CONFIRMATION FOR BOOKING
        if (status == true) {
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirm Booking?");

            // IF BOOKING CONFIRMED, INSERT DATA INTO ARRAYLIST FOR BOOKING OBJECT AND
            // PROMPT A MESSAGE
            if (alert.showAndWait().get() == ButtonType.OK) {
                try {

                    book.add(new Booking(pFrom.getText(), pDestination.getText(), pTime.getText(), pPhone.getText()));

                    for (int i = 0; i < user.size(); i++) {
                        if (user.get(i).getMatric().equals(matric)) {
                            user.get(i).addBooking(book.get(book.size() - 1));
                            System.out.println(user.get(i).getBookingList());
                        }
                    }
                    System.out.println(book);
                    alert.setAlertType(AlertType.INFORMATION);
                    alert.setTitle("Booking");
                    alert.setHeaderText("Book successfully!");
                    alert.show();

                    // LOAD HOME PAGE
                    Parent root = FXMLLoader.load(getClass().getResource("7PassengerHome.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    alert.setAlertType(AlertType.ERROR);
                    alert.setTitle("Booking");
                    alert.setHeaderText("Book unsuccessfully");
                    alert.show();
                    System.out.println(e);
                }
            }
        }
    }

}
