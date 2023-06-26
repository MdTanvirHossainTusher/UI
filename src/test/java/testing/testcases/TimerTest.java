package testing.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.base.BaseTest;
import testing.pages.GamePage;
import testing.pages.HomePage;

public class TimerTest extends BaseTest {
    @Test
    public void timerTest(){
        HomePage homePage = new HomePage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"Welcome page is not open.");
        homePage.hereBtnClick();
        Assert.assertTrue(gamePage.getTimerTime(),"Timer is not starts from \"00:00\".");
    }
}
