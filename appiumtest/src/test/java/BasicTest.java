import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by Administrator on 2018/8/31.
 */
/*
将所有类的共同部分抽取出来，作为父类，父类一般包括setUp（）和tearDown（）方法等
 */
public class BasicTest {
    static AppiumDriver driver;
    UiHelper helper;
    PageManager pageManager;

    @BeforeMethod
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app= new File(classpathRoot, "apk/oschina.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "My phone");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("noSign","true");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appActivity", "net.oschina.app.improve.main.splash.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        helper=new UiHelper(driver);
        pageManager=new PageManager(helper);

    }

    @AfterMethod
    public void tearDown() throws Exception {

        driver.quit();

    }
}
