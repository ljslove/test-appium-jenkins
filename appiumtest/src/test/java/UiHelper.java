import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2018/8/31.
 */
/*
将定位的方法进行封装，定位控件前要先使用WebDriverWait类，控件显示在页面中后再进行定位，不需要使用Thread.sleep()方法
 */
public class UiHelper {

    public AppiumDriver driver;

    public UiHelper(AppiumDriver driver){
        this.driver=driver;
    }

    public WebElement findId(String id) {
        waitForElement(By.id(id));
        WebElement element=driver.findElement(By.id(id));
        return element;
    }

    public WebElement findName(String name) {
       waitForElement(By.name(name));
        WebElement element=driver.findElementByName(name);
        return element;
    }

    public WebElement findClassName(String className) {
        waitForElement(By.className(className));
        WebElement element=driver.findElementByClassName(className);
        return element;
    }
    public WebElement findIdIndex(String id,int index) {
        waitForElement(By.id(id));
        WebElement element=(WebElement)driver.findElements(By.id(id)).get(index);
        return element;
    }

   public void waitForElement(By by){

       WebDriverWait webDriverWait=new WebDriverWait(driver,20);
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
   }

}
