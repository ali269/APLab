import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OperandButtons extends JTabbedPane {
    private JPanel commons;
    private JPanel engine;
    private JTextField field;
    private JTextArea area;

    private final String[] comm = {
            "*", "/",
            "+", "-",
            "%", "="
    };
    private final String[][] eng = {
            {"sin", "tan", "exp"}, {"cos", "cot", "log"},
    };

    public OperandButtons(JTextArea a, JTextField f) {
        area = a;
        field = f;
        commons = new JPanel();
        engine = new JPanel();
        setButtons();
    }

    private void setButtons() {
        commons.setLayout(new GridLayout(3, 2, 3, 3));
        commons.setBackground(Color.orange);
        for (String s: comm) {
            JButton b = new JButton();
            b.setFocusable(false);
            b.setText(s);
            commons.add(b);
        }
        addTab("COMMON", commons);
        engine.setLayout(new GridLayout(2, 2, 3, 3));
        engine.setBackground(Color.CYAN);
        for (String s: eng[0]) {
            JButton button = new JButton();
            button.setText(s);
            button.setFocusable(false);
            engine.add(button);
        }
        JButton b = new JButton();
        b.setText("shift");
        b.setFocusable(false);
        b.addMouseListener(new ShiftMouseHandler());
        engine.add(b);
        add("ENGINE", engine);
    }


    private class ShiftMouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            for (int i = 0; i < 3; i++) {
                Component c = engine.getComponent(i);
                if (c instanceof JButton) {
                    String q = ((JButton) c).getText();
                    if (q.equals(eng[0][i]))
                        ((JButton) c).setText(eng[1][i]);
                    else
                        ((JButton) c).setText(eng[0][i]);
                }
            }

        }
    }

}
