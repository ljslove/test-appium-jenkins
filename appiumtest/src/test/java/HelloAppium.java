import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by Administrator on 2018/8/30.
 */
/*
一个简单的Appium程序
在setUp方法中，要定义driver，设置属性（设备名字，手机平台版本，app的启动页面，以及创建连接
 */
public class HelloAppium {

    AppiumDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app= new File(classpathRoot, "apk/hjnsj_e.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "My phone");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "com.hj.nsj_e.ui.LoadingActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testName() throws Exception {

        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() throws Exception {

        driver.quit();

    }
}
