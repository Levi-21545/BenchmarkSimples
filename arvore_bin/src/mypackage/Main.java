package mypackage;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new Janela().setVisible(true);

        Scanner leitor = new Scanner(System.in);
    }

}
