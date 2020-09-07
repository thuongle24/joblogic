package automation.jlweb.tasks;

import automation.jlweb.model.JLFeature;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectTab implements Task {
    private final String feature;
    private final String tabName;

    public SelectTab(String feature, String tabName) {
        this.feature = feature;
        this.tabName = tabName;
    }

    @Step("{0} tries to select tab #tabName")
    public <T extends Actor> void performAs(T actor) {
        String tabsID;
        if(feature.equals(JLFeature.CUSTOMER))
            tabsID="customerTabs";
        else if (feature.equals(JLFeature.SITE))
            tabsID="SiteTabs";
        else if (feature.equals(JLFeature.ASSETS))
            tabsID="assetTabs";
        else if (feature.equals((JLFeature.JOBS)))
            tabsID="jobTabs";
        else if (feature.equals(JLFeature.QUOTES))
            tabsID="quoteTabs";
        else if (feature.equals(JLFeature.INVOICES))
            tabsID="invoiceTabs";
        else if (feature.equals(JLFeature.PPM))
            tabsID="ppmContractTabs";
        else if (feature.equals(JLFeature.PO))
            tabsID="tabFilter";
        else if (feature.equals(JLFeature.REPORT))
            tabsID="reportTabs";
        else
            throw new IllegalStateException("Unexpected value: " + feature);

        if(tabName!= null)
            actor.attemptsTo(Click.on(By.xpath("//ul[@id='" + tabsID + "']//a[@aria-controls='" + tabName + "']")));
    }
    public static Performable with(String feature, String tabName) {
        return instrumented(SelectTab.class, feature, tabName);
    }

}
