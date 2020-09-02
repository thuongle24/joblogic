package automation.jlweb.tasks;

import net.bytebuddy.implementation.bytecode.Throw;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.*;

public class AddTags implements Task {
    private final String[] tagValues;
    private final Target tagBoxTarget;
    private final Target addTagTarget;
    protected AddTags(String[] tagValues, Target tagBoxTarget, Target addTagTarget) {
        this.tagValues = tagValues;
        this.tagBoxTarget = tagBoxTarget;
        this.addTagTarget = addTagTarget;
    }

    @Step("{0} tries to add Tag(s) into #tagBoxTarget.getName()")
    public <T extends Actor> void performAs(T actor) {
        int length= tagValues.length;
        if(length>0)
        {
            for(int i=0;i<length;i++)
            {
                actor.attemptsTo(Enter.keyValues(tagValues[i]).into(tagBoxTarget));
                if(addTagTarget.resolveFor(actor).isVisible()== true)
                    actor.attemptsTo(Click.on(addTagTarget));
                else {
                    actor.attemptsTo(Hit.the(Keys.ENTER).into(tagBoxTarget));
                }
            }
        }
        else
            actor.sawAsThe(tagBoxTarget.getName() + " has no value needed to be entered");
    }
    public static Performable with(String[] tagValues, Target tagBoxTarget, Target addTagTarget) {
        return instrumented(AddTags.class, tagValues, tagBoxTarget, addTagTarget);
    }

}
