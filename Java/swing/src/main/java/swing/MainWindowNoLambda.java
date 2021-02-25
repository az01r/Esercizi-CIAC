/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author tss
 */
public class MainWindowNoLambda extends JFrame {

    private final JButton btn;
    private final JPanel pMain;
    
    public MainWindowNoLambda(String title) throws HeadlessException {
        super(title);
        this.btn = new JButton("click");
        this.btn.addActionListener(new Ascolta(this));
        
        Container cp = this.getContentPane();
        this.pMain = new JPanel();
        pMain.add(this.btn);
        
        //cp.add(this.btn, BorderLayout.NORTH); // se non metto il border layout lo posiziona al centro 
        cp.add(pMain); // avendo creato un JPanel  posso passarlo al Container cp
        this.setSize(500,300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // quando chiudo la finestra principale chiude anche l'applicazione
        this.setVisible(true);
    }

    
}


class Ascolta implements ActionListener {
    private Component parentComponent;
    public Ascolta(Component parentComponent) {
        this.parentComponent=parentComponent;
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(parentComponent, "click listener ok");
    }
    
}