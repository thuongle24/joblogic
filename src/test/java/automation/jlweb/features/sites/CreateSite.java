package automation.jlweb.features.sites;

import automation.jlweb.actions.NavigateToPage;
import automation.jlweb.model.Category;
import automation.jlweb.model.SubCategory;
import automation.jlweb.tasks.*;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.and;

@RunWith(SerenityRunner.class)
public class CreateSite {
    Actor anna = Actor.named("Anna");
    SubCategory subCategory;
    String[] tagValues= {"edit tag"};

    @Managed(driver = "chrome",options = "--whitelisted-ips")
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void create_site_from_site_page() {

        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(LoginJLWeb.withTheCredentials("lienn-live@joblogic.com","1"));
        and(anna).attemptsTo(NavigateToPage.withMenu(Category.SITES.getName()).selectItem(SubCategory.ADDSITE.getName()));
        and(anna).attemptsTo(
                EnterSiteInfo
                        .withCustomer("Candy Crush")
                        .withSite("TESTSITE091420")

        );
    }
}
