package Utilities;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.FileUtils;

public class CaptureScreenShotOnFailure 
{
	public static void captureScreenShot(String testCaseName,WebDriver driver) throws IOException, AWTException
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Robot rt = new Robot();
        BufferedImage img = rt.createScreenCapture(new Rectangle((int) screen
                .getWidth(), (int) screen.getHeight()));
        ImageIO.write(img, "jpeg", new File(System.currentTimeMillis() + ".jpeg"));
	}

}
