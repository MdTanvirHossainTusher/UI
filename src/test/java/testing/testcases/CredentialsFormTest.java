package testing.testcases;

import org.testng.Assert;
import testing.base.BaseTest;
import org.testng.annotations.Test;
import testing.pages.GamePage;
import testing.pages.HomePage;

public class CredentialsFormTest extends BaseTest {
    @Test
    public void credentialsFormTest(){
        HomePage homePage = new HomePage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"Welcome page is not open.");
        homePage.hereBtnClick();
        Assert.assertTrue(gamePage.getCredentialsForm().state().waitForDisplayed(),"The '1' card is not open.");

        gamePage.getCredentialsForm().setPwd();
        gamePage.getCredentialsForm().setEmail();
        gamePage.getCredentialsForm().setDomain();
        gamePage.getCredentialsForm().clickDropDownBtn();
        gamePage.getCredentialsForm().selectDomainNames();
        gamePage.getCredentialsForm().unselectTermsCheckBox();
        gamePage.getCredentialsForm().clickOnNextBtn();
        Assert.assertTrue(gamePage.getInterestsForm().state().waitForDisplayed(),"The '2' card is not open.");

        gamePage.uploadImage();
        gamePage.getInterestsForm().setUnselectAllCheckBox();
        gamePage.getInterestsForm().selectRandomInterests();
        gamePage.getInterestsForm().clickNextBtn();
        Assert.assertTrue(gamePage.getPersonalDetailsForm().state().waitForDisplayed(),"The '3' card is not open.");
    }
}
