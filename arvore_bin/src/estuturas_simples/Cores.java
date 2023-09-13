package estuturas_simples;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Cores {

    // Códigos de escape ANSI para cores de texto
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    class CustomCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            Component rendererComponent = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            // Defina a cor do texto e de fundo das células conforme necessário
            if (isSelected) {
                rendererComponent.setForeground(Color.WHITE);
                rendererComponent.setBackground(Color.BLUE);
            } else {
                rendererComponent.setForeground(Color.BLACK);
                rendererComponent.setBackground(Color.WHITE);
            }

            return rendererComponent;
        }
    }
}
