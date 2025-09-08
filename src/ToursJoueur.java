public class ToursJoueur {
    private Grille grille;
    private TesterEntrees tester;
    private char lettreJoueur;

    public ToursJoueur(Grille grille, char lettreJoueur) {
        this.grille = grille;
        this.tester = new TesterEntrees(grille);
        this.lettreJoueur = lettreJoueur;
    }

    public void jouerTour() {
        grille.afficherGrille();
        tester.validerPosition();
        grille.remplirGrille();
        grille.afficherGrille();
    }

    public char getLettreJoueur() {
        return lettreJoueur;
    }
}
