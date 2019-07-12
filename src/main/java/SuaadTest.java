import TakeScreenShots.TakeScreenShot;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SuaadTest {

    AndroidDriver driver;



    @Before
    public void setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("real_mobile", "true");
        capabilities.setCapability("deviceName", "Huaweip10lite");
        capabilities.setCapability("appPackage", "com.hungerstation.android.web.debug");
        capabilities.setCapability("appActivity", "com.hungerstation.android.web.v6.screens.vatinvoices.view.VatInvoicesActivity");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("app", "/Users/suaadbatis/Desktop/app.apk");
        /*capabilities.setCapability("fullReset", false);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("unlockType","pin");
        capabilities.setCapability("unlockKey","1989");*/
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }


    @After
    public void thawed()
    {
        driver.quit ();
    }


  @Test
  public  void UserOpenApp() {


      try {
          TakeScreenShot.takeScreenShot();
      } catch (IOException e) {
          e.printStackTrace ();
      }

  }


 /*@BeforeMethod
    public void LaunchApp()
    {
       driver.launchApp ();
    }

    @AfterMethod
    public void CloseApp()
    {
        driver.close ();
    }*/

/*

    @Test(priority = 1)
    public  void UserOpenApp() {


        try {
            TakeScreenShot.takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
*/


}