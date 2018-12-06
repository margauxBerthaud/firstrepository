/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    public HashSet<Plongeur> lesPlongeurs = new HashSet<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        lesPlongeurs.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        int conforme = 0;
        for(Plongeur p : lesPlongeurs){
            if(p.licenceValide(date)==true){
                conforme++;
            }
        }
        if(this.chefDePalanquee!=null && conforme==lesPlongeurs.size()){
            return true;
        }
        else{
            return false;
        }
    }

}
