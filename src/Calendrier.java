import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Calendrier extends JFrame
{
	
	public Calendrier()
	{
		super();
		setSize(600, 600);
		setTitle("Add Event");
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("calendar.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
}
