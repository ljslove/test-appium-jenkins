import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2018/8/31.
 */
public class PageToLogin {

    UiHelper helper;
    WebElement nameET,psdET,loginBtn;

    public PageToLogin(UiHelper helper){
        this.helper=helper;
    }

    public void initViews(){
            nameET = helper.findId("net.oschina.app:id/et_login_username");
            psdET = helper.findId("net.oschina.app:id/et_login_pwd");
            loginBtn = helper.findId("net.oschina.app:id/bt_login_submit");
    }

    public void nameSendKeys(String name){
        nameET.clear();
        nameET.sendKeys(name);
    }

    public void psdSendKeys(String psd){
        psdET.clear();
        psdET.sendKeys(psd);
    }

    public void clickButton(){
        loginBtn.click();
    }
}
