package assignment2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A2Stepdefination {

	
	
	
	
	
	ObjectsRepository pageObj;


    @Test
    public void Test() throws Exception {
    	
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.weightwatchers.com/us/");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        pageObj = new ObjectsRepository(driver);

        
        Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers",pageObj.validateTitle());
        Assert.assertEquals("Find A Meeting: Get Schedules & Times Near You | Weight Watchers",pageObj.clickFindMeeting());
        String expectedLocation = pageObj.searchByZipCode("10011");
        System.out.println(expectedLocation);
        Assert.assertEquals(expectedLocation,pageObj.validateLocation());
        
        pageObj.getHoursOfOperation(getTodays());
        driver.quit();

    }

    private String getTodays() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return new SimpleDateFormat("EEEE",Locale.ENGLISH).format(date.getTime());
    }
    
}
