package tasks;
import java.util.Arrays;
import java.util.Scanner;


public class DiceGame {

	public static void main(String[] args) {
		/*Pseudocode
				Start
				display welcome message
				Start the game by starting infinite loop that can stop only if the user enters q
				Check if counter equals to three and if so it means all dices have been rolled, so clear all the values from the array and reset counter and sum
				Get the dice number as an input from the user
				If the user pressed q then terminate the program
				If the user pressed 1, then generate a random value between 1 to 6 and save it in the array, and add this random value to the sum and increase the counter 
				If the user pressed 2, then generate a random value between 1 to 6 and save it in the array, and add this random value to the sum and increase the counter 
				If the user pressed 3, then generate a random value between 1 to 6 and save it in the array, and add this random value to the sum and increase the counter 
				If the user didnt enter a valid input then print an error message and re-ask the user to enter a valid input
				Check if the sum equals to 12 then increase the number of wins
				Check if the sum less than 12 then increase the number of loses
				Print dices values, sum, wins and loses
				*/
				
				// Initialize minimum and maximum values for dice 
				   final int min=1;
				   final int max=6;
				   
				   // Initialize/declare variables
				   char dice;
				   int sum=0;
				   int win=0;
				   int lose=0;
				   int counter =0;
				   int charToInt;
				   
				   // Initialize a new array to save dice values
				   int[] diceValues = new int[3];
				   
				   // Initialize a Scanner 
					Scanner scan = new Scanner(System.in); 

					System.out.println("Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12 ... ");
					 
					//Start the game by starting infinite loop that can stop only if the user enters q
					 while(true) {
						 //Check if counter equals to three and if so it means diceValues array is full and the user have rolled the dice three times 
						 //So start a new round and reset diceValues values, and reset counter and sum values
						 if(counter==3) {
							 for(int k=0; k<3;k++) {
								 diceValues[k]=0;
								}
								counter=0;
								 sum=0;
								 System.out.println("Next round! ");
						 		}
						 
						 
						 System.out.println("Enter which dice you want to roll [1,2,3] (exit with q):");
						 //Get the user's input
						 dice = scan.next().charAt(0);
						 
						 
						 // Check the input
						switch(dice) {
						//If the input equals to Q then exit the program
						  case 'q':
							  	System.err.println("Game Over!");
							    System.exit(0);
								 break;
						// If the input equals to 1 then create a random int between 1 to 6 and save it in [] diceValues
						  case '1':
							  charToInt= Character.getNumericValue(dice); // Convert the input from char to int to make it easier. However, it can be done without it
							  if(diceValues[charToInt-1]==0) {// If dice index equals to 0, it means the dice is unrolled yet so enter and roll it 
							   diceValues[charToInt-1]=(int)Math.floor(Math.random()*(max-min+1)+min); //Generate random value from 1 to 6 and save it in the array
							   sum+=diceValues[charToInt-1]; // Add the random value to the sum
							   counter++; // Increase the counter
							   break;
							   }
							  else
								  // If dice index doesnt equals to 0, it means the dice is already rolled so print this error message
								  System.err.println("PLEASE CHOOSE UNROLLED DICE BETWEEN 1-3");
							  break;
							  
							  
								// If the input equals to 2 then create a random int between 1 to 6 and save it in [] diceValues
						  case '2':
							  charToInt= Character.getNumericValue(dice); // Convert the input from char to int to make it easier. However, it can be done without it
							  if(diceValues[charToInt-1]==0) { // If dice index equals to 0, it means the dice is unrolled yet so enter and roll it 
							   diceValues[charToInt-1]=(int)Math.floor(Math.random()*(max-min+1)+min); //Generate random value from 1 to 6 and save it in the array
							   sum+=diceValues[charToInt-1]; // Add the random value to the sum
							   counter++; // Increase the counter
							   break;
							   }
							  else 
								  // If dice index doesnt equals to 0, it means the dice is already rolled so print this error message 
								  System.err.println("PLEASE CHOOSE UNROLLED DICE BETWEEN 1-3");
							  break;
						    
							  
								// If the input equals to 3 then create a random int between 1 to 6 and save it in [] diceValues
						  case '3':
							  charToInt= Character.getNumericValue(dice); // Convert the input from char to int to make it easier. However, it can be done without it
							  if(diceValues[charToInt-1]==0) {
							   diceValues[charToInt-1]=(int)Math.floor(Math.random()*(max-min+1)+min); //Generate random value from 1 to 6 and save it in the array
							   sum+=diceValues[charToInt-1]; // Add the random value to the sum
							   counter++; // Increase the counter
							   break;
							   }
							  else 
								  // If dice index doesnt equals to 0, it means the dice is already rolled so print this error message and return
								  System.err.println("PLEASE CHOOSE UNROLLED DICE BETWEEN 1-3");
							  break;
							  
						  default:
							  //If the user enters a value not equals to 1 or 2 or 3 or q, then print this errors message
							  System.err.println("Wrong value please try again...");
			                  break;

						}
						
						// Increase the number of wins of the sum equals to 12
						if(sum==12) {
							win++;
						}
						
						// Increase the number of lose of the sum less than 12
						else if(sum>12) {
							lose++;
						}
						// Print dice values and sum and lose
						 System.out.println(Arrays.toString(diceValues) + " sum: " + sum+ " # win: "+win+"# loss: "+lose);
						
					 }
				}
		  	}

