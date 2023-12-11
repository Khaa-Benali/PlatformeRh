package UserModel;


public class Entretien {
    private int idCandidature ;
    private int idEntretien;
    private String date;
    private String lieu;
    private String heure;
    private String type;
    private int note;
    private String commentaires;
    // Constructeur
    public Entretien(int candi, int id, String date, String lieu, String heure, String type,int note,String commentaires) {
        
        this.idCandidature=candi;
        this.idEntretien=id;
        this.date = date;
        this.lieu = lieu;
        this.heure = heure;
        this.type = type;
        this.note=note;
        this.commentaires=commentaires;
    }
    // Getters et setters pour chaque attribut
    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }
    // Getters et setters pour chaque attribut
    public int getId() {
        return idEntretien;
    }
      public void setId(int id) {
        this.idEntretien=id;
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
     public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String comn) {
        this.commentaires = comn;
    }
     public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

}
