package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

/**
 * Presents the user with the game graphical user interface
 */
public class Client extends Application
{
    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel fishRemaining;
    private GameBoardLabel guessesRemaining;
    private GameBoardLabel message;

    public static void main(String[] args)
    {
        // TODO: launch the app
        System.out.println("Hello World");
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
}