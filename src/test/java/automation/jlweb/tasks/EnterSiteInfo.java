package automation.jlweb.tasks;

import automation.jlweb.actions.UpdateTextFieldValue;
import automation.jlweb.ui.AddSitePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Settable;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterSiteInfo implements Performable {

    private final String customer;
    String site;

    public EnterSiteInfo(String customer){
        this.customer = customer;
    }

    public static Settable customer() { return instrumented(UpdateTextFieldValue.class, AddSitePage.DDCUSTOMER); }
    public static Settable site() { return instrumented(UpdateTextFieldValue.class, AddSitePage.TXTSITE);
    }

    public static EnterSiteInfo withCustomer(String customer) {
        return instrumented(EnterSiteInfo.class, customer);
    }

    public EnterSiteInfo withSite(String site) {
        this.site = site;
        return this;
    }

    @Step("{0} Add New Site for a customer")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterSiteInfo.customer().to(customer),
                EnterSiteInfo.site().to(site),
                Click.on(AddSitePage.BTNSAVE)
        );

    }
}
