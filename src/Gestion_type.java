import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gestion_type extends JFrame implements ActionListener 
{
	protected JTabbedPane onglet = new JTabbedPane(SwingConstants.TOP);
	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	
	protected JButton fermerC = new JButton("Fermer");
	protected JButton enregistrerC = new JButton("Enregistrer");
	protected JButton effacerC = new JButton("Effacer");
	
	protected JButton fermerT = new JButton("Fermer");
	protected JButton enregistrerT = new JButton("Enregistrer");
	protected JButton effacerT = new JButton("Effacer");
	
	protected JButton liste_calendar = new JButton("Liste [Type calendrier]");
	protected JButton liste_type = new JButton("Liste [Type]");
	
	protected JTextField calendar_name, calendar_login;
	protected JComboBox calendar_color;
	String[] listStrings = { "1. rouge", "2. bleu", "3. vert", "4. jaune", "5. orange", "6. marron", "7. noir" };
	
	protected JTextField event_label;
	
	public Gestion_type()
	{
		super();
		setSize(600, 600);
		setTitle("Gestion des type de calendrier et de titre");
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		calendar_name=new JTextField("Name");
		
		calendar_color=new JComboBox(listStrings);
		calendar_color.setPreferredSize(new Dimension(320, 200));
		calendar_login=new JTextField("Login ID");
		
		event_label=new JTextField("Event label");
		
		
		JLabel calendar = new JLabel("Pour editer un type de calendrier, remplir les champs suivants: ");
		JPanel panneau1 = new JPanel();
		panneau1.setLayout(null);
		panneau1.setPreferredSize(new Dimension( 500, 500));
		calendar.setBounds(100,20,900,50);
		calendar_login.setBounds(50, 100, 200, 30);
		calendar_color.setBounds(300, 100, 200, 30);
		calendar_name.setBounds(180, 150, 200, 30);
		effacerC.setBounds(1, 420, 580, 40);
		liste_calendar.setBounds(1, 340, 580, 40);
		fermerC.setBounds(1, 380, 580, 40);
		enregistrerC.setBounds(1, 460, 580, 40);
		panneau1.add(calendar);
		panneau1.add(calendar_login);
		panneau1.add(calendar_color);
		panneau1.add(calendar_name);
		panneau1.add(effacerC);
		panneau1.add(fermerC);
		panneau1.add(enregistrerC);
		panneau1.add(liste_calendar);
		onglet.addTab("edit Calendar",new JScrollPane(panneau1));
		
		
		
		JLabel type = new JLabel("Pour editer un type, remplir les champs suivants: ");
		JPanel panneau2 = new JPanel();
		panneau2.setLayout(null);
		panneau2.setPreferredSize(new Dimension( 500, 500));
		type.setBounds(100,20,900,50);
		event_label.setBounds(180, 100, 200, 30);
		effacerT.setBounds(1, 420, 580, 40);
		liste_type.setBounds(1, 340, 580, 40);
		fermerT.setBounds(1, 380, 580, 40);
		enregistrerT.setBounds(1, 460, 580, 40);
		panneau2.add(type);
		panneau2.add(event_label);
		panneau2.add(effacerT);
		panneau2.add(fermerT);
		panneau2.add(enregistrerT);
		panneau2.add(liste_type);
		onglet.addTab("Type",new JScrollPane(panneau2));
		
		calendar_login.addActionListener(this);
		calendar_color.addActionListener(this);
		calendar_name.addActionListener(this);
		event_label.addActionListener(this);
		fermerC.addActionListener(this);
		fermerT.addActionListener(this);
		effacerC.addActionListener(this);
		effacerT.addActionListener(this);
		enregistrerC.addActionListener(this);
		enregistrerT.addActionListener(this);
		liste_calendar.addActionListener(this);
		liste_type.addActionListener(this);
		
		calendar_color.setSelectedIndex(6);
		calendar_color.addActionListener(this);
		
		this.getContentPane().add(onglet, BorderLayout.NORTH);
		this.setVisible(true);
		
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==fermerC)
		{
			fctQuitter();
		}
		else if(e.getSource()==fermerT)
		{
			fctQuitter();
		}
		else if(e.getSource()==enregistrerC)
		{
			enregistrerC();
		}
		else if(e.getSource()==enregistrerT)
		{
			enregistrerT();
		}
		else if(e.getSource()==effacerC)
		{
			effacerC();
		}
		else if(e.getSource()==effacerT)
		{
			effacerT();
		}
		else if(e.getSource()==liste_calendar)
		{
			liste_calendar();
		}
		else if(e.getSource()==liste_type)
		{
			liste_type();
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
	
	public void enregistrerC()
	{
		
		String sql, calendar_login, calendar_name;

		Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
		maBDD.seConnecter();
		try { 
		calendar_login=this.calendar_login.getText();
		String result = (String) calendar_color.getSelectedItem();
		System.out.println("Choix : "+result);
		calendar_name=this.calendar_name.getText();

		System.out.println(calendar_login+" "+calendar_color+" "+calendar_name+"");
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "INSERT INTO calendar (calendar_name,calendar_color,calendar_login_id) VALUES ('"+this.calendar_name.getText()+"','"+this.calendar_color.getSelectedItem()+"','"+this.calendar_login.getText()+"')";
		 
		 unStatement.executeUpdate(sql);
		//System.out.println(sql+" ligne insérée");
		 JOptionPane.showMessageDialog(this,"Votre type de calendrier à bien été ajouté");
		 
		 unStatement.close();
		 unStatement.close();
		
		 }catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
			maBDD.seDeconnecter();
	}
	
	public void enregistrerT()
	{
		String sql, event_label;
		
		Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
		maBDD.seConnecter();
		try { 
		event_label=this.event_label.getText();
		
		//moyPaiement=txtmoy.getSelectedText();
		System.out.println(event_label+"");
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "INSERT INTO event_type (event_type_label) VALUES ('"+this.event_label.getText()+"')";
		 unStatement.executeUpdate(sql);
		//System.out.println(sql+" ligne insérée");
		 JOptionPane.showMessageDialog(this,"Votre type à été ajouté");
		 unStatement.close();
		 unStatement.close();
		 
		 }catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
			maBDD.seDeconnecter();
	}
	
	public void effacerC()
	{
		calendar_login.setText("Login ID");
		calendar_name.setText("Name");
	}
	
	public void effacerT()
	{
		event_label.setText("Event label");
	}
	
	public void liste_calendar()
	{	
		Liste_calendar liste_calendar = new Liste_calendar();
		liste_calendar.show();
		liste_calendar.setVisible(true);
	}
		
	
	public void liste_type()
	{
		Liste_type liste_type = new Liste_type();
		liste_type.show();
		liste_type.setVisible(true);
	}
	
	
}
