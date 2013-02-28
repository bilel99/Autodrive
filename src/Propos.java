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

public class Propos extends JFrame implements ActionListener{
protected JPanel panel = new JPanel();
protected JButton fermer = new JButton("Fermer");

	public Propos()
	{
		super();
		setSize(400, 400);
		setTitle("A-Propos !");
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		setLayout(new FlowLayout());
		add(fermer);
		this.fermer.addActionListener(this);
		panel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(800, 2));
		getContentPane().add(panel);
		
		JLabel propos =
				new JLabel("Welcome to AutoDrive");
		propos.setFont(new Font("MS", 40, 40));
		getContentPane().add(propos);
		
		
		JLabel a =
				new JLabel("1° Ce logiciel a été programmer à l'aide de Eclipse IDE sous JAVA ''langage of programmation'' ");
		a.setFont(new Font("MS", 9, 9));
		getContentPane().add(a);
		
		JLabel b =
				new JLabel("Copyright AUTODRIVE reserved of AutoEcole - AutoDrive - ");
		b.setFont(new Font("MS", 9, 9));
		getContentPane().add(b);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.fermer)
		{
			fctQuitter();
		}	
	}
	
	public void fctQuitter()
	{
	JOptionPane.showMessageDialog(null, "Fermeture de la fenetre", "Information", JOptionPane.INFORMATION_MESSAGE);
	this.dispose();
	}
}
