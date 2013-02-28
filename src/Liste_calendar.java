import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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


public class Liste_calendar extends JFrame implements ActionListener {
	
	protected JPanel panel = new JPanel();
	protected JButton fermer = new JButton("fermer");
	protected JButton supprimer = new JButton("supprimer");
	
	public Liste_calendar()
	{
		super();
		setSize(600, 600);
		setTitle("Liste des calendriers");
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		this.fermer.addActionListener(this);
		setLayout(new FlowLayout());
		add(fermer);
		
		JLabel title =
				new JLabel("Liste des nom de calendrier");
		title.setFont(new Font("MS", 35, 35));
		getContentPane().add(title);	
		
		panel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(800, 2));
		getContentPane().add(panel);
		
		
		
		Connexion maBDD = new Connexion ("localhost", "root", "", "planitup");
		maBDD.seConnecter();
		String sql ="select * from calendar where calendar_id = calendar_id";
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{
				getContentPane().add(
						new JLabel("Calendar name: "+unResultat.getString ("calendar_name")));
				
				getContentPane().add(
						new JLabel("Calendar color:" +unResultat.getString("calendar_color")));
				
				getContentPane().add(
						new JLabel("calendar_login:" +unResultat.getString("calendar_login_id")));
				
				JLabel h =
						new JLabel("------------------------------------------------------------");
				h.setFont(new Font("MS", 40, 40));
				getContentPane().add(h);
				
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
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==fermer)
		{
			quitter();
		}
		else if(e.getSource()==supprimer)
		{
			supprimer();
		}
	}
	
	public void quitter()
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
			sql = "DELETE FROM calendar WHERE calendar_id = calendar_id";
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

}
