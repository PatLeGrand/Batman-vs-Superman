public class Game {
    private Grille grille;
    private Joueur joueur1;
    private Joueur joueur2;
    private Competence competence;
    private TesterEntrees tester;
    private boolean modeIA;

    public Game(boolean modeIA) {
        this.modeIA = modeIA;
        grille = new Grille();
        tester = new TesterEntrees(grille);

        choisirPersonnage();

        competence = new Competence(grille);
    }

    private void choisirPersonnage() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║    CHOISISSEZ VOTRE HÉROS  ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ 1. Batman                  ║");
        System.out.println("║ 2. Superman                ║");
        System.out.println("╚════════════════════════════╝");

        int choix = tester.choixPersonnage();

        if (choix == 1) {
            joueur1 = new Joueur("Batman", 'B');
            joueur2 = new Joueur("Superman", 'S');
        } else {
            joueur1 = new Joueur("Superman", 'S');
            joueur2 = new Joueur("Batman", 'B');
        }

        System.out.println("Vous avez choisi: " + joueur1.getNom());
    }

    public void jouer() {
        Joueur joueurActuel = joueur1;
        IA ia = null;
        int choix;
        if (modeIA) {
            ia = new IA(grille, joueur2.getLettreJoueur());
        }

        while (grille.verifierGrille() && grille.statutJeu()) {
            ToursJoueur player = new ToursJoueur(grille, joueurActuel.getLettreJoueur());
            grille.setToursJoueur(player);
            System.out.println(" ");
            System.out.println(joueurActuel.getNom() + ", c'est ton tour");

            if (!modeIA || joueurActuel == joueur1) {
                System.out.println("Choisissez une action :");
                System.out.println("1. Jouer un tour normal");

                if (joueurActuel.getNom().equals("Batman")) {
                    if (!joueurActuel.isCompetence1Utilisee()) {
                        System.out.println("2. Utiliser Batarang");
                    }
                    if (!joueurActuel.isCompetence2Utilisee()) {
                        System.out.println("3. Utiliser Tactician");
                    }
                } else if (joueurActuel.getNom().equals("Superman")) {
                    if (!joueurActuel.isCompetence1Utilisee()) {
                        System.out.println("2. Utiliser High Speed");
                    }
                    if (!joueurActuel.isCompetence2Utilisee()) {
                        System.out.println("3. Utiliser Heat Vision");
                    }
                }

                choix = tester.choixMenuPrincipal();

                if ((choix == 2 && joueurActuel.isCompetence1Utilisee()) ||
                        (choix == 3 && joueurActuel.isCompetence2Utilisee())) {
                    System.out.println("Cette compétence a déjà été utilisée, tour normal par défaut.");
                    choix = 1;
                }

                choixJoueur(choix, player, joueurActuel);
            } else {
                int[] coup = ia.jouerCoup();
                grille.setNumeroLigne(coup[0]);
                grille.setNumeroColonne(coup[1]);
                grille.remplirGrille();
                grille.afficherGrille();
                if (!grille.statutJeu()) break;
                joueurActuel = joueur1;
                continue;
            }

            if(!grille.statutJeu()){
                System.out.println(grille.getGagnant() + " a gagné la partie");
            }

            if (joueurActuel == joueur1) {
                joueurActuel = joueur2;
            } else {
                joueurActuel = joueur1;
            }
        }

        if (!grille.verifierGrille()){
            System.out.println("Match null");
        }
    }

    private void choixJoueur(int choix, ToursJoueur player, Joueur joueurActuel) {
        switch (choix) {
            case 1:
                player.jouerTour();
                break;
            case 2:
                if (joueurActuel.getNom().equals("Batman")) {
                    {
                        competence.batmanBatarang(player);
                        joueurActuel.setCompetence1Utilisee(true);
                        if(!competence.getBatmanBatarangUtilisee()){
                            joueurActuel.setCompetence1Utilisee(false);
                        }
                    }
                } else if (joueurActuel.getNom().equals("Superman")) {
                    competence.supermanHighSpeed(player);
                    joueurActuel.setCompetence1Utilisee(true);
                }
                break;
            case 3:
                if (joueurActuel.getNom().equals("Batman")) {
                    competence.batmanTactician(player);
                    joueurActuel.setCompetence2Utilisee(true);
                } else if (joueurActuel.getNom().equals("Superman")) {
                    competence.supermanHeatVison(player);
                    joueurActuel.setCompetence2Utilisee(true);
                }
                break;
            default:
                System.out.println("Choix invalide, tour normal par défaut.");
                player.jouerTour();
                break;
        }
    }
}