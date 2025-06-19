package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        int max = modules.length - 1;
        int min = 0;

        for (int i = 0; i < professeurs.length; i++) {
            int indexModule = (int) (Math.random() * (max - min + 1)) + min;

            if (professeurs[i].enseigneCeModule(modules[indexModule].getNom())) {
                continue;
            } else {
                professeurs[i].ajouterModuleEnseigne(modules[indexModule]);
            }

        }
    }

    public static boolean tousModulesCouverts(Professeur[] professeurs, ModuleInfo[] modules) {
        boolean estCouvert = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i].getProfesseur() != null) {
                estCouvert = true;
            }
        }
        return estCouvert;
    }
}
/*
 * public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[]
 * modules) {
 * boolean ressourcesSuffisantes = true;
 * 
 * for (int i = 0; i < modules.length; i++) {
 * boolean moduleCouvert = false;
 * for (int j = 0; j < profs.length; j++) {
 * if (profs[j].enseigneCeModule(modules[i].getNom())) {
 * moduleCouvert = true;
 * break;
 * }
 * }
 * if (!moduleCouvert) {
 * ressourcesSuffisantes = false;
 * }
 * }
 * return ressourcesSuffisantes;
 * }
 * }
 */
