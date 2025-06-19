package models;

public class ModuleInfo {
    private final String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        professeur = null;
    }

    public String getNom() {
        return nom + " ";
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        String resultat;
=======
        String resultat = "";
>>>>>>> 1ab3e3992d055c39e037a16b8aecdd2d65b42e8d
        if (professeur != null) {
            resultat = nom + " avec " + professeur;
        }
        resultat = nom;
        return resultat;
    }

}
