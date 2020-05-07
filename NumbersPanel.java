import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NumbersPanel extends JPanel {
    private JTextField field;
    public NumbersPanel(JTextField field) {
        this.field = field;
        setLayout(new GridLayout(4, 3));
        setBackground(Color.lightGray);
        prepareGUI();
    }

    private void prepareGUI() {
        for(Integer i = 1; i < 10; i++) {
            JButton b = new JButton();
            b.setText(i.toString());
            b.setFocusable(false);
            b.setBackground(Color.CYAN);
            b.addMouseListener(new MouseHandler(i.toString()));
            add(b);
        }
        JButton b = new JButton();
        b.setBackground(Color.CYAN);
        b.setFocusable(false);
        b.setText(".");
        b.addMouseListener(new MouseHandler("."));
        add(b);

        JButton b1 = new JButton();
        b1.setText("0");
        b1.setFocusable(false);
        b1.setBackground(Color.CYAN);
        b1.addMouseListener(new MouseHandler("0"));
        add(b1);
    }


    private class MouseHandler extends MouseAdapter {
        private String s;
        public MouseHandler(String s) {
            this.s = s;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            String u = field.getText();
            if (u.length() < 10) {
                field.setText(u + s);
            }
        }
    }
}
