package Infra.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

    public abstract class WebDriverListeners implements WebDriverEventListener{//WebDriverEventListener {





        @Override
        public void afterClickOn(WebElement arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("After clicked"+arg0);
        }

        @Override
        public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
            // TODO Auto-generated method stub
            System.out.println("After Find By"+arg1);

        }

        @Override
        public void afterNavigateBack(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("After Navigate Back");
        }

        @Override
        public void afterNavigateForward(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("After Navigate Forward");
        }

        @Override
        public void afterNavigateRefresh(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("On Navigating Refresh");
        }

        @Override
        public void afterNavigateTo(String arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("On Navigating To"+arg0);

        }

        @Override
        public void afterScript(String arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("After Script");
        }


        @Override
        public void beforeAlertAccept(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("Before Alert Accept");
        }

        @Override
        public void beforeAlertDismiss(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("Before Alert Dismiss");
        }

        @Override
        public void beforeChangeValueOf(WebElement arg0, WebDriver arg1,
                                        CharSequence[] arg2) {
            // TODO Auto-generated method stub
            System.out.println("Before Change Value of"+arg0);
        }

        @Override
        public void beforeClickOn(WebElement arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("Before Click on"+arg0);
        }

        @Override
        public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
            // TODO Auto-generated method stub
            System.out.println("Before Find By"+arg0);
        }

        @Override
        public void beforeNavigateBack(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("Before Navigate Back");
        }

        @Override
        public void beforeNavigateForward(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("Before Navigate Forward");
        }

        @Override
        public void beforeNavigateRefresh(WebDriver arg0) {
            // TODO Auto-generated method stub
            System.out.println("Before Navigate Refresh");
        }

        @Override
        public void beforeNavigateTo(String arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("Before Navigate To"+arg0);
        }

        @Override
        public void beforeScript(String arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("Before Script");
        }

        @Override
        public void onException(Throwable arg0, WebDriver arg1) {
            // TODO Auto-generated method stub
            System.out.println("On Exception"+arg0);
        }


    }

