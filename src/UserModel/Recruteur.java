package UserModel;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

    
public final class Recruteur extends User {
    private final String specialisation;
    private final List<Candidature> candidatures;
    private final Map<Candidat, Cv> candidatCv;
    private final Map<Candidature, Entretien> entretiens;
    //public static final List<String> TYPES = List.of("Accepted", "Other");

    // Constructeur record
    public Recruteur(int id, String nom, String prenom, String email, String specialisation) {
        super(id, nom, prenom, email);
        this.specialisation = specialisation;
        this.candidatures = new ArrayList<>();
        this.entretiens = new HashMap<>();
        this.candidatCv = new HashMap<>();
    }

    // Getter pour specialisation
    public String getSpecialisation() {
        return specialisation;
    }

    // Getter pour candidatures
    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    // Méthode pour ajouter une candidature
    public void ajouterCandidature(Candidature candidature) {
        candidatures.add(candidature);
    }

    // Getter pour entretiens
    public Map<Candidature, Entretien> getEntretiens() {
        return entretiens;
    }


    // Méthode pour évaluer un entretien
    public void evaluerEntretien(Entretien entretien) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Évaluez l'entretien :");
        System.out.print("Note : ");
        int note = Integer.parseInt(scanner.nextLine());
        System.out.print("Commentaires : ");
        String commentaire = scanner.nextLine();
        entretien.setNote(note);
        entretien.setCommentaires(commentaire);
        
    }
        // Méthode pour filtrer les candidatures par type avec Stream et Lambda
    public List<Candidature> filterCandidaturesByType(String type) {
        return candidatures.stream()
            .filter(candidature -> candidature.getType().equals(type))
            .collect(Collectors.toList());
    }
 
}