package automation.jlweb.tasks;

import automation.jlweb.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginJLWeb implements Task {

    private final String userName;
    private final String passWord;

    protected LoginJLWeb(String userName, String passWord) {
        this.userName=userName;
        this.passWord = passWord;
    }

    @Step("Login with #userName and #passWord")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(userName)
                     .into(LoginPage.USERNAMETXT),
                Enter.keyValues(passWord)
                     .into(LoginPage.PASSWORDTXT),
                Click.on(LoginPage.LOGINBTN)
        );
    }

    public static LoginJLWeb withTheCredentials(String userName, String passWord) {
        return instrumented(LoginJLWeb.class, userName,passWord);
    }

}
