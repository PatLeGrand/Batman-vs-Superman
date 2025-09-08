import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private TesterEntrees tester;
    private boolean continuer = true;
    private boolean modeIA;

    public Menu() {
        scanner = new Scanner(System.in);
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
                    Game jeu = new Game(false);
                    jeu.jouer();
                    modeIA = false;
                    break;
                case 2:
                    Game jeuIA = new Game(true);
                    jeuIA.jouer();
                    modeIA = true;
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
    public boolean getModeIA() {
        return modeIA;
    }
}


