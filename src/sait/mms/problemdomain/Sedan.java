package sait.mms.problemdomain;

public class Sedan extends Vehicle {

	
	private String trunkSize;
	
	public Sedan (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String driveTrain, int price, int quantity,
            String trunkSize) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
		
		this.trunkSize = trunkSize;
	}
	
	
	//Getter for trunk Size
	public String getTrunkSize() {
		return trunkSize;
	}
	
	
	
	
	
	@Override
	public String toString() {
		
		String trunkDescription; 
	
		//Upper case it all for comparison in switch statement
		String trunkSizeUpper = trunkSize.toUpperCase();
		
		
		//Changing return value based on given trunk size.
		switch(trunkSizeUpper) {
			case "L":
				trunkDescription =  "Large/spacious Trunk";
				break;
			case "S":
				trunkDescription = "Small Trunk";
				break;
			case "M":
				trunkDescription = "Moderate Trunk";
				break;
			default:
				trunkDescription = trunkSize;
		}
		
		
		//using common String so its in the right format. Than adding at the end, trunk Desciprtion
		return commonToString() + String.format("%nTrunk Size:  %s", trunkDescription);
	}
	
	
	
	
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
            trunkSize);
    }
	


	
}
