import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/9/1.
 */
/*
监听脚本失败后，要跑的脚本次数
 */
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer iRetryAnalyzer=annotation.getRetryAnalyzer();
        /*
        第一次跑脚本，iRetryAnalyzer的值为空
         */
        if(iRetryAnalyzer==null){
            annotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }
}
