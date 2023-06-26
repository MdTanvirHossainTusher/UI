package testing.base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.utils.ConfigUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    Browser browser = AqualityServices.getBrowser();

    @BeforeMethod
    public void setup(){
        browser.maximize();
        browser.goTo(new ConfigUtils().getUrl());
    }

    @AfterMethod
    public void teardown(){
        browser.quit();
    }
}
