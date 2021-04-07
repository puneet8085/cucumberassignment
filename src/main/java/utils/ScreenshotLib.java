package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class ScreenshotLib extends Driver
{

   public static void screenShot() throws IOException
   {
       TakesScreenshot ts = (TakesScreenshot) driver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       String datetime = CommonUtils.getDateTimeWithSec();
       FileUtils.copyFile(source,new File("./screenshot/"+datetime+"screenshot.png"));
   }
}
