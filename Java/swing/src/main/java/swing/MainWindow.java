/* 
    ActionListener intercetta solo i click su un button           
    posso usare una lambda perchè la classe ActionListener ha un solo metodo
    in questo modo evito di creare un'istanza della classe 
 */
package swing;

import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author tss
 */
public class MainWindow extends JFrame {

    private final JButton btn;
    private final JPanel pMain;

    public MainWindow(String title) throws HeadlessException {
        super(title);
        this.btn = new JButton("click");
        this.btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "click listener ok");
        });

        Container cp = this.getContentPane(); // creo una finestra
        this.pMain = new JPanel();
        pMain.add(this.btn);

        //cp.add(this.btn, BorderLayout.NORTH); // se non metto il border layout lo posiziona al centro 
        cp.add(pMain); // avendo creato un JPanel  posso passarlo al Container cp
        this.setSize(500, 300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // quando chiudo la finestra principale chiude anche l'applicazione
        this.setVisible(true);
    }

}
