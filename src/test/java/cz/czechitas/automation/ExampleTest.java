package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Example test class for functionality showcase
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class ExampleTest extends TestRunner {

    @Test
    void overKontaktniWwwAdresu() {
        prohlizec.horniMenu.jdiDoSekceKontakt();
        overeni.overAdresuWwwStranky("www.czechitas.cz");
    }

    @Test
    void overUspesnePrihlaseni() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("admin@czechitas-app.loc");
        prohlizec.prihlasovani.vyplnHeslo("Czechitas123");
        prohlizec.prihlasovani.provedPrihlaseni();
        overeni.overPrihlaseniUzivatele();
    }

    @Test
    void _X1vyplnHeslo() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vypEmail("admin@czechitas-app.loc");
        prohlizec.prihlasovani.vypHeslo("Czechitas123");
        prohlizec.cekejNekolikVterin(3);
        prohlizec.prihlasovani.klikniNaPrihlasit();
        prohlizec.cekejNekolikVterin(3);
    }

    @Test
    void _X2overUrlOdkazu() {
        prohlizec.horniMenu.jdiDoSekceNavodyAFormulareProUcitele();
        overeni.sekcePrihlasky.overSpravnyodkazNavodyProUcitele("https://google.com/");
}
    @Test
    void _1NavigaceOpakovani() {
        prohlizec.horniMenu.jdiDoSekceObjednavkaProMSZS();
        prohlizec.sekceObjednavky.vyplnICO("00023337");
        prohlizec.sekceObjednavky.vyberMoznostSkolaVPrirode();
        prohlizec.sekceObjednavky.vyplnPocetDeti(5);
}
    @Test
    void _1AsertaceOpakovani() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vypEmail("marketa@seznam.cz");
        prohlizec.prihlasovani.vypHeslo("Marketa123");
        prohlizec.cekejNekolikVterin(2);
        prohlizec.prihlasovani.klikniNaPrihlasit();
        overeni.sekcePrihlasky.overExistenciSloupce("Jméno");
        overeni.sekcePrihlasky.overExistenciSloupce("Kategorie");
}
    @Test
    void _1KomplexnejsiTextyVytvorPrihlasku() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vypEmail("marketa@seznam.cz");
        prohlizec.prihlasovani.vypHeslo("Marketa123");
        prohlizec.cekejNekolikVterin(2);
        prohlizec.prihlasovani.klikniNaPrihlasit();
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlasku();
        prohlizec.detailPrihlasky.vyberTermin("21.11.-30.11.2022");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Tyna");
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka("Kostricova");
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("30.11.2016");
        prohlizec.detailPrihlasky.vyplnPoznamku("Moje poznamka");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami(); //nebylo definováno v zadání, ale nez tohoto pole nelze přihlášku vytvořit
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();
    }
    @Test
    void _1KomplexnejsiTextyKontrolaPrihlasky() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vypEmail("marketa@seznam.cz");
        prohlizec.prihlasovani.vypHeslo("Marketa123");
        prohlizec.cekejNekolikVterin(2);
        prohlizec.prihlasovani.provedPrihlaseni();
        overeni.detailPrihlasky.overTermin("21.11. - 30.11.2022");
        overeni.detailPrihlasky.overKrestniJmeno("Tyna");
        overeni.detailPrihlasky.overPrijmeni("Kostricova");
        overeni.detailPrihlasky.overDatumNarozeni("30.11.2016");
        overeni.detailPrihlasky.overPoznamku("Moje poznamka");

    }
    @Test
    void _1DUAutomatizace() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vypEmail("jan.novotny@seznam.cz");
        prohlizec.prihlasovani.vypHeslo("Czechitas123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlaskuJavy(); //automaticky klikal na 1., vytvořila jsem odkaz na 2.
        prohlizec.detailPrihlasky.vyberTermin("09.01. - 13.01.2023");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Tom");
        //prohlizec.vygenerujNahodnePrijmeni(98);
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka(prohlizec.vygenerujNahodnePrijmeni(10));
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("16.11.2014");
        prohlizec.detailPrihlasky.vyplnPoznamku("Je hodný.");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami(); //nebylo definováno v zadání, ale nez tohoto pole nelze přihlášku vytvořit
        prohlizec.cekejNekolikVterin(2);
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();
    }
        @Test
        void _2DUAutomatizaceOvereni() {
            prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
            prohlizec.prihlasovani.vypEmail("jan.novotny@seznam.cz");
            prohlizec.prihlasovani.vypHeslo("Czechitas123");
            prohlizec.prihlasovani.provedPrihlaseni();
            overeni.overTlacitkoDetail();
            prohlizec.profil.otevriProfil();
            overeni.overJmenoPrihlaseneho();
            prohlizec.horniMenu.jdiDoSekceKontaktOprava();//puvodni odkazoval na Prihlasky, proto vytvoren novy
            overeni.overAdresuKontaktu();
    }
}
