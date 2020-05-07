import javax.swing.*;
import java.awt.*;

public class PanelDown extends JPanel {

    public PanelDown(JTextField field, JTextArea area) {
        setLayout(new GridLayout(1, 2, 3,0));
        add(new NumbersPanel(field));
        add(new Operands(area, field));
    }
}
