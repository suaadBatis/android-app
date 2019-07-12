import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.Utils;


public class Place_order {

    AndroidDriver driver;
    MockServerClient mockServerClient;


    @Before
    public void setup() throws MalformedURLException {

        mockServerClient = new MockServerClient("localhost", 4723);

         mockServerClient.when(new HttpRequest().withPath("/api/v2/orders/")
                        .withMethod("POST"))
                        .respond(new HttpResponse()
                        .withBody(" "));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("real_mobile", "true");
        capabilities.setCapability("deviceName", "Huaweip10lite");
        capabilities.setCapability("appPackage", "com.hungerstation.android.web.debug");
        capabilities.setCapability("appActivity", "com.hungerstation.android.web.v6.screens.splash.view.SplashActivity");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("app", "/Users/suaadbatis/Desktop/app.apk");
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("unlockType","pin");
        capabilities.setCapability("unlockKey","1989");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        /*if (driver.isDeviceLocked()){
            driver.unlockDevice();
        }*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }


    }
    @After
    public void thawed()
    {driver.quit();}


    @Test
    public  void LoginAfterPlaceOrder()
    {
        MobileElement el2 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/BtnRestaurants");
        el2.click();
        Utils.sleep (1);
        MobileElement el3 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/BtnAddAddress");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/editDescription");
        el4.sendKeys("Catch bug if you can");
        MobileElement el5 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/BtnAddAddress");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/image_plus");
        el8.click();
        el8.click();
        el8.click();
        el8.click();
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/btn_add_to_cart");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/phone_number");
        el11.sendKeys("0500341221");
        MobileElement el12 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/btn_login");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/edt_verification_number");
        el14.sendKeys("000000");
        MobileElement el15 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/btn_checkout");
        el15.click();

        driver.removeApp ("com.hungerstation.android.web.debug");

    }

}