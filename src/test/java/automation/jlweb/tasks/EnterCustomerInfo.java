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

    private final Category category;

    protected EnterCustomerInfo(Category category) {
        this.category = category;
    }

    @Step("{0} navigates to the #category category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NavigationBar.category(category))
        );
    }
    public static Performable theCategory(Category category) {
        return instrumented(EnterCustomerInfo.class, category);
    }
}
