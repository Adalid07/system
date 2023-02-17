package cxone.serenity.system.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignIn extends PageObject {
    public static Target USER_NAMES= Target.the("username").located(By.xpath("//input[@id='emailFieldNext']"));
    public static Target USER_NAME= Target.the("username").located(By.cssSelector("#emailFieldNext"));
    public static Target PASSWORD = Target.the("password").located(By.id("mfaPassField"));
    public static Target SIGN_IN = Target.the("sign In").located(By.id("mfaLoginBtn"));
    public static Target FORGOT_PASSWORD_HYPERLINK = Target.the("blocked message").located(By.cssSelector("#mfa-forgot-password-link"));

}
