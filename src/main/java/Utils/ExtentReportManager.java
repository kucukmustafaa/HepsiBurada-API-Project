package Utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager{

    public static ExtentReports extentReports = createReport() ;
    public static ExtentSparkReporter reporter ;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<>();

    public static synchronized ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }

    public static ExtentReports createReport(){
        extentReports = new ExtentReports();
        reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("HepsiBurada API Case");
        //reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
        return extentReports;
    }

    public static ExtentTest createExtentTest(String message){
        ExtentTest extentTest=extentReports.createTest(message);
        extentTestThreadLocal.set(extentTest);
        return extentTest;
    }

    public static void flushReport(){
        extentReports.flush();
    }


}