package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;
    private final String nom;
    private final ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        ModuleInfo matu = new ModuleInfo("Matu");
        for (int i = 0; i < 3; i++) {
            modules[i] = matu;
        }
    }

    public boolean planifierModule(ModuleInfo module) {
        boolean estPlanifier = false;
        int trou = 0;
        if (module != null) {
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] == null) {
                    trou++;
                }

            }
            if (trou >= 3) {
                trou = 0;
                for (int i = 0; i < modules.length; i++) {

                    if (modules[i] == null) {
                        module = modules[i];
                        trou++;
                        if (trou >= 3) {
                            break;
                        }
                    }
                }
            }
        }

        return estPlanifier;
    }

    public void afficherHoraire() {
        for (int i = 0; i < modules.length; i++) {
            // System.out.println();
            // System.out.println(nom);
            // System.out.println("--------------");
            // for (int i = 0; i < modules.length; i += 2) {
            // System.out.println(DayOfWeek.values()[i / 2].getDisplayName(TextStyle.FULL,
            // Locale.FRANCE));
            // System.out.println(" matin : " + modules[i]);
            // System.out.println(" après-midi: " + modules[i + 1]);
            // }
            // System.out.println();
        }
    }

    public boolean estTotalementPlanifie() {
        boolean estRemplie = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] != null) {
                estRemplie = true;
            }
        }

        return estRemplie;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean estPresent = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i].equals(module)) {// if (modules[i] == module) {
                estPresent = true;
            }
        }
        return estPresent;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
