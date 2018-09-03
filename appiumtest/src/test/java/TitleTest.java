import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TitleTest {

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
        通过xpath来定位一个控件
         */
        WebElement ele=driver.findElement(By.xpath(".//*[@text='问答']"));
        ele.click();
        Thread.sleep(3000);
        /*
        获得控件的文本
         */
        System.out.println("====================="+ele.getText().toString());
        Thread.sleep(3000);
        /*
        通过classname来获取一组控件，并使用get（index）方法来获取第index个控件
         */
        WebElement element=(WebElement)driver.findElementsByClassName("android.widget.ImageView").get(0);
        element.click();
        Thread.sleep(3000);
        /*
        获取一组控件，放入list中，遍历list，打印控件的文本
         */
        List<WebElement> webElementList=driver.findElements(By.id("net.oschina.app:id/tv_title"));
        for(WebElement ele0:webElementList){
            System.out.println(ele0.getText().toString());
        }
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}
