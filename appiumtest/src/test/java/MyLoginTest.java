import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by Administrator on 2018/8/31.
 */
public class MyLoginTest {

    AppiumDriver driver;

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

    }

    @Test
    public void testName() throws Exception {

        Thread.sleep(3000);
        /*
        通过name也就是text来获取控件
         */
        WebElement webElement1=driver.findElement(By.name("我的"));
        webElement1.click();
        Thread.sleep(3000);
        WebElement webElement2=driver.findElementByName("收藏");
        webElement2.click();
        Thread.sleep(3000);
       // WebElement webElement3=driver.findElement(By.className("android.widget.LinearLayout"));
        /*
        长按一个控件，使用TouchAction类的longPress方法，参数是控件的坐标
         */
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(PointOption.point(204,255)).perform();

    }

    @AfterMethod
    public void tearDown() throws Exception {

        driver.quit();

    }
}
