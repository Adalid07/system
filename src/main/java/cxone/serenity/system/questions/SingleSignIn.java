package cxone.serenity.system.questions;

import cxone.serenity.system.ui.SignIn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class SingleSignIn implements Question<String> {


   public static Question<String> getProfileTitle() {
        return Question.about("In profile site - get the title").answeredBy(actor -> SignIn.FORGOT_PASSWORD_HYPERLINK.resolveFor(actor).getTextContent());

    }

    public static SingleSignIn getForgotPasswordHyperlink(){
        return new SingleSignIn();
    }

    @Override
    public String answeredBy(Actor actor) {
       return  Text.of(SignIn.FORGOT_PASSWORD_HYPERLINK).answeredBy(actor);
    }

}
