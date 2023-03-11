package edu.sdccd.cisc191.template;


import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class CoffeeShopTest extends CoffeeShopController{

    @Test
    public void testDisplayMenuButton() throws AWTException {
        Robot fakeMouse = new Robot();
        //ActionEvent printAll = new ActionEvent(1, 1, "#displayMenu");
        fakeMouse.mouseMove(141, 68);
        fakeMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        fakeMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
