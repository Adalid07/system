package net.serenitybdd.tutorials.features.search;
import cxone.serenity.system.questions.SingleSignIn;
import cxone.serenity.system.tasks.Credentials;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import cxone.serenity.system.tasks.OpenTheApplication;
import cxone.serenity.system.tasks.Search;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {
    Actor user = Actor.named("User");
    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void userCanBrowseTheWeb() {
        user.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void verify_that_forgot_password_hyperlink_is_displaed_on_loggin_page() {
        givenThat(user).wasAbleTo(openTheApplication);
        when(user).attemptsTo(Credentials.enterCredentials("adalid.claure@qqsso32.com","9pa6sda5sd123"));
        //when(user).attemptsTo(Search.forTheblocMessage("BDD In Action"));
        then(user).should(seeThat(SingleSignIn.getForgotPasswordHyperlink(), containsString("Forgot your password?")));
        //then(user).should(eventually(seeThat(TheWebPage.title(), containsString("Your account has been locked for 30 minutes for entering the wrong sign in credentials too many times."))));

    }
}