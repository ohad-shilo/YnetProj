package Infra;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


import static org.junit.Assert.fail;

public  class LoogerProj extends CommonAuto implements CommomConstants, ITestListener {
    private static FileWriter fileWriter;
    static Logger logger;// = Logger.getLogger(SampleClass.class.getName());
FileHandler fileHandler;
    FileWriter file;

    public void initLog() throws IOException {
        String fileName = getFilePath(FileType.LOG_REPORT);
        fileWriter = new FileWriter(fileName);
        fileWriter.write("= = = = = =  LOG for run on: " + getSimpleDateFormat()+ "= = = = = ="+ "\n\n") ;
    }

    public void existLog() throws IOException
    {
        fileWriter.close();
    }


 public void addLog(Level level, String str)
    {
        try {
            fileWriter.write(getSimpleDateFormat() +" Log type: " + level.toString() +". Message is: "+ str + "\n");
            fileWriter.flush();
            System.out.println(" Log type: " + level.toString() +". Message is: "+ str );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void takeScreenshot() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) CommonAuto.driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(getFilePath(FileType.SCREENSHOT));
            FileUtils.copyFile(SrcFile, DestFile);
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
            fail("ERROR: " + e.getMessage());
        }
    }

    public  void createJSON() {
        String url = "https://www.geektime.co.il/source-defense-raises-10-5-m/";
        CommonAuto.driver.get(url);


        // String str = (String)((JavascriptExecutor) CommonAuto.driver).executeScript("return window.javascript_errors ");


        // Mentioning type of Log
        LogEntries entry = CommonAuto.driver.manage().logs().get(LogType.BROWSER);//LogType.PERFORMANCE
        // Retrieving all log
        List<LogEntry> logs= entry.getAll();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Logs for URL: ",url);

        JSONArray jsonArray = new JSONArray();

        int i = 1;

        for(LogEntry e: logs)  // Print one by one
        {
            jsonArray.put("Row #:" + i + " Logs is: " + e);
            jsonArray.put("Row #:" + i + " Message is: " + e.getMessage());
            jsonArray.put("Row #:" + i + " Logs: " + e.getLevel());
            System.out.println("Log: " + e);
            System.out.println("Message is: " +e.getMessage());
            System.out.println("Level is: " +e.getLevel());
            i++;
        }
        jsonObject.put("main", jsonArray);

        try {
            file = new FileWriter(getFilePath(FileType.JSON_REPORT));
            file.write(jsonObject.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                file.flush();
                file.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    private  String getFilePath(FileType fileType){
        CommonAuto commonAuto = new CommonAuto();
        String path = commonAuto.getRunFolder() + "//";

        switch(fileType) {
            case HTML_REPORT:
                System.out.println("HTML_REPORT");
                break;
            case JSON_REPORT:
                System.out.println("JSON_REPORT");
                path += getTestFailureName() + "_" + JSON_FILE_NAME;
                break;
            case SCREENSHOT:
                System.out.println("SCREENSHOT");
                path += getTestFailureName() + "_" + SCREEN_SHOT_FILE_NAME;
                break;
            case LOG_REPORT:
                System.out.println("LOG_REPORT");
                path +=  LOG_REPORT_FILE_NAME;
                break;
        }
        return path;
    }

}