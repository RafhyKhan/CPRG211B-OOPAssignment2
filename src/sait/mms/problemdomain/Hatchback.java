package sait.mms.problemdomain;



public class Hatchback extends Vehicle {

	private String hatchBackType;
	
	public Hatchback (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String driveTrain, int price, int quantity,
            String hatchBackType) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
		
        this.hatchBackType = hatchBackType;
	}
	

	
	//returning hatch back type String.
	public String getHatchType() {
		return hatchBackType;
	}
	
	
	
	//we are getting the super quantities from VEHICLE, than using that we append Hatch back type and return it as a string! same format
	@Override
	public String toString() {
		return super.toString() + " | Hatch Type: " + hatchBackType;
	}

	
	//again getting super values from vehivle and changing format.
	@Override
	public String toFileFormat() {
		return super.toFileFormat() + ";" + hatchBackType;
	}
	
}
