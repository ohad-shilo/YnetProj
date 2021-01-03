package Suites;

import Infra.CommomConstants;
import Infra.CommonAuto;
import Infra.Listeners.ListenerTest;
import Pages.CountriesPage;
import Pages.LinkedinPage;
import Pages.YnetPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class Sanity_Ynet extends CommonAuto implements CommomConstants {

    @BeforeClass(groups = {"SmokeTest", "RegressionTest"})
    public void envSetup()  {
        commonAuto.InitEnvironment("Chrome");
    }

    @AfterClass(groups = {"SmokeTest", "RegressionTest"})
    public void Exit()  {
        commonAuto.ExitEnvironment();
    }

    CommonAuto commonAuto = new CommonAuto();
    YnetPage ynetPage = new YnetPage();



    @Test(priority = 10, groups = {"SmokeTest", "RegressionTest"}, description = "Test-P10")
    public void gotoYnet() throws InterruptedException {
        commonAuto.NavigateTo(URL_GOOGLE);
        ynetPage.gotoSite();
        Verify_Title_Text(HOME_PAGE_TITLE_YNET);
    }

    @Test(priority = 20, groups = {"SmokeTest"}, description = "Test-P20")
    public void checkTheWeather() throws InterruptedException {
        commonAuto.NavigateTo(URL_YNET_NEWS); // To avoid depenency
        ynetPage.checkWeather();
    }

    @Test(priority = 30, groups = {"SmokeTest", "RegressionTest"}, description = "Test-P30")
    public void updateThePageResolution() throws InterruptedException {
        commonAuto.NavigateTo(URL_YNET_MAGAZINE);
        ynetPage.pageResolution();
    }

    @Test(priority = 40, groups = {"SmokeTest", "RegressionTest"}, description = "Test-P40")
    public void choiceArticle() throws InterruptedException {
        ynetPage.gotoYentNews();
        ynetPage.choiceArticle();
    }

    @Test(priority = 50, groups = {"SmokeTest", "RegressionTest"}, description = "Test-P50")
    public void sendToFriend() throws InterruptedException {
        commonAuto.NavigateTo(URL_YNET_MAGAZINE);
        ynetPage.sendToFriend();
    }

    @Test(priority = 60, groups = {"SmokeTest", "RegressionTest"}, description = "Test-P60")
    public void seeTestFailed() throws InterruptedException {
        commonAuto.NavigateTo(URL_YNET_MAGAZINE);
        ynetPage.seeTestFailed();
    }
}
