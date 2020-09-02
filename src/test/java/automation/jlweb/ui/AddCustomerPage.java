package automation.jlweb.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.questions.TargetedUIState;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetSelectorWithVariables;
import org.openqa.selenium.By;

import java.util.ArrayList;

//@DefaultUrl("page:login.page")
public class AddCustomerPage extends PageObject {
    public static final Target CUSTOMERNAMETXT = Target.the( "Customer Name textbox" ).locatedBy( "#CustomerName" );
    public static final Target ADDRESS1TXT = Target.the( "Address 1 textbox" ).locatedBy( "#CustomerAddress1" );
    public static final Target ADDRESS2TXT = Target.the( "Address 2 textbox" ).locatedBy( "#CustomerAddress2" );
    public static final Target ADDRESS3TXT = Target.the( "Address 3 textbox" ).locatedBy( "#CustomerAddress3" );
    public static final Target ADDRESS4TXT = Target.the( "Address 4 textbox" ).locatedBy( "#CustomerAddress4" );
    public static final Target ZIPCODETXT = Target.the("Zip code textbox" ).locatedBy("#CustomerPostcode");
    public static final Target TELEPHONETXT = Target.the("Telephone textbox" ).locatedBy("#Telephone");
    public static final Target CUSTOMERTELEPHONECOUNTRYBTN = Target.the("Customer Telephone Country button").located(By.xpath("//input[@id='Telephone']/preceding-sibling::div"));
    public static final Target CUSTOMERTELEPHONECOUNTRYLIST=Target.the("Customer Telephone Country List").located(By.xpath("//input[@id='Telephone']/preceding-sibling::div/ul"));
    public static final Target CUSTOMERTYPETXT = Target.the("Customer Type textbox").located(By.name("CustomerTypeId_input"));
    public static final Target REFERENCENUMBERTXT = Target.the("Reference Number textbox").locatedBy("#CustomReference");
    public static final Target SELLINGRATETXT = Target.the("Selling Rate textbox").located(By.name("SellingRateId_input"));
    public static final Target CANCELBTN = Target.the("Cancel button").locatedBy("#cancelButton");
    public static final Target SAVEBTN= Target.the("Save button").located(By.className("mdi mdi-content-save"));
    public static final Target ADDCUSTOMERTYPEBTN= Target.the("Add Customer Type button").located(By.xpath("//button[contains(@onclick,'CustomerTypeId')]"));
    public static final Target ADDSELLINGRATEBTN= Target.the("Add Selling Rate button").located(By.xpath("//button[contains(@onclick,'SellingRateId')]"));
    public static final Target CUSTOMERTAGTXT = Target.the("Customer Tag(s) textbox").located(By.xpath("//input[contains(@aria-describedby,'Customer_TagIds_taglist')]"));
    public static final Target ADDTAGBTN = Target.the("Add Tag(s) button").located(By.xpath("//ul[@id='Customer_TagIds_taglist']/ancestor::div/span[@role='button']"));
}
