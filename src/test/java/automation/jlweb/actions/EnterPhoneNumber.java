package automation.jlweb.actions;

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
    private String telephoneNumber;
    private Target telephoneFieldTarget;

    public EnterPhoneNumber(String telephoneNumber, Target telephoneFieldTarget) {
        this.telephoneNumber = telephoneNumber;
        this.telephoneFieldTarget = telephoneFieldTarget;
    }


    @Step("{0} enters #country telephone with number #telephoneNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.keyValues(telephoneNumber).into(telephoneFieldTarget).thenHit(TAB));
    }
    public static EnterPhoneNumber on(Target telephoneFieldTarget) {
        return instrumented(EnterPhoneNumber.class, telephoneFieldTarget);
    }
    public EnterPhoneNumber withValue(String telephoneNumber) {
        this.telephoneNumber=telephoneNumber;
        return this;
    }

}
