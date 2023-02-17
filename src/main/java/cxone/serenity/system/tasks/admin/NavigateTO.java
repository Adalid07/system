package cxone.serenity.system.tasks.admin;

import cxone.serenity.system.ui.admin.AdminPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTO implements Task {
    Target section;

    public NavigateTO(Target section) {
        this.section = section;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(AdminPageObject.ROLES_AND_PERMISSIONS, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(Click.on(section));
    }
    public static NavigateTO rolesAndPermisssion(){
        return instrumented(NavigateTO.class);
    }
    public static NavigateTO section(Target section){
        return instrumented(NavigateTO.class,section);
    }
}
