package testing.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import framework.utils.TestDataUtils;
import org.openqa.selenium.By;
import testing.utils.RandomUtils;
import java.util.List;
import java.util.Set;


public class InterestsForm extends Form {
    private static final String uploadButtonLocator = "//p[contains(@class,'avatar-and-interests__text')]//a";
    private static final String interestsLocator = "//span[contains(@class,'checkbox small')]";
    private final ICheckBox unselectAllCheckBox = getElementFactory().getCheckBox(By.xpath("//label[contains(@for,'interest_unselectall')]"),"Unselect Check Box");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--stroked')]"),"Interest Next Button");
    private final IButton uploadButton = getElementFactory().getButton(By.xpath(uploadButtonLocator),"Upload Button");

    public InterestsForm() {
        super(By.xpath(uploadButtonLocator), "Interests Page");
    }

    public void clickUploadLink(){
        uploadButton.click();
    }

    public void setUnselectAllCheckBox(){
        unselectAllCheckBox.clickAndWait();
    }

    public void clickNextBtn(){
        try {
            Thread.sleep(2000);
            nextBtn.clickAndWait();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectRandomInterests(){
        Set<Integer> uniqueValues = RandomUtils.getRandomInterestsValues();
        int count = 0;
        List<ICheckBox> interests = getElementFactory().findElements(By.xpath(interestsLocator), "Interests checkbox", ElementType.CHECKBOX);
        TestDataUtils testDataUtils = new TestDataUtils();
        long noOfInterests = testDataUtils.getIntValueByKey("selectInterests","noOfInterests");

        for(int i = 0; i < interests.size() && count < noOfInterests; i++){
            for(Integer val:uniqueValues){
                if(val == i + 1){
                    interests.get(i).clickAndWait();
                    count++;
                    break;
                }
            }
        }
    }
}
