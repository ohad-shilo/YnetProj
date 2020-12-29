package Infra.Listeners;

import Infra.CommomConstants;
import Infra.CommonAuto;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentManager extends CommonAuto {

    public ExtentReports extent;
    public ExtentTest test;
    public ExtentHtmlReporter htmlReporter;
    public String filePath;

    public void init() {
        filePath = getRunFolder() +"//"+ CommomConstants.REPORT_FILE_NAME;

        htmlReporter = new ExtentHtmlReporter(filePath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle(CommomConstants.REPORT_PAGE_TITLE);
        htmlReporter.config().setReportName(CommomConstants.REPORT_NAME);
        htmlReporter.config().setEncoding("windows-1255");
    }

    public void create_test(String testName) {
        test = extent.createTest(testName);
    }
}
