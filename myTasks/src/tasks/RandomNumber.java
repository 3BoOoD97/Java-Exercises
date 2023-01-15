package tasks;
import java.util.Arrays;
import java.util.Scanner;

public class RandomNumber {

	  public static void main(String[] args) {
		  /* @author abddab-1
			    	
			    	Pseudocode
					 Start
					 Get the range from the user
					 Check if the input is a number
					 Check if the system can handle allocate large amount of memory
					 Check if the range is less than 1000 and bigger than 0
					 Generate random numbers and add them to the randomNumbers[] array and then print it
					 Add even numbers from randomNumbers[] to tempArray[]
					 Arrange numbers in tempArray 
					 Add odd numbers from randomNumbers[] to tempArray[]
					 Arrange odd numbers in tempArray 
					 Print the tempArray after the numbers are arranged
					 Print total numbers in the array and odd and even numbers
					 */
			    	
			    	
			    	
			    	
			    	// Initialize and declare variables
					int randomNumbers[]= null;
					int tempArray[]= null;
					int temp= 0;   
					String arrSize;
					int arrSizeToInt= 0;
					int evenNumCounter= 0;
					int oddNumCounter= 0;

					final int MIN_RANDOM_NUMB= 0;
					final int MAX_RANDOM_NUMB= 999;
					
					Scanner scan= new Scanner(System.in);
					
					
					System.out.println("How many random numbers in the range 0 - 999 are desired?");
					// Get the desired range from the user
					arrSize=scan.next();
					
					
					//Check if the input is a number and save it as int. Otherwise, print error message 
					  try{
						  arrSizeToInt = Integer.parseInt(arrSize);
				        }
				        catch (NumberFormatException ex){
				            System.err.println("Please enter numbers...!");
				        }
					  	
				
					// If the system can not handle allocate large amount of memory then print error message otherwise initialize randomNumbers size
				  try{
					  randomNumbers = new int[arrSizeToInt];
					  tempArray = new int [arrSizeToInt];
			        }
			        catch (OutOfMemoryError ex){
			            System.err.println("Larage array size, the system can not allocate this amount of memory...!");
			        }
				 
				  // If the range less than 1000 and bigger than 0 then enter
				  if(arrSizeToInt<=999 && arrSizeToInt>0) { 
					  
				  //Generate random numbers and add them to the randomNumbers array and then print it
				  for (int i=0; i<arrSizeToInt;i++) {
				  randomNumbers[i]= (int) Math.floor(Math.random()*(MAX_RANDOM_NUMB-MIN_RANDOM_NUMB+1)+MIN_RANDOM_NUMB);
				    }
				 System.out.println("Here are the random numbers");
				 
				 for(int i: randomNumbers){
					    System.out.print(i + " ");
					}
				 
				 // A new line
				 System.out.println();
				
				 // Add even numbers to the temp array
				 for (int i=0; i<arrSizeToInt;i++) {
				 if(randomNumbers[i]%2==0) {
						tempArray[evenNumCounter]=randomNumbers[i];
						evenNumCounter++;
					}
				 }

				  // Arrange even numbers in the array from the largest to the smallest
				  for (int i = 0; i <evenNumCounter; i++) {     
			         for (int j = i+1; j <evenNumCounter; j++) {     
			             if(tempArray[i] >tempArray[j]) {     
			                temp = tempArray[i];    
			                tempArray[i] = tempArray[j];    
			                tempArray[j] = temp;    
			              }     
			           }     
			       }

				 // Add odd numbers to the temp array
				 for (int i=0; i<arrSizeToInt;i++) { 
				 if(randomNumbers[i]%2!=0) {
						tempArray[evenNumCounter+oddNumCounter]=randomNumbers[i];
						oddNumCounter++;
					}
				 }


				  // Arrange odd numbers in the array from the smallest to the largest
				  for (int i = evenNumCounter; i <arrSizeToInt; i++) {     
			        for (int j = i+1; j <arrSizeToInt; j++) {     
			            if(tempArray[i] <tempArray[j]) {     
			               temp = tempArray[i];    
			               tempArray[i] = tempArray[j];    
			               tempArray[j] = temp;    
			             }     
			          }     
			      }
			    
				  
				// Print the array arranged
				  System.out.println("Here are the random numbers arranged: ");
				  for(int i=0; i<tempArray.length; i++) {
					  if(i==evenNumCounter) {
						  System.out.print("- ");
					  }
					    System.out.print(tempArray[i]+" ");    
					}
				  
				  // A new line
				  System.out.println();
				  
					// Print the total numbers and total odd and even numbers 
				 System.out.println("Of the above "+arrSizeToInt+" numbers, " +evenNumCounter+" were even and "+oddNumCounter+" odd");
				   }
					  
				  // If the range was less than 0 or bigger than 999 then print error message
				  else 
					  System.err.println("Array size should be smaller than 1000");
				
				}
				}