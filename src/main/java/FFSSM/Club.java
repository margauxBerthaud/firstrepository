/**margaux
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    private HashSet<Plongee> plongeesNonConformes = new HashSet<>();
    
    private HashSet<Plongee> plongeesConformes = new HashSet<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
        return plongeesNonConformes;
    }

    public void organisePlongee(Plongee p) {
        if (p.estConforme()) {
            plongeesConformes.add(p);
        } else {
            plongeesNonConformes.add(p);
        }
    }

    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
