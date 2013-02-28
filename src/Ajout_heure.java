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

public class Ajout_heure extends JFrame implements ActionListener 
{
	protected JPanel panel = new JPanel();
	protected JLabel label = new JLabel();
	protected JButton fermer = new JButton("Fermer");
	protected JButton enregistrer = new JButton("Enregistrer");
	protected JButton effacer = new JButton("Effacer");
	
	JTextField event_title,cf_event_start,cf_event_end,event_detail;
	JComboBox calendar_name, event_type_label, all_day;
	String[] day_all = { "1. T/P 24/24", "2. M/T 12/24" };
	
	public Ajout_heure()
	{
		super();
		setSize(600, 600);
		setTitle("Ajout d'événement");
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
		tittre.setText(" ----- Ajout d'événement -----");
		c.add(tittre);
		
		event_title=new JTextField();
		cf_event_start=new JTextField();
		cf_event_end=new JTextField();
		event_detail=new JTextField();
		
		Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
		maBDD.seConnecter();
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			String sql = "SELECT * FROM calendar";
			ResultSet rs = unStatement.executeQuery(sql);
			
			calendar_name=new JComboBox();
			calendar_name.setPreferredSize(new Dimension(320, 200));
			calendar_name.addItem("Choisir");
			
			while(rs.next())
			{
				calendar_name.addItem(rs.getString("calendar_name"));
			}
		}
		catch(SQLException exp)
		{
			JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
		}
		
		
		try
		{
			Statement unStatement = maBDD.getConnection().createStatement();
			String sql = "SELECT * FROM event_type";
			ResultSet rs = unStatement.executeQuery(sql);
			
			event_type_label=new JComboBox();
			event_type_label.setPreferredSize(new Dimension(320, 200));
			event_type_label.addItem("Choisir");
			
			while(rs.next())
			{
				event_type_label.addItem(rs.getString("event_type_label"));
			}
		}
		catch(SQLException exp)
		{
			JOptionPane.showMessageDialog(null, exp.getMessage(), "ERREUR SUR LA REQUETTE ! ", JOptionPane.ERROR_MESSAGE);
		}
		
		
		all_day=new JComboBox(day_all);
		all_day.setPreferredSize(new Dimension(320, 200));
		
		panelcentre.add(new JLabel("Calendar  :",SwingConstants.CENTER));
		panelcentre.add(calendar_name);
		panelcentre.add(new JLabel("Title  :",SwingConstants.CENTER));
		panelcentre.add(event_type_label);
		panelcentre.add(new JLabel("Event title  :",SwingConstants.CENTER));
		panelcentre.add(event_title);
		panelcentre.add(new JLabel("Date entrée :",SwingConstants.CENTER));
		panelcentre.add(cf_event_start);
		panelcentre.add(new JLabel("Date sortie :",SwingConstants.CENTER));
		panelcentre.add(cf_event_end);
		panelcentre.add(new JLabel("Detail :",SwingConstants.CENTER));
		panelcentre.add(event_detail);
		panelcentre.add(new JLabel("All day  :",SwingConstants.CENTER));
		panelcentre.add(all_day);
		
		c.add(panelcentre);
		//creer et ajouter des boutons au panel de bas
		panelbas.add(enregistrer);
		panelbas.add(effacer);
		panelbas.add(fermer);
		c.add(panelbas);
		//enregistrer le frame comme auditeur de bouton
		enregistrer.addActionListener(this);
		effacer.addActionListener(this);
		fermer.addActionListener(this);
		calendar_name.addActionListener(this);
		event_type_label.addActionListener(this);
		event_title.addActionListener(this);
		cf_event_start.addActionListener(this);
		cf_event_end.addActionListener(this);
		event_detail.addActionListener(this);
		
		all_day.setSelectedIndex(1);
		all_day.addActionListener(this);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
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
		String sql, event_title,cf_event_start,cf_event_end,event_detail;
		
		Connexion maBDD = new Connexion("localhost", "root", "", "planitup");
		maBDD.seConnecter();

		try
		{
			
		String results = (String) calendar_name.getSelectedItem();
		System.out.println("Choix : "+results);	
		
		String resultss = (String) event_type_label.getSelectedItem();
		System.out.println("Choix : "+resultss);
			
		event_title=this.event_title.getText();
		cf_event_start=this.cf_event_start.getText();
		cf_event_end=this.cf_event_end.getText();
		event_detail=this.event_detail.getText();
		
		String result = (String) all_day.getSelectedItem();
		System.out.println("Choix : "+result);
		
		System.out.println(event_title+" "+cf_event_start+" "+cf_event_end+""+event_detail+""+all_day+""+calendar_name+""+event_type_label);
		

		//insertion
		Statement unStatement = maBDD.getConnection().createStatement();
		//ResultSet unResultat = unStatement.executeQuery(sql);
		 sql = "INSERT INTO event (calendar_name,event_type_label,event_title,cf_event_start,cf_event_end,event_detail,all_day) VALUES ('"+this.calendar_name.getSelectedItem()+"','"+this.event_type_label.getSelectedItem()+"','"+this.event_title.getText()+"','"+this.cf_event_start.getText()+"','"+this.cf_event_end.getText()+"','"+this.event_detail.getText()+"','"+this.all_day.getSelectedItem()+"')";
		 unStatement.executeUpdate(sql);
		 //System.out.println(sql+" ligne insérée");
		 JOptionPane.showMessageDialog(this,"Votre événement à bien été ajouté");
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
		event_title.setText("New event");
		cf_event_start.setText("NEW 1969-12-31 16:00:00");
		cf_event_end.setText("NEW 1969-12-31 16:00:00");
		event_detail.setText("New comments");

	}
	
}