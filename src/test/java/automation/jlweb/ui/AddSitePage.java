package automation.jlweb.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddSitePage extends PageObject {
    private static final String CUSTOMER = "input[name='CustomerId_input']";
    private static final String SITE = "#SiteName";
    private static final String TAGS = "input[class='k-input k-readonly valid k-valid']";
    private static final String ADDSTREET = "#SiteAddress1";
    private static final String ADDAREA = "#SiteAddress2";
    private static final String ADDCITY = "#SiteAddress3";
    private static final String ADDCOUNTY = "#SiteAddress4";
    private static final String POSTCODE = "#SitePostcode";
    private static final String TELEPHONE = "#Telephone";
    private static final String AREA = "input[name='AreaId_input']";
    private static final String SITEREFNO = "input[name='CustomReference']";
    private static final String CNTFIRSTNAME = "#ContactFirstName";
    private static final String CNTLASTNAME = "#ContactLastName";
    private static final String CNTTELEPHONE = "input[name='ContactTelephone']";
    private static final String CNTEMAIL = "input[name='CustomerId_input']";
    private static final String CNTJOBPOSITION = "#ContactPosition";
    private static final String CANCEL = "//a[@class='jl-button-red mr12']";
    private static final String SAVE = "//button[@class='jl-button-green disableSubmitButton']";

    public static Target DDCUSTOMER = Target.the("CustomerName").located(By.cssSelector(CUSTOMER));
    public static Target TXTSITE = Target.the("SiteName").located(By.cssSelector(SITE));
    public static Target DDTAGS = Target.the("Tags").located(By.cssSelector(TAGS));
    public static Target TXTADDSTREET = Target.the("AddressStreet").located(By.cssSelector(ADDSTREET));
    public static Target TXTADDAREA = Target.the("AddressArea").located(By.cssSelector(ADDAREA));
    public static Target TXTADDCITY = Target.the("AddressCity").located(By.cssSelector(ADDCITY));
    public static Target TXTADDCOUNTY = Target.the("AddressCounty").located(By.cssSelector(ADDCOUNTY));
    public static Target TXTPOSTCODE = Target.the("PostCode").located(By.cssSelector(POSTCODE));
    public static Target TXTTEL = Target.the("Telephone").located(By.cssSelector(TELEPHONE));
    public static Target DDAREA = Target.the("Area").located(By.cssSelector(AREA));
    public static Target TXTREFNO = Target.the("SiteReferenceNumber").located(By.cssSelector(SITEREFNO));
    public static Target TXTCNTFIRSTNAME = Target.the("ContactFirstName").located(By.cssSelector(CNTFIRSTNAME));
    public static Target TXTCNTLASTNAME = Target.the("ContactLastName").located(By.cssSelector(CNTLASTNAME));
    public static Target TXTCNTTEL = Target.the("ContactTelephone").located(By.cssSelector(CNTTELEPHONE));
    public static Target TXTCNTEMAIL = Target.the("ContactEmail").located(By.cssSelector(CNTEMAIL));
    public static Target TXTCNTJOBPOS= Target.the("ContactJobPosition").located(By.cssSelector(CNTJOBPOSITION));
    public static Target BTNCANCEL = Target.the("Cancel").located(By.xpath(CANCEL));
    public static Target BTNSAVE = Target.the("Save").located(By.xpath(SAVE));
}
