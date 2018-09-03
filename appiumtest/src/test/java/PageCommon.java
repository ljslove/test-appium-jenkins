import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2018/8/31.
 */
/*
将每个页面的定位控件、对控件的操作方法等，集中放到一个类中，只要调用这个类的方法即可
 */
public class PageCommon {

    UiHelper helper;
    WebElement allTab,moveTab,findTab,myTab;


    public PageCommon(UiHelper helper){
        this.helper=helper;
    }

    public void initViews(){
            allTab = helper.findIdIndex("net.oschina.app:id/nav_iv_icon", 0);
            moveTab = helper.findIdIndex("net.oschina.app:id/nav_iv_icon", 1);
            findTab = helper.findIdIndex("net.oschina.app:id/nav_iv_icon", 2);
            myTab = helper.findIdIndex("net.oschina.app:id/nav_iv_icon", 3);
    }

    public void clickAllTab(){
        allTab.click();
    }
    public void clickMoveTab(){
        moveTab.click();
    }
    public void clickMyTab(){
        myTab.click();
    }
    public void clickFindTab(){
        findTab.click();
    }


}
