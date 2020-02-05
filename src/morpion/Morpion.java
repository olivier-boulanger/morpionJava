package morpion;

public class Morpion {

    public int[][] grille; // déclaration de ma grille de jeu
    public int VIDE = 0; // variable pour les cases pas encore joués
    public int ROND = 1; // variable pour les cases jouées par le joueur 1
    public int CROIX = 2; // variable pour les cases jouées par le joueur 2
    public String str = ""; // variable d'affichage de ma grille
    public int compteur = 0; // variable me permettant de bien positionner la grille en calculant le modulo de 3
    public int coup = 0; // variable pour comptabiliser le nombre de coups joués
    public boolean replay; // variable pour faire rejouer le joueur en cas de case déjà prise ou d'indices non compris dans le jeu
    public boolean endGame = false; // variable pour notifier la fin de la partie si 9 coups joués
    public boolean over = false; // variable pour déterminer si la partie est finie

    public void initialise() { // methode d'initialisation de la grille en attribuant la valeur VIDE à tous les éléments du tableau
        grille = new int[3][3];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = VIDE;
            }
        }
    }

    public String affiche() { // methode qui affiche la grille après chaque tour 
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                compteur++;
                if (compteur % 3 == 0) { // je fais un retour chariot et une tabulation pour bien mettre en place ma grille de morpion
                    str += grille[i][j] + " \n\n";
                } else {
                    str += grille[i][j] + " \t";
                }
            }
        }
        System.out.println("COUP N° " + coup + "\n"); // j'affiche le nombre de coups joués
        if (coup == 9) { // condition sur le fin de partie 
            endGame = true;
        } else {
            endGame = false;
        }
        return str;
    }

    public void coupJoueur(int x, int y, int z) {
        if ((x < 0 || x > 2) || (y < 0 || y > 2)) {
            System.out.println("Veuillez choisir un entier entre 0 et 2");
            replay = true;
        } else if (grille[x][y] != VIDE) {
            System.out.println("Cette case est déjà jouée !");
            replay = true;
        } else {
            if (z == 1) {
                grille[x][y] = ROND;
            } else {
                grille[x][y] = CROIX;
            }
            coup++;
            replay = false;
        }
        str = "";
    }
    
    public void winGame(int gamer){ // methode de verification de victoires
        if (       (grille[0][0] == gamer && grille[0][1] == gamer && grille[0][2] == gamer) // horizontale 1
                || (grille[1][0] == gamer && grille[1][1] == gamer && grille[1][2] == gamer) // horizontale 2
                || (grille[2][0] == gamer && grille[2][1] == gamer && grille[2][2] == gamer) // horizontale 3
                || (grille[0][0] == gamer && grille[1][0] == gamer && grille[2][0] == gamer) // verticale 1
                || (grille[1][0] == gamer && grille[1][1] == gamer && grille[1][2] == gamer) // verticale 2
                || (grille[2][0] == gamer && grille[2][1] == gamer && grille[2][2] == gamer) // verticale 3
                || (grille[0][0] == gamer && grille[1][1] == gamer && grille[2][2] == gamer) // diagonale 1
                || (grille[0][2] == gamer && grille[1][1] == gamer && grille[2][0] == gamer) // diagonale 2
                ){
            System.out.println("Le Joueur " + gamer + " a gagné");
            over = true; // variable qui désigne la fin de la partie
        } else {
            over = false; // la partie continue, il n'y a aucun gagnant
        }
    }

}
