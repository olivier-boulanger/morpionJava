package morpion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Morpion morp = new Morpion(); // création de l'objet morp à partir de la classse Morpion
        morp.initialise(); // on initialise le tableau de la nouvelle partie
        System.out.println(morp.affiche()); // on affiche la grille
        Scanner sc = new Scanner(System.in); // on deigne une variable pour récupérer l'entrée clavier
        int x; // variable pour le choix vertical
        int y; // variable pour le choix horizontal
        char resp; // variable pour la réponse finale si l'on veut refaire une partie
        do { // boucle entourant le jeu complet que l'on parcourt tant que les joueurs veulent refaire une partie
            do { // boucle tant que la partie n'est pas fini
                do { // boucle pour le premier joueur
                    System.out.println("JOUEUR 1");
                    System.out.println("Quel ligne ?"); // on demande les valeurs de la case souhaitée
                    x = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Quel colonne ?");
                    y = sc.nextInt();
                    sc.nextLine();
                    morp.coupJoueur(x, y, 1); // on appelle la méthode coupJoueur avec les valeurs saisies pour attribuer le coup ou faire rejouer (voir la méthode)
                } while (morp.replay); // on boucle sur le premier joueur si la case choisie est déjà prise ou non comprise dans la grille de jeu
                System.out.println(morp.affiche()); // on fait appelle à la méthode pour afficher la grille modifiée après le coup joué
                morp.winGame(1); // on vérifie avec la méthode winGame si le joueur a gagné ou si la partie continue
                if (morp.over) { // si la partie est terminée on quitte la boucle (ligne 51)
                    break;
                }
                if (morp.endGame == true) { // on quitte la boucle si le nombres de coups joués est à 9 (maximum au morpion
                    break;
                }
                do {
                    System.out.println("JOUEUR 2");
                    System.out.println("Quel valeur pour x ?");
                    x = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Quel valeur pour y ?");
                    y = sc.nextInt();
                    sc.nextLine();
                    morp.coupJoueur(x, y, 2);
                } while (morp.replay);
                System.out.println(morp.affiche());
                morp.winGame(2);
                if (morp.over) {
                    break;
                }
            } while (morp.endGame == false); // on redemande aux joueurs un choix tant que la partie n'est pas terminée
            if (morp.over == false) { // si la partie est terminée (9 coups) et qu'il n'y a pas eu de systèmes gagnants
                System.out.println("MATCH NUL"); 
            }
            System.out.println("FIN DE LA PARTIE"); // message de fin de partie
            System.out.println("Voulez-vous rejouer ?");
            resp = sc.nextLine().toUpperCase().charAt(0); // on récupére la premiere lettre saisie mis en majuscule des joueurs dans la variable resp
        } while (resp == 'O'); // tant que les joueurs saisissent o ou O, la partie recommence
        System.out.println("DOMMAGE ! Au revoir !"); // sinon fin du programme
    }

}
