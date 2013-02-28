import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Field;



public class Partage extends JFrame implements ActionListener
{
	protected JPanel panel = new JPanel();
	protected JButton quitter = new JButton("Quitter");
	protected JButton valider = new JButton("Valider");
	protected JButton inscription = new JButton("Pas de compte");
	protected JButton effacer = new JButton("Effacer");
	
	protected JTextField email;
	protected JPasswordField password;
	
	public Partage()
	{
		super();
		setSize(400, 300);
		setTitle("Connexion");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Container c=this.getContentPane();
		c.setLayout(new GridLayout(2,4));
		JLabel tittre=new JLabel("",SwingConstants.CENTER);
		JPanel panelcentre=new JPanel(new GridLayout(8,2));

		JPanel panelbas=new JPanel(new FlowLayout());
		tittre.setForeground(Color.red);
		tittre.setFont(new Font("TimesRoman",Font.ITALIC,18));
		tittre.setText(" ----- Connexion -----");
		c.add(tittre);
		
		email = new JTextField("Login");
		password = new JPasswordField("Password");
		
		panelcentre.add(new JLabel("Login  :",SwingConstants.CENTER));
		panelcentre.add(email);
		panelcentre.add(new JLabel("Password :",SwingConstants.CENTER));
		panelcentre.add(password);
		
		c.add(panelcentre);
		//creer et ajouter des boutons au panel de bas
		panelbas.add(valider);
		panelbas.add(inscription);
		panelbas.add(quitter);
		panelbas.add(effacer);
		c.add(panelbas);
		
		
		
		email.addActionListener(this);
		password.addActionListener(this);
		valider.addActionListener(this);
		inscription.addActionListener(this);
		quitter.addActionListener(this);
		effacer.addActionListener(this);
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==quitter)
		{
			fctQuitter();
		}
		else if(e.getSource()==inscription)
		{
			inscription();
		}
		else if(e.getSource()==valider)
		{
			valider();
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
	
	public void inscription()
	{
		Inscription inscription = new Inscription();
		inscription.show();
		inscription.setVisible(true);
	}
	
	public void valider()
	{
		String email;
		String password;
		
		Connexion maBDD = new Connexion ("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		
			try{
				Statement st = maBDD.createStatement();
				ResultSet res = st.executeQuery("SELECT email, password FROM utilisateurs where email='"+email+"' && password='"+password+"'");
				
					while (res.next()) {
						email = res.getString("login_login");
						password = res.getString("login_password");
						}
		
					if(email.equals(email) && password.equals(password)) {
						JOptionPane.showMessageDialog(null,"Welcome "+email+", You have successfully Login");
		
						Contenu contenu = new Contenu();
						contenu.show();
						contenu.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
						}
				}
			catch(SQLException exp)
			{
				JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
			}
		}
		});
		
		// AIDE : http://www.roseindia.net/answers/viewqa/Java-Beginners/7374-Login-authentication-&-mysql.html
	}









	public void effacer()
	{
		email.setText("");
		password.setText("");
	}

}
