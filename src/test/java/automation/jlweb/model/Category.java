package automation.jlweb.model;

public enum Category {
    CUSTOMERS("customer"),
    SITES("site");

    private String name;

    Category(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
