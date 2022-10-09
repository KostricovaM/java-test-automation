package cz.czechitas.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.util.Objects;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class SeleniumAction {

    private final WebDriver driver;

    public SeleniumAction(@Nonnull WebDriver driver) {
        this.driver = Objects.requireNonNull(driver);
    }

    void jdiDoSekceKontakt() {
        var agreeButton = findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        agreeButton.click();
    }

    void overAdresuWwwStranky(String wwwAdresa) {
        var url = findByXPath("/html/body/div/div/div/div/div/div/div/div[1]/p[2]/a");
        assertThat(url.getText()).isEqualTo(wwwAdresa);
    }

    void klikniNaTlacitkoPrihlasit() {
        var loginButton = findByXPath("/html/body/div/header/nav/div/div[2]/a");
        loginButton.click();
    }

    void vyplnEmail(String email) {
        var emailInputBox = findByXPath("//*[@id=\"email\"]");
        emailInputBox.sendKeys(email);
    }

    void vyplnHeslo(String heslo) {
        var passwordInputBox = findByXPath("//*[@id=\"password\"]");
        passwordInputBox.sendKeys(heslo);
    }

    void provedPrihlaseni() {
        var loginButton = findByXPath("/html/body/div/div/div/div/div/div/form/div[3]/div/button");
        loginButton.click();
    }

    void overPrihlaseniUzivatele() {
        var loggedInText = findByXPath("/html/body/div/header/nav[1]/div/div[2]/div/span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }

    @Nonnull
    private WebElement findByXPath(String xpathExpression) {
        return driver.findElement(By.xpath(xpathExpression));
    }
}
