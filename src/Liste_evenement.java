import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Liste_evenement extends JFrame implements ActionListener {

	protected JPanel panel = new JPanel();
	protected JButton fermer = new JButton("fermer");
	protected JButton supprimer = new JButton("supprimer");
	protected JButton modifier = new JButton("modifier");
	
	JTextField event_title, cf_event_start, cf_event_end, event_detail;
	
	public Liste_evenement()
	{
		super();
		setSize(600, 600);
		setTitle("Liste des événements");
		this.setResizable(true);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		this.fermer.addActionListener(this);
		setLayout(new FlowLayout());
		add(fermer);
		
		JLabel title =
				new JLabel("Liste des événements et des taches");
		title.setFont(new Font("MS", 35, 35));
		getContentPane().add(title);	
		
		panel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(800, 2));
		getContentPane().add(panel);
		
		
		
		Connexion maBDD = new Connexion ("localhost", "root", "", "planitup");
		maBDD.seConnecter();
		String sql ="select * from event where event_id = event_id";
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{
				getContentPane().add(
						new JLabel("Event ID: "+unResultat.getString ("event_id")));
				
				getContentPane().add(
						new JLabel("Calendar ID : "+unResultat.getString ("calendar_name")));
				
				getContentPane().add(
						new JLabel("Type du calendrier : "+unResultat.getString ("event_type_label")));
				
				getContentPane().add(
						new JLabel("Title:" +unResultat.getString("event_title")));
				
				getContentPane().add(
						new JLabel("Date start:" +unResultat.getString("cf_event_start")));
				
				getContentPane().add(
						new JLabel("Date end:" +unResultat.getString("cf_event_end")));
				
				getContentPane().add(
						new JLabel("detail:" +unResultat.getString("event_detail")));
				
				getContentPane().add(
						new JLabel("All day:" +unResultat.getString("all_day")));
				
				JLabel h =
						new JLabel("------------------------------------------------------------");
				h.setFont(new Font("MS", 40, 40));
				getContentPane().add(h);
				
				this.modifier.addActionListener(this);
				setLayout(new FlowLayout());
				add(modifier);
				
				this.supprimer.addActionListener(this);
				setLayout(new FlowLayout());
				add(supprimer);
			
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
		// TODO Auto-generated method stub
		if(e.getSource()==fermer)
		{
			fctQuitter();
		}
		else if(e.getSource()==modifier)
		{
			modifier();
		}
		else if(e.getSource()==supprimer)
		{
			supprimer();
		}
		
	}

	public void fctQuitter()
	{
	 JOptionPane.showMessageDialog(null, "Fermeture de la fenetre", "Information", JOptionPane.INFORMATION_MESSAGE);
	 this.dispose();
		
	}
	
	public void modifier()
	{
		String modifier1;
		
		//JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane(), jop3 = new JOptionPane(), jop4 = new JOptionPane();
		modifier1 = JOptionPane.showInputDialog(null, "Veuiller modifier le titre de l'événement", "Modification du titre de l'événement", JOptionPane.QUESTION_MESSAGE);
		modifier1 = JOptionPane.showInputDialog(null, "Veuiller modifier la date d'entrée", "Modification de la date d'entrée", JOptionPane.QUESTION_MESSAGE);
		modifier1 = JOptionPane.showInputDialog(null, "Veuiller modifier la date de sortie", "Modification de la date de sortie", JOptionPane.QUESTION_MESSAGE);
		modifier1 = JOptionPane.showInputDialog(null, "Veuiller modifier le commentaire", "Modification du commentaire", JOptionPane.QUESTION_MESSAGE);
		
		if(modifier1 == JOptionPane.OPTIONS_PROPERTY)
		{
			String sql, event_title,cf_event_start,cf_event_end,event_detail;
			
			Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
			maBDD.seConnecter();
			try { 
			event_title = this.event_title.getText();
			cf_event_start=this.cf_event_start.getText();
			cf_event_end=this.cf_event_end.getText();
			event_detail=this.event_detail.getText();

			//insertion
			Statement unStatement = maBDD.getConnection().createStatement();
			sql = "UPDATE event SET event_title = event_title, cf_event_start = cf_event_start, cf_event_end = cf_event_end, event_detail = event_detail where event_id = event_id";
			unStatement.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(this,"Votre événement à bien été modifier");
			unStatement.close();
			}catch(SQLException exp)
				{
					JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
				}
				maBDD.seDeconnecter();
		}
		else
		{
			JLabel information1 =
					new JLabel("Echec de la modification de votre événement");
			information1.setFont(new Font("MS", 2, 20));
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
			sql = "DELETE FROM event WHERE event_id = event_id";
			unStatement.executeUpdate(sql);
			JOptionPane.showMessageDialog(this,"Votre événement à bien été supprimer ");
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
	
	public void trier_evenement()
	{
		
	}
	
}
