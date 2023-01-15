package tasks;

public class TablePrintout {

	public static void main(String[] args) {
	 	// Print the table header
				System.out.printf("%1s %14s %19s %22s%n", "Ström(A)","Spänning(V)","Leddeffekt(Kw)", "Laddningstid(h)");
				//Loop to print 65 '=' symbols after the header
				for(int i=0; i<65;i++) {
					System.out.print("=");
				}
				//Just to make a new line
			    System.out.println();
				//Print the table data and call chargTimeSinglePhase and chargTimeThreePhase methods to calculate the charging time
				System.out.printf("%1s %14s %19s %22s%n", 10, 230, 2.3, String.format("%.2f",chargTimeSinglePhase(10)));
				System.out.printf("%1s %14s %19s %22s%n", 16, 230, 3.68, String.format("%.2f",chargTimeSinglePhase(16)));
				System.out.printf("%1s %14s %19s %22s%n", 10, 400, 6.93, String.format("%.2f",chargTimeThreePhase(10)));
				System.out.printf("%1s %14s %19s %22s%n", 16, 400, 11.09,String.format("%.2f",chargTimeThreePhase(16)));
				System.out.printf("%1s %14s %19s %22s%n", 32, 400, 22.17, String.format("%.2f",chargTimeThreePhase(32)));
			}
			
			//Declaring the variables
			static float chargPower;
			final static double BATTERY_CAPACITY= 35.8;
			final static int SINGLE_PHASE_CURRENT=230;
			final static int THREE_PHASE_CURRENT =400;
			final static int CUBE_ROOT =3;
			final static int ROUNDING_CHARGPOWER = 1000;
		
			// Create a function to calculate charging time for Single Phase based on this formula: Charge time = battery capacity / (Voltage x Current)
			public static float chargTimeSinglePhase(int voltage) {
				chargPower= (float) (BATTERY_CAPACITY/(voltage*SINGLE_PHASE_CURRENT));
				return chargPower*ROUNDING_CHARGPOWER;
			}
			
			//Create a function to calculate charging time for Single Phase based on this formula: Charge time = battery capacity / (Voltage x Current x power factor)
			public static float chargTimeThreePhase(int voltage) {
				chargPower= (float) (BATTERY_CAPACITY/(voltage*THREE_PHASE_CURRENT*Math.sqrt(CUBE_ROOT)));
				return chargPower*ROUNDING_CHARGPOWER;		
			}
		}