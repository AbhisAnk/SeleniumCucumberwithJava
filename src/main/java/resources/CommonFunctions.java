package resources;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import logs.Log;

public class CommonFunctions {
	
	 WebDriver driver;
	 Alert alert;
	
	public static void takeSnapshot(String snapShotName) {
		
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException e) {
			 
			e.printStackTrace();
		} catch (AWTException e) {
			 
			e.printStackTrace();
		}
	    try {
			ImageIO.write(image, "jpg", new File("./snapshots/"+snapShotName+".jpg"));
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
	}
	
	
	public  String getAlertText() {
		alert = driver.switchTo().alert();
		Log.info("Alert received. Text: "+alert.getText());
		return alert.getText();
		
	}
	


}
