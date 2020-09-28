package automation.jlweb.ui;

import automation.jlweb.features.Hook;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.ThucydidesSystemProperty;

//@DefaultUrl("page:login.page")
public class LoginPage extends PageObject {
    public static final Target USERNAMETXT = Target.the( "Username textbox" ).locatedBy( "#UserName" );
    public static final Target PASSWORDTXT = Target.the( "Password textbox" ).locatedBy( "#Password" );
    public static final Target LOGINBTN = Target.the( "Login button" ).locatedBy( "#loginButton" );
}

