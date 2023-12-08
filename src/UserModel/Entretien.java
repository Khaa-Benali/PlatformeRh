package UserModel;
import java.util.Date;

 enum Type {technique,Comportementale}
public class Entretien {
    //zidou id candidature lena 
    private int idCandidature ;
    private int id;
    private String date;
    private String lieu;
    private String heure;
    private String type;
    // Constructeur
    public Entretien(int candi, int id, String date, String lieu, String heure, String type) {
        
        this.id=id;
        this.idCandidature=candi;
        this.date = date;
        this.lieu = lieu;
        this.heure = heure;
        this.type = type;
    }

    // Getters et setters pour chaque attribut
    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
