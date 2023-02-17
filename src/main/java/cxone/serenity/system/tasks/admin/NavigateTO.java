package cxone.serenity.system.tasks.admin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

    }
    public static Navigate rolesAndPermisssion(){
        return instrumented(Navigate.class);
    }
}
