package automation.jlweb.tasks;

import automation.jlweb.model.Category;
import automation.jlweb.model.SubCategory;
import automation.jlweb.ui.NavigationBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToSubCategory implements Task {

    private final String subCategory;

    protected NavigateToSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Step("{0} navigates to the #subCategory sub-category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NavigationBar.subCategory(subCategory))
        );
    }
    public static Performable with(String subCategory) {
        return instrumented(NavigateToSubCategory.class, subCategory);
    }
}
