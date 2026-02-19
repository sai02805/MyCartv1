package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	 public WebDriver driver;
	 public Properties p;
	 
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		//loading config file
		//FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		//FileReader fis = new FileReader("./src/test/resources/config.properties");
		FileReader fis = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");


		p= new Properties();
		p.load(fis);
		switch(br.toLowerCase())
		{
		case "chrome"  : driver = new ChromeDriver();  break;
		case "edge"    : driver = new EdgeDriver();    break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default        : System.out.println("no browser...."); return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
		
	}
	public String captureScreen(String tname) {
		String targetPath =null;
		try {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		 targetPath = System.getProperty("user.dir") + "\\screenshots\\" +tname+"_" + timestamp +".png";
		
		File target = new File(targetPath);
		
		src.renameTo(target);
		//return targetPath;
	}
	
	catch(Exception e) {
		  e.printStackTrace();
	}
		return targetPath;
	}

}
