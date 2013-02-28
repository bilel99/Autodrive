import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Inscription extends JFrame implements ActionListener {

	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	
	protected JButton fermer = new JButton("Fermer");
	protected JButton enregistrer = new JButton("Enregistrer");
	protected JButton effacer = new JButton("Effacer");
	
	protected JTextField nom, prenom, date_naissance, email, adresse, ville, code_postal, telephone, mobile; 
	protected JPasswordField password1, password2;
	
	public Inscription()
	{
		super();
		setSize(400, 300);
		setTitle("Inscription");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		Container c=this.getContentPane();
		c.setLayout(new GridLayout(4,2));
		JLabel tittre=new JLabel("",SwingConstants.CENTER);
		JPanel panelcentre=new JPanel(new GridLayout(4,2));

		JPanel panelbas=new JPanel(new FlowLayout());
		tittre.setForeground(Color.red);
		tittre.setFont(new Font("TimesRoman",Font.ITALIC,18));
		tittre.setText(" ----- Inscription -----");
		c.add(tittre);
		
		nom=new JTextField("New Login");
		prenom=new JTextField("New Password");
		date_naissance=new JTextField("New Password");
		email=new JTextField("New Name");
		adresse=new JTextField("New Firstname");
		ville=new JTextField("New Comments");
		code_postal=new JTextField("New code postal");
		telephone=new JTextField("New telephone");
		mobile=new JTextField("New mobile");
		
		password1=new JPasswordField("New password");
		password2=new JPasswordField("New password");
		
		panelcentre.add(new JLabel("Nom  :",SwingConstants.CENTER));
		panelcentre.add(nom);
		panelcentre.add(new JLabel("Prenom :",SwingConstants.CENTER));
		panelcentre.add(prenom);
		panelcentre.add(new JLabel("Date de naissance  :",SwingConstants.CENTER));
		panelcentre.add(date_naissance);
		panelcentre.add(new JLabel("Email :",SwingConstants.CENTER));
		panelcentre.add(email);
		
		panelcentre.add(new JLabel("Password :",SwingConstants.CENTER));
		panelcentre.add(password1);
		panelcentre.add(new JLabel("Password :",SwingConstants.CENTER));
		panelcentre.add(password2);
		
		panelcentre.add(new JLabel("Adresse  :",SwingConstants.CENTER));
		panelcentre.add(adresse);
		panelcentre.add(new JLabel("Ville :",SwingConstants.CENTER));
		panelcentre.add(ville);
		panelcentre.add(new JLabel("code postal :",SwingConstants.CENTER));
		panelcentre.add(code_postal);
		panelcentre.add(new JLabel("telephone :",SwingConstants.CENTER));
		panelcentre.add(telephone);
		panelcentre.add(new JLabel("mobile :",SwingConstants.CENTER));
		panelcentre.add(mobile);
	    
		c.add(panelcentre);
		panelbas.add(enregistrer);
		panelbas.add(effacer);
		panelbas.add(fermer);
		c.add(panelbas);
		
		fermer.addActionListener(this);
		enregistrer.addActionListener(this);
		effacer.addActionListener(this);
		nom.addActionListener(this);
		prenom.addActionListener(this);
		date_naissance.addActionListener(this);
		email.addActionListener(this);
		password1.addActionListener(this);
		password2.addActionListener(this);
		adresse.addActionListener(this);
		ville.addActionListener(this);
		code_postal.addActionListener(this);
		telephone.addActionListener(this);
		mobile.addActionListener(this);
		
	}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fermer)
		{
			fctQuitter();
		}
		else if(e.getSource()==enregistrer)
		{
			enregistrer();
		}
		else if(e.getSource()==effacer)
		{
			effacer();
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
	
	public void enregistrer()
	{
String sql, nom,prenom,date_naissance,email,password1,password2,adresse,ville,code_postal,telephone,mobile;
		
		Connexion maBDD = new Connexion("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		try { 
		nom=this.nom.getText();
		prenom=this.prenom.getText();
		date_naissance=this.date_naissance.getText();
		email=this.email.getText();
		password1=this.password1.getText();
		password2=this.password2.getText();
		adresse=this.adresse.getText();
		ville=this.ville.getText();
		code_postal=this.code_postal.getText();
		telephone=this.telephone.getText();
		mobile=this.mobile.getText();
		
		
		//moyPaiement=txtmoy.getSelectedText();
		System.out.println(nom+" "+prenom+" "+date_naissance+""+email+" "+password1+" "+password2+" "+adresse+" "+ville+""+code_postal+" "+telephone+" "+mobile);
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "INSERT INTO utilisateurs (nom,prenom,date_naissance,email,password,adresse,ville,code_postal,telephone,mobile) VALUES ('"+this.nom.getText()+"','"+this.prenom.getText()+"','"+this.date_naissance.getText()+"','"+this.email.getText()+"','"+this.password1.getText()+"','"+this.adresse.getText()+"','"+this.ville.getText()+"','"+this.code_postal.getText()+"','"+this.telephone.getText()+"','"+this.mobile.getText()+"')";
		 unStatement.executeUpdate(sql);
		//System.out.println(sql+" ligne insérée");
		 JOptionPane.showMessageDialog(this,"Votre compte à bien été ajouter");
		 unStatement.close();
		 unStatement.close();
	
		 }catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
			maBDD.seDeconnecter();
	}
	
	public void effacer()
	{
		nom.setText("New Login");
		prenom.setText("New Password");
		date_naissance.setText("New Password");
		email.setText("New Name");
		password1.setText("New Firstname");
		password2.setText("New Comments");
		adresse.setText("New Comments");
		ville.setText("New Comments");
		code_postal.setText("New Comments");
		telephone.setText("New Comments");
		mobile.setText("New Comments");
		
	}
}
