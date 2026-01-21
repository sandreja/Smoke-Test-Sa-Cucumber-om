package stepdefs;

import browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs1 {
    private static Imdb imdb;

    //pre svakog testa
    @Before
    public void setup(){
        imdb = new Imdb();
        WebDriverManager.firefoxdriver().setup();
        Browser.getBrowser().manage().window().maximize();
        Browser.getBrowser().get("https://www.imdb.com/");

    }

//Prvi test
//    @Given("that the user clicks on Sign in button from Homepage")
//    public void thatUserClicksOnSignInButtonFromHomepage() {
//        imdb.homePage().getSignIn().click();
//
//    }

//    @And("user clicks on Sign in to an existing account button")
//    public void userClicksOnSignInToAnExistingAccountButton() {
//        imdb.signInPage().getSignInToAnExistingAccountButton().click();
//
//    }

    @Then("verify that there are four sign in options present")
    public void verifyThatThereAreFourSignInOptionsPresent() {
        Assert.assertEquals("Sign in with IMDb", imdb.signInPage().getSignInWithImdbButton().getText());
        assertTrue(imdb.signInPage().getSignInWithAmazonButton().getText().contains("Amazon"));
        Assert.assertEquals("Sign in with Google", imdb.signInPage().getSignInWithGoogleButton().getText());
        assertTrue(imdb.signInPage().getSignInWithAppleButton().getText().equals("Sign in with Apple"));

    }


//Drugi test

    @Given("that the user types {string} in the searchbar")
    public void thatTheUserTypesMovieTitleInTheSearchbar(String movieTitle) {
        imdb.homePage().getSearchTextbox().sendKeys(movieTitle);

    }

    @And("click on search icon")
    public void clickOnSearchIcon() {
        imdb.homePage().getSearchIcon().click();

    }

    @Then("verify that the first option has the movie title that we searched for")
    public void verifyThatTheFirstOptionHasTheMovieTitleThatWeSearchedFor(String movieTitle) {

        assertTrue(imdb.searchPage().getFirstSearchResultTitle().getText().contains(movieTitle));


    }
//Treci test

    @Given("that the user clicks on Sign in button from Homepage")
    public void thatUserClicksOnSignInButtonFromHomepage() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(imdb.homePage().getSignIn()));
        imdb.homePage().getSignIn().click();

    }

    @And("user clicks on Sign in to an existing account button")
    public void userClicksOnSignInToAnExistingAccountButton() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(imdb.signInPage().getSignInToAnExistingAccountButton()));
        imdb.signInPage().getSignInToAnExistingAccountButton().click();

    }

    @And("user clicks on Sign in with IMDb button")
    public void userClicksOnSignInWithIMDbButton() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(imdb.signInPage().getSignInWithImdbButton()));
        imdb.signInPage().getSignInWithImdbButton().click();
    }

    @When("user inputs email and password")
    public void userInputsEmailAndPassword() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(imdb.imdbCreateAccountPage().getEmailTextField()));
        wait.until(ExpectedConditions.visibilityOf(imdb.imdbCreateAccountPage().getPasswordTextField()));

        imdb.imdbCreateAccountPage().getEmailTextField().sendKeys("mock@email.com");
        imdb.imdbCreateAccountPage().getPasswordTextField().sendKeys("Test1234");

    }

    @And("clicks on the Sign in button")
    public void clicksOnTheSignInButton() {
        imdb.imdbCreateAccountPage().getSignInButton().click();

    }

    @Then("verify that the user is signed in via the sign out option in profile dropdown")
    public void verifyThatTheUserIsSignedIn() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(imdb.imdbCreateAccountPage().getProfileButton()));
        imdb.imdbCreateAccountPage().getProfileButton().click();
        assertTrue(imdb.imdbCreateAccountPage().getSignOutButton().isDisplayed());


    }

    @And("user inputs {string} and {string}")
    public void userInputsEmailAndPassword(String email, String password) {
        imdb.imdbCreateAccountPage().getEmailTextField().sendKeys(email);
        imdb.imdbCreateAccountPage().getPasswordTextField().sendKeys(password);

    }

    @And("clicks on the profile button")
    public void clicksOnTheProfileButton() {
        imdb.imdbCreateAccountPage().getProfileButton().click();

    }

    @Then("verify that the user is logged in")
    public void verifyThatTheUserIsLoggedIn() {
        assertEquals(true, ExpectedConditions.visibilityOf(imdb.imdbCreateAccountPage().getSignOutButton()));

    }

//    @After
//    public void cleanup(){
//        Browser.getBrowser().quit();
//    }

}
