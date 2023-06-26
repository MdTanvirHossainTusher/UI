package testing.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.base.BaseTest;
import testing.pages.GamePage;
import testing.pages.HomePage;

public class CookiesFormTest extends BaseTest {
    @Test
    public void cookiesFormTest(){
        HomePage homePage = new HomePage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"Welcome page is not open.");
        homePage.hereBtnClick();
        gamePage.getCookiesForm().acceptCookies();
        Assert.assertTrue(gamePage.getCookiesForm().isCookiesDisappear(),"Cookies form is not closed.");
    }
}
