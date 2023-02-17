package cxone.serenity.system.tasks.admin;

import cxone.serenity.system.ui.admin.AdminPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Inject implements Task {
    String xss;

    public Inject(String xss) {
        this.xss = xss;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AdminPageObject.NEW_ROLE));
        actor.attemptsTo(Enter.theValue(xss).into(AdminPageObject.ROL_NAME));
    }

    public static Inject enterXssCode(String xssCode){
        return instrumented(Inject.class, xssCode);
    }
}
