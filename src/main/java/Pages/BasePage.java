package Pages;

import Infra.CommonAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage extends CommonAuto {


    public String getTabName() {
        return driver.getTitle();
    }

    public int getNumberOfWindowsHandle() {
        return (driver.getWindowHandles().size());
    }

    public List<String> getTextFromElements(By elem) {

        List<WebElement> elementList = driver.findElements(elem);
        List<String> stringList = new ArrayList<>();

        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    public WebElement findElementProj(By elem){
        return (driver.findElement(elem));
    }

    public void clickOnElement(By elem) {

        driver.findElement(elem).click();
    }

    public void sendKeysToElement(By elem, String textToType) {

        driver.findElement(elem).sendKeys(textToType);
    }

    public String getURL() {

        return driver.getCurrentUrl();
    }


    public void waitForPageLoad(){
        //wait.until(ExpectedConditions.)

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void waitForElementToBeVisable(By elem) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
    }

    public void waitForElementToBeClickable(By elem) {

        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public WebElement returnWebElement(By elem) {

        return driver.findElement(elem);
    }

    public String getTextFromElement(By elem) {

        return driver.findElement(elem).getText();
    }

    public int countElements(By elem, int numberOfElementsToBE) {
        wait.until(ExpectedConditions.numberOfElementsToBe(elem, numberOfElementsToBE));
        List<WebElement> list = driver.findElements(elem);
        return list.size();
    }

    public String getURL(WebDriver driver) {

        return driver.getCurrentUrl();
    }

    public boolean isElementValid(By elem) {

        return driver.findElements(elem).isEmpty();
    }


}
