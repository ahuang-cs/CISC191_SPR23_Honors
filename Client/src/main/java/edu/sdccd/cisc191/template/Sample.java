package edu.sdccd.cisc191.template;
//This is the homepage(First scene when it gets started)



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.TransformationList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Sample implements Initializable {


    @FXML
    private TableColumn<user, Integer> MenuIndex;

    @FXML
    private TableColumn<user,String> MenuItem;

    @FXML
    private TableColumn<user, Integer> Quantity;

    @FXML
    private TableView<user> table;

    @FXML
    private TextField menuIdInput;
    @FXML
    private TextField menuItemInput;
    @FXML
    private TextField  quantityInput;
    @FXML
    private Button button;


    //switches to addData Stage
    @FXML
    void addData(MouseEvent event) throws IOException {
    Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Client.class.getResource("/sample1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stage 2");
        stage.setScene(scene);
    }

    @FXML
    void displayMenuScene(MouseEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Client.class.getResource("/sample2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stage 3");
        stage.setScene(scene);
    }


    ObservableList<user> list = FXCollections.observableArrayList(
            new user(1, "Coffee", 10),
            new user(2, "Frappe", 20),
            new user(3, "Tea", 6),
            new user(4, "Caramel mocha Coffee", 25)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MenuIndex.setCellValueFactory(new PropertyValueFactory<user,Integer>("MenuIndex"));
        MenuItem.setCellValueFactory(new PropertyValueFactory<user,String>("MenuItem"));

        Quantity.setCellValueFactory(new PropertyValueFactory<user,Integer>("Quantity"));

        table.setItems(list);
    }






}

