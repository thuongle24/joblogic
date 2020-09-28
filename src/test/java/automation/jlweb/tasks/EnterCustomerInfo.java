package automation.jlweb.tasks;

import automation.jlweb.actions.EnterPhoneNumber;
import automation.jlweb.actions.SelectPhoneCountry;
import automation.jlweb.model.TelephoneType;
import automation.jlweb.ui.AddCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

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


    @Step("{0} enters customer info")
    public <T extends Actor> void performAs(T actor) {
        if (customerName!= null)
            actor.attemptsTo(Enter.keyValues(customerName).into(AddCustomerPage.CUSTOMERNAMETXT));
        if (address1!=null)
            actor.attemptsTo(Enter.keyValues(address1).into(AddCustomerPage.ADDRESS1TXT));
        if(address2!=null)
            actor.attemptsTo(Enter.keyValues(address2).into(AddCustomerPage.ADDRESS2TXT));
        if(address3!=null)
            actor.attemptsTo(Enter.keyValues(address3).into(AddCustomerPage.ADDRESS3TXT));
        if(address4!=null)
            actor.attemptsTo(Enter.keyValues(address4).into(AddCustomerPage.ADDRESS4TXT));
        if (postCode!=null)
            actor.attemptsTo(Enter.keyValues(postCode).into(AddCustomerPage.ZIPCODETXT));
        if (telephoneNumber!=null)
            actor.attemptsTo(
                            SelectPhoneCountry.on(AddCustomerPage.CUSTOMERTELEPHONECOUNTRYBTN).forType(TelephoneType.TELEPHONE).withValue(telephoneCountry),
                            EnterPhoneNumber.on(AddCustomerPage.TELEPHONETXT).withValue(telephoneNumber)
                            );
        if (customerType!=null)
            actor.attemptsTo(Enter.keyValues(customerType).into(AddCustomerPage.CUSTOMERTYPETXT).thenHit(Keys.TAB));
        if(referenceNumber!=null)
            actor.attemptsTo(Enter.keyValues(referenceNumber).into(AddCustomerPage.REFERENCENUMBERTXT));
        if(sellingRate!=null)
            actor.attemptsTo(Enter.keyValues(sellingRate).into(AddCustomerPage.SELLINGRATETXT).thenHit(Keys.TAB));

    }

    public static Performable with(String customerName, String address1, String address2, String address3, String address4,
                                          String postCode, String telephoneCountry, String telephoneNumber, String customerType,
                                          String referenceNumber, String sellingRate) {

        return instrumented(EnterCustomerInfo.class,customerName,address1,address2,address3,address4,postCode, telephoneCountry,
                telephoneNumber,customerType,referenceNumber,sellingRate);
    }
}
