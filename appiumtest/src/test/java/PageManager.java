/**
 * Created by Administrator on 2018/8/31.
 */
/*
管理各种Page类，提供一个统一的入口，获取各个页面的类的对象，方便调用方法。
 */
public class PageManager {

    PageCommon pageCommon;
    PageLogin pageLogin;
    PageToLogin pageToLogin;
    UiHelper helper;

    public PageManager(UiHelper helper){
        this.helper=helper;
    }


    public PageCommon getPageCommon(){
        if(pageCommon==null){
            pageCommon=new PageCommon(helper);
        }
        pageCommon.initViews();
        return pageCommon;
    }

    public PageLogin getPageLogin(){
        if(pageLogin==null){
            pageLogin=new PageLogin(helper);
        }
        pageLogin.initViews();
        return pageLogin;
    }

    public PageToLogin getPageToLogin(){
        if(pageToLogin==null){
            pageToLogin=new PageToLogin(helper);
        }
        pageToLogin.initViews();
        return pageToLogin;
    }
}
