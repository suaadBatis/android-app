import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;




public class payment_method {

    AndroidDriver driver;
    MockServerClient mockServerClient;


    @Before
    public void setup () throws MalformedURLException {

        mockServerClient = new MockServerClient ("localhost", 8080);

        mockServerClient.when (new HttpRequest ().withPath ("/account").withBody ("{name:}").withMethod ("GET")).respond (new HttpResponse ().withBody (""));


        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("real_mobile", "true");
        capabilities.setCapability ("deviceName", "Huaweip10lite");
        capabilities.setCapability ("appPackage", "com.hungerstation.android.web.debug");
        capabilities.setCapability ("appActivity", "com.hungerstation.android.web.v6.screens.splash.view.SplashActivity");
        capabilities.setCapability ("platformName", "android");
        capabilities.setCapability ("platformVersion", "7.0");
        capabilities.setCapability ("app", "/Users/suaadbatis/Desktop/app.apk");
        capabilities.setCapability ("fullReset", false);
        capabilities.setCapability ("noReset", true);
        capabilities.setCapability ("unlockType", "pin");
        capabilities.setCapability ("unlockKey", "1989");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);
        /*if (driver.isDeviceLocked()){
            driver.unlockDevice();
        }*/
        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        // driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();


    }

    @After
    public void thawed () {
        driver.quit ();



    }
}