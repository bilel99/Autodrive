import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

public class Gestion_utilisateur extends JFrame implements ActionListener 
{
	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	protected JButton fermer = new JButton("Fermer");
	protected JButton supprimer = new JButton("Supprimer");
	
	public Gestion_utilisateur()
	{
		super();
		setSize(600, 600);
		setTitle("Gestion utilisateur");
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		Container c=this.getContentPane();
		c.setLayout(new GridLayout(2,4));
		JLabel tittre=new JLabel("",SwingConstants.CENTER);
		JPanel panelcentre=new JPanel(new GridLayout(8,2));

		JPanel panelbas=new JPanel(new FlowLayout());
		tittre.setForeground(Color.red);
		tittre.setFont(new Font("TimesRoman",Font.ITALIC,18));
		tittre.setText(" ----- Gestion utilisateur -----");
		c.add(tittre);
		
		
		
		Connexion maBDD = new Connexion ("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		String sql ="select * from utilisateurs where id_utilisateur = id_utilisateur";
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{
				getContentPane().add(
						new JLabel("ID:" +unResultat.getString("id_utilisateur")));
				
				getContentPane().add(
						new JLabel("Nom: "+unResultat.getString ("nom")));
				
				getContentPane().add(
						new JLabel("Prenom:" +unResultat.getString("prenom")));
				
				getContentPane().add(
						new JLabel("Date de naissance:" +unResultat.getString("date_naissance")));
				
				getContentPane().add(
						new JLabel("Email:" +unResultat.getString("email")));
				
				getContentPane().add(
						new JLabel("Password:" +unResultat.getString("password")));
				
				getContentPane().add(
						new JLabel("Adresse:" +unResultat.getString("adresse")));
				
				getContentPane().add(
						new JLabel("Ville:" +unResultat.getString("ville")));
				
				getContentPane().add(
						new JLabel("code_postal:" +unResultat.getString("code_postal")));
				
				getContentPane().add(
						new JLabel("Telephone:" +unResultat.getString("telephone")));
				
				getContentPane().add(
						new JLabel("Mobile:" +unResultat.getString("mobile")));
				
				JLabel h =
						new JLabel("------------------------------------------------------------");
				h.setFont(new Font("MS", 40, 40));
				getContentPane().add(h);
				
				this.supprimer.addActionListener(this);
				setLayout(new FlowLayout());
				add(supprimer);
			
			}
			
			this.fermer.addActionListener(this);
			setLayout(new FlowLayout());
			add(fermer);
			
			unResultat.close();
			unStatement.close();
		}
		catch(SQLException exp)
		{
			JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
		}
		maBDD.seDeconnecter();
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==fermer)
		{
			fctQuitter();
		}
		else if(e.getSource()==supprimer)
		{
			supprimer();
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
	
	public void supprimer()
	{
		int suppression;
		suppression = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette événement ?", "Message d'information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(suppression == JOptionPane.YES_NO_OPTION)
		{
			String sql;
			
			Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
			maBDD.seConnecter();
			try { 
			Statement unStatement = maBDD.getConnection().createStatement();
			sql = "DELETE FROM login WHERE login_id = login_id";
			unStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(this,"Le compte à bien été supprimer ");
			unStatement.close();
			}catch(SQLException exp)
				{
					JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
				}
				maBDD.seDeconnecter();
		}
		else
		{
			JLabel information =
					new JLabel("Echec de la suppression de votre événement");
			information.setFont(new Font("MS", 2, 20));
		}
	}
}
