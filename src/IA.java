public class IA {
        private Grille grille;
        private char lettreIA;

        public IA(Grille grille, char lettreIA) {
            this.grille = grille;
            this.lettreIA = lettreIA;
        }

        public int[] jouerCoup() {
            int[] coupGagnant = rechercherCoupGagnant();
            if (coupGagnant != null) {
                return coupGagnant;
            }

            int[] coupBloquant = rechercherCoupBloquant();
            if (coupBloquant != null) {
                return coupBloquant;
            }

            return jouerCoupStrategique();
        }

        private int[] rechercherCoupGagnant() {

            return rechercherCoupPotentiel(lettreIA);
        }

        private int[] rechercherCoupBloquant() {
            char lettreAdversaire;
            if (lettreIA == 'S') {
                lettreAdversaire = 'B';
            } else {
                lettreAdversaire = 'S';
            }
            return rechercherCoupPotentiel(lettreAdversaire);
        }

        private int[] rechercherCoupPotentiel(char lettre) {
            char[][] grilleActuelle = grille.getGrille();

            for (int i = 0; i < 4; i++) {
                int compteur = 0;
                int colonneVide = -1;
                for (int j = 0; j < 4; j++) {
                    if (grilleActuelle[i][j] == lettre) {
                        compteur++;
                    } else if (grilleActuelle[i][j] == ' ') {
                        colonneVide = j;
                    }
                }
                if (compteur == 3 && colonneVide != -1) {
                    return new int[]{i, colonneVide};
                }
            }

            for (int j = 0; j < 4; j++) {
                int compteur = 0;
                int ligneVide = -1;
                for (int i = 0; i < 4; i++) {
                    if (grilleActuelle[i][j] == lettre) {
                        compteur++;
                    } else if (grilleActuelle[i][j] == ' ') {
                        ligneVide = i;
                    }
                }
                if (compteur == 3 && ligneVide != -1) {
                    return new int[]{ligneVide, j};
                }
            }

            return null;
        }

        private int[] jouerCoupStrategique() {
            char[][] grilleActuelle = grille.getGrille();

            if (grilleActuelle[1][1] == ' ') return new int[]{1, 1};
            if (grilleActuelle[1][2] == ' ') return new int[]{1, 2};
            if (grilleActuelle[2][1] == ' ') return new int[]{2, 1};
            if (grilleActuelle[2][2] == ' ') return new int[]{2, 2};


            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (grilleActuelle[i][j] == ' ') {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }


}
