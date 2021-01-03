package Pages;

import Infra.CommomConstants;
import Infra.LoogerProj;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Level;

public class YnetPage extends BasePage implements CommomConstants {

    private By by;
    private WebElement webElement;
    private LoogerProj loogerProj = new LoogerProj();

    /**
     * Go to Ynetnews and verfiy the page title
     */
    public void gotoSite() {
        loogerProj.addLog(Level.INFO,"Start: gotoSite");
        //Search for Ynetnews
        by = By.xpath(GOOGLE_SEARCH_XPATH);
        webElement = driver.findElement(by);
        webElement.sendKeys(GOOGLE_YNET);
        webElement.sendKeys(Keys.RETURN);
        //this.waitForPageLoad();
        by = By.xpath(YNET_NEWS_XPATH);
        this.waitForElementToBeVisable(by);
        this.waitForElementToBeClickable(by);

        //Open for Ynetnews
       // by = By.xpath(YNET_NEWS_XPATH);
        webElement = driver.findElement(by);
        webElement.click();
        this.waitForPageLoad();
        System.out.println("Verify the page is load, by checking the page title");
        Verify_Title_Text(HOME_PAGE_TITLE_YNET);
    }

    public void gotoYentNews(){
        loogerProj.addLog(Level.INFO,"Start: gotoYentNews");
        this.NavigateTo(URL_YNET_NEWS);
        this.waitForPageLoad();
    }

    /**
     *
     * @return - the Temperature(
     */
    public String getTemperature()
    {
        loogerProj.addLog(Level.INFO,"Start: getTemperature");
        by = By.xpath(WEATHER_XPATH);
        webElement = driver.findElement(by);
        return webElement.getText();
    }

    /**
     *  Check the weather in TLV and then change the location to Eilat and check the weather again
     */
    public void checkWeather()
    {
        loogerProj.addLog(Level.INFO,"Start: checkWeather");
        int weather_TLV=0, weather_Eilat=0;
        String str;

        str = getTemperature();
        loogerProj.addLog(Level.INFO,"The Weather in Tel Eilat is: " + str);
        System.out.println("The Weather in Tel Aviv is: " + str);
        weather_TLV = Integer.parseInt(str.substring(0,str.length()-1));

        by = By.xpath(Eilat_XPATH);
        webElement = driver.findElement(by);
        webElement.click();
        str = getTemperature();
        loogerProj.addLog(Level.INFO,"The Weather in Tel Eilat is: " + str);
        System.out.println("The Weather in Tel Eilat is: " + str);
        weather_Eilat = Integer.parseInt(str.substring(0,str.length()-1));

        if (weather_TLV < weather_Eilat)
        {
            ReportSuccess("The temperature in Eilat is: "+ weather_Eilat + ", and it higher than the temperature in TLV: " + weather_TLV);
        }
        else {
            ReportError("The temperature in Eilat is: "+ weather_Eilat + ", and it is NOT higher than the temperature in TLV: " + weather_TLV);
        }
    }

    public void pageResolution ()
    {
        loogerProj.addLog(Level.INFO,"Start: pageResolution");
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("The page size before the change is, High:" +dimension.height + " ,Width " + dimension.width) ;

        driver.manage().window().setSize(new Dimension(1920, 1080));
        dimension = driver.manage().window().getSize();
        System.out.println("The page size After the change is, High:" +dimension.height + " ,Width " + dimension.width) ;
    }

    public void openArticle()throws InterruptedException{
        loogerProj.addLog(Level.INFO,"Start: openArticle");
        Thread.sleep(1000);
        List<WebElement> list =  driver.findElements(By.className("imageView"));
        list.get(3).click();
        this.waitForPageLoad();
    }

    public void choiceArticle() throws InterruptedException {
        loogerProj.addLog(Level.INFO,"Start: choiceArticle");
        webElement = driver.findElement(By.partialLinkText("Magazine"));
        webElement.click();
        this.waitForPageLoad();
        this.openArticle();

    }

    public void sendToFriend() throws InterruptedException {
        loogerProj.addLog(Level.INFO,"Start: sendToFriend");
        this.openArticle();
        Thread.sleep(1000);
       webElement = driver.findElement(By.className("ArticleSideShareComponent_mailto"));
       //webElement.click(); - avoid click as it open mail app
        if (webElement != null)
        {
            ReportSuccess("Send To Friend link is exist in the page");
        }
        else {
            ReportError ("Send To Friend link is not exist in the page");
        }
    }

    public void seeTestFailed()
    {
        Verify_Title_Text("Test Error");
    }

    public void facebook()
    {

    }


}
