package sait.mms.problemdomain;

public class Sedan extends Vehicle {

	
	public Sedan (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String driveTrain, int price, int quantity,
            String hatchBackType) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
		
	}
	
	public String toString() {
		
		return "A String";
	}



	public String getTrunkSize() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
