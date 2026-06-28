package sait.mms.problemdomain;

public class Hybrid extends Vehicle {

	
	public Hybrid (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String drivetrain, int price, int quantity,
            String hatchBackType) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
	}
	
	
	public String toString() {
		
		return "A String";
	}


	public String getPowerTrain() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
