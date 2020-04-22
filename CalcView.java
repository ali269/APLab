import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CalcView {
    private JFrame frame;
    private JTextArea area;
    private JTextField field;


    public CalcView() {
        frame = new JFrame();
        frame.setTitle("CALCULATOR");
        frame.setSize(300, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        prepareCalc();

    }

    private void prepareCalc() {
        JPanel mainPanel;
        mainPanel = new JPanel();
        mainPanel.setMinimumSize(new Dimension(500, 500));
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setBackground(Color.magenta);
        mainPanel.setFocusable(true);

        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.WHITE);
        panelUp.setLayout(new GridLayout(2, 1, 0, 0));
        area = new JTextArea(3, 10);
        area.setLineWrap(true);
        area.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);
        area.setAlignmentY(JTextArea.BOTTOM_ALIGNMENT);
        area.setFocusable(false);
        JScrollPane historyPane = new JScrollPane(area);
        historyPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //historyPane.add(area);

        field = new JTextField();
        field.setFocusable(false);
        panelUp.add(historyPane);
        panelUp.add(field);

        mainPanel.add(panelUp);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.setBackground(Color.BLUE);
        JButton exitButton = new JButton();
        exitButton.setText("EXIT");
        exitButton.setFocusable(false);
        exitButton.addMouseListener(new MouseHandler());


        panel2.add(exitButton);
        mainPanel.add(panelUp);


        JPanel numberPane = new JPanel();
        numberPane.setBackground(Color.GREEN);
        numberPane.setLayout(new GridLayout(4, 3,0, 0));
        for (Integer i = 1; i < 10; i++) {
            JButton button = new JButton();
            button.setFocusable(false);
            button.setText(i.toString());
            button.addMouseListener(new MouseHandler1(button.getText()));
            numberPane.add(button);
        }
        JLabel l = new JLabel();
        numberPane.add(l);
        JButton b = new JButton("0");
        b.setFocusable(false);
        b.addMouseListener(new MouseHandler1("0"));
        numberPane.add(b);


        mainPanel.add(numberPane);


        OperandButtons o = new OperandButtons(area, field);
        mainPanel.add(o);










        frame.add(mainPanel);
    }

    public void show() {
        //frame.pack();
        frame.setVisible(true);
    }


    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (e.getButton() == MouseEvent.BUTTON1) {
                System.exit(0);
            }
        }
    }

    private class MouseHandler1 extends MouseAdapter{
        String s;
        public MouseHandler1(String u) {
            s = u;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            field.setText(field.getText() + s);
        }
    }



}
