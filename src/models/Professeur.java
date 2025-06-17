package models;

public class Professeur {

    private final String nom;
    private final String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean estEnseigne = false;
        if (nomDuModule != null) {
            for (int i = 0; i < modulesEnseignes.length; i++) {
                if (modulesEnseignes[i].getProfesseur() != null) {
                    estEnseigne = true;
                    break;
                }
            }
        }
        return estEnseigne;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {

        if (module != null) {
            modulesEnseignes = new ModuleInfo[modulesEnseignes.length + 1];
            for (int i = 0; i < modulesEnseignes.length; i++) {
                if (modulesEnseignes[i] == null) {
                    modulesEnseignes[i] = module;
                    module.setProfesseur(modulesEnseignes[i].getProfesseur());
                }

            }
        }
    }

    public void viderModules() {
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = null;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

}
