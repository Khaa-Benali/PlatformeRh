package UserModel;
import User.recrutement.Authentification;
import java.util.List;
import java.util.ArrayList;

public final class Candidat extends User implements Authentification {
    private String username;
    private String motDePasse;
    private int cin;
    private Cv cv;
    private final List<Candidature> candidatures;

    // Constructeur record
    public Candidat(int id, String nom, String prenom, String username, String email, int cin, String motDePasse) {
        super(id, nom, prenom, email);
        this.motDePasse = motDePasse;
        this.username = username;
        this.cin = cin;
        this.candidatures = new ArrayList<>();
    }

    // Setters for attributes inherited from User

  @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }
@Override
    // Setter for prenom
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

   @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

 @Override
    public void setID(int id) {
        super.setID(id);
    }
    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter for motDePasse
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    // Setter for cin
    public void setCin(int cin) {
        this.cin = cin;
    }

    // Setter for cv
    public void setCv(Cv cv) {
        this.cv = cv;
    }

    // ... (Other setters for attributes specific to Candidat)

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for motDePasse
    public String getMotDePasse() {
        return motDePasse;
    }

    // Getter for cin
    public int getCin() {
        return cin;
    }

    // Getter for cv
    public Cv getCv() {
        return cv;
    }

    // Getter for candidatures
    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    // Méthode pour postuler à une offre
    public void postuler(Offre_emplois offre) {
        Candidature candidature = new Candidature(getId(), offre);
        candidatures.add(candidature);
    }

    @Override
    public boolean authentifier(String nomUtilisateur, String motDePasse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
