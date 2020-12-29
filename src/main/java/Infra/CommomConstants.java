package Infra;

import com.sun.codemodel.internal.fmt.JStaticFile;

public interface CommomConstants {
    public static final String URL_CONTRIES = "https://af-qa-test.vercel.app/countries";
    public static final String URL_HOME = "https://af-qa-test.vercel.app";

    public static final String HOME_PAGE_TITLE = "React App";
    public static final String COUNTRIES_PAGE_TITLE = "React App";

    public static final String[] COUNTRIES_LIST = {"Armenia selector", "Antarctica selector", "Aruba selector"};

    public static final String GO_TO_COUNTRIES_XPATH  = "//*[@id='root']/div/div[3]/table/tbody/tr[5]/td[4]";

    public static final String OUTPUT_FOLDER = ".//TestRunResults";

    public static final String JSON_FILE_NAME = "json_report.json";
    public static final String SCREEN_SHOT_FILE_NAME = "error_screenshoot.png";
    public static final String LOG_REPORT_FILE_NAME = "log_report.log";

    public static final String REPORT_FILE_NAME = "Run_report.html";
    public static final String REPORT_PAGE_TITLE = "Report Page Title";
    public static final String REPORT_NAME = "The Report Name";


    public static final String LINKEDIN_INVITED ="https://www.linkedin.com/groups/13760531/manage/membership/invited/";
    public static final String LINKEDIN_NETWORK ="https://www.linkedin.com/mynetwork/";



    public static final String URL_GOOGLE = "https://www.google.com";
    public static final String URL_YNET_NEWS = "https://www.ynetnews.com/category/3083";
    public static final String HOME_PAGE_TITLE_YNET = "ynetnews - Homepage";
    public static final String GOOGLE_SEARCH_XPATH = "//input[@name='q']";
    public static final String YNET_NEWS_XPATH = "//*[@id='rso']/div[1]/div/div[1]/a/h3/span";
    public static final String WEATHER_XPATH = "//*[@id=\'cdanwmansrch_weathertempsdiv\']/div[1]/a/span";
    public static final String Eilat_XPATH = "//*[@id='weathercityselect']/option[8]";
    public static final String GOOGLE_YNET = "ynetnews";
}
