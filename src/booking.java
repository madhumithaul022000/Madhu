package RailwayReserv;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	int trainNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter train no: ");
		trainNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean isAvailable()  throws SQLException{
		
		TrainDAO traindao = new TrainDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = traindao.getCapacity(trainNo);

		int booked = bookingdao.getBookedCount(trainNo,date);
		
		return booked<capacity;
		
	}
}
