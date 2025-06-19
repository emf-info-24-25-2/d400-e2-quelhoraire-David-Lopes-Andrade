package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Horaire {
    public static int NBRE_DE_BLOCS = 6;
    private Bloc[] blocs;

    public Horaire() {
        String resultat = "";
        blocs = new Bloc[NBRE_DE_BLOCS];
        for (int i = 0; i < blocs.length; i++) {
            resultat = "B" + blocs[i] + "S" + blocs[i];
        }
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean reussi = false;
        if (modules != null) {
            for (int i = 0; i < modules.length; i++) {
                if (profs[i] != null && !profs[i].enseigneCeModule(modules[i].getNom())) {
                    profs[i].enseigneCeModule(modules[i].getNom());
                    modules[i].setProfesseur(profs[i]);
                    reussi = true;

                }
            }
        }

        /*
         * boolean moduleSansProf = false;
         * boolean moduleSansPlace = false;
         * 
         * // pour chaque module
         * for (int i = 0; i < modules.length; i++) {
         * 
         * // trouver et assigner un professeur
         * boolean professeurDisponible = false;
         * for (int j = 0; j < profs.length; j++) {
         * if (profs[j].enseigneCeModule(modules[i].getNom())) {
         * 
         * modules[i].setProfesseur(profs[j]);
         * professeurDisponible = true;
         * break;
         * }
         * ce bout de code ou on
         * doit prendre les profs de la boucle j avec les mdoules de la boucle i jamais
         * je fais ça en eval
         * 
         * 
         * 
         * }
         * if (!professeurDisponible) {
         * moduleSansProf = true;
         * continue;
         * }
         * 
         * // trouver une plage horaire
         * for (int j = 0; j < blocs.length; j++) {
         * if (blocs[j].planifierModule(modules[i])) {
         * break;
         * } else if (j == blocs.length - 1) {
         * moduleSansPlace = true;
         * }
         * }
         * 
         * }
         * return !moduleSansProf && !moduleSansPlace;
         * }
         */

        return reussi;
    }

    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            DayOfWeek.values()[i / 2].getDisplayName(TextStyle.FULL, Locale.FRANCE);
        }
    }

    public Bloc moduleDansQuelleBloc(ModuleInfo module) {
        return null;
    }
}
