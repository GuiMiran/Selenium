package library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilsFramework {
	
	
	
	public void busquedaMesDiaVuelo(String mes, String dia, WebDriver driver, Boolean retorno) throws Throwable
	{
		 WebElement datepicker =null;
		 WebElement datepickerBusqueda=null;
		 List<WebElement> divs=null;
		String botonSig ="#outboundDate > div > div > div.calendar__datepicker-wrapper > div > div > div > div > button.calendarnavigation__button.pull-right > i"; 
		if (retorno)
		{
			botonSig="#returnDate > div > div > div.calendar__datepicker-wrapper > div > div > div > div > button.calendarnavigation__button.pull-right";
		}
		
		
	  datepicker = driver.findElement(By.className("ui-datepicker-content"));
	                                //                calendar__datepicker
	  if (retorno)
	  {
		  datepicker= driver.findElement(By.cssSelector("#returnDate > div > div > div.calendar__datepicker-wrapper > div > div > div"));
	     
	     System.out.println("Mes Retorno: "+datepicker.getText().toString());
	  }
	  else 
	  	{
		  datepicker = driver.findElement(By.className("ui-datepicker-content"));
		}
	  
      divs=datepicker.findElements(By.tagName("button"));  
      
      String mesaBusqueda=divs.get(1).getText().toString(); 
      System.out.println("este el nuevo mes"+mesaBusqueda);
      
    while (!mesaBusqueda.equals(mes))
    {
    	Thread.sleep(2000);
    	driver.findElement(By.cssSelector(botonSig)).click();
    									    
    	  if (retorno)
    	  	{
    		  datepickerBusqueda= driver.findElement(By.cssSelector("#returnDate > div > div > div.calendar__datepicker-wrapper > div > div > div"));
    	  	}
    	  else
    	  	{
    		  datepickerBusqueda = driver.findElement(By.className("ui-datepicker-content"));  
    	  	}
	     
    	  
	      List<WebElement> divsBusqueda=datepickerBusqueda.findElements(By.tagName("button"));
	      
	      mesaBusqueda=divsBusqueda.get(1).getText().toString();
	         
	      System.out.println("mes igual a? "+mesaBusqueda);
	      
    }
    
    
    
    if (retorno)
  	{
	  datepickerBusqueda= driver.findElement(By.cssSelector("#returnDate > div > div > div.calendar__datepicker-wrapper > div > div > div"));
  	}
  else
  	{
	  datepickerBusqueda = driver.findElement(By.className("ui-datepicker-content"));  
  	}
     
      List<WebElement> diasBusqueda=datepickerBusqueda.findElements(By.tagName("button"));
    
    //Busqueda de los Dias 
      for (WebElement elemntDiv: diasBusqueda)
		{  
			//Select 20th Date
    	  System.out.println("dia :"+elemntDiv.getText().toString());
    	  
			if (elemntDiv.getText().equals(dia))
			  { 
				System.out.println("encontrado el dia : "+elemntDiv.getText().toString());
				
				elemntDiv.click();
				break;  
			  }
		}
}
	
	public void selectionOption (WebDriver driver, String idSelect, String Value)
	{
		WebElement select = driver.findElement(By.id("ctl01_ctl00_MainContentRegion_MainRegion_ctl00_ipcPaxBox_rptTravellers_ctl01_ddlGender"));
	      Select dropDown = new Select(select);           
	      String selected = dropDown.getFirstSelectedOption().getText();
	      if(selected.equals("Hombre")){
	          //already selected; 
	          //do stuff
	    	  System.out.println("sleccionado y encontrado>>> HOMBRE");
	      }
	      List<WebElement> Options = dropDown.getOptions();
	      for(WebElement option:Options){
	          if(option.getText().equals("Hombre")) {
	            option.click(); //select option here;       
	          }               
	      }
	}
}



