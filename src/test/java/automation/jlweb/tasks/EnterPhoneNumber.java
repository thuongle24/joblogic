package automation.jlweb.tasks;

import automation.jlweb.model.TelephoneType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.TAB;

public class EnterPhoneNumber implements Task {
    private final String telephoneNumber;
    private final Target telephoneFieldTarget;
    private final Target countryListTarget;
    private final String country;
    private final TelephoneType telephoneType; //type = CONTACT_TELEPHONE or TELEPHONE

    public EnterPhoneNumber(String telephoneNumber, Target telephoneFieldTarget,
                            Target countryListTarget, String country, TelephoneType telephoneType) {
        this.telephoneNumber = telephoneNumber;
        this.telephoneFieldTarget = telephoneFieldTarget;
        this.countryListTarget = countryListTarget;
        this.country = country;
        this.telephoneType = telephoneType;
    }


    @Step("{0} enters #country telephone with number #telephoneNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(countryListTarget));
        if(country!=null) {
            if (telephoneType.equals(TelephoneType.TELEPHONE)) {
                actor.attemptsTo(Scroll.to(By.xpath("//input[@id='Telephone']/preceding-sibling::div//span[text()='" + country + "']")));
                actor.attemptsTo(Click.on(By.xpath("//input[@id='Telephone']/preceding-sibling::div//span[text()='" + country + "']")));
            } else if (telephoneType.equals(TelephoneType.CONTACT_TELEPHONE)) {
                actor.attemptsTo(Scroll.to(By.xpath("//input[@id='ContactTelephone']/preceding-sibling::div//span[text()='" + country + "']")));
                actor.attemptsTo(Click.on(By.xpath("//input[@id='ContactTelephone']/preceding-sibling::div//span[text()='" + country + "']")));
            }
        }
        actor.attemptsTo(Enter.keyValues(telephoneNumber).into(telephoneFieldTarget).thenHit(TAB));
    }
    public static Performable with(String telephoneNumber, Target telephoneFieldTarget, Target countryListTarget, String country, TelephoneType telephoneType) {
        return instrumented(EnterPhoneNumber.class, telephoneNumber, telephoneFieldTarget, countryListTarget, country, telephoneType);
    }

}
