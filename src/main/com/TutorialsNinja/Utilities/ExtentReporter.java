package com.TutorialsNinja.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport() throws Exception {

        ExtentReports extentReports = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("TN Automation RESULTS");
        sparkReporter.config().setDocumentTitle("TNReportTitle|Automation|Results|April_2024");
        sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
        extentReports.attachReporter(sparkReporter);

        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\com\\TutorialsNinja\\Config\\config.properties");
        prop.load(ip);

        extentReports.setSystemInfo("application url", prop.getProperty("url"));
        extentReports.setSystemInfo("browser name", prop.getProperty("browser"));
        extentReports.setSystemInfo("valid Email", prop.getProperty("validEmail"));
        extentReports.setSystemInfo("valid Password", prop.getProperty("validPassword"));
        extentReports.setSystemInfo("java vendor", System.getProperty("java.vendor"));
        extentReports.setSystemInfo("java version", System.getProperty("java.vm.version"));
        extentReports.setSystemInfo("SDET", System.getProperty("user.name"));
        extentReports.setSystemInfo("operating system", System.getProperty("os.version"));
        return extentReports;
    }

}
