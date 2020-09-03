package automation.jlweb.tasks;

import automation.jlweb.model.Category;
import automation.jlweb.ui.NavigationBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterCustomerInfo implements Task {

    private final String customerName;
    private final String address1;
    private final String address2;
    private final String address3;
    private final String address4;
    private final String postCode;
    private final String telephoneCountry;
    private final String telephoneNumber;
    private final String customerType;
    private final String referenceNumber;
    private final String sellingRate;

    public EnterCustomerInfo(String customerName, String address1, String address2, String address3, String address4,
                             String postCode, String telephoneCountry, String telephoneNumber, String customerType,
                             String referenceNumber, String sellingRate) {
        this.customerName = customerName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.postCode = postCode;
        this.telephoneCountry = telephoneCountry;
        this.telephoneNumber = telephoneNumber;
        this.customerType = customerType;
        this.referenceNumber = referenceNumber;
        this.sellingRate = sellingRate;
    }


    @Step("{0} navigates to the #category category")
    public <T extends Actor> void performAs(T actor) {
    }
    public static Performable theCategory(Category category) {

        return instrumented(EnterCustomerInfo.class, category);
    }
}
