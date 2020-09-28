package automation.jlweb.actions;

import automation.jlweb.model.TelephoneType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectPhoneCountry implements Task {
    private Target countryListTarget;
    private String country;
    private TelephoneType telephoneType; //type = CONTACT_TELEPHONE or TELEPHONE

    public SelectPhoneCountry(Target countryListTarget, String country, TelephoneType telephoneType) {
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
    }
    public static SelectPhoneCountry on(Target countryListTarget) {
        return instrumented(SelectPhoneCountry.class, countryListTarget);
    }
    public SelectPhoneCountry withValue(String country) {
        this.country=country;
        return this;
    }
    public SelectPhoneCountry forType(TelephoneType telephoneType) {
        this.telephoneType=telephoneType;
        return this;
    }

}
