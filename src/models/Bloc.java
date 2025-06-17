package models;

public class Bloc {
    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;
    private final String nom;
    private final ModuleInfo[] modules;
    private final ModuleInfo matu;

    public Bloc(String nom) {
        this.nom = nom;
        modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        matu = new ModuleInfo("Matu");
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
            if (modules[i].equals(module)) {
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
