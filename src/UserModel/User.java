package UserModel;

public sealed abstract class User permits  Candidat , Recruteur {
    private  int id;
    private  String nom;
    private  String prenom;
    private  String email;
    // Constructeur
    public User(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }
     void setID(int id) {
        this.id=id;
    }
     

    void setNom(String nom) {
        this.nom=nom;
    }

    void setPrenom(String prenom) {
         this.prenom=prenom;
    }

    void setEmail(String email) {
         this.email=email;
    }

}