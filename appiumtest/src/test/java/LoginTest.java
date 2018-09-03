
import org.testng.annotations.Test;
import  org.testng.Assert;

/**
 * Created by Administrator on 2018/8/31.
 */
public class LoginTest extends BasicTest {
    PageCommon pageCommon;
    PageLogin pageLogin;
    PageToLogin pageToLogin;

    @Test
    public void testName() throws Exception {
        pageCommon=pageManager.getPageCommon();
        pageCommon.clickMyTab();
        pageLogin=pageManager.getPageLogin();
        pageLogin.clickIV();
        pageToLogin=pageManager.getPageToLogin();
        pageToLogin.nameSendKeys("lijingshan.love@163.com");
        Assert.assertNotEquals("lijingshan.love@163.com",pageToLogin.nameET.getText().toString());
        pageToLogin.psdSendKeys("ljs261809");
        pageToLogin.clickButton();

    }
}
