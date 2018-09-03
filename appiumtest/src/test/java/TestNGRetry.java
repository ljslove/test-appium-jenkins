import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Administrator on 2018/9/1.
 */
/*
脚本失败后，决定脚本重跑的次数
 */
public class TestNGRetry implements IRetryAnalyzer{

    public int count=0;
    public int maxCount=1;
    public boolean retry(ITestResult result) {

        if(count<maxCount){
            String message="running retry for "+result.getName()+"on class "+result.getClass().getName()+" retrying for "+
                    count+" times";
            System.out.println(message);
            count++;
            return true;
        }
        return false;
    }
}
