import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Preference extends JFrame implements ActionListener 
{
	protected JTabbedPane onglet = new JTabbedPane(SwingConstants.TOP);
	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	
	protected JButton fermer_edit = new JButton("Fermer");
	protected JButton enregistrer_edit = new JButton("Enregistrer");
	protected JButton effacer_edit = new JButton("Effacer");
	
	protected JButton fermer_inscription = new JButton("Fermer");
	protected JButton enregistrer_inscription = new JButton("Enregistrer");
	protected JButton effacer_inscription = new JButton("Effacer");
	
	protected JTextField nom, prenom, date_naissance, email, adresse, ville, code_postal, telephone, mobile;
	protected JPasswordField password1, password2;
	
	protected JTextField nomI, prenomI, date_naissanceI, emailI, adresseI, villeI, code_postalI, telephoneI, mobileI;
	protected JPasswordField passwordI1, passwordI2;
	
	public Preference()
	{
		super();
		setSize(600, 600);
		setTitle("Preference");
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
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
		
		nomI=new JTextField("New Login");
		prenomI=new JTextField("New Password");
		date_naissanceI=new JTextField("New Password");
		emailI=new JTextField("New Name");
		adresseI=new JTextField("New Firstname");
		villeI=new JTextField("New Comments");
		code_postalI=new JTextField("New code postal");
		telephoneI=new JTextField("New telephone");
		mobileI=new JTextField("New mobile");
		passwordI1=new JPasswordField("New password");
		passwordI2=new JPasswordField("New password");
		
		JLabel edit = new JLabel("Pour modifier votre compte, remplir les champs suivants : ");
		JPanel panneau1 = new JPanel();
		panneau1.setLayout(null);
		panneau1.setPreferredSize(new Dimension( 500, 500));
		edit.setBounds(100,20,900,50);
		nom.setBounds(50, 100, 200, 30);
		prenom.setBounds(300, 100, 200, 30);
		date_naissance.setBounds(300, 150, 200, 30);
		email.setBounds(50, 200, 200, 30);
		password1.setBounds(300, 200, 200, 30);
		password2.setBounds(300, 200, 200, 30);
		adresse.setBounds(300, 200, 200, 30);
		ville.setBounds(50, 300, 450, 40);
		code_postal.setBounds(50, 300, 450, 40);
		telephone.setBounds(50, 300, 450, 40);
		mobile.setBounds(50, 300, 450, 40);
		
		effacer_edit.setBounds(1, 420, 580, 40);
		fermer_edit.setBounds(1, 380, 580, 40);
		enregistrer_edit.setBounds(1, 460, 580, 40);
		panneau1.add(edit);
		panneau1.add(nom);
		panneau1.add(prenom);
		panneau1.add(date_naissance);
		panneau1.add(email);
		panneau1.add(password1);
		panneau1.add(password2);
		panneau1.add(adresse);
		panneau1.add(ville);
		panneau1.add(code_postal);
		panneau1.add(telephone);
		panneau1.add(mobile);
		panneau1.add(effacer_edit);
		panneau1.add(fermer_edit);
		panneau1.add(enregistrer_edit);
		onglet.addTab("Edit",new JScrollPane(panneau1));
		
		
		
		JLabel inscription = new JLabel("Pour ajouter un compte manuellement, remplir les champs suivants : ");
		JPanel panneau2 = new JPanel();
		panneau2.setLayout(null);
		panneau2.setPreferredSize(new Dimension( 500, 500));
		inscription.setBounds(100,20,900,50);
		nomI.setBounds(50, 100, 200, 30);
		prenomI.setBounds(50, 300, 450, 40);
		date_naissanceI.setBounds(50, 300, 450, 40);
		emailI.setBounds(50, 300, 450, 40);
		passwordI1.setBounds(300, 100, 200, 30);
		passwordI2.setBounds(300, 150, 200, 30);
		adresseI.setBounds(50, 200, 200, 30);
		villeI.setBounds(300, 200, 200, 30);
		code_postalI.setBounds(50, 300, 450, 40);
		telephoneI.setBounds(50, 300, 450, 40);
		mobileI.setBounds(50, 300, 450, 40);
		code_postalI.setBounds(50, 300, 450, 40);
		effacer_inscription.setBounds(1, 420, 580, 40);
		fermer_inscription.setBounds(1, 380, 580, 40);
		enregistrer_inscription.setBounds(1, 460, 580, 40);
		panneau2.add(inscription);
		panneau2.add(nomI);
		panneau2.add(prenomI);
		panneau2.add(date_naissanceI);
		panneau2.add(emailI);
		panneau2.add(passwordI1);
		panneau2.add(passwordI2);
		panneau2.add(adresseI);
		panneau2.add(villeI);
		panneau2.add(code_postalI);
		panneau2.add(telephoneI);
		panneau2.add(mobileI);
		panneau2.add(effacer_inscription);
		panneau2.add(fermer_inscription);
		panneau2.add(enregistrer_inscription);
		onglet.addTab("Inscription",new JScrollPane(panneau2));
		
		fermer_edit.addActionListener(this);
		enregistrer_edit.addActionListener(this);
		effacer_edit.addActionListener(this);
		fermer_inscription.addActionListener(this);
		enregistrer_inscription.addActionListener(this);
		effacer_inscription.addActionListener(this);
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
		
		nomI.addActionListener(this);
		prenomI.addActionListener(this);
		date_naissanceI.addActionListener(this);
		emailI.addActionListener(this);
		passwordI1.addActionListener(this);
		passwordI2.addActionListener(this);
		adresseI.addActionListener(this);
		villeI.addActionListener(this);
		code_postalI.addActionListener(this);
		telephoneI.addActionListener(this);
		mobileI.addActionListener(this);
		
		
		this.getContentPane().add(onglet, BorderLayout.NORTH);
		this.setVisible(true);
		
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==fermer_edit)
		{
			fctQuitter();
		}
		else if(e.getSource()==fermer_inscription)
		{
			fctQuitter();
		}
		else if(e.getSource()==enregistrer_edit)
		{
			enregistrer_edit();
		}
		else if(e.getSource()==enregistrer_inscription)
		{
			enregistrer_login();
		}
		else if(e.getSource()==effacer_edit)
		{
			effacer_edit();
		}
		else if(e.getSource()==effacer_inscription)
		{
			effacer_login();
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
	
	public void enregistrer_edit()
	{
		
		String sql, nom,prenom,date_naissance,email,password1,password2,adresse,ville,code_postal,telephone,mobile,id_couleur,type_utilisateur;
		
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
		
/*		calendar_id=this.calendar_id.getToolTipText();
		utc_id=this.utc_id.getToolTipText();
		title=this.title.getToolTipText(); */

		//moyPaiement=txtmoy.getSelectedText();
			System.out.println(nom+" "+prenom+" "+date_naissance+""+email+" "+password1+" "+adresse+" "+ville+""+code_postal+" "+telephone+" "+mobile);
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "UPDATE utilisateurs SET nom = nom, prenom = prenom, date_naissance = date_naissance, email = email, password1 = password, adresse = adresse, ville = ville, code_postal = code_postal, telephone = telephone, mobile = mobile where id_utilisateur = id_utilisateur";
		 
		 unStatement.executeUpdate(sql);
		//System.out.println(sql+" ligne insérée");
		 JOptionPane.showMessageDialog(this,"Votre compte à bien été modifier");
		 
		 unStatement.close();
		 unStatement.close();
		
		 }catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
			maBDD.seDeconnecter();
	}
	
	public void enregistrer_login()
	{
		String sql, nomI,prenomI,date_naissanceI,emailI,passwordI1,passwordI2,adresseI,villeI,code_postalI,telephoneI,mobileI,id_couleurI,type_utilisateurI;
		
		Connexion maBDD = new Connexion("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		try { 
			nomI=this.nomI.getText();
			prenomI=this.prenomI.getText();
			date_naissanceI=this.date_naissanceI.getText();
			emailI=this.emailI.getText();
			passwordI1=this.passwordI1.getText();
			passwordI2=this.passwordI2.getText();
			adresseI=this.adresseI.getText();
			villeI=this.villeI.getText();
			code_postalI=this.code_postalI.getText();
			telephoneI=this.telephoneI.getText();
			mobileI=this.mobileI.getText();

		//moyPaiement=txtmoy.getSelectedText();
			System.out.println(nomI+" "+prenomI+" "+date_naissanceI+""+emailI+" "+passwordI1+" "+adresseI+" "+villeI+""+code_postalI+" "+telephoneI+" "+mobileI);
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "INSERT INTO utilisateurs (nom,prenom,date_naissance,email,password,adresse,ville,code_postal,telephone,mobile) VALUES ('"+this.nomI.getText()+"','"+this.prenomI.getText()+"','"+this.date_naissanceI.getText()+"','"+this.emailI.getText()+"','"+this.passwordI1.getText()+"','"+this.adresseI.getText()+"','"+this.villeI.getText()+"','"+this.code_postalI.getText()+"','"+this.telephoneI.getText()+"','"+this.mobileI.getText()+")";
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
	
	public void effacer_edit()
	{
		nom.setText("Nom");
		prenom.setText("Prenom");
		date_naissance.setText("Date_naissance");
		email.setText("Email");
		password1.setText("Password");
		password2.setText("Password");
		adresse.setText("Adresse");
		ville.setText("Ville");
		code_postal.setText("Code postal");
		telephone.setText("Telephone");
		mobile.setText("Mobile");
	}
	
	public void effacer_login()
	{
		nomI.setText("New nom");
		prenomI.setText("New prenom");
		date_naissanceI.setText("New date de naissance");
		emailI.setText("New email");
		passwordI1.setText("New password");
		passwordI2.setText("New password");
		adresseI.setText("New adresse");
		villeI.setText("New ville");
		code_postalI.setText("New code postal");
		telephoneI.setText("New telephone");
		mobileI.setText("New mobile");
	}
}
