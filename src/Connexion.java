import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connexion {
    private String serveur, user, mdp, bdd;
    
    Connection maConnection;
    
    public Connexion(String serveur, String user, String mdp, String bdd){
        this.serveur = serveur;
        this.user = user;
        this.mdp = mdp;
        this.bdd = bdd;
    }
    
    private void chargerPilote(){
        try {
            // chargement du pilote assurant la connexion
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException exp){
			JOptionPane.showMessageDialog(null, exp.getMessage(), "Erreur de chargement du pilote", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void seConnecter(){
        //ouverture d'une connexion au serveur Mysql
        this.chargerPilote();
        String url = "jdbc:mysql://" + this.serveur + "/" + this.bdd;
        try {
            this.maConnection = DriverManager.getConnection(url, this.user, this.mdp);
        }
        catch(SQLException exp){
			JOptionPane.showMessageDialog(null, exp.getMessage(), "Erreur de chargement du pilote", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void seDeconnecter(){
       if (this.maConnection != null){
           try{
               this.maConnection.close();
           }
           catch(SQLException exp){
   			   JOptionPane.showMessageDialog(null, exp.getMessage(), "Erreur de chargement du pilote", JOptionPane.ERROR_MESSAGE);
           }
       }
    }
    
    public Connection getConnection(){
        
        return this.maConnection;
    }
}
