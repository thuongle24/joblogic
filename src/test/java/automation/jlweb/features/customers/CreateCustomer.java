package automation.jlweb.features.customers;

import automation.jlweb.model.Category;
import automation.jlweb.model.SubCategory;
import automation.jlweb.model.TelephoneType;
import automation.jlweb.tasks.*;
import automation.jlweb.ui.AddCustomerPage;
import automation.jlweb.ui.NavigationBar;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class CreateCustomer {

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
    public void create_customer_with_no_contact_from_customer_page() {

        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(LoginJLWeb.withTheCredentials("thuongl@joblogic.com","1"));
        and(anna).attemptsTo(NavigateToCategory.with(Category.Customers));
        anna.attemptsTo(WaitUntil.the(NavigationBar.subCategory(SubCategory.ADDCUSTOMER.getName()),isVisible()));
        and(anna).attemptsTo(
                            NavigateToSubCategory.with(SubCategory.ADDCUSTOMER.getName()),

                            AddTags.with(tagValues, AddCustomerPage.CUSTOMERTAGTXT,AddCustomerPage.ADDTAGBTN),

                            EnterCustomerInfo.with("Khuong Truong",
                                                    "1A Nguyen Thien Thuat",
                                                    "District 3",
                                                    "Ho Chi Minh",
                                                    "Vietnam",
                                                    "80000",
                                                    "United Kingdom",
                                                    "447476549827",
                                                    "Commercial",
                                                    "2324",
                                                    "All Chargeable Works"),

                            EnterContactInfo.with( "Adam",
                                                    "Lavin",
                                                    "United Kingdom",
                                                    "447476549828",
                                                    "adam@gmail.com",
                                                    "CEO"),

                            SelectButton.of(AddCustomerPage.CANCELBTN)

                            );
    }
}