package automation.jlweb.tasks;

import automation.jlweb.model.TelephoneType;
import automation.jlweb.ui.AddCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterContactInfo implements Task {

    private final String firstName;
    private final String lastName;
    private final String telephoneCountry;
    private final String telephoneNumber;
    private final String email;
    private final String jobPosition;

    public EnterContactInfo(String firstName, String lastName, String telephoneCountry, String telephoneNumber
            , String email, String jobPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneCountry = telephoneCountry;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.jobPosition = jobPosition;
    }


    @Step("{0} enters contact info")
    public <T extends Actor> void performAs(T actor) {
        if (firstName!= null)
            actor.attemptsTo(Enter.keyValues(firstName).into(AddCustomerPage.CONTACTFIRSTNAME));
        if (lastName!=null)
            actor.attemptsTo(Enter.keyValues(lastName).into(AddCustomerPage.CONTACTLASTNAME));
        if (telephoneNumber!=null)
            actor.attemptsTo(EnterPhoneNumber.with(telephoneNumber,AddCustomerPage.CONTACTTELEPHONETXT,AddCustomerPage.CONTACTTELEPHONECOUNTRYBTN, telephoneCountry, TelephoneType.CONTACT_TELEPHONE));
        if (email!=null)
            actor.attemptsTo(Enter.keyValues(email).into(AddCustomerPage.CONTACTEMAIL));
        if(jobPosition!=null)
            actor.attemptsTo(Enter.keyValues(jobPosition).into(AddCustomerPage.CONTACTPOSITIONTXT));

    }

    public static Performable with(String firstName, String lastName, String telephoneCountry, String telephoneNumber
            , String email, String jobPosition) {

        return instrumented(EnterContactInfo.class,firstName,lastName, telephoneCountry,
                telephoneNumber,email,jobPosition);
    }
}
