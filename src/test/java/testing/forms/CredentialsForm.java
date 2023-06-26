package testing.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import framework.utils.TestDataUtils;
import org.openqa.selenium.By;
import testing.utils.RandomUtils;
import java.util.List;

public class CredentialsForm extends Form{
    private static final String pwdLocator = "//input[contains(@placeholder,'Choose Password')]";
    private static final String domainLocator = "//div[contains(@class,'dropdown__list-item')]";
    private final ITextBox pwdField = getElementFactory().getTextBox(By.xpath(pwdLocator),"PasswordField");
    private final ITextBox emailField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Your email')]"),"EmailField");
    private final ITextBox domainField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"),"DomainField");
    private final IButton dropDownBtn = getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown__opener')]"),"DropDownButton");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary') and text()='Next']"),"NextButton");
    private final ICheckBox termsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__box')]"),"TermsCheckBox");

    private static String pass;

    public CredentialsForm() {
        super(By.xpath(pwdLocator), "Credentials Page");
    }

    public void setPwd(){
        pass = RandomUtils.generateRandomPassword();
        pwdField.clearAndType(pass);
    }

    public void setEmail(){
        emailField.clearAndType(RandomUtils.generateEmail(pass));
    }

    public void setDomain(){
        TestDataUtils testDataUtils = new TestDataUtils();
        String domainType = testDataUtils.getStringValueByKey("emailDomain","type");
        domainField.clearAndType(domainType);
    }

    public void clickDropDownBtn(){
        dropDownBtn.clickAndWait();
    }

    public void selectDomainNames(){
        int value = RandomUtils.getRandomDomainValue();
        List<IComboBox> domains = getElementFactory().findElements(By.xpath(domainLocator), "Domains Menu", ElementType.COMBOBOX);
        for(int i = 0; i < domains.size(); i++){
            if(value == i + 1){
                domains.get(i).clickAndWait();
                break;
            }
        }
    }

    public void unselectTermsCheckBox(){
        termsCheckBox.click();
    }

    public void clickOnNextBtn(){
        nextBtn.clickAndWait();
    }
}
