package edu.sdccd.cisc191.template;

import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


/**
 * This program opens a connection to a computer specified
 * as the first command-line argument.  If no command-line
 * argument is given, it prompts the user for a computer
 * to connect to.  The connection is made to
 * the port specified by LISTENING_PORT.  The program reads one
 * line of text from the connection and then closes the
 * connection.  It displays the text that it read on
 * standard output.  This program is meant to be used with
 * the server program, DateServer, which sends the current
 * date and time on the computer where the server is running.
 */
public class Client extends Application implements EventHandler<ActionEvent>
{
    Button button;
    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel fishRemaining;
    private GameBoardLabel guessesRemaining;
    private GameBoardLabel message;

    public static void main(String[] args)
    {
        // TODO: launch the app
        launch(args);
    }

    public void updateHeader() {
        //TODO update labels
        //"Fish: " + controller.modelGameBoard.getFishRemaining()
        //"Bait: " + controller.modelGameBoard.getGuessesRemaining()
        if(controller.fishWin()) {
            //"Fishes win!"
        } else if(controller.playerWins()) {
            //"You win!"
        } else {
            //"Find the fish!"
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        controller = new ControllerGameBoard();
        // TODO initialize gameCanvas
        stage.setTitle("COFFEE SHOP");
        button = new Button();
        button.setText("Menu");
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 350, 250);
        stage.setScene(scene);
        stage.show();

        fishRemaining = new GameBoardLabel();
        guessesRemaining = new GameBoardLabel();
        message = new GameBoardLabel();

        // TODO display game there are infinite ways to do this, I used BorderPane with HBox and VBox.
        updateHeader();

        for (int row = 0; row < ModelGameBoard.DIMENSION; row++) {
            // TODO: create row container
            for (int col=0; col < ModelGameBoard.DIMENSION; col++) {
                GameBoardButton button = new GameBoardButton(row, col, controller.modelGameBoard.fishAt(row,col));
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> {
                    controller.makeGuess(finalRow, finalCol);
                    if(!controller.isGameOver()) {
                        button.handleClick();
                        updateHeader();
                    }
                });
                // TODO: add button to row
            }
            // TODO: add row to column
        }

        // TODO: create scene, stage, set title, and show
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button) {
            System.out.println("Why did you click on me???");
        }
    }
}

