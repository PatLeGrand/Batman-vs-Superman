public class Grille {
    private char[][] grille;
    private int numeroLigne;
    private int numeroColonne;
    private ToursJoueur toursJoueur;
    private String gagnant;
    private int[] dernierePositionSuperman;
    private int[] dernierePositionBatman;

    public  Grille() {
        grille = new char[4][4];
        for (int i = 0 ; i < 4 ; ++i){
            for (int j = 0 ; j < 4 ; ++j){
                grille[i][j] = ' ';
            }
        }
    }

    public void remplirGrille() {
            if (numeroLigne >= 0 && numeroLigne < 4 && numeroColonne >= 0
                    && numeroColonne < 4 && grille[numeroLigne][numeroColonne] == ' ') {
                grille[numeroLigne][numeroColonne] = toursJoueur.getLettreJoueur();
                if (toursJoueur.getLettreJoueur() == 'S') {
                    dernierePositionSuperman = new int[]{numeroLigne, numeroColonne};
                }
                else if (toursJoueur.getLettreJoueur() == 'B') {
                    dernierePositionBatman = new int[]{numeroLigne, numeroColonne};
                }
            }

    }

    public boolean verifierGrille() {
        for(int i = 0;i < 4; ++i){
            for(int j = 0; j < 4; ++j){
                if(grille[i][j] == ' '){
                    return true;
                }
            }
        }
        return false;
        }

    private boolean verifierLigne(char a, char b, char c, char d) {
        if (a != ' ' && a == b && b == c && c == d) {
            if (a == 'B') {
                gagnant = "Batman";
            } else if (a == 'S') {
                gagnant = "Superman";
            }
            return true;
        }
        return false;
    }

    public boolean statutJeu() {
        for (int i = 0; i < 4; i++) {
            if (verifierLigne(grille[i][0], grille[i][1], grille[i][2], grille[i][3])) {
                return false;
            }

            if (verifierLigne(grille[0][i], grille[1][i], grille[2][i], grille[3][i])) {
                return false;
            }
        }

        if (verifierLigne(grille[0][0], grille[1][1], grille[2][2], grille[3][3])) {
            return false;
        }

        if (verifierLigne(grille[0][3], grille[1][2], grille[2][1], grille[3][0])) {
            return false;
        }

        return true;
    }

    public void afficherGrille() {
        System.out.println("\n   0   1   2   3 ");
        System.out.println(" ╔═══╦═══╦═══╦═══╗");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + "║ ");
            for (int j = 0; j < 4; j++) {
                System.out.print(grille[i][j] + " ║ ");
            }
            System.out.println();
            if (i < 3) {
                System.out.println(" ╠═══╬═══╬═══╬═══╣");
            }
        }
        System.out.println(" ╚═══╩═══╩═══╩═══╝");
    }

    public void remplirGrilleHeatVision() {
        if (numeroLigne >= 0 && numeroLigne < 4 && numeroColonne >= 0
                && numeroColonne < 4 && grille[numeroLigne][numeroColonne] == 'B') {
            grille[numeroLigne][numeroColonne] = ' ';
        }
    }

    public boolean presenceSymboleSuperman () {
        for (int i = 3; i >= 0 ; i--) {
            for (int j = 3; j >= 0; j--) {
                if (grille[i][j] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }

    public void echangerSymboles(int ligne1, int colonne1, int ligne2, int colonne2) {
        char temp = grille[ligne1][colonne1];
        grille[ligne1][colonne1] = grille[ligne2][colonne2];
        grille[ligne2][colonne2] = temp;
    }

    public int getNumeroLigne(){
        return numeroLigne;
    }
    public int getNumeroColonne(){
        return numeroColonne;
    }

    public void setNumeroLigne(int numeroLigne){
        this.numeroLigne = numeroLigne;
    }

    public void setNumeroColonne(int numeroColonne){
        this.numeroColonne = numeroColonne;
    }

    public void setToursJoueur (ToursJoueur toursJoueur){
        this.toursJoueur = toursJoueur;
    }

    public char[][] getGrille() {
        return grille;
    }


    public int[] getDernierePositionSuperman() {
        return dernierePositionSuperman;
    }

    public int[] getDernierePositionBatman() {
        return dernierePositionBatman;
    }


    public String getGagnant() {
        return gagnant;
    }
}
