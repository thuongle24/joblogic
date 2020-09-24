package automation.jlweb.model;

public enum Category {
    Customers("customer"),
    SITES("site");

    private String name;

    Category(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
