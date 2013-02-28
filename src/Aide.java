import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.transform.OutputKeys;

public class Aide extends JFrame implements ActionListener{
protected JPanel panel = new JPanel();
protected JButton fermer = new JButton("Fermer");

	public Aide()
	{
		super();
		setSize(400, 400);
		setTitle("Aide !");
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	
		this.fermer.addActionListener(this);
		setLayout(new FlowLayout());
		add(fermer);
		panel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(800, 2));
		getContentPane().add(panel);
		
		JLabel aide =
				new JLabel("Welcome to AutoDrive");
		aide.setFont(new Font("MS", 40, 40));
		getContentPane().add(aide);
		
		JLabel a =
				new JLabel("1° Pour toute question concernant l'auto-école veuiller vous adresser au responsable");
		a.setFont(new Font("MS", 9, 9));
		getContentPane().add(a);
		
		JLabel explication =
				new JLabel("Comment marche le logiciel");
		explication.setFont(new Font("MS", 33, 33));
		getContentPane().add(explication);
		
		JLabel c =
				new JLabel("1° Au démarrage du logiciel, vous devez entrer votre email et votre mot de passe pour vous connécter");
		c.setFont(new Font("MS", 9, 9));
		getContentPane().add(c);
		
		JLabel d =
				new JLabel("1° Lors de la connexion plusieurs option s'offre à vous, voir vos événements, ou inscrire vos événements");
		d.setFont(new Font("MS", 9, 9));
		getContentPane().add(d);
		
		JLabel e =
				new JLabel("1° Vous pouvez aussi calculer vos heure de conduite grâce à l'appli calculatrice en cliquant sur 'edit' ");
		e.setFont(new Font("MS", 9, 9));
		getContentPane().add(e);
		
		JLabel f =
				new JLabel("1° Vous avez la possibilités de voir le calendrier en cliquant sur le bouton Calendrier");
		f.setFont(new Font("MS", 9, 9));
		getContentPane().add(f);
		
		JLabel g =
				new JLabel("1° Vous pouvez voir la date et l'heure sur la page d'accueil mais aussi le calendrier des heures de code");
		g.setFont(new Font("MS", 9, 9));
		getContentPane().add(g);
		
		JLabel h =
				new JLabel("1° Toute vos donnée peuvent être enregistrer sur votre ordinateur en cliquant sur enregistrer 'file' ");
		h.setFont(new Font("MS", 9, 9));
		getContentPane().add(h);
		
		JLabel i =
				new JLabel("1° Avant de quitter le logiciel n'hésiter pas à vous déconnecter ");
		i.setFont(new Font("MS", 9, 9));
		getContentPane().add(i);
		
		
		
		JLabel j =
				new JLabel("1° Merci d'avoir choisie notre AUTO ECOLE, en vous souhaitons une excelente reussite à vos examen !");
		j.setFont(new Font("MS", 9, 9));
		getContentPane().add(j);
	}
	

	public void fctQuitter()
	{
	 JOptionPane.showMessageDialog(null, "Fermeture de la fenetre", "Information", JOptionPane.INFORMATION_MESSAGE);
	 this.dispose();
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.fermer)
		{
			fctQuitter();
		}
	}
}
