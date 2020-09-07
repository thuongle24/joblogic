package automation.jlweb.tasks;

import net.bytebuddy.implementation.bytecode.Throw;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;

import java.util.concurrent.Delayed;

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

    @Step("{0} tries to add Tag(s) into #tagBoxTarget")
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
                actor.attemptsTo(Hit.the(Keys.TAB).into(tagBoxTarget));

                //**** this code line is to send a sequence of keys at the same time
                //actor.attemptsTo(Enter.keyValues(Keys.chord(Keys.CONTROL,"a")).into(tagBoxTarget));
            }
        }
        else
            actor.sawAsThe(tagBoxTarget.getName() + " has no value needed to be entered");
    }
    public static Performable with(String[] tagValues, Target tagBoxTarget, Target addTagTarget) {
        return instrumented(AddTags.class, tagValues, tagBoxTarget, addTagTarget);
    }

}
