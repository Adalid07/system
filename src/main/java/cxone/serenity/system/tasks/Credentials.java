package cxone.serenity.system.tasks;

import cxone.serenity.system.ui.SignIn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Credentials implements Task {
    private String username;
    private String pass;

    public Credentials(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }


    @Override @Step("Enter Credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(username).into(SignIn.USER_NAMES).thenHit(Keys.ENTER));
        //actor.attemptsTo(Enter.theValue(username).into(SignIn.USER_NAME).thenHit(Keys.ENTER));
       /*actor.attemptsTo(Enter.theValue(pass).into(SignIn.PASSWORD).thenHit(Keys.ENTER));
       actor.attemptsTo(Click.on(SignIn.SIGN_IN));
       actor.attemptsTo(Click.on(SignIn.SIGN_IN));
       actor.attemptsTo(Click.on(SignIn.SIGN_IN));
       actor.attemptsTo(Click.on(SignIn.SIGN_IN));
      actor.attemptsTo(Click.on(SignIn.SIGN_IN));*/
    }

    public static Credentials enterCredentials(String username, String pass){
        return instrumented(Credentials.class,username,pass);
    }
}
