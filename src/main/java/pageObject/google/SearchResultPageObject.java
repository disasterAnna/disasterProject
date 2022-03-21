package pageObject.google;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Base;

public class SearchResultPageObject extends Base {
    public SearchResultPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='main']//a[contains(.,'Картинки')]")
    private WebElement imagesTab;

    /*
    Проверяем, что кнопка "Картинки" существует на странице
     */
    public boolean imagesTabButtonIsExist(){
        return waitVisibilityElement(imagesTab);
    }


}
