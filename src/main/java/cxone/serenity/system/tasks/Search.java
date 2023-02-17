package cxone.serenity.system.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import cxone.serenity.system.ui.SearchMessage;

public class Search implements Task {

    private final String searchBlockMessage;

    protected Search(String searchBlockMessage) {
        this.searchBlockMessage = searchBlockMessage;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchBlockMessage).into(SearchMessage.SEARCH_FIELD).thenHit(ENTER)
        );
    }

    public static Search getBockedMessage(String searchTerm) {
        return instrumented(Search.class, searchTerm);
    }

}
