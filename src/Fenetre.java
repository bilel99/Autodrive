import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
public class Fenetre extends JFrame {
  private JTabbedPane onglet;
  //Compteur pour le nombre d'onglets
  private int nbreTab = 0;
    
  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Conteneurs");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setSize(400, 200);
    this.setVisible(true);
       
    //Cr�ation de plusieurs Panneau
    Panneau[] tPan = {   new Panneau(Color.WHITE), new Panneau(Color.WHITE), new Panneau(Color.WHITE)};
       
    //Cr�ation de notre conteneur d'onglets
    onglet = new JTabbedPane();
    for(Panneau pan : tPan){
      //M�thode d'ajout d'onglets
      onglet.addTab("Onglet N�"+(++nbreTab), pan);
    }
    //On passe ensuite les onglets au content pane
    this.getContentPane().add(onglet, BorderLayout.CENTER);
       
    //Ajout du bouton pour ajouter des onglets
    JButton nouveau = new JButton("Ajouter un onglet");
    nouveau.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        onglet.add("Onglet N�"+(++nbreTab), new Panneau(Color.WHITE));
      }
    });
       
    //Ajout du bouton pour retirer l'onglet s�lectionn�
    JButton delete = new JButton("Effacer l'onglet");
    delete.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        //On r�cup�re l'index de l'onglet s�lectionn�
        int selected = onglet.getSelectedIndex();
        //S'il n'y a plus d'onglet, la m�thode ci-dessus retourne -1
        if(selected > -1)onglet.remove(selected);
      }
    });
       
    JPanel pan = new JPanel();
    pan.add(nouveau);
    pan.add(delete);
       
    this.getContentPane().add(pan, BorderLayout.SOUTH);
    
  }
}