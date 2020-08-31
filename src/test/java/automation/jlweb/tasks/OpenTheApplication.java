package automation.jlweb.tasks;

import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import automation.jlweb.ui.GoogleSearchPage;
import net.thucydides.core.util.EnvironmentVariables;

public class OpenTheApplication implements Task {

    //GoogleSearchPage googleSearchPage;
    EnvironmentVariables environmentVariables;
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        String url =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
