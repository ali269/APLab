import javax.swing.*;
import javax.swing.text.Keymap;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;

public class CalcView {
    private JFrame frame;
    private JTextArea area;
    private JTextField field;

    public CalcView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("CALCULATOR");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(new GridLayout());
        frame.setFocusable(true);
        frame.addKeyListener(new KeyHandler());
        area = new JTextArea();
        area.setRows(5);
        area.setColumns(20);
        area.setLineWrap(true);
        area.setFocusable(false);
        area.setFont(new Font("Calibri", Font.ITALIC, 22));
        //area.addKeyListener(new KeyHandler());
        field = new JTextField();
        field.setFocusable(false);
        field.setFont(new Font("Calibri", Font.ITALIC, 34));

        prepareGUI();
    }

    private void prepareGUI() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu();
        menu.setText("options");
        JMenuItem menu1 = new JMenuItem();
        menu1.setText("Exit");
        menu1.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK)
        );
        menu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menu1);
        JMenuItem copyMenu = new JMenuItem();
        copyMenu.setText("copy");
        copyMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection ss = new StringSelection(area.getText());
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(ss, null);
            }
        });
        copyMenu.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK)
        );
        menu.add(copyMenu);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);


        JPanel mainPanel = new JPanel();
        mainPanel.setFocusable(true);
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(new GridLayout(2, 1, 0, 7));
        mainPanel.setSize(500, 500);
        mainPanel.add(new PanelUp(field, area));
        mainPanel.add(new PanelDown(field, area));
        frame.add(mainPanel);
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            Character c = e.getKeyChar();
            if (isNumber(c)) {
                String s = field.getText();
                if (s.length() < 10) {
                   s = s + c.toString();
                }
                field.setText(s);
            }
            else if (isCommon(c)) {
                String s = area.getText();
                String s1 = field.getText();
                Calculator.setFirst(Double.parseDouble(s1));
                Calculator.setOperand(c.toString());
                field.setText("");
                area.setText(s + s1 + c.toString());
            }
            else if (isEngine(c)) {
                String s = "";
                switch (c) {
                    case 'a':
                        s = "SIN";
                        break;
                    case 'A':
                        s = "COS";
                        break;
                    case 'b':
                        s ="TAN";
                        break;
                    case 'B':
                        s = "COT";
                        break;
                    case 'c':
                        s = "EXP";
                        break;
                    case 'C':
                        s = "LOG";
                        break;

                }
                String u = field.getText();
                Calculator.setOperand(s);
                //Calculator.setFirst(Double.parseDouble(u));
                field.setText("");
                String u1 = area.getText();
                area.setText(u1 + s + u);
            }
            else if (c.equals('=')) {
                String u = field.getText();
                Calculator.setSecond(Double.parseDouble(u));
                String s = area.getText();
                area.setText(s + u + " = " + Calculator.getResult() + "\n");
                field.setText("");
            }

        }


        private boolean isNumber(char c) {
            char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
            for (char i: cs) {
                if (i == c) {
                    return true;
                }
            }
            return false;
        }

        private boolean isCommon(char c) {
            char[] cs = {'+', '-', '*', '/', '%'};
            for (char i: cs) {
                if (i == c)
                    return true;
            }
            return false;
        }

        private boolean isEngine(char c) {
            char[] cs = {'a', 'A', 'b', 'B', 'c', 'C'};
            for (char i: cs) {
                if (i == c)
                    return true;
            }
            return false;
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
