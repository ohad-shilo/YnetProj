package Infra.Listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerTest extends ExtentManager implements ITestListener {



    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        extent.flush();
    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("Start run");
        this.init();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // TODO Auto-generated method stub
        setTestFailureName(iTestResult.getName());
        errorManager();

        System.out.println("The failure test name is: " + iTestResult.getName());
        test.log(Status.INFO, "The test name: " + iTestResult.getMethod().getDescription());
        test.log(Status.ERROR, iTestResult.getMethod().getDescription() + " - - failure");

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // TODO Auto-generated method stub
        System.out.println("OnStart");
        create_test(iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // TODO Auto-generated method stub
        System.out.println("The success test name is: " + iTestResult.getName());
        test.log(Status.INFO, "The test name: " + iTestResult.getMethod().getDescription());
        test.log(Status.PASS, iTestResult.getMethod().getDescription() + " - - succeded");
    }
}
