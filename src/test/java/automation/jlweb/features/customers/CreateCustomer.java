package automation.jlweb.features.customers;
import automation.jlweb.actions.NavigateToPage;
import automation.jlweb.features.Hook;
import automation.jlweb.model.Category;
import automation.jlweb.model.CustomerType;
import automation.jlweb.model.SubCategory;
import automation.jlweb.tasks.*;
import automation.jlweb.ui.AddCustomerPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import automation.utils.*;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class CreateCustomer extends Hook {

    Actor anna = Actor.named("Thuong-live");
    SubCategory subCategory;
    String[] tagValues= {"edit tag"};

    @Managed
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb(){
        initialize(anna.getName());
        System.out.println(country);
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void create_customer_with_no_contact_from_customer_page() {
        CustomerFakeData customerFakeData = new CustomerFakeData(country);
        givenThat(anna).wasAbleTo(OpenTheApplication.with(url));
        when(anna).attemptsTo(LoginJLWeb.withTheCredentials(username,password));
        and(anna).attemptsTo(
                            NavigateToPage.withMenu(Category.CUSTOMERS.getName()).selectItem(SubCategory.ADDCUSTOMER.getName()),

                            AddTags.with(tagValues, AddCustomerPage.CUSTOMERTAGTXT,AddCustomerPage.ADDTAGBTN),

                            EnterCustomerInfo.with(CustomerFakeData.getName(),
                                                    CustomerFakeData.getAddress1(),
                                                    CustomerFakeData.getAddress2(),
                                                    CustomerFakeData.getAddress3(),
                                                    CustomerFakeData.getAddress4(),
                                                    CustomerFakeData.getZipCode(),
                                                    CustomerFakeData.getCountry(),
                                                    CustomerFakeData.getPhoneNumber(),
                                                    CustomerType.COMMERCIAL.getName(),
                                                    CustomerFakeData.getReferenceNumber(),
                                                    "All Chargeable Works"),

                            EnterContactInfo.with( CustomerFakeData.getFirstName(),
                                                    CustomerFakeData.getLastName(),
                                                    CustomerFakeData.getCountry(),
                                                    CustomerFakeData.getPhoneNumber(),
                                                    CustomerFakeData.getEmail(),
                                                    "CEO"),

                            SelectButton.of(AddCustomerPage.CANCELBTN)

                            );
    }
}