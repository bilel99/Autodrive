import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class Personaliser extends JFrame implements ActionListener{
protected JPanel panel = new JPanel();
protected JButton fermer = new JButton("Fermer");


	public Personaliser()
	{
		super();
		setSize(600, 600);
		setTitle("Personaliser");
		this.setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		setLayout(new FlowLayout());
		add(fermer);
		this.fermer.addActionListener(this);
		
		
	
		
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==fermer)
		{
			fctQuitter();
		}
	}
	
	public void fctQuitter()
	{
		int retour;
		retour = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter le programme ?", "Arrêt du programme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(retour == JOptionPane.YES_NO_OPTION)
		{
			this.dispose();
		}
	}
}