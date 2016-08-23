package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ControlsFlighter {

	String passengerName, passengerSurname, diaIda, mesIda, diaVuelta, mesVuelta;
	String origen, destino;
	 UtilsFramework utils = new UtilsFramework();
	 WebDriver driver = new ChromeDriver();
	 String infocurrentPage=null;
	
	public ControlsFlighter (String passengerName, String passengerSurname, String Origen, String Destino, String diaIda, String mesIda, String diaVuelta, String mesVuelta)
	{
		
	this.passengerName = passengerName;
	this.passengerSurname = passengerSurname;
	this.diaIda = diaIda;
	this.diaVuelta = diaVuelta;
	this.mesIda = mesIda;
	this.mesVuelta = mesVuelta;
	this.destino=Destino;
	this.origen=Origen;
	
	
	driver.get(ConstantsFlight.url);
	}
	
	

	public void SearchFlight() throws Throwable
	{
		driver.findElement(By.id("fly_from")).sendKeys(origen);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#fly_from-BCN > a")).click();
		
		
		driver.findElement(By.id("fly_to")).sendKeys(destino);
		
		driver.findElement(By.cssSelector("#fly_to-CPH > a > strong")).click();
		
		//i = driver.getCurrentUrl();
		
        Thread.sleep(1000);  	
    /////    #datepicker-724-416-title                  
      driver.findElement(By.xpath("//*[@id=\"outboundDate\"]/div/div/label/input")).click();
      Thread.sleep(1000);
        // calendar__datepicker
      
      driver.findElement(By.cssSelector("#outboundDate > div > div > div.calendar__datepicker-wrapper > div > div > div > div > button.calendarnavigation__button.pull-right > i")).click();
      
      Thread.sleep(2000);
      
      utils.busquedaMesDiaVuelo(mesIda, diaIda, driver, false);
      
      Thread.sleep(2000);
      
      utils.busquedaMesDiaVuelo(mesVuelta, diaVuelta, driver, true);
      
      
      driver.findElement(By.cssSelector("#adultCount")).sendKeys("2");
  
      
      driver.findElement(By.id("searchButton")).click();
      
      infocurrentPage = driver.getCurrentUrl();
      System.out.println(infocurrentPage);
      Thread.sleep(5000);
      infocurrentPage = driver.getCurrentUrl();
      System.out.println(infocurrentPage);
      driver.findElement(By.xpath("//*[@id=\"ctl01_ctl00_MainContentRegion_MainRegion_ctl00_lbtContinue2\"]")).click();
            
      infocurrentPage = driver.getCurrentUrl();
      System.out.println(infocurrentPage);
      
      /////////////////
      Thread.sleep(6000);
     
      driver.findElement(By.xpath("//*[@id=\"ctl01_ctl00_MainContentRegion_MainRegion_ctl00_lbtContinue\"]")).click();
      Thread.sleep(5000);
      infocurrentPage = driver.getCurrentUrl();
      System.out.println(infocurrentPage);
      
      
      driver.findElement(By.xpath("//*[@id=\"ctl01_ctl00_MainContentRegion_MainRegion_ctl00_IpcResUnregisteredUserBox_btnContinue\"]")).click();
      Thread.sleep(5000);
      infocurrentPage = driver.getCurrentUrl();
      System.out.println(infocurrentPage);
      
      //DATOS PASAJERO
      
      driver.findElement(By.id("ctl01_ctl00_MainContentRegion_MainRegion_ctl00_ipcPaxBox_rptTravellers_ctl01_txtFirstName")).sendKeys(passengerName);
      driver.findElement(By.id("ctl01_ctl00_MainContentRegion_MainRegion_ctl00_ipcPaxBox_rptTravellers_ctl01_txtLastName")).sendKeys(passengerSurname);
      
       
      utils.selectionOption(driver, ConstantsFlight.idSelectGener, "Hombre");
     
      
      driver.findElement(By.id("ctl01_ctl00_MainContentRegion_MainRegion_ctl00_ipcPaxBox_rptTravellers_ctl01_ddlOutboundLuggage")).click();
      driver.findElement(By.id("ctl01_ctl00_MainContentRegion_MainRegion_ctl00_ipcPaxBox_rptTravellers_ctl01_ddlGender")).sendKeys("2 maleta(s) (38,00€)");
      
      
      
      
      
      
      Thread.sleep(5000);
    // driver.close();
	}
	
	
}
