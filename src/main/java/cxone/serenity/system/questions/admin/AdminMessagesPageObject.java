package cxone.serenity.system.questions.admin;

import cxone.serenity.system.ui.admin.AdminPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Admin implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return null;
    }

    public static Question<String> getWarningMessage(){
        return Question.about("Warning messages").answeredBy(actor -> AdminPageObject.ROLES_AND_PERMISSIONS.resolveFor(actor).getTextContent());
    }
}
