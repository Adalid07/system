package net.serenitybdd.tutorials.features.admin;

import cxone.serenity.system.tasks.Credentials;
import cxone.serenity.system.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

@RunWith(SerenityRunner.class)
public class XssInjections {
    Actor user = new Actor("Anonymous");
    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;
    @Steps
    OpenTheApplication openTheApplication;

    public void userCanOpenBrowser(){
        user.can(BrowseTheWeb.with(hisBrowser));
    }
    @Test
    public void verifyThatAMessageIsDisplayedWhenXssCodeIsInjectedIntoRolesAndPermissions(){
         givenThat(user).wasAbleTo(openTheApplication);
         when(user).attemptsTo(Credentials.enterCredentials("https://na1.staging.nice-incontact.com/","Hola que hace1!"));
     }
}
