package sait.mms.problemdomain;



//SUV class for the SUV vehicle types. Subclass of Vehicle class, overrides the toString method, and toFileFormat.
public class SUV extends Vehicle {
	
	
	
	public SUV (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String drivetrain, int price, int quantity) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		
	}
	
	//returns a string, altered, adding drivetrain variable
	@Override
	public String toString() {
		return commonToString() + String.format("%nDriveTrain:  %s", getDriveTrain());
	}
	
	
	
	//returning in proper format for file,
    @Override
    public String toFileFormat() {
        return String.join(";",
            getCarId(), 
            getVehicleType(), 
            getSubType(),
            String.valueOf(getSpeed()),
            String.valueOf(getFuel()),
            String.valueOf(getSeats()),
            String.valueOf(getYear()),
            getDriveTrain(),
            String.valueOf(getPrice()),
            String.valueOf(getQuantity()));
    }
    

}
