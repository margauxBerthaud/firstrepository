package FFSSM;

import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne {

    private int niveau;
    private HashSet<Licence> lesLicences = new HashSet<>();
    private GroupeSanguin gs;

    public Plongeur(int niveau, GroupeSanguin gs, String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.gs = gs;
    }

    public void ajouterLicence(Licence lic) {
        lesLicences.add(lic);
    }
    
        public boolean licenceValide(Calendar d){
        boolean valide = false;
        for(Licence l : lesLicences){
            if(l.estValide(d)){
                valide = true;
            }
        }
        return valide;
    }
    
}
