package automation.jlweb.ui;

import automation.jlweb.model.Category;
import automation.jlweb.model.SubCategory;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static Target category(Category category)
    {
        return Target.the(category.name() + " category")
                .locatedBy("//li[@class=\"jl-has-submenu\"]//span[contains(text(),'{0}')]")
                .of(category.name());
    }
    public static Target subCategory(String subCategory)
    {
        return Target.the(subCategory + " sub-category")
                .locatedBy("//ul[@class=\"jl-submenu menu-open\"]//a[contains(text(),'{0}')]")
                .of(subCategory);
    }

    public static String menu(String menu)
    {
        menu = "a[id=" + menu + "Menu]";
        return menu;
    }

    public static String subMenu(String subMenu)
    {
        subMenu = "a[id=" + subMenu + "Menu]";
        return subMenu;
    }
}
