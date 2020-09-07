package automation.jlweb.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CustomerPage extends PageObject {
    public static final Target CUSTOMERTABLE = Target.the( "Customer table" ).locatedBy( ".jl-table" );
    public static final Target SEARCHCUSTOMER = Target.the( "Search Customer textbox" ).locatedBy( "#SearchTerm" );
    public static final Target SHOWADVANCEDSEARCHBTN = Target.the( "Show Advanced Search button" ).locatedBy( ".jlAdvanceSearchTrigger" );
    public static final Target SEARCHBTN = Target.the( "Search button" ).locatedBy( "#CustomerSearch_Submit" );
    public static final Target IMPORTBTN = Target.the( "Import button" ).located(By.xpath("//a[@class='jl-button-blue import-csv']"));
    public static final Target EXPORTBTN = Target.the( "Export button" ).located(By.xpath("//a[@class='jl-button-blue export-csv']"));
}
