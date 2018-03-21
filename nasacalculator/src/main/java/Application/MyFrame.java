package Application;

import org.mariuszgromada.math.mxparser.Expression;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {
    final application app=new application();
    final JMenuBar menuBar = new JMenuBar(); // mmenu z opcjami exit i reset

    JMenu optionsMenu= new JMenu("Options");
    JMenuItem resetMenuItem = new JMenuItem("Reset");
    JMenuItem exitMenuItem = new JMenuItem("Exit");

    public MyFrame() {

        super("Science Calculator");
        setJMenuBar(menuBar);
        generate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);      // ustawia widocznosc
        setSize(700, 450);

        exitMenuItem.addActionListener(new ActionListener() { //zamkniecie programu
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        resetMenuItem.addActionListener(new ActionListener() {  // czyszczenie pol
            public void actionPerformed(ActionEvent e) {
                app.getFormulaInput().setText("");
                app.getHistoryTextArea().setText("");

            }
        });



    }



    public void generate() {

        setContentPane(app.getMainPanel()); // ustawia panel
        optionsMenu.add(resetMenuItem);
        optionsMenu.add(exitMenuItem);
        menuBar.add(optionsMenu);

    }
}

