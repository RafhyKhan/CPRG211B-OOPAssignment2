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
	

	
	//returns a string, altered, adding extra variables 
	@Override
	public String toString() {
		
		String hatchBackTypeDescription; 
	
		//Upper case it all for comparison in switch statement
		String hatchBackTypeUpper = hatchBackType.toUpperCase();
		
		
		//Changing return value based on given trunk size.
		switch(hatchBackTypeUpper) {
			case "S":
				hatchBackTypeDescription = "Standard Liftgate";
				break;
			case "T":
				hatchBackTypeDescription = "Split Liftgate";
				break;
			case "P":
				hatchBackTypeDescription = "Power Liftgate";
				break;
			default:
				hatchBackTypeDescription = hatchBackType;
		}
		
		
		//using common String so its in the right format. Than adding at the end, hatchBackTypeDescription
        return commonToString() + String.format("%nHatch Type:  %s", hatchBackTypeDescription);
	}
	
	
	
	//getter
	public String getHatchBackType() {
		return hatchBackType;
	}

	
	
	//returning in proper format
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
            String.valueOf(getQuantity()),
            hatchBackType);
    }
	
}
