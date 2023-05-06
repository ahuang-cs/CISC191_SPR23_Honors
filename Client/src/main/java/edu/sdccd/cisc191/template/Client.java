package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.spec.IvParameterSpec;

public class Client extends Application{

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            InventoryManager sharedInventoryManager = new InventoryManager();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/CoffeeShop.fxml"));
            Parent shopMenu = loader.load();
            CoffeeShopController controller = loader.getController();
            controller.setInventoryManager(sharedInventoryManager);
            Scene scene = new Scene(shopMenu);
            stage.setScene(scene);
            stage.show();

            FXMLLoader newLoader = new FXMLLoader();
            newLoader.setLocation(getClass().getResource("/CoffeeShop.fxml"));
            Parent newShopMenu = newLoader.load();
            CoffeeShopController newController = newLoader.getController();
            newController.setInventoryManager(sharedInventoryManager);
            Stage newStage = new Stage();
            Scene newScene = new Scene(newShopMenu);
            newStage.setScene(newScene);
            newStage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

