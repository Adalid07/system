package cxone.serenity.system.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchMessage {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));
    public static Target USER_NAME_FIELD = Target.the("usern name field").located(By.id("emailFieldNext"));
}
