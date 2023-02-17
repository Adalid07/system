package cxone.serenity.system.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import cxone.serenity.system.ui.LoginSignInPage;

public class OpenTheApplication implements Task {

    LoginSignInPage loginSignInPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(loginSignInPage)
        );
    }

}
