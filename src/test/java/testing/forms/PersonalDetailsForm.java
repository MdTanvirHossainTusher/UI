package testing.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {
    public PersonalDetailsForm() {
        super(By.xpath("//div[contains(@class,'toggle-button toggle-button--left')]"), "Personal Details Page");
    }
}
