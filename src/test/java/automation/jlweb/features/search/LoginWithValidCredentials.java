package automation.jlweb.features.search;

import automation.jlweb.tasks.LoginJLWeb;
import automation.jlweb.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class LoginWithValidCredentials {

    Actor anna = Actor.named("Anna");

    @Managed(driver = "chrome",options = "--whitelisted-ips")
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void login_with_valid_credentials_should_show_home_page() {

        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(LoginJLWeb.withTheCredentials("thuongl@joblogic.com","1"));
        then(anna).should(eventually(seeThat(TheWebPage.title(), equalToIgnoringWhiteSpace("Dashboard - Joblogic"))));
    }
}