package tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MathematicalMethods {

	 public static void main(String[] args)
	    {

	       Scanner cin = new Scanner(System.in);
	    testAreaAndVolume(cin);
	    testFractionalMethods(cin);
	  }

	  
	  // This method calculates the area of the base(circle) of the cone
	   
	  public static double area(int radius) {
	    return Math.PI * Math.pow(radius, 2);
	  }

	  /***
	   * The method returns the area of the tip of the cone.
	   * In order to calculate the area of the tip of the cone we need to calculate s, which  in this case
	   * is the distance from the circle to the tip of the cone.
	   * We can do that by using Pythagoras theorem, because the radius of the circle,
	   * the line from center of the circle and the side of the surface of the cone form a right triangle.
	   * Where the side of the surface is the hypotenuse.
	   */
	  public static double area(int radius, int height) {
	    final double s = pythagoras(radius, height);
	    return Math.PI * radius * s;
	  }

	  /***
	   *
	   *  sideA length of a side of right triangle (one that creates the right angle)
	   *  sideB length of the other side of right triangle (the other one that creates the right angle)
	   *  sideC or the hypotenuse length.
	   */
	  public static double pythagoras(int sideA, int sideB) {
	    return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
	  }

	  
	   // Method that calculates the volume of a cone by the formula (PI*radius^2*height) / 3
	  public static double volume(int radius, int height) {
	    return (Math.PI * Math.pow(radius, 2) * height) / 3;
	  }

	 
	   // Returns an integer (whole part of fraction) and fraction part that is shortened

	   
	  public static int[] fraction(int numerator, int denominator) {
	    int[] result = new int[3];
	    // If the denominator is 0 we cannot divide by and we return null
	    if (denominator == 0) {
	      return null;
	    } else if (numerator == 0) {
	      // if the numerator is 0 we have a 0 value, so we return all zeroes
	      result[0] = 0;
	      result[1] = 0;
	      result[2] = 0;
	    } else {
	      // in every other case we calculate the whole part and a fraction that we are shortening.
	      final int integerPart = numerator / denominator;
	      // we get the fraction numerator as the rest of the division (%), the denominator stays the same
	      int fractionNumerator = numerator % denominator;
	      // We need to find the greatest common divider and divide both the new numerator and denominator with it, in order to shorten the fraction part
	      int gcd = gcd(fractionNumerator, denominator);

	      // Divide both the new numerator and  new denominator by their gcd
	      fractionNumerator = fractionNumerator / gcd;
	      final int fractionDenominator = denominator / gcd;

	      result[0] = integerPart;
	      result[1] = fractionNumerator;
	      result[2] = fractionDenominator;
	    }

	    return result;
	  }


	 // greatest common divider by Euclide's algorithm
	   
	  public static int gcd(int a, int b) {
	    // if a is smaller than b then we need to switch them
	    if (a < b) {
	      final int temp = a;
	      a = b;
	      b = temp;
	    }

	    // Implementation of Euclide's algorithm
	    while (b != 0) {
	      final int c = a % b;
	      a = b;
	      b = c;
	    }

	    return a;
	  }

	 
	  //parts should be null or an array of 3 integers which represent integer part of fraction, numerator, denominator accordingly.
	   
	  static void printFraction(int[] parts) {
	    // if we have a null print error
	    if (parts == null) {
	      System.out.print("\"Error\"");
	    } else {
	      final int integerPart = parts[0];
	      final int numerator = parts[1];
	      final int denominator = parts[2];

	      // if the denominator is 0 we have a 0 value
	      if (denominator == 0) {
	        System.out.print(0);
	      } else if (integerPart != 0 && numerator == 0) {
	        // The fraction part is 0, we print only the whole part of the fraction
	        System.out.print(integerPart);
	      } else if (integerPart == 0 && numerator != 0) {
	        // The fraction part is not 0, but the integer part is 0, so we print only the fraction part
	        System.out.print(numerator + "/" + denominator);
	      } else {
	        // There is a whole part and fraction part so we print everything
	        System.out.print(integerPart + " " + numerator + "/" + denominator);
	      }
	    }
	  }

	  static void testAreaAndVolume(Scanner cin) {
	    System.out.println("----------------------------------");
	    System.out.println("# Test of area and volume methods");
	    System.out.println("----------------------------------");
	    final List<Integer> values = input(cin);
	    for (int i = 0; i < values.size() - 1; i = i + 2) {
	      final int radius = values.get(i);
	      final int height = values.get(i + 1);
	      System.out.println("r = " + radius + " h = " + height);
	      System.out.println("Basytans area: " + String.format("%.2f", area(radius)));
	      System.out.println("Mantle area: " + String.format("%.2f", area(radius, height)));
	      System.out.println("Volume: " + String.format("%.2f", volume(radius, height)));
	    }
	  }

	  static void testFractionalMethods(Scanner cin) {
	    System.out.println("----------------------------------");
	    System.out.println("# Test of the fractional methods");
	    System.out.println("----------------------------------");
	    final List<Integer> values = input(cin);
	    // Go through the inputs and print as required, increase i by 2, so we don't take the same number twice
	    for (int i = 0; i < values.size() - 1; i = i + 2) {
	      final int numerator = values.get(i);
	      final int denominator = values.get(i + 1);
	      System.out.print(numerator + "/" + denominator + " = ");
	      printFraction(fraction(numerator, denominator));
	      System.out.print("\n");
	    }
	  }

	  static List<Integer> input(Scanner cin) {
	    List<Integer> result = new ArrayList<>();
	    // Read the whole line and split it on spaces characters
	    String[] input = cin.nextLine().split("\\s+");
	    for (int i = 0; i < input.length; i++) {
	      // Stop the reading if the entered value is q
	      if (input[i].equals("q")) {
	        break;
	      }

	      // Try parsing the input to an integer and take the absolute value
	      try {
	        int inputNumber = Math.abs(Integer.parseInt(input[i]));
	        result.add(inputNumber);
	      } catch (Exception e) {
	        continue;
	      }

	    }
	    return result;
	  }
	}