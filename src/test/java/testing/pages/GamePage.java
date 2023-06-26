package testing.pages;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import framework.utils.TestDataUtils;
import org.openqa.selenium.By;
import testing.forms.*;
import testing.utils.ImageUtils;
import java.io.IOException;


public class GamePage extends Form {
    private static final By timerLocator = By.xpath("//div[contains(@class,'timer')]");
    private final ILabel timer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"),"Timer");

    public GamePage() {
        super(timerLocator, "Game page");
    }


    public CookiesForm getCookiesForm() {
        return new CookiesForm();
    }

    public CredentialsForm getCredentialsForm() {
        return new CredentialsForm();
    }

    public HelpForm getHelpForm() {
        return new HelpForm();
    }

    public InterestsForm getInterestsForm() {
        return new InterestsForm();
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return new PersonalDetailsForm();
    }

    public boolean getTimerTime(){
        TestDataUtils testDataUtils = new TestDataUtils();
        return timer.getElement().getText().equals(testDataUtils.getStringValueByKey("time","timerTime"));
    }

    public void uploadImage(){
        try {
            getInterestsForm().clickUploadLink();
            ImageUtils.uploadImage();
        } catch (InterruptedException | IOException e) {
            Logger.getInstance().warn(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
