package RailwayReserv;

import java.util.Scanner; //nested package/ hierarchical package


public class TrainDemo {

	public static void main(String[] args)  {
		
		TrainDAO traindao = new TrainDAO();
		
		try {
			traindao.displayTrainInfo();
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
					
			while(userOpt==1) {
				System.out.println("Enter 1 to Book and 2 to exit");
				userOpt = scanner.nextInt();
				if(userOpt == 1) {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
					else
						System.out.println("Sorry. Train is full. Try another train or date.");
				}
			}
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}