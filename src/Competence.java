import java.util.Random;

public class Competence {
    private Grille grille;
    private TesterEntrees tester ;
    private boolean batmanBatarangUtilisee = false;

    public Competence(Grille grille) {
        this.grille = grille;
        this.tester = new TesterEntrees(grille);
    }

    public void supermanHighSpeed (ToursJoueur player){
        System.out.println("Vous avez activé High speed pour jouer 2 fois");
        player.jouerTour();
        if (!grille.statutJeu()){
            return;
        }
        player.jouerTour();
        System.out.println("Superman a sctivé High speed pour jouer 2 fois");

    }

    public void supermanHeatVison (ToursJoueur player){
        System.out.println("Vous avez activé la Heat vison pour détruire un symbole de Batman" +
                " Veillez d'abord placer votre symbole, ensuite vous pourrier détruire un symbole de Batman");
        player.jouerTour();
        System.out.println("Veillez selectionner le symbole de Batman a detruire");
        tester.validerPosionHeatVision();
        grille.remplirGrilleHeatVision();
        grille.afficherGrille();
        System.out.println("Superman a détruit un symbole de Batman");

    }

    public void batmanBatarang (ToursJoueur player){
        int nouvellePositionI, nouvellePositionJ;
        System.out.println("Vous avez activé la capacité Batarang pour détrure le symbole joué par superman, une fois que " +
                "aurz joué, son symbole sera détruit");
        System.out.println("Veillez poser votre symbole");
        player.jouerTour();
        if (grille.verifierGrille()) {
            int[] positionDernierS = grille.getDernierePositionSuperman();
            if (positionDernierS == null) {
                System.out.println("Superman n'a pas encore joué, " +
                        "vous ne pouvez pas relocaliser son dernier symbole");
                return;
            }
            grille.getGrille()[positionDernierS[0]][positionDernierS[1]] = ' ';
            Random random = new Random();
            do {
                nouvellePositionI = random.nextInt(4);
                nouvellePositionJ = random.nextInt(4);
            } while (grille.getGrille()[nouvellePositionI][nouvellePositionJ] != ' ');

            grille.getGrille()[nouvellePositionI][nouvellePositionJ] = 'S';
            batmanBatarangUtilisee = true;
            System.out.println("Batman a utilisé le Batarang ! Le dernier symbole de Superman a été déplacé.");
            grille.afficherGrille();

        }

    }

    public void batmanTactician(ToursJoueur player) {
        int ligneS, colonneS, ligneB, colonneB;
                if (!grille.presenceSymboleSuperman()) {
            System.out.println("Aucun symbole de Superman sur la grille. Compétence Tactician non utilisable.");
            return;
        }
        System.out.println("Vous avez choisi la compétence Tactican de batman pour poser votre symbole et l'echanger avec un symbole de superman \n" +
                "Veillez poser votre synbole dans un premier temps");
        player.jouerTour();
        if (!grille.statutJeu()) {
            return;
        }

        ligneB = grille.getNumeroLigne();
        colonneB = grille.getNumeroColonne();

        System.out.println("Veuillez sélectionner un symbole de Superman à échanger");
        tester.validerPositionTactician();

        ligneS = tester.getLigneSelectionnee();
        colonneS = tester.getColonneSelectionnee();

        grille.echangerSymboles(ligneB, colonneB, ligneS, colonneS);
        grille.afficherGrille();
    }
    public boolean getBatmanBatarangUtilisee(){
        return batmanBatarangUtilisee;
    }

}
