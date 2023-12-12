/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author khadi
 */
public record Entreprise(int id, String nom, String secteurActivite, int taille, Set<Offre_emplois> offres) {

    // Méthode pour créer une offre
    public void creerOffre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titre de l'offre: ");
        String titre = scanner.nextLine();

        System.out.print("Description de l'offre: ");
        String description = scanner.nextLine();

        System.out.print("Saisir les exigences de l'offre (séparées par des virgules): ");
        String exigencesInput = scanner.nextLine();
        List<String> exigences = Arrays.asList(exigencesInput.split(","));

        System.out.println("L'offre a été créée avec succès.");
        scanner.close();
    }
}