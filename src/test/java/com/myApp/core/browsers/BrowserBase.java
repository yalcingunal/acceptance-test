package com.myApp.core.browsers;

import com.myApp.core.configuration.AppSettings;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BrowserBase {

    private static final Logger LOGGER = Logger.getLogger(BrowserBase.class);
    private String PATH_FORMAT = "drivers/%s/%s";
    private DesiredCapabilities caps;

    abstract void configure(DesiredCapabilities caps, Platform platform, File driverFile);

    abstract RemoteWebDriver create(DesiredCapabilities caps);


    BrowserBase(DesiredCapabilities caps, String driverFileName) {
        this.caps = caps;
        Platform platform = getPlatform();
        File driverPath = getDriverFile(platform, driverFileName);
        configure(caps, platform, driverPath);
        setBrowserLogging(Level.INFO);
    }

    private Platform getPlatform() {
        String osName = System.getProperty("os.name").toUpperCase();
        return osName.contains("WINDOWS") ? Platform.WINDOWS
            : osName.contains("MAC") ? Platform.MACOS
            : osName.contains("LINUX") ? Platform.LINUX
            : null;
    }

    private File getDriverFile(Platform platform, String fileName) {
        String driverPath = String.format(PATH_FORMAT, platform.toString(), fileName).toLowerCase();
        LOGGER.info("Driver path: " + driverPath);
        File driverFile = new File(ClassLoader.getSystemResource(driverPath).getPath());
        driverFile.setExecutable(true);
        return driverFile;
    }

    public RemoteWebDriver getDriver() {
        RemoteWebDriver driver = null;
        if (AppSettings.Instance.UsingSeleniumGrid.equals("false")) {
            driver = create(caps);
        } else if (AppSettings.Instance.UsingSeleniumGrid.equals("true")) {
            if (AppSettings.Instance.Browser.name().equals("CHROME")) {
                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("window-size=1920,1080");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("disable-notifications");
                chromeOptions.addArguments("process-per-site");
                chromeOptions.addArguments("--dns-prefetch-disable");

                if (getPlatform() == Platform.LINUX) {
                    chromeOptions.addArguments("headless");
                }

                caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(AppSettings.Instance.SeleniumGridSwarmUrl), caps);
                    driver.setFileDetector(new LocalFileDetector());
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                DesiredCapabilities capability = DesiredCapabilities.firefox();

                try {
                    driver = new RemoteWebDriver(new URL(AppSettings.Instance.SeleniumGridSwarmUrl), capability);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            //Selenium Grid

        }

        Capabilities capabilities = driver.getCapabilities();

        LOGGER.info("Browser information" + System.lineSeparator() +
                "browser: " + capabilities.getBrowserName() + System.lineSeparator() +
                "version: " + capabilities.getVersion() + System.lineSeparator() +
                "platform: " + capabilities.getPlatform() + System.lineSeparator() +
                "size: " + driver.manage().window().getSize().toString()
        );

        setTimeputs(driver);

        return driver;
    }

    private void setBrowserLogging(Level logLevel) {
        LoggingPreferences loggingPrefs = new LoggingPreferences();

        loggingPrefs.enable(LogType.PERFORMANCE, logLevel);
        loggingPrefs.enable(LogType.DRIVER, logLevel);
        loggingPrefs.enable(LogType.BROWSER, logLevel);

        caps.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);
    }

    private void setTimeputs(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
