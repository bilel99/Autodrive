import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;


public class Contenu extends Jframe implements ActionListener
{
	
	//Variables d'instance
			private Calendrier calendrier;

			//Getters & Setters
			public Calendrier getCalendrier() {
				return calendrier;
			}

			public void setCalendrier(Calendrier cal) {
				calendrier = cal;
			}

	public Contenu()
	{	
		super();
		
		this.item0_1.addActionListener(this);
		this.item0.addActionListener(this);
		this.item1.addActionListener(this);
		this.item3.addActionListener(this);
		this.item3_1.addActionListener(this);
		this.item3_2.addActionListener(this);
		this.item4.addActionListener(this);
		this.item5.addActionListener(this);
		this.item6.addActionListener(this);
		this.item6_1.addActionListener(this);
		this.item6_2.addActionListener(this);
		this.item6_3.addActionListener(this);
		this.item7.addActionListener(this);
		this.item8.addActionListener(this);
		this.item9.addActionListener(this);
		
		this.ajout.addActionListener(this);
		this.gestion.addActionListener(this);
		this.gestion_type.addActionListener(this);
		this.commentaires.addActionListener(this);
		this.calendrierr.addActionListener(this);
		this.quitter.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==this.quitter || e.getSource()==this.item5)
		{
			fctQuitter();
		}
		else if(e.getSource()==this.ajout || e.getSource()==this.item1)
		{
			ajout_event();
		}
		else if(e.getSource()==this.gestion)
		{
			gestion();
		}
		
		else if(e.getSource()==this.commentaires)
		{
			commentaires();
		}
		
		else if(e.getSource()==this.gestion_type)
		{
			gestion_type();
		}

		else if(e.getSource()==this.calendrierr)
		{
			calendrier();
		}
		else if(e.getSource()==this.item3)
		{
			actualiser();
		}
		else if(e.getSource()==this.item4)
		{
			redemarrer();
		}
		else if(e.getSource()==this.item0)
		{
			deconnexion();
		}
		
		else if(e.getSource()==this.item0_1)
		{
			liste_evenement();
		}
		else if(e.getSource()==this.item6_1)
		{
			personaliser();
		}
		else if(e.getSource()==this.item6_2)
		{
			preference();
		}
		else if(e.getSource()==item6_3)
		{
			calculatrice();
		}
		else if(e.getSource()==item7)
		{
			aide();
		}
		else if(e.getSource()==item8)
		{
			propos();
		}
		else if(e.getSource()==item9)
		{
			website();
		}
	}
	
	public void fctQuitter()
	{
		int retour;
		
		retour = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter le programme ?", "Arrêt du programme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(retour == JOptionPane.OK_OPTION)
		{
			this.dispose();
		}
	}
	
	public void ajout_event()
	{
		// AJOUT D UN EVENEMENT //
		Ajout_heure add = new Ajout_heure();
		add.show();
		add.setVisible(true);
		
	}
	
	public void gestion()
	{
		// OUVERTURE D UNE NOUVELLE FENETRE POUR LA //
		// MODIFICATION D UN COMPTE MOT DE PASSE OU INFO PERSONNELLE //
		Gestion_utilisateur gestionUtilisateur = new Gestion_utilisateur();
		gestionUtilisateur.show();
		gestionUtilisateur.setVisible(true);
		
	}
	
	public void calendrier()
	{
		// AFFICHER TOUT LES EVENEMENTS SOUS FORME DE CALENDRIER //
		Calendrier calendar = new Calendrier();
		calendar.show();
		calendar.setVisible(true);
	}
	
	public void save()
	{
		// FONCTION DE SAUVEGARDE LECTURE ECRITURE SUR LE DISQUE DUR //
	}
	
	public void actualiser()
	{
		// FONCTION ACTUALISER LE PROGRAMME //
		revalidate();
	}
	
	//Méthodes
			public void sauvegarder() throws IOException {
				FileOutputStream f = new FileOutputStream("calendrier.obj");
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(getCalendrier());
				o.close();
			}

			public void charger() throws IOException, ClassNotFoundException {
				FileInputStream f = new FileInputStream("calendrier.obj");
				ObjectInputStream o = new ObjectInputStream(f);
				Calendrier c = (Calendrier) o.readObject();
				o.close();
				setCalendrier(c);
			}
	
	public void redemarrer()
	{
		// FONCTION DE REDEMARRAGE DU PROGRAMME //
		int redemarrer;
		redemarrer = JOptionPane.showConfirmDialog(null, "Voulez-vous redemarrer le programme ?", "Redemarrage du programme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(redemarrer == JOptionPane.OK_OPTION)
		{
			this.dispose();
			new Contenu();
		}
		
	}
	
	public void deconnexion()
	{
		// DECONNEXION DE LA BASE DE DONNEE //
		// OUVERTURE D UNE FENETRE DE CONNEXION //
	}
	
	public void personaliser()
	{
		Personaliser personaliser = new Personaliser();
		personaliser.show();
		personaliser.setVisible(true);
	}
	
	public void preference()
	{
		Preference preference = new Preference();
		preference.show();
		preference.setVisible(true);
	}
	
	public void calculatrice()
	{
		// APPEL DE LA CLASS CALCULATRICE //
		Calculatrice calc = new Calculatrice();
		calc.setVisible(true);
		calc.show();
	}
	
	public void aide()
	{
		// OUVERTURE D UNE NOUVELLE FENETRE AIDE //
		Aide help = new Aide();
		help.setVisible(true);
		help.show();
	}
	
	public void propos()
	{
		// OUVERTURE D UNE NOUVELLE FENETRE A PROPOS //
		Propos propos = new Propos();
		propos.setVisible(true);
		propos.show();
		
	}
	
	public void website()
	{
		// On vérifie que la classe Desktop soit bien supportée :
					if ( Desktop.isDesktopSupported() ) {
						// On récupère l'instance du desktop :
						Desktop desktop = Desktop.getDesktop();
					 
						// On vérifie que la fonction browse est bien supportée :
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
					 
							// Et on lance l'application associé au protocole :
							try {
								desktop.browse(new URI("http://www.google.fr"));
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (URISyntaxException e1) {
								e1.printStackTrace();
							}
						}
					}
	}
	
	
	public void nettoyer() {
		Component[] comp = this.getContentPane().getComponents();
		for (int i = 0; i < comp.length; i++) {
			comp[i].setVisible(false);
		}
	}
	
	public void liste_evenement()
	{
		Liste_evenement liste = new Liste_evenement();
		liste.show();
		liste.setVisible(true);
	}
	
	public void commentaires()
	{
		Commentaires commentaire = new Commentaires();
		commentaires.show();
		commentaires.setVisible(true);
	}
	
	public void gestion_type()
	{
		Gestion_type gestion_type = new Gestion_type();
		gestion_type.show();
		gestion_type.setVisible(true);
	}
	
}
