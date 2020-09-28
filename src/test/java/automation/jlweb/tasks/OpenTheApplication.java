package automation.jlweb.tasks;

import automation.jlweb.features.Hook;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.tags.EnvironmentDefinedTags;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import automation.jlweb.ui.GoogleSearchPage;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Optional;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Task {
    //EnvironmentVariables environmentVariables;
    private final String url;
    protected OpenTheApplication(String url) {
        this.url = url;
    }
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
    //    String url =  EnvironmentSpecificConfiguration.from(environmentVariables)
    //            .getProperty("webdriver.base.url");
        actor.attemptsTo(
                Open.url(url)
        );
    }
    public static Performable with(String url) {
        return instrumented(OpenTheApplication.class, url);
    }
}
