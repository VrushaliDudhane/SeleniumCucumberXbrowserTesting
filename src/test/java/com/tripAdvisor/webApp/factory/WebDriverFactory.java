/**
 * 
 */
package com.tripAdvisor.webApp.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Vrushali
 *
 */
public class WebDriverFactory {
	
	public static ThreadLocal<WebDriver> tl=new ThreadLocal<>();
	
	public static WebDriver initDriver(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			tl.set(new ChromeDriver(opt));
		}

		else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			tl.set(new EdgeDriver(opt));
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt=new FirefoxOptions();
			opt.addArguments("--remote-allow-origins=*");
			tl.set(new FirefoxDriver(opt));
		}
		return getDriver();
		
		
	}
	
	public static WebDriver getDriver()
	{
		return tl.get();
	}
}
