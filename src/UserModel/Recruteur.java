package UserModel;
import UserModel.Cv;
import UserModel.Offre_emplois;
import UserModel.Candidature;
import UserModel.Candidat;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

    
public final class Recruteur extends User {
    private final String specialisation;
    private final List<Candidature> candidatures;
    private final Map<Candidat, Cv> candidatCv;
    private final Map<Candidature, Entretien> entretiens;

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

    /* // Méthode pour filtrer les candidatures selon les exigences de l'offre et les compétences du CV
    public List<Candidature> filtrerCandidatures(Offre_emplois offre) {
        return candidatures.stream()
            .filter(candidature -> candidature.getOffre().equals(offre))
            .filter(candidature -> verifierExigences(offre, candidature.getIdCandidat()))
            .collect(Collectors.toList());
    }

    // Méthode pour vérifier les exigences de l'offre
    private boolean verifierExigences(Offre_emplois offre, int idCandidat) {
        List<String> exigencesOffre = offre.getExigences();
        List<String> competencesCandidat = getCvCompetencesByIdCandidat(idCandidat);
        return competencesCandidat.containsAll(exigencesOffre);
    }

    // Méthode pour enregistrer le CV d'un candidat
    public void enregistrerCvCandidat(Candidat candidat, Cv cv) {
        candidatCv.put(candidat, cv);
    }

    // Méthode fictive pour récupérer les compétences du candidat par ID
    private List<String> getCvCompetencesByIdCandidat(int idCandidat) {
        Candidat candidat = getCandidatFromCandidatureId(idCandidat);
        if (candidat != null) {
            Cv cv = candidatCv.get(candidat);
            if (cv != null) {
                return cv.getCompetences();
            }
        }
        return Collections.emptyList();
    }

    private Candidat getCandidatFromCandidatureId(int idCandidature) {
    return candidatures.stream()
            .filter(candidature -> candidature.getIdCandidature() == idCandidature)
            .map(Candidature::getCandidat)
            .findFirst()
            .orElse(null);
}*/

}