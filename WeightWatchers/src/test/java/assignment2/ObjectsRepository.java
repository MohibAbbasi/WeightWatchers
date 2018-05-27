package assignment2;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	
	public class ObjectsRepository {

		
		
		
	    WebDriver driver;
	    By findMeetingBtn = By.cssSelector(".find-a-meeting");
	    By searchCityZip = By.id("meetingSearch");
	    By location = By.cssSelector(".location__name");
	    By day = By.cssSelector(".hours-list-item-day");
	    By hour = By.cssSelector(".hours-list-item-hours");

	    public ObjectsRepository(WebDriver driver){
	        this.driver = driver;
	    }

	    
	    public String validateTitle() {
	        return driver.getTitle();
	    }

	    
	    public String clickFindMeeting() throws Exception {
	        driver.findElement(findMeetingBtn).click();
	        Thread.sleep(3000);
	        return driver.getTitle();
	    }

	    
	    public String searchByZipCode(String zipCode) {
	        driver.findElement(searchCityZip).sendKeys(zipCode,Keys.ENTER);
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        List<WebElement> locations = driver.findElements(location);
	        return locations.get(0).getText();
	    }

	    
	    public String validateLocation() {
	        List<WebElement> locations = driver.findElements(location);
	        locations.get(0).click();
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        return driver.findElement(location).getText();
	    }

	    
	    public void getHoursOfOperation(String value) {
	        List<WebElement> days = driver.findElements(day);
	        List<WebElement> hours = driver.findElements(hour);
	        for (int i = 0; i < days.size(); i++){
	            if(value.equalsIgnoreCase(days.get(i).getText())){
	                System.out.println(hours.get(i).getText());
	            }
	            
	        }
	        
	    }
	    
	}
