/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongeur;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FFSMTest {

    public Calendar ddn;
    public Calendar delivrance;
    public Calendar delivrancefausse;
    public Calendar dateval;
    public Licence licenceToto;
    public Licence licenceInvalide;
    public Plongeur pv;
    public Plongeur pf;
    public Moniteur toto;
    public Club club;
    public Personne totoo;
    public Plongee plongee;

    public FFSMTest() {
    }

    @Before
    public void setUp() {
        Calendar ddn = Calendar.getInstance();
        Calendar delivrance = Calendar.getInstance();
        Calendar delivrancefausse = Calendar.getInstance();
        Calendar dateval = Calendar.getInstance();
        dateval.set(2019, 01, 01);
        delivrancefausse.set(2015, 11, 20);
        delivrance.set(2018, 11, 17);
        ddn.set(1988, 11, 2);
        Personne totoo = new Personne("7", "Toto", "Titi", "3 Avenue de la bonne blague ", "01 02 03 04 05", ddn);
        Licence licenceToto = new Licence(totoo, "1", delivrance, 4, club);
        Licence licenceInvalide = new Licence(totoo, "2", delivrancefausse, 2, club);
        Plongeur pv = new Plongeur(2, GroupeSanguin.BMOINS, "2", "Oui", "Oui", "Oui le village", "01 01 01 01 01", ddn);
        Plongeur pf = new Plongeur(3, GroupeSanguin.AMOINS, "8", "Non", "Non", "Non la ville ", "10 10 10 10 10", ddn);
        Moniteur toto = new Moniteur(4, 2, GroupeSanguin.APLUS, "8", "Toto", "Titi", "3 Avenue de la bonne blague ", "01 02 03 04 05", ddn);
        Club club = new Club(toto, "Mon club", "06.08.09.10.11");
        Site StFereol = new Site("StFé","Lac magnifique"); 
        Plongee plongee = new Plongee(StFereol,toto,dateval,10,30);
        licenceToto.setClub();
        this.ddn = ddn;
        this.delivrance = delivrance;
        this.delivrancefausse = delivrancefausse;
        this.totoo = totoo;
        this.licenceToto = licenceToto;
        this.licenceInvalide = licenceInvalide;
        this.pv = pv;
        this.pf = pf;
        this.toto = toto;
        this.club = club;
        this.dateval = dateval;
        this.plongee = plongee;
    }

    @Test
    public void testLicence() {
        assertEquals(true, licenceToto.estValide(dateval));
        assertEquals(false, licenceInvalide.estValide(dateval));
    }

    @Test
    public void testEmbauche() {
        Embauche e = new Embauche(delivrance, toto, club);
        Embauche f = new Embauche(dateval, toto, club);
        Calendar date = Calendar.getInstance();
        date.set(2018, 11, 20);
        e.terminer(date);
        assertEquals(true, e.estTerminee());
        assertEquals(false, f.estTerminee());
    }

    @Test
    public void testMoniteur() {
        assertEquals(null, toto.employeur());
        Calendar date = Calendar.getInstance();
        date.set(2018, 11, 20);
        toto.nouvelleEmbauche(club, date);
        assertEquals(club, toto.employeur());
    }

    @Test
    public void testLicencesValides() {
        assertEquals(true, toto.licenceValide(dateval));
        assertEquals(false, pv.licenceValide(dateval));
    }

}
