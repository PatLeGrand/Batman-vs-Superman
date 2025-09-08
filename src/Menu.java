public class Menu {
    private TesterEntrees tester;
    private boolean continuer = true;

    public Menu() {
        tester = new TesterEntrees(new Grille());
    }

    public int afficherMenuPrincipal() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║      SUPER TIC-TAC-TOE     ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ 1. Joueur contre Joueur    ║");
        System.out.println("║ 2. Joueur contre IA        ║");
        System.out.println("║ 3. Quitter                 ║");
        System.out.println("╚════════════════════════════╝");
        System.out.println("Votre choix : ");

        return tester.choixMenuPrincipal();
    }
    public void start  () {
        while (continuer) {
            int choix = afficherMenuPrincipal();
            switch (choix) {
                case 1:
                    launchGame(false);
                    break;
                case 2:
                    launchGame(true);
                    break;
                case 3:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    private void launchGame(boolean modeAi){
        Game game= new Game(modeAi);
        game.jouer();
    }
}