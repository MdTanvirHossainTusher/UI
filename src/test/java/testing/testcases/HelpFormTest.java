package testing.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.base.BaseTest;
import testing.pages.GamePage;
import testing.pages.HomePage;

public class HelpFormTest extends BaseTest {
    @Test
    public void helpFormTest(){
        HomePage homePage = new HomePage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"Welcome page is not open.");
        homePage.hereBtnClick();
        gamePage.getHelpForm().hideHelpForm();
        Assert.assertTrue(gamePage.getHelpForm().state().waitForDisplayed(),"Help form content is not hidden.");
    }
}
