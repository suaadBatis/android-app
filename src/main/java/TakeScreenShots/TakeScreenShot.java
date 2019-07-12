package TakeScreenShots;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot {
    public static AndroidDriver<MobileElement> driver;
    public static String destDir;
    public static DateFormat dateFormat;

    public static void takeScreenShot () throws IOException {

        //directory
        destDir = "screenshots";

        //capturing screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);

        //Set date
        dateFormat = new SimpleDateFormat ("dd-MMM-yyyy__hh_mm_ssaa");


        //create folder
        new File (destDir).mkdir ();

        String destFile = dateFormat.format (new Date ()) + ".png";


        FileUtils.copyFile (scrFile, new File (destDir + "/" + destFile));

    
    }
}