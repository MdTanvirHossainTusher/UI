package testing.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.io.File;
import java.time.Duration;
import java.util.Collections;

import static org.testng.Assert.assertTrue;

public class CookiesForm extends Form {
    private final static String cookiesLocator = "//button[contains(@class,'button--transparent')]";
    private final IButton cookieBtn = getElementFactory().getButton(By.xpath(cookiesLocator),"Cookie Button");
    private static final Duration waitForTimeoutCondition = Duration.ofSeconds(10);
    private static final Duration waitForTimeoutPolling = Duration.ofMillis(150);

    public CookiesForm() {
        super(By.xpath(cookiesLocator), "Cookie Form");
    }

    public void acceptCookies(){
        cookieBtn.clickAndWait();
    }

    public boolean isCookiesDisappear(){
        boolean fileShouldBeDownloaded = false;
        try{
//            acceptCookies();
            fileShouldBeDownloaded = AqualityServices.getConditionalWait().waitFor((driver) ->
                    {
                        acceptCookies();
                        return false;
                    }, waitForTimeoutCondition, waitForTimeoutPolling,
                    "Conditional should be true");
        }catch (TimeoutException e){
            return true;
        }
        return fileShouldBeDownloaded;
    }
}
