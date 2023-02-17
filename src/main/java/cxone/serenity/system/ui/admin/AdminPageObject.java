package cxone.serenity.system.ui.admin;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminPageObject extends PageObject {
    public static Target ROLES_AND_PERMISSIONS = Target.the("Roles and Permissions").located(By.cssSelector("#roleManagement"));
    public static Target NEW_ROLE = Target.the("New Role").located(By.cssSelector("#createRole"));
    public static Target ROL_NAME = Target.the("New Role Name").located(By.xpath("//input[@id='roleName']"));
    public static Target WARNING_MESSAGE = Target.the("Warning Message").located(By.xpath("//div[contains(text(),'Oops, you can’t use \\ ! < > ? % \"')]"));
}
