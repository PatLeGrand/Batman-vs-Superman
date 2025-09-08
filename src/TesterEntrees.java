import java.util.Scanner;

public class TesterEntrees {
    Scanner sc = new Scanner(System.in);
    private Grille grille;
    private int ligneSelectionnee;
    private int colonneSelectionnee;


    public TesterEntrees(Grille grille) {
        this.grille = grille;
    }

    public void validerRemplissageLigne(){

        System.out.println("Veillez entrer le numéro de la ligne");
        while(!sc.hasNextInt()){
            System.out.println("Veillez entrer un nombre");
            sc.nextLine();
        }
        grille.setNumeroLigne(sc.nextInt());
        while (grille.getNumeroLigne() < 0 || grille.getNumeroLigne() > 3) {
            System.out.println("Veillez entrer un numéro de ligne correct entre 0 et 3");
            sc.nextLine();
            while(!sc.hasNextInt()){
                System.out.println("Veillez entrer un nombre");
                sc.nextLine();
            }
            grille.setNumeroLigne(sc.nextInt());
        }
    }

    public void validerRemplissageColonne(){
        grille.getNumeroColonne();
        System.out.println("Veillez entrer le numéro de la colonne");
        while(!sc.hasNextInt()){
            System.out.println("Veillez entrer un nombre");
            sc.nextLine();
        }
        grille.setNumeroColonne(sc.nextInt());
        while (grille.getNumeroColonne() < 0 || grille.getNumeroLigne() > 3) {
            System.out.println("Veillez entrer un numéro de ligne correct entre 0 et 3");
            sc.nextLine();
            while(!sc.hasNextInt()){
                System.out.println("Veillez entrer un nombre");
                sc.nextLine();
            }
            grille.setNumeroColonne(sc.nextInt());
        }
    }

    public void validerPosition() {
     do    {
            validerRemplissageLigne();
            validerRemplissageColonne();
             if (grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != ' '){
                 System.out.println("Cette case est déja occupée, veillez en choisir une autre svp");
             }
        } while(grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != ' ');

    }

    public void validerPosionHeatVision () {
        do    {
            validerRemplissageLigne();
            validerRemplissageColonne();
            if (grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != 'B'){
                System.out.println("Veillez choisir une case occupé par Batman svp");
            }
        } while(grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != 'B');

    }

    public int choixMenuPrincipal () {
        int choix;
        while (!sc.hasNextInt()) {
            System.out.println("Veillez entrer un nombre svp");
            sc.nextLine();
        }
        choix = sc.nextInt();
        return choix;
    }
    public int choixPersonnage() {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        boolean choixValide = false;

        while (!choixValide) {
            System.out.print("Votre choix (1 ou 2): ");
            try {
                choix = Integer.parseInt(scanner.nextLine());
                if (choix == 1 || choix == 2) {
                    choixValide = true;
                } else {
                    System.out.println("Veuillez entrer 1 pour Batman ou 2 pour Superman.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        return choix;
    }

    public void validerPositionTactician() {
        do {
            validerRemplissageLigne();
            validerRemplissageColonne();
            if (grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != 'S') {
                System.out.println("Veuillez choisir une case occupée par Superman s'il vous plaît.");
            } else {
                ligneSelectionnee = grille.getNumeroLigne();
                colonneSelectionnee = grille.getNumeroColonne();
                return;
            }
        } while (grille.getGrille()[grille.getNumeroLigne()][grille.getNumeroColonne()] != 'S');
    }

    public int getLigneSelectionnee() {
        return ligneSelectionnee;
    }

    public int getColonneSelectionnee() {
        return colonneSelectionnee;
    }

}
