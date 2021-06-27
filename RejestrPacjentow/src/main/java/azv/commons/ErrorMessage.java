/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azv.commons;

import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class ErrorMessage {
    public static void DisplayError(String message, String title) {
        JOptionPane.showMessageDialog(new Frame(),
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void DisplayError(String message) {
        DisplayError(message, "Wystąpił błąd");
    }
}
