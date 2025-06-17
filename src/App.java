
import models.*;
import services.*;

public class App {

    public static final String[] NOMS_MODULES = { "G300", "187", "162", "123", "293", "117", "164", "216", "106", "231",
            "122", "431" };

    public static void main(String[] args) {
        Horaire horaire = new Horaire();
        ModuleInfo[] modules1ere = new ModuleInfo[12];

        modules1ere[0] = new ModuleInfo(NOMS_MODULES[0]);
        modules1ere[1] = new ModuleInfo(NOMS_MODULES[1]);
        modules1ere[2] = new ModuleInfo(NOMS_MODULES[2]);
        modules1ere[3] = new ModuleInfo(NOMS_MODULES[3]);
        modules1ere[4] = new ModuleInfo(NOMS_MODULES[4]);
        modules1ere[5] = new ModuleInfo(NOMS_MODULES[5]);
        modules1ere[6] = new ModuleInfo(NOMS_MODULES[6]);
        modules1ere[7] = new ModuleInfo(NOMS_MODULES[7]);
        modules1ere[8] = new ModuleInfo(NOMS_MODULES[8]);
        modules1ere[9] = new ModuleInfo(NOMS_MODULES[9]);
        modules1ere[10] = new ModuleInfo(NOMS_MODULES[10]);
        modules1ere[11] = new ModuleInfo(NOMS_MODULES[11]);
        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("WICK", "John");
        profs[1] = new Professeur("SWIFT", "Taylor");
        profs[2] = new Professeur("CROFT", "Lara");
        profs[3] = new Professeur("SKYWALKER", "Anakin");
        profs[4] = new Professeur("RICHARD", "Jean-marc");
        // je suis pas loin mais ça suffit pas je pense
        // pas de e3 je vous en prie
        do {
            ServiceFormationMaitres.attribuerModules(profs, modules1ere);
        } while (ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere));

        System.out.println("l'ecole a engagé les professeurs suivants");
        for (int i = 0; i < profs.length; i++) {
            System.out.print("-" + profs[i] + " peut enseigner les modules  :");
            ModuleInfo[] moduleDuProf = profs[i].getModulesEnseignes();

            for (int j = 0; j < moduleDuProf.length; j++) {
                System.out.println(" " + moduleDuProf[j].getNom());

            }
            System.out.println();
        }
        System.out.println("il est temp de preparer l'horaire");
        boolean reussi = horaire.planifier(modules1ere, profs);
        if (reussi) {
            System.out.println("Modules planifier avec succès!");
            horaire.afficherHoraire();
        } else if (!reussi) {
            System.out.println("probleme de planification");
        }

    }

}
