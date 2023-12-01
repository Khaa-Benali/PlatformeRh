package User.recrutement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khadi
 */
@FunctionalInterface
public interface Authentification {
    boolean authentifier(String nomUtilisateur, String motDePasse);
}
