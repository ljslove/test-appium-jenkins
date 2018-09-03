


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/31.
 */
/*
用例执行失败就会调用这个监听，拍照并保存
 */
public class TestListener implements ITestListener  {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
       captureScreenShot(result);
    }

    public void onTestSkipped(ITestResult result) {



    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void captureScreenShot(ITestResult result){
       /*
       getMethod()获取失败的方法，getRealClass（）获取失败的方法所在的类的反射，getSimpleName（）获取类的简单的名字
       getMethodName（）获取失败的方法的名字
        */
        String passFailMethod=result.getMethod().getRealClass().getSimpleName()+"."+result.getMethod().getMethodName();
        /*
        拍照
         */
        File srcFile=(BasicTest.driver).getScreenshotAs(OutputType.FILE);
        /*
        时间戳，用于区分照片
         */
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        /*
        照片要保存的路径
         */
        String desDir="screenshots/Failure";
        new File(desDir).mkdir();
        /*
        照片的命名
         */
        String desFile= passFailMethod+"---"+dateFormat.format(new Date())+".png";
        try{
            FileUtils.copyFile(srcFile,new File(desDir+"/"+ desFile));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
