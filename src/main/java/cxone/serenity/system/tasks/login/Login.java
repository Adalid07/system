package cxone.serenity.system.tasks.login;

import cxone.serenity.system.questions.SingleSignIn;
import cxone.serenity.system.ui.SignIn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Enter.theValue(username).into(SignIn.USER_NAME).thenHit(Keys.ENTER));
            actor.attemptsTo(Enter.theValue(password).into(SignIn.PASSWORD).thenHit(Keys.ENTER));
        } catch (Exception e){
            System.out.println("Code was not executed");
        }

    }
    public static Login enterCredentials(String username, String pass){
        return instrumented(Login.class, username,pass);
    }
    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }
}
