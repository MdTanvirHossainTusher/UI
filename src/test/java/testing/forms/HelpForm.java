package testing.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton helpBtn = getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]"),"Send To Bottom Button");

    public HelpForm() {
        super(By.xpath("//div[contains(@class,'is-hidden')]"), "Help Form Status");
    }

    public void hideHelpForm(){
        helpBtn.clickAndWait();
    }
}
