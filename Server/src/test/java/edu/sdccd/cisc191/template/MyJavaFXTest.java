package edu.sdccd.cisc191.template;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class extends the CoffeeShopController class, which is assumed to be the class that contains the JavaFX button being tested.
 *
 * In the setup() method, the JavaFX toolkit is initialized using a new JFXPanel. The displayMenuButton object is then created and assigned the label "Display Menu".
 *
 * In the tearDown() method, the Platform.exit() method is called to clean up the JavaFX toolkit.
 *
 * The testDisplayMenuButtonLabel() method tests whether the displayMenuButton object's label is equal to the string "Display Menu". If the label is not equal to this string, the test will fail.
 */
public class MyJavaFXTest extends CoffeeShopController {
    private Button displayMenuButton;

    @BeforeEach
    public void setUp() {
        // Initialize
        new JFXPanel();

        // Create the button to be tested
        displayMenuButton = new Button("Display Menu");
    }

    @AfterEach
    public void tearDown() {
        // Clean up
        Platform.exit();
    }

    @Test
    public void testDisplayMenuButtonLabel() {
        assertEquals("Display Menu", displayMenuButton.getText());
    }
}
