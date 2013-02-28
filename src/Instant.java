import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Instant extends Object implements Serializable{
	
	//Variables d'instance
	private int jour;
	private int mois;
	private int annee;
	private int heure;
	private int minute;
	
	//Getters & Setters
	public int getJour(){
		return jour;
	}
	
	public int getMois(){
		return mois;
	}
	
	public int getAnnee(){
		return annee;
	}
	
	public int getHeure(){
		return heure;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public static String actuel(){
		Date d = new Date();
		return(DateFormat.getDateInstance().format(d));
	}
	
	public void setJour(int j){
		jour = j;
	}
	
	public void setMois(int m){
		mois=m;
	}
	
	public void setAnnee(int a){
		annee = a;
	}
	
	public void setHeure(int h){
		heure = h;
	}
	
	public void setMinute(int m){
		minute = m;
	}
	
	//Constructeur
	public Instant(int jo, int mo, int an, int he, int mi){
		setJour(jo);
		setMois(mo);
		setAnnee(an);
		setHeure(he);
		setMinute(mi);
	}
	
	//Méthodes
	public boolean anterieurA(Instant t){
		return(
				(annee < t.getAnnee())
				|
				((annee == t.getAnnee()) & (mois < t.getMois()))
				|
				((annee == t.getAnnee()) & (mois == t.getMois()) & (jour < t.getJour()))
				|
				((annee == t.getAnnee()) & (mois == t.getMois()) & (jour == t.getJour()) & (heure < t.getHeure()))
				|
				(annee == t.getAnnee()) & (mois == t.getMois()) & (jour == t.getJour()) & (heure == t.getHeure()) & (minute < t.getMinute())
		);
	}

	public boolean posterieurA(Instant t){
		return(
				(annee > t.getAnnee())
				|
				((annee == t.getAnnee()) & (mois > t.getMois()))
				|
				((annee == t.getAnnee()) & (mois == t.getMois()) & (jour > t.getJour()))
				|
				((annee == t.getAnnee()) & (mois == t.getMois()) & (jour == t.getJour()) & (heure > t.getHeure()))
				|
				(annee == t.getAnnee()) & (mois == t.getMois()) & (jour == t.getJour()) & (heure == t.getHeure()) & (minute > t.getMinute())
		);
	}
	
	public boolean appartientALaPeriode(Periode p){
		return!(
			(anterieurA(p.getDateDebut()))
			|
			(posterieurA(p.getDateFin()))
		);
	}
	
	public boolean enMemeTempsQue(Instant i){
		return (!(this.anterieurA(i))&(!(this.posterieurA(i))));
	}
	
	public String toString(){
		return(getJour()+"/"+getMois()+"/"+getAnnee()+" à "+getHeure()+":"+getMinute());
	}
}
