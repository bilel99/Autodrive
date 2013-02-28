import java.io.Serializable;

public class Periode implements Serializable{
	
//Variables d'instance
	private Instant dateDebut;
	private Instant dateFin;
	
//Getters & Setters
	public Instant getDateDebut(){
		return dateDebut;
	}
	
	public Instant getDateFin(){
		return dateFin;
	}
	
	public void setDateDebut(Instant t){
		dateDebut = t;
	}
	
	public void setDateFin(Instant t){
		dateFin = t;
	}

	//Constructeurs
	public Periode(Instant t1, Instant t2){
		setDateDebut(t1);
		setDateFin(t2);
	}
	
	//Méthodes
	public boolean disjointeDe(Periode p){
		return(
				getDateFin().anterieurA(p.getDateDebut())
				|
				getDateDebut().posterieurA(p.getDateFin())
		);
	}

	public String toString(){
		return("Du "+getDateDebut().toString()+" au "+getDateFin().toString());
	}
}
