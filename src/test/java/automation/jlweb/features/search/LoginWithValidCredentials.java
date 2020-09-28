package automation.jlweb.features.search;

import automation.jlweb.features.Hook;
import automation.jlweb.tasks.LoginJLWeb;
import automation.jlweb.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class LoginWithValidCredentials extends Hook {

    Actor anna = Actor.named("Anna");
    @Managed
    public WebDriver driver;

    @Before
    public void annaCanBrowseTheWeb() {
        initialize(anna.getName());
        anna.can(BrowseTheWeb.with(driver));
    }

    @Test
    public void login_with_valid_credentials_should_show_home_page() {
        givenThat(anna).wasAbleTo(OpenTheApplication.with(url));
        when(anna).attemptsTo(LoginJLWeb.withTheCredentials(username,password));
        then(anna).should(eventually(seeThat(TheWebPage.title(), equalToIgnoringWhiteSpace("Dashboard - Joblogic"))));
    }
}