package principalTesting;

import library.ControlsFlighter;

public class reservationFlightTest {

	public static void main(String[] args) throws Throwable
	{
		
       ControlsFlighter fly = new ControlsFlighter("GUIDO", "MIRANDA", "BARCELONA", "Copenhague (CPH)", "23", "diciembre 2016", "04", "enero 2017");
       
       fly.SearchFlight();
      

	}
	
	
	
	
}
