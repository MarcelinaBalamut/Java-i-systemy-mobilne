package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.MessageFormat;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.mXparser;




public class application {
    private JPanel mainPanel;

     private JScrollPane scrollContainerPane;
    private JButton evalButton;
    public String last;
    private JTextField formulaInput;
    private JTextArea historyTextArea;
    JList <Application.Function> functionList;
    DefaultListModel <Application.Function>listModel= new DefaultListModel<>();


    public application(){

        historyTextArea.setEditable(false);  // read-only
        functionList.setModel(listModel);  // ustawia model listy na liscie
        functions();



        functionList.addMouseListener(new MouseAdapter() {  // zdarzenie myszy

            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                if(e.getClickCount()==2){  // double click

                     int index=functionList.getSelectedIndex();  // pobiera miejsce gdzie jest funkcja
                     String function=listModel.getElementAt(index).getFunction(); // pobranie funkcji(np sin())

                    formulaInput.setText(formulaInput.getText() + function);

                    formulaInput.requestFocus(); //kursor
                    if(formulaInput.getText().contains("(")){ // jesli formula ma jakis nawias

                        formulaInput.setCaretPosition(formulaInput.getText().lastIndexOf("(")+1);  // to ustawia kursor miedzy nimi
                    }
                    else
                    formulaInput.setCaretPosition(formulaInput.getText().length()); // jesli nie to na koncu

                    }

            }

        });

        formulaInput.addKeyListener(new KeyAdapter() {  // zdarzenie klawiatury


            public void keyPressed(KeyEvent e) {super.keyPressed(e);

                String lastCalculate=null;

                    if(e.getKeyCode() == KeyEvent.VK_ENTER){  // jesli klikniemy enter
                        try {

                            formula(formulaInput.getText()); // metoda liczaca wyrazenie w formulaInput


                        }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Wrong data format"," Error", JOptionPane.ERROR_MESSAGE);
                        }
                        formulaInput.setText(""); // czyszczenie


                }

                if(e.getKeyCode() == KeyEvent.VK_UP){  // jesli strzala w gore to pokazuje ostatnie wyrazenie

                    formulaInput.setText(last.toString());
                }
            }
        });


        evalButton.addMouseListener(new MouseAdapter() { // przycisk , to samo co enter
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    formula(formulaInput.getText());

                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Wrong data format"," Error", JOptionPane.ERROR_MESSAGE);
                }
                formulaInput.setText("");

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList getFunctionList() {
        return functionList;
    }

    public JScrollPane getScrollContainerPane() {
        return scrollContainerPane;
    }

    public JButton getEvalButton() {
        return evalButton;
    }

    public JTextField getFormulaInput() {
        return formulaInput;
    }

    public JTextArea getHistoryTextArea() {
        return historyTextArea;
    }

public void formula( String form) throws Exception{

        Expression expression=new Expression(form);
    if (expression.checkSyntax()){ // jelsi poprawne wyrazenie to liczy i dodaje do historii

        Double result=expression.calculate();
        listModel.lastElement().setFunction(result.toString()); // wartosc osttaniej funkcji zwracajacej wynik osttaniego wyrazenia
        last=form; //zapamietanie ostatniego wyrazenia
        addHistory(form, result); // dodaje do historii
    }
    else{

        String errorMessage = expression.getErrorMessage();
//        JOptionPane.showMessageDialog(null, "Wrong data format"," Error", JOptionPane.ERROR_MESSAGE);
        throw new Exception(errorMessage);

    }

}

public void addHistory(String form, Double result){

    Object[] testArgs = {form, result, };
    MessageFormat formats = new MessageFormat(
            "{0}\n \t = {1} \n ------- \n");

    historyTextArea.setText( historyTextArea.getText()+ "\n "+formats.format(testArgs));
    formulaInput.setText("");



}


    public void functions(){
        Application.Function tan=new Application.Function("tangens","tan()");
        listModel.addElement(tan);
        Application.Function sin=new Application.Function("sinus","sin()");
        listModel.addElement(sin);
        Application.Function cos=new Application.Function("cosinus","cos()");
        listModel.addElement(cos);
        Application.Function mod=new Application.Function("modulo","mod(,)");
        listModel.addElement(mod);
        Application.Function euler=new Application.Function("euler","Euler(,)");
        listModel.addElement(euler);
        Application.Function log=new Application.Function("logarytm","log(,)");
        listModel.addElement(log);
        Application.Function e=new Application.Function("euler's number","e");
        listModel.addElement(e);
        Application.Function pi=new Application.Function("ludolph's  number","pi");
        listModel.addElement(pi);
        Application.Function cah=new Application.Function("cahen's constant ","[Cah]");
        listModel.addElement(cah);
        Application.Function lastR=new Application.Function("last result ","");
        listModel.addElement(lastR);


    }


}


