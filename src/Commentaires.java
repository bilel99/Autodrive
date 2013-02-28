import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Commentaires extends JFrame implements ActionListener
{
	protected JTabbedPane onglet = new JTabbedPane(SwingConstants.TOP);
	protected JButton ajouter = new JButton("Ajouter_commentaire");
	protected JButton effacer = new JButton("effacer");
	protected JButton supprimer = new JButton("Supprimer_commentaire");
	protected JButton modifier = new JButton("Modifier_commentaire");
	protected JButton fermer = new JButton("Fermer");
	
	JTextField id_cible, type_commentaire, commentaire;
	
	public Commentaires()
	{
		super();
		setSize(600, 600);
		setTitle("Commentaires");
		this.setResizable(true);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		id_cible=new JTextField();
		type_commentaire=new JTextField();
		commentaire=new JTextField();
		
		
		JLabel lecture_commentaires = new JLabel("Vos commentaires sont : ");
		//getContentPane().add(lecture_commentaires);
		JPanel panneau1 = new JPanel();
		panneau1.setLayout(null);
		panneau1.setPreferredSize(new Dimension(500, 500));
		lecture_commentaires.setBounds(5,10,900,20);
		panneau1.add(lecture_commentaires);
		onglet.addTab("Affichage commentaires", new JScrollPane(panneau1));
		afficher_commentaires();
		
		
		
		
		
		
		JLabel ajout_commentaires = new JLabel("Pour ajouter un commentaires, remplir le formulaire ci-dessous : ");
		//getContentPane().add(ajout_commentaires);
		JPanel panneau2 = new JPanel();
		panneau2.setLayout(null);
		panneau2.setPreferredSize(new Dimension( 500, 500));
		ajout_commentaires.setBounds(100,20,900,50);
		id_cible.setBounds(100, 100, 100, 20);
		type_commentaire.setBounds(200, 100, 100, 20);
		commentaire.setBounds(100, 200, 200, 80);
		ajouter.setBounds(1, 460, 580, 40);
		effacer.setBounds(1, 420, 580, 40);
		fermer.setBounds(1, 380, 580, 40);
		panneau2.add(ajout_commentaires);
		panneau2.add(id_cible);
		panneau2.add(type_commentaire);
		panneau2.add(commentaire);
		panneau2.add(ajouter);
		panneau2.add(effacer);
		panneau2.add(fermer);
		onglet.addTab("Ajout commentaires",new JScrollPane( panneau2));
		ajouter_commentaires();
		
		this.getContentPane().add(onglet, BorderLayout.NORTH);
		this.setVisible(true);
	}
		

	public void afficher_commentaires()
	{
		Connexion maBDD = new Connexion ("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		String sql ="SELECT * FROM utilisateurs, commentaires where id_utilisateur = id_posteur";
				 
	    
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{	
				this.modifier.addActionListener(this);
				setLayout(new FlowLayout());
				add(modifier);
				
				this.supprimer.addActionListener(this);
				setLayout(new FlowLayout());
				add(supprimer);
							
				getContentPane().add(
						new JLabel("type_commentaire: " +unResultat.getString ("type_commentaire")));
				
				getContentPane().add(
						new JLabel("date_publication: " +unResultat.getString ("date_publication")));
				
				getContentPane().add(
						new JLabel("commentaire: " +unResultat.getString ("commentaire")));	
			
				JLabel separateur =
						new JLabel("--------------------------------------------------");
				separateur.setFont(new Font("MS", 2, 20));	
			}
			unResultat.close();
			unStatement.close();
		}
		catch(SQLException exp)
		{
			JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
		}
		
		maBDD.seDeconnecter();
	}
	
	public void ajouter_commentaires()
	{	
		Connexion maBDD = new Connexion ("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		String sql ="SELECT * FROM utilisateurs where id_utilisateur";
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{
				JLabel b = new JLabel("Votre identifiant est : " +unResultat.getString ("email"));
				b.setFont(new Font("MS", 20, 20));
				getContentPane().add(b);

					
			}
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==supprimer)
		{
			supprimer();
		}
		else if(e.getSource()==modifier)
		{
			modifier();
		}
		else if(e.getSource()==effacer)
		{
			effacer();
		}
	}
	
	public void supprimer()
	{
		int suppression;
		suppression = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette événement ?", "Message d'information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(suppression == JOptionPane.YES_NO_OPTION)
		{
			String sql;
			
			Connexion maBDD = new Connexion("localhost", "root", "", "autodrive");
			maBDD.seConnecter();
			try { 
			Statement unStatement = maBDD.getConnection().createStatement();
			sql = "DELETE FROM commentaires WHERE id_commentaire = id_commentaire";
			unStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(this,"Votre commentaire à bien été supprimer ");
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
	
	public void modifier()
	{	
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String commentaires = jop.showInputDialog(null, "Veuiller modifier le commentaire de saisie", "Modification du commentaire", JOptionPane.QUESTION_MESSAGE);
		String typeCommentaire = jop.showInputDialog(null, "Veuiller modifier le type de saisie", "Modification du type", JOptionPane.QUESTION_MESSAGE);
		
		String sql, commentaire, type_commentaire;
		
		Connexion maBDD = new Connexion("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		try { 
		type_commentaire = this.type_commentaire.getText();
		commentaire=this.commentaire.getText();

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		sql = "UPDATE commentaires SET type_commentaire = type_commentaire, commentaire = commentaire where id_commentaire = id_commentaire";
		unStatement.executeUpdate(sql);
		
		JOptionPane.showMessageDialog(this,"Votre événement à bien été modifier");
		unStatement.close();
		}catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
			maBDD.seDeconnecter();
	}
	
	public void effacer()
	{
		id_cible.setText("");
		type_commentaire.setText("");
		commentaire.setText("");
	}
}