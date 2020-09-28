package automation.jlweb.model;

public enum CustomerType {
    COMMERCIAL("Commercial"),
    DOMESTIC("Domestic/Residential"),
    GOVERNMENT("Government"),
    INDUSTRIAL("Industrial"),
    LANDLORD("Landlord"),
    RETAIL("Retail"),
    STORE("Store");

    private String name;

    CustomerType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }





}
