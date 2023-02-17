package net.serenitybdd.tutorials.features.admin;

import cxone.serenity.system.questions.admin.AdminMessagesPageObject;
import cxone.serenity.system.tasks.Credentials;
import cxone.serenity.system.tasks.OpenTheApplication;
import cxone.serenity.system.tasks.admin.Inject;
import cxone.serenity.system.tasks.admin.NavigateTO;
import cxone.serenity.system.tasks.login.Login;
import cxone.serenity.system.ui.admin.AdminPageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class XssInjectionsStory {
    Actor user = new Actor("Anonymous");

    @Managed(uniqueSession = false)
    public WebDriver hisBrowser;
    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void userCanOpenBrowser(){
        user.can(BrowseTheWeb.with(hisBrowser));
    }
    @Issue("CX-123411")
    @Test
    public void verifyThatAMessageIsDisplayedWhenXssCodeIsInjectedIntoRolesAndPermissions(){
         givenThat(user).wasAbleTo(openTheApplication);
         when(user).attemptsTo(Login.enterCredentials("adalid.claure@so32.com","Hola que hace1!"));
         and(user).attemptsTo(NavigateTO.section(AdminPageObject.ROLES_AND_PERMISSIONS));
         and(user).attemptsTo(Inject.enterXssCode("<script>alert('test')</script>"));
         then(user).should(seeThat(AdminMessagesPageObject.getWarningMessage(), containsString("Oops, you can’t use \\ ! < > ? % \"")));
     }

    @Test
    public void verifyThatAMessageIsDisplayedWhenXssCodeIsInjectedIntoRolesAndPermissionsNot(){
        givenThat(user).wasAbleTo(openTheApplication);
        when(user).attemptsTo(Login.enterCredentials("adalid.claure@so32.com","Hola que hace1!"));
        and(user).attemptsTo(NavigateTO.section(AdminPageObject.ROLES_AND_PERMISSIONS));
        and(user).attemptsTo(Inject.enterXssCode("<script>alert('test')</script>"));
        then(user).should(seeThat(AdminMessagesPageObject.getWarningMessage(), equalToObject("Oops, you can’t use \\ ! < > ? % \" ")));
    }
}
