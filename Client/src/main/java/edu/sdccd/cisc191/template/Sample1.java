package edu.sdccd.cisc191.template;
//This is scene 2 (Add data page)


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sample1 implements Initializable {
    @FXML
    private TextField MenuIndex;

    @FXML
    private TextField MenuItem;

    @FXML
    private Button button;

    @FXML
    private TableColumn<tableViewScene2, Integer> indexColumn;

    @FXML
    private TableColumn<tableViewScene2, String> itemColumn;

    @FXML
    private TextField menuQuantity;

    @FXML
    private TableColumn<tableViewScene2, Integer> quantityColumn;

    @FXML
    private Button submit;

    @FXML
    private TableView<tableViewScene2>tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
    }

    //submit button
    @FXML
    public void submit(javafx.event.ActionEvent actionEvent) {
        tableViewScene2 customer = new tableViewScene2(Integer.parseInt(MenuIndex.getText()), MenuItem.getText(), Integer.parseInt(menuQuantity.getText()));
        ObservableList<tableViewScene2> customers = tableView.getItems();
        customers.add(customer);
        tableView.setItems(customers);
    }
    //remove button
    @FXML
    public void remove(MouseEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }








    /**
     *
     * @param event
     * @throws IOException
     * Below are the buttons for the navigation bar :)
     */
    @FXML
    void itemSorterHomePage(MouseEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Client.class.getResource("/sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stage 1");
        stage.setScene(scene);
    }

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











    /*
    When this method is called, it will change the scene to a addDataView
     */




}

