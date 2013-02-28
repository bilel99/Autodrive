import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Modifier_heure extends JFrame implements ActionListener
{

	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	protected JButton fermer = new JButton("Fermer");
	protected JButton modifier = new JButton("Modifier");
	protected JButton effacer = new JButton("Effacer");
	
	JTextField titre,date,type,detail; // Ajouter la durée
	//JComboBox calendar_id,utc_id,title;
	
	public Modifier_heure()
	{
		super();
		setSize(600, 600);
		setTitle("Liste des événements");
		this.setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	
		Container c=this.getContentPane();
		c.setLayout(new GridLayout(3,4));
		JLabel tittre=new JLabel("",SwingConstants.CENTER);
		JPanel panelcentre=new JPanel(new GridLayout(8,2));

		JPanel panelbas=new JPanel(new FlowLayout());
		tittre.setForeground(Color.red);
		tittre.setFont(new Font("TimesRoman",Font.ITALIC,18));
		tittre.setText(" ----- FICHE CLIENT -----");
		c.add(tittre);
		
		titre=new JTextField();
		date=new JTextField();
		type=new JTextField();
		detail=new JTextField();
		
	/*	calendar_id=new JComboBox();
		utc_id=new JComboBox();
		title=new JComboBox(); */
		
		panelcentre.add(new JLabel("Titre  :",SwingConstants.RIGHT));
		panelcentre.add(titre);
		panelcentre.add(new JLabel("Date :",SwingConstants.RIGHT));
		panelcentre.add(date);
		panelcentre.add(new JLabel("Type :",SwingConstants.RIGHT));
		panelcentre.add(type);
		panelcentre.add(new JLabel("Detail :",SwingConstants.RIGHT));
		panelcentre.add(detail);
		
	/*	panelcentre.add(new JLabel("UTC :",SwingConstants.RIGHT));
		panelcentre.add(utc_id);
		panelcentre.add(new JLabel("TITRE :",SwingConstants.RIGHT));
		panelcentre.add(title); */
		
		c.add(panelcentre);
		//creer et ajoutter des boutons au panel de bas
		panelbas.add(modifier);
		panelbas.add(effacer);
		panelbas.add(fermer);
		c.add(panelbas);
		//enregistrer le frame comme auditeur de bouton
		modifier.addActionListener(this);
		effacer.addActionListener(this);
		fermer.addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==modifier)
		{
			modifier();
		}
		else if(e.getSource()==effacer)
		{
			effacer();
		}
		else if(e.getSource()==fermer)
		{
			fctQuitter();
		}
	}
	
	public void modifier()
	{
		
	}
	
	public void effacer()
	{
		titre.setText("");
		date.setText("");
		type.setText("");
		detail.setText("");
/*		
		calendar_id.setToolTipText("");
		utc_id.setToolTipText("");
		title.setToolTipText(""); */
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

