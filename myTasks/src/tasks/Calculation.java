package tasks;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Calculation {

	 public static void main(String[] args) throws ParseException {

	 		/* Pseudocode
					Start
					Get the date (month + day) from user in form (mm-dd)
					calculate the last digit of the month's value
					Check if the last digit of the month value is not equal to June or July and the day is not between 1 and 31 then print an error message and exit the programme
					Get the sunrise and sunset time from the user in form (hh: mm), then create DateFormat to format the time and create Date to assign the user's input to it
					Check if sunrise is after or equal sunset, if so print an error message and exit the programme
					Else calculate the number of hours of sunshine, production, and electricity price
					Print hours of sunshine, date, production, and electricity price
					End
					*/
					
					final int SUN_RADIATION= 166;
					final double SURFACE= 44.2;
					final float electPris = 0.9f;
					int day;
					int month;
					int lastDigit;
					String sunrise;
					String sunset;
					float diffHou = 0; 
					float production;
					Date sunriseData;
					Date sunsetData;
					 long diffMs;
				     long diffSec;
				     float min;
				     float calcElectPris;
				     int sunriseHour;
				     int sunriseMinute; 
				     String sunriseSplitter[];
				     String sunsetSplitter[];
				     int sunsetMinute; 
				     int sunsetHour;
				      // Creating scanner object for reading from input stream 
				      Scanner dateInput = new Scanner(System.in);

				      // Set delimiter to '-' or '/' or whitespace 
				      dateInput.useDelimiter("[-/\\s]");
				 

				      // Get today's date from the user
				  	System.out.println("Enter today's date [mm-dd]> ");
				      month = dateInput.nextInt();
				      day = dateInput.nextInt();       

				      // Get the last digit of month's value to display it later + to check its value
				       lastDigit = month%10; 
				      
				      // Check if the input  fulfills our condition for June + Check if the entered day is logical 
				      if (month != 06 && day<1 || day>30) {	      
				      System.err.println("DATE is not proper");
				      System.err.println("EXIT...");
				      System.exit(0);
				      }
				      
				   //   Check if the input  fulfills our condition for  July + Check if the entered day is logical 
				      else if( month != 07 && day<1 || day>31) {
				    	  System.err.println("DATE is not proper");
					      System.err.println("EXIT...");
					      System.exit(0);
				      }
				  
				      // New Scanner to get the time from the user
				      Scanner timeInput = new Scanner(System.in);

				      // Get sunrise from the user
				      System.out.println("Enter time of sunrise [hh: mm]> ");
					      sunrise = timeInput.next();
			              
			               sunriseSplitter=sunrise.split(":"); // Splitting the string by identifying : inside the string and storing in array
			               sunriseHour=Integer.parseInt(sunriseSplitter[0]); //identifying elements based on the array index hours is 0
			               sunriseMinute=Integer.parseInt(sunriseSplitter[1]);//minutes is 1
			                  if(sunriseHour<0 || sunriseHour>24 ){ // performing checks for hour  whether the is valid or not       
			                          System.out.println("Sunrise hour is not proper");
			                          System.err.println("EXIT...");
								    	 System.exit(0);			   
			                  }
			                  else if(sunriseMinute<=0 || sunriseMinute>60) { // performing checks for minutes whether is valid or not 
			                	  System.out.println("Sunrise minutes is not proper");
		                          System.err.println("EXIT...");
							    	 System.exit(0);			   
			                  }
				      
				     
						      // Get sunset from the user
			                  System.out.println("Enter time of sunset [hh: mm]>  ");
				               sunset = timeInput.next();
				               
				               sunsetSplitter=sunset.split(":"); // Splitting the string by identifying : inside the string and storing in array
				               sunsetHour=Integer.parseInt(sunsetSplitter[0]); //identifying elements based on the array index hours is 0
				               sunsetMinute=Integer.parseInt(sunsetSplitter[1]);//minutes is 1
				                  if(sunsetHour<0 || sunsetHour>24 ){ // performing checks for hour  whether the is valid or not       
				                          System.out.println("Sunset hour is not proper");
				                          System.err.println("EXIT...");
									    	 System.exit(0);			   
				                  }
				                  else if(sunsetMinute<=0 || sunsetMinute>60) { // performing checks for minutes whether is valid or not 
				                	  System.out.println("Sunset minutes is not proper");
			                          System.err.println("EXIT...");
								    	 System.exit(0);			   
				                  }
				      
				      
				      
				      //Format the times and assign them to Date var 
				      DateFormat sdf = new SimpleDateFormat("hh:mm");
						  sunriseData = sdf.parse(sunrise);
						  sunsetData = sdf.parse(sunset);
						 
						 // Check if sunrise after sunsetData or if sunrise equals sunset
						    if(sunriseData.after(sunsetData) || 
	               sunriseData.equals(sunsetData)){
						    	System.err.println("The time of sunset should be later than sunrise");
						    	 System.err.println("EXIT...");
						    	 System.exit(0);	    	
						    }
						    
						    //If not then, calculate the number of hours of sunshine
						      diffMs = sunsetData.getTime() - sunriseData.getTime();
						      diffSec = diffMs / 1000;
						      min = diffSec/ 60;
						      diffHou =   min/60;
						 
						     // Calculate production value
						   production = (float) (SUN_RADIATION *20* diffHou* SURFACE);
						   
						   // Calculate electricity price value
						    calcElectPris = electPris* production;
						    
						    //Print the data
						     System.out.println("==========================================");
						     System.out.printf("Sun hours: %.2f hours \n",diffHou);			     
						     System.out.printf("The production on: %d/%d is: %.2f kWh to a value of: %.2f", day, lastDigit, production/100000, calcElectPris/100000);
				
					    }

					 }	
