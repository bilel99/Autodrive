import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;


public class Jframe extends JFrame implements ActionListener
{	
	private static final Graphics Graphics = null;
	protected JPanel panel = new JPanel();
	protected JToolBar toolBar = new JToolBar();
	protected JPopupMenu files = new JPopupMenu();
	protected JMenuBar maBarre = new JMenuBar();
	
	protected JMenu file = new JMenu("File");
	protected JMenu edit = new JMenu("Edit");
	protected JMenu help = new JMenu("Help");
	
	protected JMenuItem item0_1= new JMenuItem("Liste des événements", new ImageIcon("images/liste.png"));
	protected JMenuItem item1 = new JMenuItem("Nouvelle événement", new ImageIcon("images/new_event.png"));
	protected JMenuItem item3 = new JMenuItem("Actualiser", new ImageIcon("images/actualise.png"));
	protected JMenuItem item3_1 = new JMenuItem("Sauvegarder", new ImageIcon("images/sauvegarde.png"));
	protected JMenuItem item3_2 = new JMenuItem("Charger", new ImageIcon("images/charger.gif"));
	protected JMenuItem item4 = new JMenuItem("Redemarrer", new ImageIcon("images/redemarrer.png"));
	protected JMenuItem item0 = new JMenuItem("Deconnexion", new ImageIcon("images/logout_icon.png"));
	protected JMenuItem item5 = new JMenuItem("Quitter", new ImageIcon("images/exit.gif"));
	
	protected JMenu item6 = new JMenu("Configurer");
	protected JMenuItem item6_1 = new JMenuItem("Personnaliser", new ImageIcon("images/color.png"));
	protected JMenuItem item6_2 = new JMenuItem("Préference", new ImageIcon("images/preference.png"));
	protected JMenuItem item6_3 = new JMenuItem("Calculatrice", new ImageIcon("images/calc.png"));
	
	protected JMenuItem item7 = new JMenuItem("Aide", new ImageIcon("images/aide.jpeg"));
	protected JMenuItem item8 = new JMenuItem("A-propos", new ImageIcon("images/propos.gif"));
	protected JMenuItem item9 = new JMenuItem("Website", new ImageIcon("images/website.png"));
/*	
	protected JButton ajout = new JButton("Ajout");
	protected JButton gestion = new JButton("Gestion_utilisateur");
	protected JButton commentaires = new JButton("Commentaires");
	protected JButton calendrierr = new JButton("Calendrier");
	protected JButton quitter = new JButton("Quitter");
*/	
	protected JButton ajout = new JButton(new ImageIcon("images/add_event.png")),
			    gestion = new JButton(new ImageIcon("images/admin.png")),
			    gestion_type = new JButton(new ImageIcon("images/calendar_edit.gif")),
			    commentaires = new JButton(new ImageIcon("images/comments.gif")),
			    calendrierr = new JButton(new ImageIcon("images/calendar.gif")),
			    quitter = new JButton(new ImageIcon("images/exit.gif"));
	

	public Jframe()
	{
		super();
		setSize(800, 600);
		setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setTitle("Gestion");
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		char raccourci = 0;
		setAccelerator(KeyStroke.getKeyStroke("control "+raccourci));
		
		files.setComponentPopupMenu(files);
		files.add(item0_1);
		
		
		file.add(item0_1);
		file.add(item1);
		file.add(item3);
		file.add(item3_1);
		file.add(item3_2);
		file.add(item4);
		file.addSeparator();
		file.add(item0);
		file.add(item5);	
		
		item6.add(item6_1);
		item6.add(item6_2);
		edit.add(item6_3);
		edit.addSeparator();
		
		help.add(item7);
		help.add(item8);
		help.addSeparator();
		help.add(item9);
		
		maBarre.add(file);
		maBarre.add(edit);
		edit.add(item6);
		maBarre.add(help);
		
		setJMenuBar(maBarre);
		
		add(ajout);
		add(gestion);
		add(gestion_type);
		add(commentaires);
		add(calendrierr);
		add(quitter);
		
		JToolBar palette = new JToolBar("Palette");
		palette.add(ajout);
		palette.add(gestion);
		palette.add(gestion_type);
		palette.add(commentaires);
		palette.add(calendrierr);
		palette.add(quitter);
		add(palette, BorderLayout.NORTH);
		bienvenue();
		
		//JInternalFrame fen = new JInternalFrame();
				getContentPane().setBackground(Color.LIGHT_GRAY);
				getContentPane().setLayout(new GridLayout(0, 1));
				
				JLabel h =
						new JLabel("HORAIRES DU CODE DE LA ROUTE");
				h.setFont(new Font("MS", 40, 40));
				getContentPane().add(h);
				
				//Les données du tableau
			    Object[][] data = {
			      {"9H00 à 11H00 CODE", "9H00 à 11H00 CODE", "9H00 à 11H00 CODE", "9H00 à 11H00 CODE", "9H00 à 11H00 CODE", "9H00 à 11H00 CODE"},
			      {"14H00 à 16H00 EXAMEN", "14H00 à 16H00 EXAMEN", "14H00 à 16H00 EXAMEN", "14H00 à 16H00 EXAMEN", "14H00 à 16H00 EXAMEN", "14H00 à 16H00 EXAMEN"},
			      {"17H00 à 19H00 CODE", "17H00 à 19H00 CODE", "17H00 à 19H00 CODE", "17H00 à 19H00 CODE", "17H00 à 19H00 CODE", "17H00 à 19H00 CODE"},
			      {"20H00 à 22H00 EXAMEN", "20H00 à 22H00 EXAMEN", "20H00 à 22H00 EXAMEN", "20H00 à 22H00 EXAMEN", "20H00 à 22H00 EXAMEN", "20H00 à 22H00 EXAMEN"}
			    };
			 
			    //Les titres des colonnes
			    String  title[] = {"LUNDI", "MARDI", "MERCREDI", "JEUDI", "VENDREDI", "SAMEDI"};
			    JTable tableau = new JTable(data, title);
			    this.getContentPane().add(new JScrollPane(tableau));
			    
			    
				
				getContentPane().add(
					new JLabel("                                 Pour toute question concernant le Logiciel vous réferer à la rubrique AIDE, Merci"));
				JLabel j =
					new JLabel("                                    AUTODRIVE");
				j.setFont(new Font("MS", 2, 20));

				getContentPane().add(j);
				getContentPane().add(new JLabel("                                        " + Instant.actuel()));
				getContentPane();
				
			
		
	}
	
	private void setAccelerator(KeyStroke keyStroke) {
		// TODO Auto-generated method stub
		
	}

	public void bienvenue()
	{
		Connexion maBDD = new Connexion ("localhost", "root", "", "autodrive");
		maBDD.seConnecter();
		String sql ="SELECT * FROM utilisateurs where email = email";
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			ResultSet unResultat = unStatement.executeQuery(sql);
			while(unResultat.next())
			{
				JLabel b = new JLabel("Bienvenue sur votre compte : " +unResultat.getString ("email"));
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
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
	}
}