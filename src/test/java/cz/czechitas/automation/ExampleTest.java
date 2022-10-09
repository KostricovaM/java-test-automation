package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * TODO: JavaDoc
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class ExampleTest extends TestRunner
{
    @Test
    void overKontaktniWwwAdresu() {
        firefox.jdiDoSekceKontakt();
        firefox.overAdresuWwwStranky("www.czechitas.cz");
    }

    @Test
    void overUspesnePrihlaseni() {
        firefox.klikniNaTlacitkoPrihlasit();
        firefox.vyplnEmail("admin@czechitas-app.loc");
        firefox.vyplnHeslo("Czechitas123");
        firefox.provedPrihlaseni();
        firefox.overPrihlaseniUzivatele();
        //TODO: Assert separe
        //TODO: WebDriver manager pro stazeni odpovidajich driveru
    }
}
