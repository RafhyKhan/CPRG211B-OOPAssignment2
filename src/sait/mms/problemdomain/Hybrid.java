package sait.mms.problemdomain;

public class Hybrid extends Vehicle {

	
	//initializing calsses unique variables
	private int carRange;
	private String powerTrain;
	
	
	public Hybrid (String carId, String vehicleType, String subType,
            int speed, double fuel, int seats, int year,
            String drivetrain, int price, int quantity,
            String powerTrain, int carRange) {
		
		super(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		
		//getting values
		this.carRange = carRange;
		this.powerTrain = powerTrain;
	}
	
	
	
	//returns a string, altered, adding extra variables 
	@Override
	public String toString() {
		
		String powerTrainDescription; 
	
		//Upper case it all for comparison in switch statement
		String powerTrainUpper = powerTrain.toUpperCase();
		
		
		//Changing return value based on given trunk size.
		switch(powerTrainUpper) {
			case "L":
				powerTrainDescription = "Series Hybrid";
				break;
			case "S":
				powerTrainDescription = "Parallel Hybrid";
				break;
			case "M":
				powerTrainDescription = "Plug-in Hybrid";
				break;
			default:
				powerTrainDescription = powerTrain;
		}
		
		
		//using common String so its in the right format. Than adding at the end, powerTrainDescription and car range
		return commonToString() + String.format("%nPower Train: %s%nElectric Range:   %d",
				powerTrainDescription, carRange);
	}
	
	


	//getter
	public String getPowerTrain() {
		return powerTrain;
	}
	
	
	//getter
	public int getCarRange() {
		return carRange;
	}
	
	
	
	//returns in the correct format all variables, also the added onces
    @Override
    public String toFileFormat() {
        return String.join(";",
            getCarId(), getVehicleType(), getSubType(),
            String.valueOf(getSpeed()),
            String.valueOf(getFuel()),
            String.valueOf(getSeats()),
            String.valueOf(getYear()),
            getDriveTrain(),
            String.valueOf(getPrice()),
            String.valueOf(getQuantity()),
            powerTrain,
            String.valueOf(carRange));
    }
}
