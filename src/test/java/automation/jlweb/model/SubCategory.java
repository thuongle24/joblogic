package automation.jlweb.model;

public enum SubCategory {
    ADDCUSTOMER("Add Customer"),
    ADDSITE("createSite");

    private String name;

    SubCategory(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
