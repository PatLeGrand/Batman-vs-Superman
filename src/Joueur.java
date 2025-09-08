public class Joueur {
    private String nom;
    private char lettreJoueur;
    private boolean competence1Utilisee = false;
    private boolean competence2Utilisee = false;

    public Joueur (String nom, char lettreJoueur){
        this.nom = nom;
        this.lettreJoueur = lettreJoueur;
    }
    public boolean isCompetence1Utilisee() {
        return competence1Utilisee;
    }

    public void setCompetence1Utilisee(boolean competence1Utilisee) {
        this.competence1Utilisee = competence1Utilisee;
    }

    public boolean isCompetence2Utilisee() {
        return competence2Utilisee;
    }

    public void setCompetence2Utilisee(boolean competence2Utilisee) {
        this.competence2Utilisee = competence2Utilisee;
    }

    char getLettreJoueur () {
        return lettreJoueur;
    }

    String getNom () {
        return nom;
    }
}
