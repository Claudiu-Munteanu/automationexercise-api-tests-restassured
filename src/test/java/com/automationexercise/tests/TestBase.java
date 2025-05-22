package com.automationexercise.tests;

import com.automationexercise.AutomationExerciseWebService;
import com.automationexercise.contracts.RetryConfiguration;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({ AllureTestNg.class })
public class TestBase extends RetryConfiguration implements IRetryAnalyzer, IConfigurable {
    public static final AutomationExerciseWebService automationExerciseWebService = AutomationExerciseWebService.getInstance();
    protected static Logger logger;
    public static String automationExerciseApiUrl;
    private Integer retryTestCount = 0;
    private Integer retryConfigCount = 0;

    @Parameters({"url"})
    @BeforeSuite
    protected void beforeSuite(@Optional("QA") final String url) {
        readAppProperties(url);
        initLogger();
    }

    private void readAppProperties(final String url) {
        FileInputStream fis = null;
        Properties appProperties = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configs/app.properties");
            appProperties = new Properties();
            appProperties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (url.equals("QA")) {
            automationExerciseApiUrl = appProperties.getProperty("automationExerciseApiUrl");
        } else {
            automationExerciseApiUrl = url;
        }

        try {
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initLogger() {
        logger = LogManager.getLogger();
    }

    @BeforeMethod
    protected void beforeTest() {
        logger.info("Test scenario started.");
    }

    @Override
    public boolean retry(ITestResult result) {
        if (result.getThrowable() != null || result.getStatus() == ITestResult.FAILURE) {
            if (retryTestCount < maxRetries) {
                retryTestCount++;
                try {
                    System.out.println("Retry #" + retryTestCount + " in " + retryInterval + " seconds...");
                    TimeUnit.SECONDS.sleep(retryInterval);
                } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                }
                return true;
            } else {
                System.out.println("Maximum number of retry attempts reached. Stopping retry attempts.");
                return false;
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test succeeded. Stopping retry attempts.");
            return false;
        }
        return true;
    }

    @Override
    public void run(IConfigureCallBack callBack, ITestResult result) {
        callBack.runConfigurationMethod(result);
        if (result.getThrowable() != null || result.getStatus() == ITestResult.FAILURE) {
            for(; retryConfigCount < maxRetries; retryConfigCount++) {
                try {
                    callBack.runConfigurationMethod(result);
                    if (result.getThrowable() == null && result.getStatus() !=ITestResult.FAILURE) {
                        break;
                    }
                    System.out.println("Retry #" + (retryConfigCount + 1) + " in " + retryInterval + " seconds...");
                    TimeUnit.SECONDS.sleep(retryInterval);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (retryConfigCount >= maxRetries) {
                System.out.println("Maximum number of retry attempts reached. Stopping retry attempts.");
            }
        }
    }
}
