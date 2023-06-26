package testing.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class HomePage extends Form {
    private final IButton hereBtn = getElementFactory().getButton(By.xpath("//a[contains(@class,'start__link')]"),"HereButton");

    public HomePage() {
        super(By.xpath("//button[contains(@class,'start__button')]"), "Home Page");
    }

    public void hereBtnClick(){
        hereBtn.click();
    }
}
