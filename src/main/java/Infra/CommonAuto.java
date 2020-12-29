package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CommonAuto implements  CommomConstants{

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    private static LoogerProj logs = null;


    private static String testFailureName = null;

    public static String getTestFailureName() {
        return testFailureName;
    }

    public static void setTestFailureName(String testFailureName) {
        CommonAuto.testFailureName = testFailureName;
    }

    private static String runFolder;

    public static void setRunFolder(String runFolder) {
        CommonAuto.runFolder = runFolder;
    }

    public static  String getRunFolder()
    {
        if(runFolder==null)
        {
            runFolder =  CommomConstants.OUTPUT_FOLDER + "//" + getSimpleDateFormat();
            boolean res = new File( runFolder).mkdirs();
            System.out.println("Build the folder: " + runFolder + " create folder result are:" + res);
        }
        return (runFolder);
    }

    public static String getSimpleDateFormat() {
        return (new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()));
    }



    public  void errorManager() {
        logs.takeScreenshot();
        logs.createJSON();
    }

    public  void InitEnvironment(String BrowserType) {

        try{

            if ("FireFox".equals(BrowserType)) {
                System.setProperty("webdriver.gecko.driver", "D://Dev//Course//SeleniumServ//geckodriver.exe");
                driver = new FirefoxDriver();
            } else if ("Chrome".equals(BrowserType)) {
               // System.setProperty("webdriver.chrome.driver", "D://Dev//Course//SeleniumServ//chromedriver.exe");
                driver = new ChromeDriver();
            } else if ("IE".equals(BrowserType)) {
                driver = new InternetExplorerDriver();
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 5);
            logs = new LoogerProj();
            logs.initLog();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public void ExitEnvironment()  {

        try{
            logs.addLog(Level.INFO," = = = = =  ExitEnvironment  = = = = =");
            driver.quit();
            logs.existLog();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

    }


    public void Verify_Title_Text(String ExpectedPageTitle)  {

        try{
            String pageTitle =  CommonAuto.driver.getTitle();

            ReportInfo("Compare page tile: "+ pageTitle + " to " + ExpectedPageTitle );
            if(pageTitle.equals(ExpectedPageTitle))
            {
                ReportSuccess("Page title: " + pageTitle + " equals to expected " + ExpectedPageTitle);
            }
            else
            {
                ReportError("Page title: " + pageTitle + " Not equals to expected " + ExpectedPageTitle);
            }
        }
        catch (Exception e)
        {
            ReportError("ERROR: " + e.getMessage());
        }
    }


    public void NavigateTo(String URL) {

        try{
            ReportInfo("Go to URL: " + URL);
            driver.get(URL);
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            logs.addLog(Level.SEVERE, e.getMessage());
            System.out.println("ERROR: " + e.getMessage());
        }
    }


    public void ReportInfo(String InfoMessage) {

        try{

            System.out.println("Info : " + InfoMessage);
        }
        catch (Exception e)
        {
            logs.addLog(Level.SEVERE, e.getMessage());
            System.out.println("ERROR: " + e.getMessage());
            fail("ERROR: " + e.getMessage());
        }

    }



    public void ReportError(String ErrorMessage) {

        try{
            logs.addLog(Level.SEVERE, ErrorMessage);
            System.out.println("FAILED : " + ErrorMessage);

            fail("FAILED : " + ErrorMessage);
            logs.errorManager();
        }
        catch (Exception e)
        {
            logs.addLog(Level.SEVERE, e.getMessage());
            System.out.println("ERROR: " + e.getMessage());
            fail("ERROR: " + e.getMessage());
        }

    }


    public void ReportSuccess(String Message)  {

        try{

            System.out.println("PASS : " + Message);
            assertTrue("PASS : " + Message, true);
        }
        catch (Exception e)
        {
            logs.addLog(Level.SEVERE, e.getMessage());
            System.out.println("ERROR: " + e.getMessage());
            fail("ERROR: " + e.getMessage());
        }

    }
}
