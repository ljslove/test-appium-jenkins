import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2018/8/31.
 */
public class PageLogin {

    UiHelper helper;
    WebElement imgIV;

    public PageLogin(UiHelper helper){
        this.helper=helper;
    }
    public void initViews(){
        imgIV = helper.findId("net.oschina.app:id/iv_portrait");
    }
    public void clickIV(){
        imgIV.click();

    }









}
